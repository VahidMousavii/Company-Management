package ir.dotin.controller;

import ir.dotin.da.PersonDA;
import ir.dotin.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("request")
@RequestMapping("/person")
public class PersonController {
    private List<Person> personList;
    private Person person2;

    @Autowired
    PersonDA personDA;


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    @RequestMapping("/save.do")
    public String save(@ModelAttribute Person person) {
        personDA.save(person);
        return "redirect:/person/findAll.do";
    }

    @RequestMapping("/update.do")
    public String update(@ModelAttribute Person person) {
        person2 = personDA.loadPerson(person.getPersonID());

        return "person/updatePerson";
    }

    @RequestMapping("/saveUpdate.do")
    public String saveUpdate(@ModelAttribute Person person) {
        personDA.update(person);
        return "redirect:/person/findAll.do";
    }

    @RequestMapping("/delete.do")
    public String delete(@ModelAttribute Person person) throws Exception {
        personDA.deleteByID(person.getPersonID());
        return "redirect:/person/findAll.do";
    }

    @RequestMapping("/active.do")
    public String active(@ModelAttribute Person person) {
        personDA.active(person);
        return "redirect:/person/findAll.do";
    }
    @RequestMapping("/deactivate.do")
    public String deactivate(@ModelAttribute Person person) {
        personDA.deactivate(person);
        return "redirect:/person/findAll.do";
    }

    @RequestMapping("/findAll.do")
    public String findAll(HttpServletRequest request) throws Exception {
        personList = personDA.findAll();
        return "person/index";
    }

    @RequestMapping("/updatePerson.do")
    public String update(HttpServletRequest request) throws Exception {
        personList = personDA.findAll();
        return "";
    }

}

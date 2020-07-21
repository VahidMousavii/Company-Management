package ir.dotin.controller;

import ir.dotin.entity.Person;
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

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @RequestMapping("/save.do")
    public String save(@ModelAttribute Person person) {
        System.out.println("test : call save");
        return "redirect:/person/findAll.do";
    }

    @RequestMapping("/update.do")
    public String update(@ModelAttribute Person person) {
        System.out.println("test : call update");
        return "redirect:/person/findAll.do";
    }

    @RequestMapping("/delete.do")
    public String delete(@ModelAttribute Person person) throws Exception {
        System.out.println("test : call delete");
        return "redirect:/person/findAll.do";
    }

    @RequestMapping("/findAll.do")
    public String findAll(HttpServletRequest request) throws Exception {
        System.out.println("test : call findAll");
        return "person/index";
    }
}

package ir.dotin;

import ir.dotin.da.CategoryDA;
import ir.dotin.da.EmailDA;
import ir.dotin.da.OffRequestDA;
import ir.dotin.da.PersonDA;
import ir.dotin.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        PersonDA personDA = new PersonDA();
        Person person = new Person();
        person.setPersonName("Vahid");
        //Email
        Email email = new Email();
        email.setEmailContent("salam 3");
        email.setSenderPerson(person);
        email.setReceiverPersons(Arrays.asList(person));
        person.setReceivedPersonEmails(Arrays.asList(email));
        person.setSentEmails(Arrays.asList(email));
        EmailDA emailDA = new EmailDA();
        emailDA.addEmail(email);

        //Category
        CategoryDA categoryDA = new CategoryDA();
        SubCategory gottenRole = categoryDA.findByName("Developer");
        SubCategory gottenType = categoryDA.findByName("Hourly");

        person.setRoleSubCategory(gottenRole);
        if (gottenRole.getPersonList() == null) {
            gottenRole.setPersonList(new ArrayList<Person>(Arrays.asList(person)));
        } else {
            gottenRole.getPersonList().add(person);
        }
        personDA.save(person);

        //OffRequest
        OffRequest offRequest = new OffRequest();
        OffRequestDA offRequestDA = new OffRequestDA();
        offRequest.setTypeOfRequest(gottenType);
        offRequest.setRequesterPerson(person);
//        offRequestDA.addOffRequest(offRequest);

        //checking findAll method
        List<Email> emailList = emailDA.findAll();
        for (Email e : emailList) {
            System.out.println(e.getEmailContent());
        }

    }
}

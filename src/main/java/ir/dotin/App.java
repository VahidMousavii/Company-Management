package ir.dotin;

import ir.dotin.DAO.UserDA;
import ir.dotin.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        UserDA userDA = new UserDA();
        Person person = new Person();
        Phone phone = new Phone();
        person.setPhoneList(Arrays.asList(phone));


        Person person1=new Person();
        Person person2=new Person();
        person1.setDirectManager(person);
        person2.setDirectManager(person);
        person.setEmployees(Arrays.asList(person1,person2));

        person2.getDirectManager();




        userDA.addUser(person);
    }

}

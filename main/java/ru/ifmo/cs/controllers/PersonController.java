package ru.ifmo.cs.controllers;

import ru.ifmo.cs.domain.Person;
import ru.ifmo.cs.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class PersonController {
   @Autowired
   private  PersonService service;
    @RequestMapping("/pers/getbyname")
    public List<Person> findByNameAndSurname(@RequestParam(value = "name") String name, @RequestParam(value = "surname")String surname){
        return service.findByNameAndSurname(name, surname);
    }
    @RequestMapping("/pers/findone")
    public Person findOne(@RequestParam(value = "id") int id){
        return service.findOne(id);
    }
    @RequestMapping("/pers/findall")
    public Iterable<Person> findAll(){
        return service.findAll();
    }
    @RequestMapping("/pers/upd")
    public void update(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "descr") String descr,@RequestParam(value = "prevname") String prevNname, @RequestParam(value = "prevsur") String prevSurname){
        service.updatePerson(name, surname, descr, prevNname, prevSurname);
    }
    @RequestMapping("/pers/rembyname")
    public void removeByNameAndSurname(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname){
        service.removeByNameAndSirname(name, surname);
    }
    @RequestMapping("/pers/add")
    public void add(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "descr") String descr){
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setDescription(descr);
        service.save(person);
    }
}

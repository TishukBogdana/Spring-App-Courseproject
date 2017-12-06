package ru.ifmo.cs.domain;

import javax.persistence.*;

/**
 * Created by Богдана on 11.11.2017.
 */
@Entity
public class Person {
    private int idPerson;
    private String name;
    private String surname;
    private String description;
public Person(){}
public Person(int id,String name, String surname, String description){
    this.name =name;
    this.surname = surname;
    this.description = description;
    this.idPerson =id;
}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator ="persgen")
    @SequenceGenerator(name="persgen", sequenceName = "person_id_person_seq")
    @Column(name = "id_person", nullable = false)
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (idPerson != person.idPerson) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (description != null ? !description.equals(person.description) : person.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPerson;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

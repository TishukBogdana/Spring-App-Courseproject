package ru.ifmo.cs.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Богдана on 11.11.2017.
 */
@Entity
public class Human {
    private int idHuman;
    private String name;
    private String password;
    private String surname;
    private String login;

    public Human(int id, String name, String sir, String login, String passw){
        this.name=name;
        this.surname=sir;
        this.login = login;
        this.password = passw;
        this.idHuman=id;
    }
    public Human(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "humgen")
    @SequenceGenerator(name = "humgen",sequenceName = "human_id_human_seq")
    @Column(name = "id_human", nullable = false)
    public int getIdHuman() {
        return idHuman;
    }

    public void setIdHuman(int idHuman) {
        this.idHuman = idHuman;
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
    @Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "login", nullable = false, length = 30)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (idHuman != human.idHuman) return false;
        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        if (password != null ? !password.equals(human.password) : human.password != null) return false;
        if (surname != null ? !surname.equals(human.surname) : human.surname != null) return false;
        if (login != null ? !login.equals(human.login) : human.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHuman;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

}

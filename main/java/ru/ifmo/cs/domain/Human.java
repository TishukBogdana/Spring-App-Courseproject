package ru.ifmo.cs.domain;

import javax.persistence.*;

/**
 * Created by Богдана on 12.12.2017.
 */
@Entity
//@Table(name = "human", schema = "s225081")
public class Human {
    private int idHuman;
    private String password;
    private String login;
    private boolean present;

    public void setPresent(Boolean present) {
        this.present = present;
    }

    @Id
    @Column(name = "id_human", nullable = false)
    public int getIdHuman() {
        return idHuman;
    }

    public void setIdHuman(int idHuman) {
        this.idHuman = idHuman;
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
    @Column(name = "login", nullable = false, length = 30)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "present", nullable = true)
    public boolean getPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (idHuman != human.idHuman) return false;
        if (present != human.present) return false;
        if (password != null ? !password.equals(human.password) : human.password != null) return false;
        if (login != null ? !login.equals(human.login) : human.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHuman;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (present ? 1 : 0);
        return result;
    }
}

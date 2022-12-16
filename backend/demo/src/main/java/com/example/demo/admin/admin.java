package com.example.demo.admin;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class admin  {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @SequenceGenerator(name="identi", sequenceName="st", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identi")
    @NotNull
    private int id;
    private String email;
    private String password;







    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

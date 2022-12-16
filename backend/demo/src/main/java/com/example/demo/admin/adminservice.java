package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class adminservice {
    @PersistenceContext
    private EntityManager em;
    private final adminrepo adminrepo;
    @Autowired
    public adminservice(com.example.demo.admin.adminrepo adminrepo) {
        this.adminrepo = adminrepo;
    }

    boolean issignup;
    public List<admin> admins()
    {
        return  adminrepo.findAll();
    }

    public  int adminbyid()
    {

        return adminrepo.searchforid(1);
    }


    public String signup(admin s) {
        if(adminrepo.findAll().isEmpty())
        {
            //s.setId(1);
            issignup=true;
            adminrepo.save(s);
            return "admin added successfully";
        }
        else
        {

            return "an admin already exist";
        }


    }


    public String signin(admin s) {
         admin d=adminrepo.searchforadmin(s.getId());
        if(Objects.equals(s.getEmail(),d.getEmail()) &&Objects.equals(s.getPassword(),d.getPassword()) )
        {
            issignup=false;

            return "Admin Logged in successfully";
        }
        else
        {
            return "Sorry it is either wrong email or wrong password, Please try again ";
        }
    }


    public  String adminbyemail() {
        return adminrepo.searchforemail(1);
    }

    public String adminbypass() {
        return adminrepo.searchforpass(1);
    }
}


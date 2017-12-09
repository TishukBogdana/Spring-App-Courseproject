package ru.ifmo.cs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.services.HumanService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class HumanController {
@Autowired
    HumanService service;
@RequestMapping("/admin")
    public void login(HttpServletRequest req, HttpServletResponse resp)throws Exception{
    try{
    String log = req.getParameter("login");
    String passw = req.getParameter("password");
    Human admin = service.findByLogin(log).get(0);
    if(!(admin==null)){
    if(admin.getPassword().equals(passw)){
        resp.sendRedirect("http://localhost:8080/adminpanel.html");
    }else {
        resp.sendRedirect("http://localhost:8080/mainpage.html");

    }
    }
    }catch (Exception e){}
}
}

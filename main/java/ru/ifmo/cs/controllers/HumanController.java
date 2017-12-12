package ru.ifmo.cs.controllers;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.services.HumanService;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController

public class HumanController {
@Autowired
    HumanService service;
@RequestMapping("/auth/admin")
    public void login(@RequestParam(value = "login") String login,@RequestParam(value = "password") String password, HttpServletRequest req, HttpServletResponse resp)throws Exception{
    try{
    Human admin = service.findByLogin(login).get(0);
    if(!(admin==null)){
    if(admin.getPassword().equals(password)){
     HttpSession ses =  req.getSession();
     ses.setAttribute("login", login);
     service.update(true);
        resp.sendRedirect("http://localhost:8080/adminpanel.html");
    }else {
        resp.sendRedirect("http://localhost:8080/errorpage.html");
    }
    }
    }catch (Exception e){}
}
@RequestMapping("/check")
    public Human check(){
   Human human = service.findByPresent(true).get(0);
  return human;
}
@RequestMapping("/exit")
    public void exiT(HttpServletRequest req, HttpServletResponse resp) throws Exception{
    service.update(false);

        resp.sendRedirect("http://localhost:8080/mainpage.html");
}
}

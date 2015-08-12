/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team11.Controller;


import com.Team11.Business.UserBean;
import com.Team11.Model.User;
import com.Team11.Service.GameService;
import com.Team11.Service.GameServiceImpl;
import java.io.IOException;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    
    @EJB private UserBean userBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String username= req.getParameter("uname");
    String password = req.getParameter("password");  
        System.out.println("user name is : "+username);
        System.out.println("password is :  "+password);
        User user = userBean.login(username,password);

    resp.setContentType("text/html");
    if(user == null){
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    else{
       int userid = user.getUserid();
        System.out.println("user id  is : "+ userid);
   
        HttpSession session = req.getSession(true);
			if(session != null)
			{
				session.invalidate();			
			}		
			session = req.getSession(true);
			session.setAttribute("userid", userid);
			session.setAttribute("uname", username);
//			session.setMaxInactiveInterval(20*60);
   System.out.println(session);
    resp.sendRedirect("/SetGameTeam11CA/Username.html");
    }
    }
    
    
    
    
   
}
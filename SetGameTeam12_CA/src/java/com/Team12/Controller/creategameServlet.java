//package com.Team11.Controller;
//
//
//import com.Team11.Business.GameBean;
//import com.Team11.Model.Game;
//import java.io.IOException;
//import javax.ejb.EJB;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/creategameServlet")
//public class creategameServlet extends HttpServlet {
//     @EJB private GameBean gamebean;
//     @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
//         String groupName= req.getParameter("groupname");
//         
//         HttpSession session = req.getSession(false);
//         int userid = Integer.parseInt(session.getAttribute("userid").toString()) ;
//         System.out.println("group name andn userid are : "+groupName+" "+userid);
//         
//          gamebean.createGame(groupName);
//          Game g = gamebean.getGameID(groupName);
//          String gID = g.getId();
//          gamebean.setUserGame(userid, gID);
//          resp.sendRedirect("/test/createItems.html");
//    }
//    
//
//
//}

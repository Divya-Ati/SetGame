/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team11.Business;


import com.Team11.Model.Game;
import com.Team11.Model.Usergame;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pannthee
 */
@Stateless
public class GameBean {

        @PersistenceContext(name = "JQueryMobileTestingPU") 
       private EntityManager em;

//        public void createGame (String gameName){
//              //User user = new User();
//              Game gname = new Game();
//              gname(gameName);
//              System.out.println("game name is : "+gameName);
//              em.persist(gname);
//       }
       
        public Game getGameID(String gameName){  
//            return em.find(Game.class, gameName);
            TypedQuery<Game> q = em.createQuery("SELECT g FROM Game g WHERE g.groupName=:gameName", Game.class);
            return q.setParameter("gameName", gameName).getSingleResult();
//            q.setParameter("gameid", q)
//            List<Game> gamelist = q.getResultList();
//            Game g = gamelist.get(gamelist.size()-1);
//            return g;
        }
        
            public void setUserGame(int userid, int gameID)
        {
            Usergame ug = new Usergame();
            ug.setGameID(gameID);
            ug.setUserID(userid);
            System.out.println("game id is : "+ ug.getGameID());
            em.persist(ug);
        }

}

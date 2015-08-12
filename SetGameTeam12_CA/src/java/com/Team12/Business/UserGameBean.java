/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team11.Business;


import com.Team11.Model.Usergame;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class UserGameBean {
    @PersistenceContext private EntityManager em;
    
    
     public List<Usergame> findAll() {
        TypedQuery<Usergame> query = em.createQuery(
                "select C from Usergame C", Usergame.class);
        return (query.getResultList());
    }
    
    
    public Usergame find(Integer gameID) 
    {
        TypedQuery<Usergame> query=em.createQuery
        ("select C from Usergame where C.gameID=:gameId", Usergame.class);
        query.setParameter("gameID", gameID);
        List<Usergame> result = query.getResultList();
        return ((result.size() > 0)? result.get(0): null);
    }
        }



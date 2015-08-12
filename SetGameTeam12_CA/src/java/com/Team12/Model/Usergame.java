/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Team11.Model;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bharathikannan
 */
@Entity
@Table(name = "usergame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergame.findAll", query = "SELECT u FROM Usergame u"),
    @NamedQuery(name = "Usergame.findByUgID", query = "SELECT u FROM Usergame u WHERE u.ugID = :ugID"),
    @NamedQuery(name = "Usergame.findByGameID", query = "SELECT u FROM Usergame u WHERE u.gameID = :gameID"),
    @NamedQuery(name = "Usergame.findByUserID", query = "SELECT u FROM Usergame u WHERE u.userID = :userID"),
    @NamedQuery(name = "Usergame.findByUrl", query = "SELECT u FROM Usergame u WHERE u.url = :url")})
public class Usergame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ugID")
    private Integer ugID;
    @Column(name = "gameID")
    private Integer gameID;
    @Column(name = "userID")
    private Integer userID;
    @Size(max = 500)
    @Column(name = "url")
    private String url;

    public Usergame() {
    }

    public Usergame(Integer ugID) {
        this.ugID = ugID;
    }

    public Integer getUgID() {
        return ugID;
    }

    public void setUgID(Integer ugID) {
        this.ugID = ugID;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ugID != null ? ugID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergame)) {
            return false;
        }
        Usergame other = (Usergame) object;
        if ((this.ugID == null && other.ugID != null) || (this.ugID != null && !this.ugID.equals(other.ugID))) {
            return false;
        }
        return true;
    }

    public JsonObject toJson() {
        return (Json.createObjectBuilder()
                .add("gameID",gameID)
                .add("userID", userID)
                .add("url", url)
                .build());    
      }
    
    @Override
    public String toString() {
        return "com.Team11.Model.Usergame[ ugID=" + ugID + " ]";
    }
    
}

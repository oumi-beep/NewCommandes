package com.example.newcmmande.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private Integer tel;
    private Integer ID;

    public Client(Integer ID,String nom, String prenom, String adresse, Integer tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.ID=ID;

    }

     public String getNom(){
        return nom;
     }
    public String getPrenom(){
        return prenom;
    }
    public String getAdresse(){
        return adresse;
    }
    public Integer getTel(){
        return tel;
    }
    public Integer  getID(){
        return ID;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setAdresse(String adress){
        this.adresse=adress;
    }
    public void setTel(Integer tel){
        this.tel=tel;
    }
    public void setID(Integer id){
        this.ID=id;
    }

}
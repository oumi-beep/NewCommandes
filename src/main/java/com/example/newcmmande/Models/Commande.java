package com.example.newcmmande.Models;

import java.sql.Date;

public class Commande {
    private Integer numerocommande;
    private Date datecommande;
    private Integer numeroclient;
    private  double prixTotal;
    public Commande(Integer numerocommande,Date datecommande,Integer numeroclient,double prixTotal){
        this.numerocommande=numerocommande;
        this.datecommande=datecommande;
        this.numeroclient=numeroclient;
        this.prixTotal=prixTotal;
    }
    public Commande(Integer numerocommande,Date datecommande,double prixTotal){
        this.numerocommande=numerocommande;
        this.datecommande=datecommande;
        this.prixTotal=prixTotal;
    }

    public Integer getNumerocommande() {
        return numerocommande;
    }

    public void setNumerocommande(Integer numerocommande) {
        this.numerocommande = numerocommande;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public Integer getNumeroclient() {
        return numeroclient;
    }

    public void setNumeroclient(Integer numeroclient) {
        this.numeroclient = numeroclient;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}

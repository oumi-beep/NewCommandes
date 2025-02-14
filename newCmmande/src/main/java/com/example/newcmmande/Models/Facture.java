package com.example.newcmmande.Models;

import java.util.Date;

public class Facture {
    private Integer numeroFacture;
    private Integer numeroCommande;
    private Date dateFacture ;
    private Double montant ;

    public Facture(int numeroFacture, int numeroCommande, Date dateFacture, double montant){
        this.numeroFacture=numeroFacture;
        this.numeroCommande=numeroCommande;
        this.dateFacture=dateFacture;
        this.montant=montant;
    }


    public Date getDateFacture() {
        return dateFacture;
    }

    public double getMontant() {
        return montant;
    }

    public Integer getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroFacture(Integer numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public void setNumeroCommande(Integer numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public Integer getNumeroFacture() {
        return numeroFacture;
    }


    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }
}

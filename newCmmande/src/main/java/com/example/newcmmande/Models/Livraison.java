package com.example.newcmmande.Models;

import java.sql.Date;

public class Livraison {
    private int idLivraison;
    private int numeroCommande;
    private Date dateLivraison;
    private int numeroFacture;
    public Livraison(int idLivraison, int numeroCommande, Date dateLivraison, int numeroFacture) {
        this.idLivraison = idLivraison;
        this.numeroCommande = numeroCommande;
        this.dateLivraison = dateLivraison;
        this.numeroFacture = numeroFacture;
    }

    public int getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public int getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }
}

package com.example.newcmmande.Models;

public class ProduitsansFacteur {
    private Integer numerocommande;
    private Integer numeroproduit;
    private String nom;
    private double prixtotal;
    public ProduitsansFacteur(Integer numerocommande,Integer numeroproduit,String nom,double prixtotal){
        this.numerocommande=numerocommande;
        this.numeroproduit=numeroproduit;
        this.nom=nom;
        this.prixtotal=prixtotal;
    }

    public Integer getNumerocommande() {
        return numerocommande;
    }

    public void setNumerocommande(Integer numerocommande) {
        this.numerocommande = numerocommande;
    }

    public Integer getNumeroproduit() {
        return numeroproduit;
    }

    public void setNumeroproduit(Integer numeroproduit) {
        this.numeroproduit = numeroproduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(double quantite) {
        this.prixtotal = quantite;
    }
}

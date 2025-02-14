package com.example.newcmmande.Models;

public class ProduitFactureLivr {
    private int numeroProduit;
    private String nomProduit;
    private int quantite;
    private double prix;
    private double tva;
    private double montantTTC;

    public ProduitFactureLivr(int numeroProduit, String nomProduit, int quantite, double prix, double tva, double montantTTC) {
        this.numeroProduit = numeroProduit;
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.prix = prix;
        this.tva = tva;
        this.montantTTC = montantTTC;
    }

    public int getNumeroProduit() {
        return numeroProduit;
    }

    public void setNumeroProduit(int numeroProduit) {
        this.numeroProduit = numeroProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }
}

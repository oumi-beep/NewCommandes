package com.example.newcmmande.Models;

public class Produit {
    private Integer id;
    private String nom;
    private Double prix;
    private Integer quantite;
    private String image;
    public Produit(Integer id,String nom,Double prix,Integer quantite,String image){
        this.id=id;
        this.nom=nom;
        this.prix=prix;
        this.quantite=quantite;
        this.image=image;
    }
    public Produit(Integer id,String nom,Integer quantite){
        this.id=id;
        this.nom=nom;
        this.quantite=quantite;
    }
    public Produit(Integer id,String nom,Integer quantite,double prix){
        this.id=id;
        this.nom=nom;
        this.quantite=quantite;
        this.prix=prix;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

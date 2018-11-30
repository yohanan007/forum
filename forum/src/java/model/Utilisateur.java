/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Stagiaire
 */
public class Utilisateur {
    
    int id_utilisateur;
    String nom;
    String prenom;
    String username;
    String mot_de_passe;
    String adresse_email;
    LocalDateTime date_de_naissance;
    LocalDateTime date_inscription;

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getAdresse_email() {
        return adresse_email;
    }

    public void setAdresse_email(String adresse_email) {
        this.adresse_email = adresse_email;
    }

    public LocalDateTime getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(LocalDateTime date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public LocalDateTime getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(LocalDateTime date_inscription) {
        this.date_inscription = date_inscription;
    }
    
    
}

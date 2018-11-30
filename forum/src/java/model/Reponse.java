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
public class Reponse {
    
    int id_reponse;
    String reponse;
    LocalDateTime date_de_post;
    Utilisateur utilisateur;
    Question questtion;

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public LocalDateTime getDate_de_post() {
        return date_de_post;
    }

    public void setDate_de_post(LocalDateTime date_de_post) {
        this.date_de_post = date_de_post;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Question getQuesttion() {
        return questtion;
    }

    public void setQuesttion(Question questtion) {
        this.questtion = questtion;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import model.Utilisateur;

/**
 *
 * @author Stagiaire
 */
public class UtilisateurDAO extends db.Connect {
    
  public UtilisateurDAO(){
      super();
  }
    
    public ArrayList<Utilisateur>  adminSelectAllUtilisateur()
    {
       
        
          Utilisateur utilisateur =  null; 
          
          ArrayList<Utilisateur> listUtilisateur = null;
          
        try{
             pst = connect.prepareStatement("SELECT * FROM utilisateur");
             rs = pst.executeQuery();
             while(rs.next()){
                  utilisateur = new Utilisateur();
                 utilisateur.setAdresse_email(rs.getString("adresse_email"));
                 utilisateur.setMot_de_passe("info secréte");
                 utilisateur.setId_utilisateur(rs.getInt("id_utilisateur"));
                 utilisateur.setNom(rs.getString("nom"));
                 utilisateur.setPrenom(rs.getString("prenom"));
                 utilisateur.setUsername(rs.getString("username"));
                 utilisateur.setDate_de_naissance(rs.getTimestamp("date_de_naissance").toLocalDateTime());
                 utilisateur.setDate_inscription(rs.getTimestamp("date_inscription").toLocalDateTime());
                 listUtilisateur.add(utilisateur);
             }
                     
        }catch(SQLException e){
            System.out.println("probleme de sql");
            e.getStackTrace();
        }
        
        return listUtilisateur;
    }
    
    public Utilisateur verifUtilisateur(String  motDePasse, String email)
    {
        // fonction non fini à modifier lors de haschage en inscription 
        
        Utilisateur utilisateur = null; 
        // haschage 
         String passhashed = BCrypt.hashpw(motDePasse, BCrypt.gensalt(10));
        System.out.println(motDePasse + " " + email);
        System.out.println("mot de passe transforme : " + passhashed);
        try{
            pst = connect.prepareStatement("SELECT * FROM utilisateur WHERE username = ? OR adresse_email = ?");
            pst.setString(1, email);
            pst.setString(2, email);
            rs = pst.executeQuery();
         
            while(rs.next())
            {
                   // haschage mot de passe et transformation en string 
                  
                   System.out.println("mdp recu : " + rs.getString("mot_de_passe"));
                 
                   if(BCrypt.checkpw(rs.getString("mot_de_passe"), passhashed))
                   {
                       utilisateur = new Utilisateur();
                       utilisateur.setAdresse_email(rs.getString("adresse_email"));
                       System.out.println(rs.getString("adresse_email"));
                       utilisateur.setDate_de_naissance(rs.getTimestamp("date_de_naissance").toLocalDateTime());
                       utilisateur.setId_utilisateur(rs.getInt("id_utilisateur"));
                       utilisateur.setNom(rs.getString("nom"));
                       utilisateur.setPrenom(rs.getString("prenom"));
                       utilisateur.setUsername(rs.getString("username"));
                   }
            }
        }catch(SQLException e){
            System.out.println("probleme de sql");
            e.getStackTrace();
        }
        
        return utilisateur;
    }
    
    
    public int inscritpionUtilisateur(String nom, String prenom, String username, String mdp, String adresseEmail, LocalDateTime date_de_naissance)
    {
        try{
            
           
           // conversion de la date de naissance en format timestamp
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Timestamp ts = Timestamp.valueOf(date_de_naissance.format(dtf));
            
            
            // le mot de passe est crypté 
            String cryMdp = BCrypt.hashpw(mdp, BCrypt.gensalt(10));
            
            // requête sql
            pst = connect.prepareStatement("INSERT INTO `utilisateur` (`id_utilisateur`, `nom`, `prenom`, `username`, `mot_de_passe`, `adresse_email`, `date_de_naissance`, `date_inscription`)\n" +
"			VALUES (NULL, ?, ?, ? , ? , ? , ? , CURRENT_TIMESTAMP)");
            // on donne des valeurs 
            pst.setString(1,nom);
            pst.setString(2,prenom);
            pst.setString(3, username);
            pst.setString(4,cryMdp);
            pst.setString(5, adresseEmail);
            pst.setTimestamp(6,ts);
            
            // l'execution de la requête renvoie le nombre de ligne crée 
            int nombre = pst.executeUpdate();
            System.out.println("sql ok nombre de ligne renvoye: " + nombre);
            pst.close();
            connect.close();
            return nombre;
            
            
            
        }catch(SQLException e){
            e.getStackTrace();
            System.out.println("problem : " + e);
            return 0;
        }
        
    }
}

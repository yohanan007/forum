/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Categorie;
import model.Question;
import model.Reponse;
import model.Utilisateur;

/**
 *
 * @author Stagiaire
 */
public class ReponseDAO extends db.Connect {

    public ReponseDAO() {
        super();
    }
 
   public ArrayList<Reponse> allReponseByIdQuestion(int id)
    {
        //fonction qui renvoie une liste de reponse de la bdd du forum par rapport à l'id d'une question fournit par l'utilisateur  
        
        // initialistaion des variables 
       ArrayList<Reponse> listReponse  = new ArrayList();
       Reponse reponse = null;
       Utilisateur utilisateur = null;
       Question question = null; 
       Categorie categorie = null; 
       
       
       
       try{
           // requête permettant de recevoir la liste de toute les reponses par rapport à l'id d'une question
           
           pst =  connect.prepareStatement("SELECT u.id_utilisateur, u.username, r.date_de_post, r.reponse, r.id_reponse, q.date_de_creation, q.question, q.id_question, c.categorie, c.id_categorie\n" +
"		FROM utilisateur u, reponse r, question q, categorie c\n" +
"				WHERE c.id_categorie = q.id_categorie\n" +
"						AND q.id_question = r.id_question \n" +
"								AND r.id_utilisateur = u.id_utilisateur\n" +
"									AND q.id_question = ? \n" +
"											ORDER BY r.date_de_post ");
           
           pst.setInt(1,id);
           
           rs =  pst.executeQuery();
           
           // on fait une boucle sur les données recu 
           while(rs.next()){
               
               reponse = new Reponse();
               utilisateur = new Utilisateur();
               question = new Question();
               categorie = new Categorie();
               
               // utilisateur ayant repondu à la question
               utilisateur.setId_utilisateur(rs.getInt("u.id_utilisateur"));
               utilisateur.setUsername(rs.getString("u.username"));
               
               
                //categorie de la question 
                categorie.setId_categorie(rs.getInt("c.id_categorie"));
                categorie.setNom_categorie(rs.getString("c.categorie"));
               
               //question posé 
               question.setId_question(rs.getInt("q.id_question"));
               question.setQuestion(rs.getString("q.question"));
               question.setDate_de_creation(rs.getTimestamp("q.date_de_creation").toLocalDateTime());
               question.setCategorie(categorie);
               
               //reponse donné 
               reponse.setId_reponse(rs.getInt("r.id_reponse"));
               reponse.setReponse(rs.getString("r.reponse"));
               reponse.setDate_de_post(rs.getTimestamp("r.date_de_post").toLocalDateTime());
               reponse.setQuesttion(question);
               reponse.setUtilisateur(utilisateur);
               
               
               // la reponse est integré dans la liste de reponse 
               listReponse.add(reponse);
           }
           
           
           
       }catch(SQLException e)
       {
           System.out.println("probleme de sql : " + e);
           e.getStackTrace();
       }
       
       // la fonction renvoie une list de reponse 
       return listReponse;
    }
   
    
   
   public int ReponseUtilisateurByIdUAndIdQ(String reponse, int idUtilisateur, int idQuestion)
   {
       int nombre = 0;
       if(reponse != null)
       {
           try{
               pst = connect.prepareStatement("INSERT INTO `reponse` (`id_reponse`, `reponse`, `date_de_post`, `id_question`, `id_utilisateur`)\n" +
"	VALUES (NULL, ?, CURRENT_TIMESTAMP, ? , ?)"); 
               pst.setString(1, reponse);
               pst.setInt(2, idQuestion);
               pst.setInt(3, idUtilisateur);
               nombre  = pst.executeUpdate();
               System.out.println("nombre de ligne renvoye par la bdd : " + nombre);
               
           }catch(SQLException e){
               System.out.println("probleme sql " + e );
               e.getStackTrace();
                
           }
         
           
       }
       
       return nombre;
   }
   
}

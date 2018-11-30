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
import model.Utilisateur;

/**
 *
 * @author Stagiaire
 */
public class QuestionDAO extends db.Connect {
    
    public QuestionDAO(){
            super();
            }
    
    public Question questionById(int id)
    {
        Question question = new Question();
        Utilisateur user =  new Utilisateur();
        Categorie cat = new Categorie();
        try{
            pst =  connect.prepareStatement("SELECT * FROM question q, utilisateur u, categorie c\n" +
"		WHERE c.id_categorie = q.id_categorie \n" +
"				AND q.id_utilisateur = u.id_utilisateur \n" +
"					AND q.id_question = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next())
            {
                // initialisation categorie
                cat.setId_categorie(rs.getInt("c.id_categorie"));
                cat.setNom_categorie(rs.getString("categorie"));
                
                // initilaisation de l'utilisateur et des valeurs qui nous interesserons plus tard 
                user.setId_utilisateur(rs.getInt("u.id_utilisateur"));
                user.setUsername("u.username");
                
                // initialisation de la question
                question.setCategorie(cat);
                question.setUtilisateur(user);
                question.setDate_de_creation(rs.getTimestamp("q.date_de_creation").toLocalDateTime());
                question.setId_question(rs.getInt("q.id_question"));
                question.setQuestion(rs.getString("q.question"));
            }
        }catch(SQLException e)
        {
           System.out.println("probleme sql : ");
            e.getStackTrace();
            
        }
        return question;
    }
    
    public ArrayList<Question> allQuestionByIdCategorie(int id)
    {
        Utilisateur user = null;
        Question quest = null;
        Categorie cat = null;
        
        // creatuion d'une liste de question 
        ArrayList<Question> listQuestion = new ArrayList();
        try{
            
            // requete sql 
            pst = connect.prepareStatement("SELECT q.date_de_creation, q.question, q.id_question ,c.categorie, u.username \n" +
"		FROM categorie c, question q, utilisateur u\n" +
"				WHERE c.id_categorie = q.id_categorie \n" +
"						AND q.id_utilisateur = u.id_utilisateur\n" +
"								AND c.id_categorie = ? ORDER BY q.date_de_creation");
            pst.setInt(1, id);
            // execution de la requete 
            rs = pst.executeQuery();
            while(rs.next()){
                
                // creation d'une nouvelle categorie
                cat = new Categorie();
                // initialisatiion categorie
                cat.setNom_categorie(rs.getString("c.categorie"));
                // creation d'un nouvel utilisateur 
                user = new Utilisateur();
                //initialisation
                user.setUsername(rs.getString("u.username"));
                // creation d'une question 
                quest = new Question();
                //initialisation de la question 
                quest.setDate_de_creation(rs.getTimestamp("q.date_de_creation").toLocalDateTime());
                quest.setId_question(rs.getInt("q.id_question"));
                quest.setQuestion(rs.getString("q.question"));
                quest.setUtilisateur(user);
                quest.setCategorie(cat);
                
                //insertion de la question dans la liste de question 
                listQuestion.add(quest);
                
            }
            
        }catch(SQLException e){
            System.out.println("probleme de sql: ");
            System.out.println(e);
            e.getStackTrace();
        }
        
        return listQuestion;
    }
    
    public int insertQuestion(String question, int id_utilisateur, int id_categorie)
    {
        try{
            // sql insertion
        pst = connect.prepareStatement("INSERT INTO `question` (`id_question`, `question`, `date_de_creation`, `id_utilisateur`, `id_categorie`) VALUES (NULL, ? , CURRENT_TIMESTAMP, ? , ?)");
       // variable en  insertion 
        pst.setString(1, question);
        pst.setInt(2, id_utilisateur);
        pst.setInt(3, id_categorie);
    int nombre =  pst.executeUpdate();
      
        return nombre;
    }
        catch(SQLException e){
            System.out.println("erreur sql");
            e.getStackTrace();
            return 0;
            
        }
       
    }
}

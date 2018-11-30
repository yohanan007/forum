/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Utilisateur;
import services.QuestionDAO;

/**
 *
 * @author Stagiaire
 * page permettant de poser une question sur le forum avec pour parametre
 * l'id de la categorie
 */
public class FormulaireQuestion extends HttpServlet {
    
    

    public static final String VUE = "/WEB-INF/formulaireQuestion.jsp";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // on verifie si l'utilisateur est bien connecte à partir de la session 
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null)
        {
            // si l'utilisateur est connecte todo...
            // on verifie que l'application à bien recu un parametre id en connexion 
            if(request.getParameter("id") != null && !request.getParameter("id").equals(""))
            {
           this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
           
            }else{
                // si il n'y a pas de parametre id on le redirige vers la page menu
                response.sendRedirect("menu");
            }
        }else{
            // si l'utilisateur n'est pas connecte celui ci est redirige vers l'index
            response.sendRedirect("index");
        }
        
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        if(!request.getParameter("comment").equals(""))
        {
            System.out.println("entree dans le post ");
            HttpSession session = request.getSession();
            try{
                // initialisation
                int idCategorie = (int)session.getAttribute("idCategorie");
            Utilisateur utilisateur = (Utilisateur)session.getAttribute("user");
            int idUtilisateur =  utilisateur.getId_utilisateur();
             System.out.println("id utilisateur : " +  idUtilisateur + "id categorie: " + idCategorie);
                        if(idCategorie != 0 && idUtilisateur != 0)
                        {
                            QuestionDAO question = new QuestionDAO();
                           int nombre =  question.insertQuestion(request.getParameter("comment"), idUtilisateur, idCategorie);
                           if(nombre == 1)
                           {
                               response.sendRedirect("question?id=" + idCategorie);
                           }else{
                               request.setAttribute("reponseErreur","probleme d'insertion dans la base de donnée contactez l'admin");
                               this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
                           }
                        }
            }
            catch(Exception e){
                System.out.println("probleme d'initialisation");
                e.getStackTrace();
                response.sendRedirect("menu");
       
            }
            
           
        }
        else{
            request.setAttribute("erreur", "votre champ est vide!");
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
    }

  
}

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
import services.ReponseDAO;

/**
 *
 * @author Stagiaire
 */
public class FormulaireReponse extends HttpServlet {

    public static String VUE = "/WEB-INF/formulaireReponse.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null)
        {
            if(request.getParameter("id") != null && !request.getParameter("id").equals(""))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("id", id);
                this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
                
            }else{
                response.sendRedirect("menu");
            }
            
        }else{
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
            // on ouvre une session
            HttpSession session = request.getSession();
            // on recupere l'objet utilisateur de la session 
            Utilisateur user =  (Utilisateur)session.getAttribute("user");
            // on recupere l'id de la question 
            int idQuestion = Integer.parseInt(session.getAttribute("idQuestion").toString());
            // on recupere l'id de l'utilisateur 
            int idUtilisateur = user.getId_utilisateur();
            
            // on utilise la classe ReponseDAO pour insere la reponse 
            ReponseDAO reponse = new ReponseDAO();
            // la methode renvoie le nombre de ligne modifie ds la bdd
            int nombre = reponse.ReponseUtilisateurByIdUAndIdQ(request.getParameter("comment"),idUtilisateur , idQuestion);
            if(nombre == 0)
            {
                // si rien ne c passé on reste sur la page 
                request.setAttribute("id", request.getParameter("id"));
               this.getServletContext().getRequestDispatcher(VUE).forward(request, response);  
            }else{
                // sinon on redirige vers la page de reponse à la question 
                response.sendRedirect("reponse?id="+idQuestion);
            }
        }else{
            request.setAttribute("id", request.getParameter("id"));
            // si le formulaire est vide on reste sur la page 
            request.setAttribute("erreur", "votre champ est vide!");
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);  
        }
       
    }

    

}

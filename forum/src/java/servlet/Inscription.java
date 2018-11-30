/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UtilisateurDAO;

/**
 *
 * @author Stagiaire
 */
public class Inscription extends HttpServlet {
public static String VUE = "/WEB-INF/inscription.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

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
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
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
        
        
        // reception des données du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String username = request.getParameter("username");
        String mdp = request.getParameter("pwd");
        String dateDeNaissance = request.getParameter("dateDeNaissance");
        String email = request.getParameter("email");
        String mdp2 = request.getParameter("pwd2");
        if(!nom.equals("")&&!prenom.equals("")&&!username.equals("")&&!mdp.equals("")&&!dateDeNaissance.equals("")&&!email.equals(""))
        {
        if(mdp2.equals(mdp))
        {
                        // si les mots de passe correspondent alors :

                         dateDeNaissance = dateDeNaissance + " 00:00";
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    UtilisateurDAO utilisateur =  new UtilisateurDAO();

                    // insertion dans la base de donnee, renvoie le nombre de ligne
                   int reponse =  utilisateur.inscritpionUtilisateur(nom, prenom, username, mdp, email, LocalDateTime.parse(dateDeNaissance, formatter));

                   if (reponse == 1)
                   {
                       // si tout est ok pas de probleme d'inscription redirection vers la servlet index 
                      response.sendRedirect("./index?reussi=reussi");
                   }else{
                       // si probléme d'insertion renvoie sur le formulaire un message d'erreur 
                       request.setAttribute("erreurSql", " probleme d'insertion dans la base de donnée ");
                       this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
                   }
        }
        
        else{
            // si les mots de passe ne correspondent pas renvoie un message d'ereur 
            request.setAttribute("erreurMdp", "vos deux mots de passe ne corresponde pas!");
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
        }else{
            request.setAttribute("erreurVide", "Tout vos champ ne sont pas remplis!");
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
}
}

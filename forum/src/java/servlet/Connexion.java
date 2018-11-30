/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Connexion extends HttpServlet {
    
     public static final String VUE = "/WEB-INF/connexion.jsp";

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
        
        String username = request.getParameter("username");
        String mdp = request.getParameter("pwd");
        
        UtilisateurDAO user =  new UtilisateurDAO();
        
      if(user.verifUtilisateur(mdp, username) != null)
              {
                  HttpSession session = request.getSession();
                  session.setAttribute("user", user.verifUtilisateur(mdp, username));
                   response.sendRedirect("menu"); 
              }else{
          
          request.setAttribute("erreur", "identifiant ou mot de passe incorrect");
          this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
      }
    }
}

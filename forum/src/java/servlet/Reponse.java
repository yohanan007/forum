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
import services.ReponseDAO;

/**
 *
 * @author Stagiaire
 * page affichant toutes les reponses asssocié à une question d'id envoyé par get
 */
public class Reponse extends HttpServlet {

   public static String VUE = "/WEB-INF/reponse.jsp";

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
        
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null)
        {
            // si l'utilisateur est bien connecté todo 
            
           if(request.getParameter("id") != null)
           {
               // on verifie que la servlet à bien recu un id correspondant à une question 
              try{
                   int id = Integer.parseInt(request.getParameter("id"));
                   ReponseDAO reponses = new ReponseDAO();
                   request.setAttribute("id", id);
                   session.setAttribute("idQuestion", id);
                   request.setAttribute("reponses", reponses.allReponseByIdQuestion(id));
                   this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
               }catch(Exception e){
                   // en cas de probleme rediretion vers le menu
                    response.sendRedirect("menu");
               }
               
           }else
           {
               // si l'id est null on fait une redirection vers le menu des categories 
               response.sendRedirect("menu");
           }
            
        }else{
            // si l'utilisateur n'est pas connecté alors redirection vers l'acceuil
            response.sendRedirect("index");
        }
       
    }

    

    

}

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
import services.QuestionDAO;

/**
 *
 * @author Stagiaire
 * page affichant la liste des questions concernant la categorie avec un id recu en get 
 */
public class Question extends HttpServlet {

    public static String VUE ="/WEB-INF/question.jsp";
   
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
        
        
        // on ouvre une session et on verifie quie l'utilisateur est bien connecté
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!= null)
        {
            // si l'utilisateur est bien connecté to do 
            try{
               int id =  Integer.parseInt(request.getParameter("id"));
               String categ = request.getParameter("categorie");
                QuestionDAO question = new QuestionDAO();
                session.setAttribute("idCategorie", id);
                request.setAttribute("questions",question.allQuestionByIdCategorie(id));
                request.setAttribute("categorie",categ);
                this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
                
                
            }catch(Exception e){
                response.sendRedirect("menu");
            }
            
        }else
        {
            // si l'utilisateur n'est pas connecté redirection vers la page d'acceuil
            response.sendRedirect("index");
            
        }
       
    }

  

}

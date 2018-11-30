/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Categorie;

/**
 *
 * @author Stagiaire
 */
public class CategorieDAO extends db.Connect{
    
    public CategorieDAO(){
    super();
                        }
        
    
    public ArrayList<Categorie> selectAllCategorie(){
       
        ArrayList<Categorie> listCategorie = new ArrayList();
   
        Categorie categorie = null;
        try{
            pst = connect.prepareStatement("SELECT * FROM categorie");
            rs = pst.executeQuery();
            while(rs.next()){
                categorie = new Categorie();
                categorie.setId_categorie(rs.getInt("id_categorie"));
                categorie.setNom_categorie(rs.getString("categorie"));
                listCategorie.add(categorie);
            }
        }catch(SQLException e){
            e.getStackTrace();
            System.out.println(" probleme de sql : " + e);
        }
        return listCategorie;
        
    }
    
}

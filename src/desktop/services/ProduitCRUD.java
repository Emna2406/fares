/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.services;


import desktop.entities.Produit;
import desktop.interfaces.EntityCRUD;
import desktop.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class ProduitCRUD implements EntityCRUD<Produit> {

    @Override
    public void AddEntity(Produit t) {
        try {
            String requete = "INSERT INTO produit (nom,stock) VALUES (" + "'" + t.getNom() + "','" + t.getStock() + "')";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Produit ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AddEntity2(Produit t) {
        try {
            String requete = "INSERT INTO produit (nom,Stock) VALUES (?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);

            pst.setString(1, t.getNom());
            pst.setInt(2, t.getStock());
            pst.executeUpdate();

            System.out.println("success !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Produit> display() {
        List<Produit> myList = new ArrayList<>();
            try {
        String requete = "SELECT * FROM produit" ;
        Statement st;
        
            st = MyConnection.getInstance().getCnx().createStatement();
        
        ResultSet rs = st.executeQuery(requete);
        while (rs.next())
        {
           Produit p = new Produit();
            p.setId(rs.getInt(1));
            p.setNom(rs.getString("nom"));
            p.setStock(rs.getInt("stock"));
            myList.add(p);

            
            
        }
            }
        
       
    
        catch (SQLException ex) {
            System.out.println(ex.getMessage());    
        }
    
return myList;
}
}



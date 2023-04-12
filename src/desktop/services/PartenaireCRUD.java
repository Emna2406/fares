/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.services;

import desktop.entities.Partenaire;
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
public class PartenaireCRUD implements EntityCRUD<Partenaire> {

   

    public void AddEntity(Partenaire t) {
        try {
            String requete = "INSERT INTO partenaire (nom,prenom) VALUES (?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);

            pst.setString(1, t.getNom());
            pst.setString(2, t.getEmail());
            pst.executeUpdate();

            System.out.println("success !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Partenaire> display() {
        List<Partenaire> myList = new ArrayList<>();
            try {
        String requete = "SELECT * FROM partenaire" ;
        Statement st;
        
            st = MyConnection.getInstance().getCnx().createStatement();
        
        ResultSet rs = st.executeQuery(requete);
        while (rs.next())
        {
            Partenaire p = new Partenaire();
            p.setId(rs.getInt(1));
            p.setNom(rs.getString("nom"));
            p.setEmail(rs.getString("email"));
            myList.add(p);

            
            
        }
            }
        
       
    
        catch (SQLException ex) {
            System.out.println(ex.getMessage());    
        }
    
return myList;
}
}


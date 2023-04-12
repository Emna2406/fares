/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.entities;

/**
 *
 * @author msi
 */
public class Partenaire {
     private int id;
    private String nom;
    private String email;

    public Partenaire(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public Partenaire(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public Partenaire() {
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Partenaire{" + "id=" + id + ", nom=" + nom + ", email=" + email + '}';
    }
    
    
}

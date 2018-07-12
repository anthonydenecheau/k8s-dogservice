package com.scc.dog.model;

public class Dog{

    private int id;
    private String nom;
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public Dog withId(int id){ this.setId( id ); return this; }
    public Dog withNom(String nom){ this.setNom(nom); return this; }
    
    @Override
    public String toString() {
        return "Dog [id=" + id + ", nom=" + nom + "]";
    }
	
}

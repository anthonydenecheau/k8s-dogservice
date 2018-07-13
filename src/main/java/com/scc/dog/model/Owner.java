package com.scc.dog.model;

public class Owner {

    private int id;
    private String name;
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Owner withId(int id){ this.setId( id ); return this; }
    public Owner withName(String name){ this.setName(name); return this; }
    
    @Override
    public String toString() {
        return "Owner [id=" + id + ", name=" + name + "]";
    }
}

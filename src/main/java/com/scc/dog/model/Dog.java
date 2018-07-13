package com.scc.dog.model;

public class Dog{

    private int id;
    private String name;
    private Owner owner;
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public Dog withId(int id){ this.setId( id ); return this; }
    public Dog withName(String name){ this.setName(name); return this; }
    public Dog withOwner(Owner owner){ this.setOwner(owner); return this; }

    @Override
    public String toString() {
        return "Dog [id=" + id + ", name=" + name + ", owner=" + owner.toString() + "]";
    }
}

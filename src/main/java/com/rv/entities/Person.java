package com.rv.entities;

public abstract class Person {
  
    protected int id;
    protected String nomComplet;
    protected String type;

    public Person(int id, String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
    }

    public Person() {
    }

    public Person(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }    
    
    @Override
    public String toString() {
        return "[id=" + id + ", nomComplet=" + nomComplet ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
}

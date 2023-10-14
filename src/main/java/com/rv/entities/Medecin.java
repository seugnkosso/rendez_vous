package com.rv.entities;

public class Medecin  extends Person{
    private String grade;

    public Medecin(int id, String nomComplet, String grade) {
        super(id, nomComplet);
        this.grade = grade;
        this.type = "medecin";
    }

    public Medecin() {
        super();
        this.type = "medecin";
    }

    public Medecin(String nomComplet, String grade) {
        super(nomComplet);
        this.type = "medecin";
        this.grade = grade;
    }

    public Medecin(String nomComplet,String type, String grade) {
        super(nomComplet);
        this.type = "medecin";
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Medecin "+ super.toString() +"grade=" + grade + "]";
    }
}

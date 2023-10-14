package com.rv.entities;

public class Patient extends Person {
    private String antecedent;

    public Patient(String nomComplet) {
        super(nomComplet);
        this.type = "patient";
    }

    public Patient(int id, String nomComplet) {
        super(id,nomComplet);
        this.type = "patient";
    }

    public Patient() {
        super();
        this.type = "patient";
    }

    public Patient(String nomComplet, String antecedent) {
        super(nomComplet);
        this.type = "patient";
        this.antecedent = antecedent;
    }

    public String getAntécédent() {
        return antecedent;
    }

    public void setAntécédent(String antecedent) {
        this.antecedent = antecedent;
    }

    @Override
    public String toString() {
        return "Patient " + super.toString() + " antecedent=" + antecedent + "]";
    }
    
}

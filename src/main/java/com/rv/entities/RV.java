package com.rv.entities;

import java.sql.Date;

import com.rv.services.Iservice;

public class RV {
    private int id;
    private Date date;
    private String etat;
    private Iservice<Patient> PService;
    private Iservice<Medecin> MService;
    

    private int idpatient;
    private int idmedecin ;

    
    public RV(int id, Date date, int patient, int medecin,String etat,Iservice<Patient> p,Iservice<Medecin> m) {
        this.id = id;
        this.date = date;
        this.idpatient = patient;
        this.idmedecin = medecin;
        this.etat = etat;
        this.PService = p;
        this.MService = m;
    }
    public RV(int id, Date date) {
        this.id = id;
        this.date = date;
    }
    public RV() {
    }
    public RV(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        Patient p = this.PService.findById(this.idpatient);
        return p;
    }
    public int getIdPatient() {
        return this.idpatient;
    }  
    public void setPatient(int idpatient) {
        this.idpatient = idpatient;
    }
    public Medecin getMedecin() {
        Medecin M = this.MService.findById(this.idmedecin);
        return M;
    }
    public int getIdMedecin() {
        return this.idmedecin;
    }
    public void setMedecin(int medecin) {
        this.idmedecin = medecin;
    }

    
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RV [id= " + id + ", date= " + date + ", patient= " + getPatient().getNomComplet() + ", medecin= " + getMedecin().getNomComplet() + " etat= " + etat + "]";
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
        RV other = (RV) obj;
        if (id != other.id)
            return false;
        return true;
    }
      
}

package com.rv.repositories;

import java.sql.SQLException;

import com.rv.entities.Patient;

import com.rv.repositories.core.dBImpl;

public class PatienBdImpl implements PatientBd {

    private dBImpl db;
    Patient patient;
    public PatienBdImpl(dBImpl db) {
        this.db = db;
    }

    @Override
    public int insert(Patient obj) {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("insert into Person values(Null,?,?,Null,Null)"));
            db.getPstmt().setString(1, obj.getNomComplet());
            db.getPstmt().setString(2, obj.getType());
            int res = db.getPstmt().executeUpdate();
            db.closeConnexion();
            return res;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Patient findById(int nextInt) {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("select * from Person Where id = ? and type = ?"));
            db.getPstmt().setInt(1, nextInt);
            db.getPstmt().setString(2, "patient");
            db.setRes(db.getPstmt().executeQuery());
            patient = null;
            if(db.getRes().next()){
               patient = new Patient(db.getRes().getInt("id"),db.getRes().getString("nomComplet"));
            }
            db.closeConnexion();            
            return patient;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return patient;
        }
    }

    @Override
    public int lastInsertId() {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("select MAX(id) as 'id' from person"));
            db.setRes(db.getPstmt().executeQuery());
            int id = -1;
            if(db.getRes().next()){
                id = db.getRes().getInt("id");
            }
            db.closeConnexion();
            return id;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
    }
    
    
    
}

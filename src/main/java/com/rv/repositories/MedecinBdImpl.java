package com.rv.repositories;

import java.sql.SQLException;

import com.rv.entities.Medecin;
import com.rv.repositories.core.dBImpl;

public class MedecinBdImpl implements MedecinBd {
    private dBImpl db;
    private Medecin medecin;
    public MedecinBdImpl(dBImpl db) {
        this.db = db;
    }
    @Override
    public int insert(Medecin obj) {
         db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("insert into Person values(Null,?,?,?,Null)"));
            db.getPstmt().setString(1, obj.getNomComplet());
            db.getPstmt().setString(2, obj.getType());
            db.getPstmt().setString(3, obj.getGrade());
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
    public Medecin findById(int nextInt) {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("select * from Person Where id = ? and type = ?"));
            db.getPstmt().setInt(1, nextInt);
            db.getPstmt().setString(2, "medecin");
            db.setRes(db.getPstmt().executeQuery());
            medecin = null;
            if(db.getRes().next()){
               medecin = new Medecin(db.getRes().getInt("id"),db.getRes().getString("nomComplet"),db.getRes().getString("grade"));
            }
            db.closeConnexion();            
            return medecin;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return medecin;
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

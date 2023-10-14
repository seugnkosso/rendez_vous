package com.rv.repositories;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.entities.RV;
import com.rv.repositories.core.dBImpl;
import com.rv.services.Iservice;

public class RvBdImpl implements RvBd {
    private ArrayList<RV> rv = new ArrayList<RV>();
    private RV Rv ;

    private dBImpl db;
    public RvBdImpl(dBImpl db) {
        this.db = db;
    }

    @Override
    public int insert(RV obj) {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("insert into rv values(Null,?,?,?,'en attente')"));
            db.getPstmt().setDate(1, obj.getDate());
            db.getPstmt().setInt(2, obj.getIdMedecin());
            db.getPstmt().setInt(3, obj.getIdPatient());
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
    public RV findById(int nextInt) {
         db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("select * from rv Where id = ?"));
            db.getPstmt().setInt(1, nextInt);        
            db.setRes(db.getPstmt().executeQuery());
            Rv = null;
            if(db.getRes().next()){
               Rv = new RV(db.getRes().getInt("id"),db.getRes().getDate("date"));
            }
            db.closeConnexion();            
            return Rv;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Rv;
        }
    }

    @Override
    public int lastInsertId() {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("select MAX(id) as 'id' from rv"));
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

    @Override
    public ArrayList<RV> findAllRvDay(Iservice<Patient> PService,Iservice<Medecin> MService) {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("select * from rv where date = ?"));
            Calendar cal = Calendar.getInstance();
            Date date = new Date(cal.getTime().getTime());
            db.getPstmt().setDate(1,date);            
            db.setRes(db.getPstmt().executeQuery());
            rv.clear();
            while(db.getRes().next()){                
                int id = db.getRes().getInt("id");              
                String etat = db.getRes().getString("etat");
                int idMedecin = db.getRes().getInt("idmedecin");
                int idPatient = db.getRes().getInt("idpatient");
                RV Rv = new RV(id,date,idPatient,idMedecin,etat,PService,MService);
                rv.add(Rv);
            }            
            db.closeConnexion();
            return rv;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<RV> findAllRvMedecin(Iservice<Patient> pService, Iservice<Medecin> mService, int idMedecin) {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("select * from rv where idmedecin = ?"));
            db.getPstmt().setInt(1,idMedecin);            
            db.setRes(db.getPstmt().executeQuery());
            rv.clear();
            while(db.getRes().next()){                
                int id = db.getRes().getInt("id");              
                String etat = db.getRes().getString("etat");
                Date date = db.getRes().getDate("date");
                int idmedecin = db.getRes().getInt("idmedecin");
                int idPatient = db.getRes().getInt("idpatient");
                RV Rv = new RV(id,date,idPatient,idmedecin,etat,pService,mService);
                rv.add(Rv);
            }            
            db.closeConnexion();
            return rv;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int AnnuleRv(int idRv) {
        db.openConnexion();
        try {
            db.setPstmt(db.getConn().prepareStatement("update rv set etat = 'Annuler' where id = ?"));
            db.getPstmt().setInt(1,idRv);            
            int nbr = db.getPstmt().executeUpdate();            
            db.closeConnexion();
            return nbr;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
    }
    
}

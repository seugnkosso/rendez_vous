package com.rv.services;

import java.util.ArrayList;


import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.entities.RV;
import com.rv.repositories.Irepositories;
import com.rv.repositories.RvBd;

public class RvserviceImpl implements RvService {
    private Irepositories<RV> rvRepositories;
    private RvBd rvImpl;

    public RvserviceImpl(Irepositories<RV> rvRepositories) {
        this.rvRepositories = rvRepositories;
    }

    public RvserviceImpl(RvBd rvImpl) {
        this.rvImpl = rvImpl;
    }


    @Override
    public int add(RV obj) {
        return  rvRepositories.insert(obj);
    }

    @Override
    public RV findById(int nextInt) {
        return rvRepositories.findById(nextInt);
    }

    @Override
    public int lastInsertId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastInsertId'");
    }

    @Override
    public ArrayList<RV> Rvdujour(Iservice<Patient> PService,Iservice<Medecin> MService) {       
        return rvImpl.findAllRvDay(PService,MService);
    }

    @Override
    public ArrayList<RV> RvMedecin(Iservice<Patient> PService, Iservice<Medecin> MService, int idMedecin) {
        return rvImpl.findAllRvMedecin(PService,MService,idMedecin);
    }

    @Override
    public int AnnuleRv(int idRv) {
        return rvImpl.AnnuleRv(idRv);
    }    
}

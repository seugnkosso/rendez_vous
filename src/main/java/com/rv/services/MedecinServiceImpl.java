package com.rv.services;

import com.rv.entities.Medecin;
import com.rv.repositories.Irepositories;

public class MedecinServiceImpl implements MedecinService {
    private Irepositories<Medecin> medecinRepositories ;
    public MedecinServiceImpl(Irepositories<Medecin> medecinRepositories) {
        this.medecinRepositories = medecinRepositories;
    }
    @Override
    public int add(Medecin obj) {
        return medecinRepositories.insert(obj);
    }
    @Override
    public Medecin findById(int nextInt) {
       return medecinRepositories.findById(nextInt);
    }
    @Override
    public int lastInsertId() {
        return medecinRepositories.lastInsertId();
    }
    
}

package com.rv.repositories;

import java.util.ArrayList;

import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.entities.RV;
import com.rv.services.Iservice;

public interface RvBd extends Irepositories<RV> {
    ArrayList<RV> findAllRvDay(Iservice<Patient> PService,Iservice<Medecin> MService);

    ArrayList<RV> findAllRvMedecin(Iservice<Patient> pService, Iservice<Medecin> mService, int idMedecin);

    int AnnuleRv(int idRv);
}

package com.rv.services;

import java.util.ArrayList;

import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.entities.RV;

public interface RvService extends Iservice<RV>{
    ArrayList<RV> Rvdujour(Iservice<Patient> PService,Iservice<Medecin> MService);
    ArrayList<RV> RvMedecin(Iservice<Patient> PService,Iservice<Medecin> MService,int idMedecin);
    int AnnuleRv(int idRv);
}

package com.rv.services;

import com.rv.entities.Patient;
import com.rv.repositories.Irepositories;

public class PatientServiceImpl implements PatientService {
    
    private Irepositories<Patient> patientRepos ;

    public PatientServiceImpl(Irepositories<Patient> patientRepos) {
        this.patientRepos = patientRepos;
    }
    
    @Override
    public int add(Patient patient) {
        return patientRepos.insert(patient);
    }

    @Override
    public Patient findById(int nextInt) {
        return patientRepos.findById(nextInt);
    }

    @Override
    public int lastInsertId() {
        return patientRepos.lastInsertId();
    }
    
}

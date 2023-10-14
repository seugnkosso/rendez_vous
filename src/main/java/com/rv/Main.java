package com.rv;

import java.sql.Date;
import java.util.Scanner;

import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.entities.RV;
import com.rv.repositories.Irepositories;
import com.rv.repositories.MedecinBdImpl;
import com.rv.repositories.PatienBdImpl;
import com.rv.repositories.RvBd;
import com.rv.repositories.RvBdImpl;
import com.rv.repositories.core.MySql;
import com.rv.repositories.core.dBImpl;
import com.rv.services.Iservice;
import com.rv.services.MedecinServiceImpl;
import com.rv.services.PatientServiceImpl;
import com.rv.services.RvService;
import com.rv.services.RvserviceImpl;

public class Main {
    public static void main(String[] args) {
        dBImpl DB = new MySql();
        Irepositories<Patient> patientRepositories = new PatienBdImpl(DB);
        Iservice<Patient> patientService = new PatientServiceImpl(patientRepositories);
        Irepositories<Medecin> medecinRepositories = new MedecinBdImpl(DB);
        Iservice<Medecin> medecinService = new MedecinServiceImpl(medecinRepositories);
        Irepositories<RV> rvRepositories = new RvBdImpl(DB);
        Iservice<RV> rvService = new RvserviceImpl(rvRepositories);
        RvBd rvRepositoriesImpl = new RvBdImpl(DB);
        RvService rvServiceImpl = new RvserviceImpl(rvRepositoriesImpl);
        try (Scanner sc = new Scanner(System.in)) {
            int choix;
            do{
                System.out.println("1 => creer un patient");
                System.out.println("2 => creer un medecin");
                System.out.println("3 => planifier un rv");
                System.out.println("4 => rv du jour");
                System.out.println("5 => rv d'un medecin");
                System.out.println("6 => annuler un rv");
                System.out.println("7 => quitter");

                choix = sc.nextInt();
                sc.nextLine();

                switch(choix){
                    case 1 :                        
                        System.out.println("entrer le nomComplet du patient");
                        String nomComplet = sc.nextLine();
                        Patient patient = new Patient(nomComplet);
                        patientService.add(patient);                
                        break;
                    case 2 :  
                        System.out.println("entrer le nomComplet du medecin");
                        nomComplet = sc.nextLine();
                        System.out.println("entrer le grade du medecin");
                        String grade = sc.nextLine();
                        Medecin medecin = new Medecin(nomComplet,grade);
                        medecinService.add(medecin);
                        break;
                    case 3 :
                        System.out.println("entrer l'id du patient");
                        patient = patientService.findById(sc.nextInt());
                        sc.nextLine();                            
                        if(patient == null){
                            System.out.println("le patient n'existe pas enregistrer le");
                            System.out.println("-");
                            System.out.println("entrer le nomComplet du patient");
                            patient = new Patient(sc.nextLine());  
                            patient.setId(-1);
                        }                          
                        System.out.println("entrer l'id du medecin");
                        medecin = medecinService.findById(sc.nextInt());
                        sc.nextLine();                    
                        if(medecin == null){
                            System.out.println("le medecin n'existe pas enregistrer le");
                            System.out.println("-");
                            System.out.println("entrer le nomComplet du medecin");
                            nomComplet = sc.nextLine();
                            System.out.println("entrer le grade du medecin");
                            grade = sc.nextLine();
                            medecin = new Medecin(nomComplet,grade);                                                       
                            medecin.setId(-1);
                        }                        
                        System.out.println("entrer la date du rendez-vous");
                        System.out.println("format annéé-mois-jour");                                              
                        Date dat = Date.valueOf(sc.nextLine());
                        RV rv = new RV(dat); 
                        if(patient.getId() == -1){
                            patientService.add(patient);
                            patient.setId(patientService.lastInsertId());                   
                        }
                        if(medecin.getId() == -1){
                            medecinService.add(medecin);                    
                            medecin.setId(medecinService.lastInsertId());                   
                        }
                        rv.setPatient(patient.getId());
                        rv.setMedecin(medecin.getId());   
                        rvService.add(rv);
                        break;
                    case 4 :
                        rvServiceImpl.Rvdujour(patientService,medecinService).forEach(System.out::println);
                        break;
                    case 5:
                        System.out.println("entrer l'id du medecin");
                        medecin =medecinService.findById(sc.nextInt());
                        sc.nextLine();
                        if(medecin == null){
                            System.out.println("le medecin n'existe pas");
                        }else{
                            rvServiceImpl.RvMedecin(patientService,medecinService,medecin.getId()).forEach(System.out::println);
                        }
                        break;
                    case 6:
                        System.out.println("entrer l'id du rv");
                        rv = rvService.findById(sc.nextInt());
                        if(rv == null){
                            System.out.println("le rv n'existe pas");
                        }else{
                            rvServiceImpl.AnnuleRv(rv.getId());
                        }
                        break;
                }
            }while(choix != 7);            
        }
    }
}
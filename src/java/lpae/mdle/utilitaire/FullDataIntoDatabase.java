/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.mdle.utilitaire;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lpae.entites.Departement;
import lpae.entites.Ecole;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import lpae.entites.Region;

/**
 *
 * @author michel
 */
@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class FullDataIntoDatabase {
    @PersistenceContext//(unitName = "LPAE2PU")
    private EntityManager em;

    
    
    @PostConstruct
    public void applicationStartup() {
        System.out.println("debut insertion des utilisateurs");
        /*ArrayList<Departement> listeDesDepartements = this.dataEcoles();
        for (Departement next : listeDesDepartements) {
            em.persist(next);
        }*/
        
        ArrayList<Region> listeDesRegions= this.dataEcoles();
        for (Region next : listeDesRegions) {
            em.persist(next);
        }
        System.out.println("fin insertion");
    }

    @PreDestroy
    public void applicationShutdown() {
        System.out.println("application shutdown");
    }

    public ArrayList<Region> dataEcoles()/*Departement*/
    {
        Departement departement = new Departement("Alpes-Maritimes");
        ArrayList<Ecole> ecoles = new ArrayList<>();
        ArrayList<Region> regions = new ArrayList<>();
        
        /**
         * Regions
         */
        Region region1 = new Region("Alsace");
        Region region2 = new Region("Aquitaine");
        Region region3 = new Region("Auvergne");
        Region region4 = new Region("Basse-Normandie");
        Region region5 = new Region("Bourgogne");
        Region region6 = new Region("Bretagne");
        
        Region region7 = new Region("Centre");
        Region region8 = new Region("Champagne-Ardenne");
        Region region9 = new Region("Corse");
        Region region10 = new Region("Franche-Comté");
        Region region11 = new Region("Haute-Normandie");
        Region region12 = new Region("Ile-de-France");
        
        Region region13 = new Region("Languedoc-Roussillon");
        Region region14 = new Region("Limousin");
        Region region15 = new Region("Lorraine");
        Region region16 = new Region("Midi-Pyrénées");
        Region region17 = new Region("Nord-Pas-de-Calais");
        Region region18 = new Region("Pays de la Loire");
        Region region19 = new Region("Picardie");
        Region region20 = new Region("Picardie");
        
        Region region21 = new Region("Provence-Alpes-Côte d'Azur");
        Region region22 = new Region("Rhône-Alpes");
        Region region23 = new Region("Guadeloupe");
        Region region24 = new Region("Martinique");
        Region region25 = new Region("Guyane");
        
        Region region26 = new Region("Réunion");
        
        regions.add(region1);
        regions.add(region2);
        regions.add(region3);
        regions.add(region4);
        regions.add(region5);
        regions.add(region6);
        
        regions.add(region7);
        regions.add(region8);
        regions.add(region9);
        regions.add(region10);
        regions.add(region11);
        
        regions.add(region12);
        regions.add(region13);
        regions.add(region14);
        regions.add(region15);
        regions.add(region16);
        regions.add(region17);
        
        regions.add(region18);
        regions.add(region19);
        regions.add(region20);
        regions.add(region21);
        regions.add(region22);
        
        regions.add(region23);
        regions.add(region24);
        regions.add(region25);
        regions.add(region26);
        
        region21.addDepartement(departement);
        
        
        ArrayList<Departement> departements = new ArrayList<>();
        Ecole ecole1 = new Ecole("Universite de Nice");
        Ecole ecole2 = new Ecole("Polytech Nice-Sophia");
        Ecole ecole3 = new Ecole("Skema Business Scholl");
        Ecole ecole4 = new Ecole("EIT");
         
        departement.addEcole(ecole1);
        departement.addEcole(ecole2);
        departement.addEcole(ecole3);
        departement.addEcole(ecole4);
        
        //departements.add(departement);
        //return departements;
        return regions;
    }
    
}

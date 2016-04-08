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
import lpae.entites.Categorie;
import lpae.entites.Region;
import lpae.entites.TypeAnnonce;
import lpae.entites.TypeCategorie;

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
        
        ArrayList<TypeCategorie> listeDesTypesCategories= this.managerCategorie();
        for (TypeCategorie typeCategorie : listeDesTypesCategories) {
            em.persist(typeCategorie);
        }
        
        ArrayList<TypeAnnonce> listeDesTypesAnnonces= this.dataTypeAnnonce();
        for (TypeAnnonce typeAnnonce : listeDesTypesAnnonces) {
            em.persist(typeAnnonce);
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
    
    public ArrayList<TypeCategorie> managerCategorie()
    {
        System.out.println("debut insertion categorie !!");
        ArrayList<TypeCategorie> typesCategories = new ArrayList<TypeCategorie>();
        TypeCategorie type1 = new TypeCategorie();
        type1.setNomTyp("-- VEHICULES --");
        Categorie categorie1= new Categorie();
        categorie1.setLibelle("Voitures");
        categorie1.setIsSubAnnonce(true);
        type1.addCategorie(categorie1);
        
        Categorie categorie2= new Categorie();
        categorie2.setLibelle("Motos");
        categorie2.setIsSubAnnonce(true);
        type1.addCategorie(categorie2);
         
        Categorie categorie3= new Categorie();
        categorie3.setLibelle("Caravaning");
        categorie3.setIsSubAnnonce(false);
        type1.addCategorie(categorie3);
        
        Categorie categorie4= new Categorie();
        categorie4.setLibelle("Equipement Auto");
        categorie4.setIsSubAnnonce(false);
        type1.addCategorie(categorie4);
        
        Categorie categorie5= new Categorie();
        categorie5.setLibelle("Equipement Moto");
        categorie5.setIsSubAnnonce(false);
        type1.addCategorie(categorie5);
        typesCategories.add(type1);
        
        TypeCategorie type2 = new TypeCategorie();
        type2.setNomTyp("-- MULTIMEDIA --");
        
        Categorie categorie21= new Categorie();
        categorie21.setLibelle("Informatique");
        categorie21.setIsSubAnnonce(false);
        type2.addCategorie(categorie21);
        
        Categorie categorie22= new Categorie();
        categorie22.setLibelle("Consoles & Jeux video");
        categorie22.setIsSubAnnonce(false);
        type2.addCategorie(categorie22);
        
        Categorie categorie23= new Categorie();
        categorie23.setLibelle("Image & Son");
        categorie23.setIsSubAnnonce(false);
        type2.addCategorie(categorie23);
        
        Categorie categorie24= new Categorie();
        categorie24.setLibelle("Telephonie");
        categorie24.setIsSubAnnonce(false);
        type2.addCategorie(categorie24);
        typesCategories.add(type2);
        
        TypeCategorie type3 = new TypeCategorie();
        type3.setNomTyp("-- LOISIR --");
        
        Categorie categorie31 =new Categorie();
        categorie31.setLibelle("DVD / Films");
        categorie31.setIsSubAnnonce(false);
        type3.addCategorie(categorie31);
        
        Categorie categorie32 =new Categorie();
        categorie32.setLibelle("CD / Musique");
        categorie32.setIsSubAnnonce(false);
        type3.addCategorie(categorie32);
        
        Categorie categorie33 =new Categorie();
        categorie33.setLibelle("Livres");
        categorie33.setIsSubAnnonce(false);
        type3.addCategorie(categorie33);
        
        Categorie categorie34 =new Categorie();
        categorie34.setLibelle("Velos");
        categorie34.setIsSubAnnonce(false);
        type3.addCategorie(categorie34);
        
        Categorie categorie35 =new Categorie();
        categorie35.setLibelle("Instruments de Musique");
        categorie35.setIsSubAnnonce(false);
        type3.addCategorie(categorie35);
        
        Categorie categorie36 =new Categorie();
        categorie36.setLibelle("Jeux & Jouets");
        categorie36.setIsSubAnnonce(false);
        type3.addCategorie(categorie36);
        
        Categorie categorie37 =new Categorie();
        categorie37.setLibelle("Vins & Gastronomie");
        categorie37.setIsSubAnnonce(false);
        type3.addCategorie(categorie37);
        
        typesCategories.add(type3);
        
        System.out.println("Fin insertion categorie !!");
        return typesCategories;
    }
    
    public ArrayList<TypeAnnonce> dataTypeAnnonce()
    {
        ArrayList<TypeAnnonce> typesAnnonces = new ArrayList<TypeAnnonce>();
        System.out.println("debut insertion type annonce !!");
        TypeAnnonce type1= new TypeAnnonce();
        type1.setLibelle("Offres");
        typesAnnonces.add(type1);
        
        TypeAnnonce type2= new TypeAnnonce();
        type2.setLibelle("Recherches");
        typesAnnonces.add(type2);
        
        return typesAnnonces;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.mdle.utilitaire;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ejb.EJB;
import lpae.annonce.gestionnaire.GreAnnonce;
import lpae.categorie.gestionnaire.GreCategorie;
import lpae.ecole.gestionnaire.GreEcole;
import lpae.entites.Annonce;
import lpae.entites.Categorie;
import lpae.entites.EcoleUtilisateur;
import lpae.entites.Region;
import lpae.entites.TypeAnnonce;
import lpae.entites.TypeCategorie;
import lpae.entites.Utilisateur;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import lpae.entites.PhotoAnnonce;

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
    
    @EJB
    private GreEcole greEcole;
    
    @EJB
    private GreCategorie greCategorie;

    @EJB
    private GreAnnonce greAnnonce;
    
    private List<Ecole> listesEcoles = new ArrayList<>();

    @PostConstruct
    public void applicationStartup() {
        System.out.println("debut insertion des utilisateurs");
        /*ArrayList<Departement> listeDesDepartements = this.dataEcoles();
         for (Departement next : listeDesDepartements) {
         em.persist(next);
         }*/

        ArrayList<Region> listeDesRegions = this.dataEcoles();
        for (Region next : listeDesRegions) {
            em.persist(next);
        }

        ArrayList<TypeCategorie> listeDesTypesCategories = this.managerCategorie();
        for (TypeCategorie typeCategorie : listeDesTypesCategories) {
            em.persist(typeCategorie);
        }

        ArrayList<TypeAnnonce> listeDesTypesAnnonces = this.dataTypeAnnonce();
        for (TypeAnnonce typeAnnonce : listeDesTypesAnnonces) {
            em.persist(typeAnnonce);
        }
        
        /*
        chargement des autres ecoles
         */
        this.listesEcoles.stream().forEach((ecole) -> {
            em.persist(ecole);
        });
        
        
        createUtilisateur();
         
        System.out.println("fin insertion datas biz glassfish works!! gooooooooo");
        
        
    }

    @PreDestroy
    public void applicationShutdown() {
        System.out.println("application shutdown");
    }

    public ArrayList<Region> dataEcoles()/*Departement*/ {
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
        ecole1.setLatitude(43.716047);
        ecole1.setLongitude(7.267597);
        //Ecole ecole2 = new Ecole("Polytech Nice-Sophia");
        Ecole ecole3 = new Ecole("Skema Business Scholl");
        ecole3.setLatitude(43.613038);
        ecole3.setLongitude(7.056262);
        Ecole ecole4 = new Ecole("EIT");

        departement.addEcole(ecole1);
        //departement.addEcole(ecole2);
        departement.addEcole(ecole3);
        departement.addEcole(ecole4);
        
       this.saveDatasEcoles(departement);
        

        //departements.add(departement);
        //return departements;
        return regions;
    }

    public ArrayList<TypeCategorie> managerCategorie() {
        System.out.println("debut insertion categorie !!");
        ArrayList<TypeCategorie> typesCategories = new ArrayList<TypeCategorie>();
        TypeCategorie type1 = new TypeCategorie();
        type1.setNomTyp("-- VEHICULES --");
        Categorie categorie1 = new Categorie();
        categorie1.setLibelle("Voitures");
        categorie1.setIsSubAnnonce(true);
        type1.addCategorie(categorie1);

        Categorie categorie2 = new Categorie();
        categorie2.setLibelle("Motos");
        categorie2.setIsSubAnnonce(true);
        type1.addCategorie(categorie2);

        Categorie categorie3 = new Categorie();
        categorie3.setLibelle("Caravaning");
        categorie3.setIsSubAnnonce(false);
        type1.addCategorie(categorie3);

        Categorie categorie4 = new Categorie();
        categorie4.setLibelle("Equipement Auto");
        categorie4.setIsSubAnnonce(false);
        type1.addCategorie(categorie4);

        Categorie categorie5 = new Categorie();
        categorie5.setLibelle("Equipement Moto");
        categorie5.setIsSubAnnonce(false);
        type1.addCategorie(categorie5);
        typesCategories.add(type1);

        TypeCategorie type2 = new TypeCategorie();
        type2.setNomTyp("-- MULTIMEDIA --");

        Categorie categorie21 = new Categorie();
        categorie21.setLibelle("Informatique");
        categorie21.setIsSubAnnonce(false);
        type2.addCategorie(categorie21);

        Categorie categorie22 = new Categorie();
        categorie22.setLibelle("Consoles & Jeux video");
        categorie22.setIsSubAnnonce(false);
        type2.addCategorie(categorie22);

        Categorie categorie23 = new Categorie();
        categorie23.setLibelle("Image & Son");
        categorie23.setIsSubAnnonce(false);
        type2.addCategorie(categorie23);

        Categorie categorie24 = new Categorie();
        categorie24.setLibelle("Telephonie");
        categorie24.setIsSubAnnonce(false);
        type2.addCategorie(categorie24);
        typesCategories.add(type2);

        TypeCategorie type3 = new TypeCategorie();
        type3.setNomTyp("-- LOISIR --");

        Categorie categorie31 = new Categorie();
        categorie31.setLibelle("DVD / Films");
        categorie31.setIsSubAnnonce(false);
        type3.addCategorie(categorie31);

        Categorie categorie32 = new Categorie();
        categorie32.setLibelle("CD / Musique");
        categorie32.setIsSubAnnonce(false);
        type3.addCategorie(categorie32);

        Categorie categorie33 = new Categorie();
        categorie33.setLibelle("Livres");
        categorie33.setIsSubAnnonce(false);
        type3.addCategorie(categorie33);

        Categorie categorie34 = new Categorie();
        categorie34.setLibelle("Velos");
        categorie34.setIsSubAnnonce(false);
        type3.addCategorie(categorie34);

        Categorie categorie35 = new Categorie();
        categorie35.setLibelle("Instruments de Musique");
        categorie35.setIsSubAnnonce(false);
        type3.addCategorie(categorie35);

        Categorie categorie36 = new Categorie();
        categorie36.setLibelle("Jeux & Jouets");
        categorie36.setIsSubAnnonce(false);
        type3.addCategorie(categorie36);

        Categorie categorie37 = new Categorie();
        categorie37.setLibelle("Vins & Gastronomie");
        categorie37.setIsSubAnnonce(false);
        type3.addCategorie(categorie37);

        typesCategories.add(type3);
        
        TypeCategorie type4 = new TypeCategorie();
        type4.setNomTyp("-- MAISON --");

        Categorie categorie41 = new Categorie();
        categorie41.setLibelle("Vêtements");
        categorie41.setIsSubAnnonce(false);
        type4.addCategorie(categorie41);
        
        Categorie categorie42 = new Categorie();
        categorie42.setLibelle("Chaussures");
        categorie42.setIsSubAnnonce(false);
        type4.addCategorie(categorie42);
        
        typesCategories.add(type4);

        System.out.println("Fin insertion categorie !!");
        return typesCategories;
    }

    public ArrayList<TypeAnnonce> dataTypeAnnonce() {
        ArrayList<TypeAnnonce> typesAnnonces = new ArrayList<TypeAnnonce>();
        System.out.println("debut insertion type annonce !!");
        TypeAnnonce type1 = new TypeAnnonce();
        type1.setLibelle("Offres");
        typesAnnonces.add(type1);

        TypeAnnonce type2 = new TypeAnnonce();
        type2.setLibelle("Recherches");
        typesAnnonces.add(type2);

        return typesAnnonces;
    }

    public  void loadEtudiant() 
    {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("generateData.json");
        URL url = this.getClass().getResource("generateData.json");
        System.out.println("file " + url.getHost() + " autre " + url.getFile());
        File file = new File(url.getFile());
        JSONArray json = new JSONArray();
        JSONParser parser = new JSONParser();
        
        if(file!=null && file.exists())
        {
            System.out.println(" existe " + file.getPath());
            
            try {
                BufferedReader inB = new BufferedReader(new FileReader(file));
                json = (JSONArray) parser.parse(inB);
                System.out.println("la taille est : " + json.size());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            BufferedInputStream buffer = new BufferedInputStream(in);
            byte[] contents = new byte[1024];

            int bytesRead = 0;
            String s;
            System.out.println(" size *********************" + buffer.available());

            while ((bytesRead = buffer.read(contents)) != -1) {
                s = new String(contents, 0, bytesRead);
                System.out.print(s);
            }

        }catch (IOException ioe) {
			System.out.println("Exception while reading into buffer " + ioe);
		}
        System.out.println("test");
    }
    
   public int generateRandom(int min, int max)
    {
       Random r = new Random();
       return r.nextInt((max - min) + 1) + min; 
    }
   
   public void saveDataStudent(List<Ecole> list)
   {
       URL url = this.getClass().getResource("dataStudent.json");
        System.out.println("file " + url.getHost() + " autre " + url.getFile());
        File file = new File(url.getFile());
        JSONArray json = new JSONArray();
        JSONParser parser = new JSONParser();
        
        if(file!=null && file.exists())
        {
            System.out.println(" existe " + file.getPath());
            
            try {
                BufferedReader inB = new BufferedReader(new FileReader(file));
                json = (JSONArray) parser.parse(inB);
                System.out.println("debut insertion etudiant");
                for (Iterator it = json.iterator(); it.hasNext();) 
                {
                    JSONObject json1 = (JSONObject) it.next();
                    int max = list.size()-1;
                     Utilisateur utilisateur = new Utilisateur();
                    if(max>0 && list.size()>0)
                    {
                        int nombre = this.generateRandom(0, max);
                        Ecole ecole = list.get(nombre);
                        if(ecole!=null)
                        {
                            EcoleUtilisateur ecoleUtilisateur = new EcoleUtilisateur();
                            ecoleUtilisateur.setUtilisateur(utilisateur);
                            ecoleUtilisateur.setEcole(ecole);
                            utilisateur.addEcoleUtilisateur(ecoleUtilisateur);
                        }
                        
                    }
                    
                    String civilite = (String) json1.get("civilite");
                    String nom = (String) json1.get("nom");
                    String prenom = (String) json1.get("prenom");
                    String login = (String) json1.get("pseudo");
                    String email = (String) json1.get("email");
                    String tel = (String) json1.get("tel");
                    String dateN = (String) json1.get("dteN");
                    String password = (String) json1.get("password");
                    //boolean accept = (boolean) json1.get("accepte");
                    
                    utilisateur.setNom(nom);
                    utilisateur.setPrenom(prenom);
                    utilisateur.setTel(tel);
                    if(dateN!=null && dateN.length()>0)
                    {
                        utilisateur.setDateNaissance(HelpClass.getDateByString(dateN));
                    }

                    utilisateur.setLogin(login);
                    utilisateur.setEmail(email);
                    StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                    password = passwordEncryptor.encryptPassword(password);
                    utilisateur.setMdp(password);
                    utilisateur.setAcceptCondi(true);
                    utilisateur.setProfession("etu");
                    
                    if(civilite!=null && civilite.equals("Female"))
                    {
                        utilisateur.setSexe("Mr");
                    }else{
                        utilisateur.setSexe("Mlle");
                    }
                    utilisateur.setDateCreation(HelpClass.getCurrentDate());
                    em.persist(utilisateur);
                    
                    
                }
                System.out.println("la taille est : " + json.size() + " fin insertion ");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
   
   public void saveDatasEcoles()
   {
       URL url = this.getClass().getResource("ecole2.json");
        System.out.println("file " + url.getHost() + " autre " + url.getFile());
        File file = new File(url.getFile());
        JSONArray json = new JSONArray();
        JSONParser parser = new JSONParser();
        
        if(file!=null && file.exists())
        {
            System.out.println(" existe " + file.getPath());
            
            try {
                BufferedReader inB = new BufferedReader(new FileReader(file));
                json = (JSONArray) parser.parse(inB);
                System.out.println("debut insertion etudiant");
                for (Iterator it = json.iterator(); it.hasNext();) 
                {
                    JSONObject json1 = (JSONObject) it.next();
                    
                    
                    String civilite = (String) json1.get("civilite");
                    String nom = (String) json1.get("nom");
                    String prenom = (String) json1.get("prenom");
                    String login = (String) json1.get("pseudo");
                    String email = (String) json1.get("email");
                    String tel = (String) json1.get("tel");
                    String dateN = (String) json1.get("dteN");
                    String password = (String) json1.get("password");
                    //boolean accept = (boolean) json1.get("accepte");
                    
                   
                    
                }
                System.out.println("la taille est : " + json.size() + " fin insertion ");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
   
   public void saveDatasEcoles(Departement departementE)
   {
       URL url = this.getClass().getResource("ecole2.json");
        System.out.println("file " + url.getHost() + " autre " + url.getFile());
        File file = new File(url.getFile());
        JSONArray json = new JSONArray();
        JSONParser parser = new JSONParser();
        
        if(file!=null && file.exists())
        {
            System.out.println(" existe " + file.getPath());
            
            try {
                BufferedReader inB = new BufferedReader(new FileReader(file));
                json = (JSONArray) parser.parse(inB);
                System.out.println("debut insertion etudiant");
                for (Iterator it = json.iterator(); it.hasNext();) 
                {
                    JSONObject json1 = (JSONObject) it.next();
                    Ecole ecole = new Ecole();
                    
                    String typeEtab = (String) json1.get("typeEtab");
                    String nom = (String) json1.get("nom");
                    String sigle = (String) json1.get("sigle");
                    String tutelle = (String) json1.get("tutelle");
                    String universite = (String) json1.get("universite");
                    String adresse = (String) json1.get("adresse");
                    String cp =  String.valueOf(json1.get("cp"));
                    String commune = String.valueOf(json1.get("commune"));
                    
                    
                    String departement = (String) json1.get("departement");
                    String academie = (String) json1.get("academie");
                    String region = (String) json1.get("region");
                    
                   
                    double longitude =0.0;
                    double latitude = 0.0;
                    //boolean accept = (boolean) json1.get("accepte"); (String) json1.get("latitude");
                    try{
                        String sLong =  String.valueOf(json1.get("longitude"));
                        if(sLong!=null)
                        {
                            longitude = Double.parseDouble(sLong);
                        }
                    }catch(NumberFormatException number)
                    {
                        longitude =0.0;
                    }
                    
                    try{
                        String sLat =  String.valueOf(json1.get("latitude"));
                        if(sLat!=null)
                        {
                            latitude = Double.parseDouble(sLat);
                        }
                    }catch(NumberFormatException number)
                    {
                        latitude =0.0;
                    }
                    
                    ecole.setTypeEtab(typeEtab);
                    ecole.setNom(nom);
                    ecole.setSigle(sigle);
                    ecole.setTutelle(tutelle);
                    ecole.setUniversite(universite);
                    ecole.setAdresse(adresse);
                    ecole.setCp(cp);
                    ecole.setCommune(commune);
                    ecole.setLatitude(latitude);
                    ecole.setLongitude(longitude);
                    
                    if(departementE.getNom().equals(departement))
                    {
                        departementE.addEcole(ecole);
                    }else{
                        //em.persist(ecole);
                        this.listesEcoles.add(ecole);
                        
                    }
                   
                }
                System.out.println("la taille est : " + json.size() + " fin insertion ");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(FullDataIntoDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
   
   public void createUtilisateur() {
       
        String nomEcole ="Axe sud";
        List<Ecole> listEcole = greEcole.obtenirEcoleParNom(nomEcole);
        
        if(listEcole.size()>0) {
            
            //////////////////////////////////////////
            //////////////// USER 1 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setSexe("Mr");
            utilisateur.setProfession("etu");
            utilisateur.setDetailProf("");
            utilisateur.setNom("Mvouma");
            utilisateur.setPrenom("Michel");
            utilisateur.setAdresse("16 rue Fontaine de la ville");
            utilisateur.setCp("06300");
            utilisateur.setTel("0617115624");
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            utilisateur.setEmail("michel@gmail.com");
            utilisateur.setRecevoirOffre(true);
            String mdp = "michel";

            utilisateur.setLogin("michel");
            mdp = passwordEncryptor.encryptPassword(mdp);
            utilisateur.setMdp(mdp);
            
            EcoleUtilisateur ecoleUtilisateur = new EcoleUtilisateur();
            ecoleUtilisateur.setUtilisateur(utilisateur);
            ecoleUtilisateur.setEcole(listEcole.get(0));
            utilisateur.addEcoleUtilisateur(ecoleUtilisateur);
             em.persist(utilisateur);
             em.flush();
                   
            
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce1 = new Annonce();
            
            annonce1.setDateCreation(HelpClass.getCurrentDate());
            annonce1.setDescription("Bonjour à vous ! Je vends une paire de chaussures converse blanche taille 42 et une paire de chaussure redskins bleue marine "
                                    + "taille 42, chaussures occasions peu utilisées, prix 19 euros la paire.");
            
            TypeAnnonce typeAnnonce = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat = null;
            if(listesCategories!=null && listesCategories.size()>0){
                cat = listesCategories.get(0);
            }
            
            annonce1.setTitre("Converse / Redskins taille 42");
            annonce1.setCategorie(cat);
            annonce1.setTypeAnnonce(typeAnnonce);
            annonce1.setCout(19);
            annonce1.setEtat(false); // visible
            annonce1.setUtilisateur(utilisateur);
            annonce1.setUrgente(true);
            annonce1.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo1 = new PhotoAnnonce();
            photo1.setNomLocalisation("image-offre1a.jpg");
            photo1.setNomPropre("Photo principale");
            annonce1.addPhoto(photo1);
            
            PhotoAnnonce photo2 = new PhotoAnnonce();
            photo2.setNomLocalisation("image-offre1b.jpg");
            photo2.setNomPropre("Photo2");
            annonce1.addPhoto(photo2);
            
            Ecole ecole = null;
            for (Iterator iterator = utilisateur.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce1.setEcole(next.getEcole()); // laisser ceci
                ecole = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce1);
            
             
            //////////////// ANNONCE 2 ////////////////
            Annonce annonce2 = new Annonce();
            annonce2.setDateCreation(HelpClass.getCurrentDate());

            //System.out.println(" ajout infos " + HelpClass.ajoutInformationNomPhoto());
            annonce2.setDescription("Lots sacs de marque loliipops pas neuf occasion quelque marque d'usures en dessous du sac sur les coter sinon bon etat!.\n *** AU TOTAL 3 SACS VRAIS SACS -GUESS ***\n" +
            "Soit à la pièce : - noir : 30€ pièce beige et bleu-gris : 60€ pièce");
            
            TypeAnnonce typeAnnonce2 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories2 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat2 = null;
            if(listesCategories2!=null && listesCategories2.size()>0) {
                cat2 = listesCategories2.get(0);
            }
            
            annonce2.setTitre("Lot de Sacs lollipops");
            annonce2.setCategorie(cat2);
            annonce2.setTypeAnnonce(typeAnnonce2);
            annonce2.setCout(30);
            annonce2.setEtat(false); // visible
            annonce2.setUtilisateur(utilisateur);
            annonce2.setUrgente(true);
            annonce2.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo3 = new PhotoAnnonce();
            photo3.setNomLocalisation("image-offre2a.jpg");
            photo3.setNomPropre("Photo principale");
            annonce2.addPhoto(photo3);
            
            PhotoAnnonce photo4 = new PhotoAnnonce();
            photo4.setNomLocalisation("image-offre2b.jpg");
            photo4.setNomPropre("Photo2");
            annonce2.addPhoto(photo4);
            
            // Ecole ecole = null;
            for (Iterator iterator = utilisateur.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce2.setEcole(next.getEcole()); // laisser ceci
                ecole = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce2);
            
            
            //////////////// ANNONCE 3 ////////////////
            Annonce annonce3 = new Annonce();
            annonce3.setDateCreation(HelpClass.getCurrentDate());
            annonce3.setDescription("Vends Escarpins Salomé Marque Sam Edelman Couleur Noir/Taupe Talon Métal/Argent Très tendance ÉTAT NEUF Prix d'achat : 80Euro(s)\n"
            + " Ce produit n'est pas une contrefaçon");
            
            TypeAnnonce typeAnnonce3 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories3 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat3 = null;
            if(listesCategories3!=null && listesCategories3.size()>0){
                cat3 = listesCategories3.get(0);
            }
            annonce3.setTitre("Chaussures noires à talons bon état!");
            annonce3.setCategorie(cat3);
            annonce3.setTypeAnnonce(typeAnnonce3);
            annonce3.setCout(80);
            annonce3.setEtat(false); // visible
            annonce3.setUtilisateur(utilisateur);
            annonce3.setUrgente(true);
            annonce3.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo5 = new PhotoAnnonce();
            photo5.setNomLocalisation("image-offre3a.jpg");
            photo5.setNomPropre("Photo principale");
            annonce3.addPhoto(photo5);
            
            PhotoAnnonce photo6 = new PhotoAnnonce();
            photo6.setNomLocalisation("image-offre3b.jpg");
            photo6.setNomPropre("Photo2");
            annonce3.addPhoto(photo6);

            PhotoAnnonce photo7 = new PhotoAnnonce();
            photo7.setNomLocalisation("image-offre3c.jpg");
            photo7.setNomPropre("Photo3");
            annonce3.addPhoto(photo7);
            
            // Ecole ecole = null;
            for (Iterator iterator = utilisateur.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce3.setEcole(next.getEcole()); // laisser ceci
                ecole = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce3);        
            
            
            //////////////////////////////////////////
            //////////////// USER 2 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur2 = new Utilisateur();
            utilisateur2.setSexe("Mme");
            utilisateur2.setProfession("etu2");
            utilisateur2.setDetailProf("");
            utilisateur2.setNom("Begyn");
            utilisateur2.setPrenom("Melissa");
            utilisateur2.setAdresse("26 rue Hollywood Cocaine");
            utilisateur2.setCp("06200");
            utilisateur2.setTel("0777917185");
            utilisateur2.setEmail("melissa@gmail.com");
            utilisateur2.setRecevoirOffre(true);
            utilisateur2.setLogin("melissa");
            
            StrongPasswordEncryptor passwordEncryptor2 = new StrongPasswordEncryptor();
            String mdp2 = "melissa";            
            mdp2 = passwordEncryptor2.encryptPassword(mdp2);
            utilisateur2.setMdp(mdp2);
            
            EcoleUtilisateur ecoleUtilisateur2 = new EcoleUtilisateur();
            ecoleUtilisateur2.setUtilisateur(utilisateur2);
            ecoleUtilisateur2.setEcole(listEcole.get(0));
            utilisateur2.addEcoleUtilisateur(ecoleUtilisateur2);
             em.persist(utilisateur2);
             em.flush();
             
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce4 = new Annonce();
            annonce4.setDateCreation(HelpClass.getCurrentDate());
            annonce4.setDescription("Studio meublé 25m2 centre ville");
            
            TypeAnnonce typeAnnonce4 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories4 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat4 = null;
            if(listesCategories4!=null && listesCategories4.size()>0){
                cat4 = listesCategories4.get(0);
            }
            
            annonce4.setTitre("Studio meublé 25m2 centre ville");
            annonce4.setCategorie(cat4);
            annonce4.setTypeAnnonce(typeAnnonce4);
            annonce4.setCout(405);
            annonce4.setEtat(false); // visible
            annonce4.setUtilisateur(utilisateur2);
            annonce4.setUrgente(true);
            annonce4.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo8 = new PhotoAnnonce();
            photo8.setNomLocalisation("image-offre4a.jpg");
            photo8.setNomPropre("Photo principale");
            annonce4.addPhoto(photo8);
            
            PhotoAnnonce photo9 = new PhotoAnnonce();
            photo9.setNomLocalisation("image-offre4b.jpg");
            photo9.setNomPropre("Photo2");
            annonce4.addPhoto(photo9);

            PhotoAnnonce photo10 = new PhotoAnnonce();
            photo10.setNomLocalisation("image-offre4c.jpg");
            photo10.setNomPropre("Photo3");
            annonce4.addPhoto(photo10);
            
            //Ecole ecole = null;
            for (Iterator iterator = utilisateur2.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce4.setEcole(next.getEcole()); // laisser ceci
                ecole = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce4);
                   
        }
        
///////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////// ECOLE 2 ///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String nomEcole2 ="IUP Miage";
        List<Ecole> listEcole2 = greEcole.obtenirEcoleParNom(nomEcole2);
        
        if(listEcole2.size()>0) {
            
            //////////////////////////////////////////
            //////////////// USER 1 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur3 = new Utilisateur();
            utilisateur3.setSexe("Mr");
            utilisateur3.setProfession("etu");
            utilisateur3.setDetailProf("");
            utilisateur3.setNom("Spugna");
            utilisateur3.setPrenom("Lorris");
            utilisateur3.setAdresse("18 rue de l'Italie");
            utilisateur3.setCp("06280");
            utilisateur3.setTel("0604785239");
            StrongPasswordEncryptor passwordEncryptor3 = new StrongPasswordEncryptor();
            utilisateur3.setEmail("lorris@gmail.com");
            utilisateur3.setRecevoirOffre(true);
            String mdp3 = "lorris";

            utilisateur3.setLogin("lorris");
            mdp3 = passwordEncryptor3.encryptPassword(mdp3);
            utilisateur3.setMdp(mdp3);
            
            EcoleUtilisateur ecoleUtilisateur3 = new EcoleUtilisateur();
            ecoleUtilisateur3.setUtilisateur(utilisateur3);
            ecoleUtilisateur3.setEcole(listEcole2.get(0));
            utilisateur3.addEcoleUtilisateur(ecoleUtilisateur3);
             em.persist(utilisateur3);
             em.flush();
            
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce5 = new Annonce();
            annonce5.setDateCreation(HelpClass.getCurrentDate());
            annonce5.setDescription("Banquette convertible tissus marron 2 places matelas 127 x 197 banquette 160 x 67 pour voir mes autres annonces tapez janneke83/toutes catégories /provence Alpes Côte d'Azur dans la barre de recherche");
            
            TypeAnnonce typeAnnonce5 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories5 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat5 = null;
            if(listesCategories5!=null && listesCategories5.size()>0){
                cat5 = listesCategories5.get(0);
            }
            
            annonce5.setTitre("Banquette convertible");
            annonce5.setCategorie(cat5);
            annonce5.setTypeAnnonce(typeAnnonce5);
            annonce5.setCout(150);
            annonce5.setEtat(false); // visible
            annonce5.setUtilisateur(utilisateur3);
            annonce5.setUrgente(true);
            annonce5.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo11 = new PhotoAnnonce();
            photo11.setNomLocalisation("image-offre5a.jpg");
            photo11.setNomPropre("Photo principale");
            annonce5.addPhoto(photo11);
            
            PhotoAnnonce photo12 = new PhotoAnnonce();
            photo12.setNomLocalisation("image-offre5b.jpg");
            photo12.setNomPropre("Photo2");
            annonce5.addPhoto(photo12);
            
            Ecole ecole2 = null;
            for (Iterator iterator = utilisateur3.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce5.setEcole(next.getEcole()); // laisser ceci
                ecole2 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce5);
            
            
            //////////////// ANNONCE 2 ////////////////
            Annonce annonce6 = new Annonce();
            annonce6.setDateCreation(HelpClass.getCurrentDate());
            annonce6.setDescription("Billet");
            
            TypeAnnonce typeAnnonce6 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories6 = greCategorie.rechercheCategorieNomCategories("CD / Musique");
            
            Categorie cat6 = null;
            if(listesCategories6!=null && listesCategories6.size()>0){
                cat6 = listesCategories6.get(0);
            }
            
            annonce6.setTitre("Muse Garorock 2016");
            annonce6.setCategorie(cat6);
            annonce6.setTypeAnnonce(typeAnnonce6);
            annonce6.setCout(67);
            annonce6.setEtat(false); // visible
            annonce6.setUtilisateur(utilisateur3);
            annonce6.setUrgente(true);
            annonce6.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo13 = new PhotoAnnonce();
            photo13.setNomLocalisation("image-offre6a.jpg");
            photo13.setNomPropre("Photo principale");
            annonce6.addPhoto(photo13);
            
            // Ecole ecole2 = null;
            for (Iterator iterator = utilisateur3.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce6.setEcole(next.getEcole()); // laisser ceci
                ecole2 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce6);
    
        }   

///////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////// ECOLE 3 ///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String nomEcole3 ="Atelier de Conti";
        List<Ecole> listEcole3 = greEcole.obtenirEcoleParNom(nomEcole3);
        
        if(listEcole3.size()>0) {
            
            //////////////////////////////////////////
            //////////////// USER 1 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur4 = new Utilisateur();
            utilisateur4.setSexe("Mr");
            utilisateur4.setProfession("etu");
            utilisateur4.setDetailProf("");
            utilisateur4.setNom("Puybonnieux");
            utilisateur4.setPrenom("Pierros");
            utilisateur4.setAdresse("27 av de la picolarde");
            utilisateur4.setCp("06380");
            utilisateur4.setTel("0605478139");
            StrongPasswordEncryptor passwordEncryptor4 = new StrongPasswordEncryptor();
            utilisateur4.setEmail("pierros@gmail.com");
            utilisateur4.setRecevoirOffre(true);
            String mdp4 = "pierros";

            utilisateur4.setLogin("pierros");
            mdp4 = passwordEncryptor4.encryptPassword(mdp4);
            utilisateur4.setMdp(mdp4);
            
            EcoleUtilisateur ecoleUtilisateur4 = new EcoleUtilisateur();
            ecoleUtilisateur4.setUtilisateur(utilisateur4);
            ecoleUtilisateur4.setEcole(listEcole3.get(0));
            utilisateur4.addEcoleUtilisateur(ecoleUtilisateur4);
             em.persist(utilisateur4);
             em.flush();
            
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce7 = new Annonce();           
            annonce7.setDateCreation(HelpClass.getCurrentDate());
            annonce7.setDescription("Fauteuil vert à vendre !");
            
            TypeAnnonce typeAnnonce7 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories7 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat7 = null;
            if(listesCategories7!=null && listesCategories7.size()>0){
                cat7 = listesCategories7.get(0);
            }
            
            annonce7.setTitre("Fauteuil assez bon état");
            annonce7.setCategorie(cat7);
            annonce7.setTypeAnnonce(typeAnnonce7);
            annonce7.setCout(70);
            annonce7.setEtat(false); // visible
            annonce7.setUtilisateur(utilisateur4);
            annonce7.setUrgente(true);
            annonce7.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo111 = new PhotoAnnonce();
            photo111.setNomLocalisation("image-offre7a.jpg");
            photo111.setNomPropre("Photo principale");
            annonce7.addPhoto(photo111);
            
            PhotoAnnonce photo112 = new PhotoAnnonce();
            photo112.setNomLocalisation("image-offre7b.jpg");
            photo112.setNomPropre("Photo2");
            annonce7.addPhoto(photo112);
            
            Ecole ecole3 = null;
            for (Iterator iterator = utilisateur4.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce7.setEcole(next.getEcole()); // laisser ceci
                ecole3 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce7);
            
            
            //////////////// ANNONCE 2 ////////////////
            Annonce annonce8 = new Annonce();
            annonce8.setDateCreation(HelpClass.getCurrentDate());
            annonce8.setDescription("Prix ferme ! Disque de 500 gigas!");
            
            TypeAnnonce typeAnnonce8 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories8 = greCategorie.rechercheCategorieNomCategories("CD / Musique");
            
            Categorie cat8 = null;
            if(listesCategories8!=null && listesCategories8.size()>0){
                cat8 = listesCategories8.get(0);
            }
            
            annonce8.setTitre("Pc toshiba c55 dalle 15.6 led 4g 500g hd ");
            annonce8.setCategorie(cat8);
            annonce8.setTypeAnnonce(typeAnnonce8);
            annonce8.setCout(255);
            annonce8.setEtat(false); // visible
            annonce8.setUtilisateur(utilisateur4);
            annonce8.setUrgente(true);
            annonce8.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo01 = new PhotoAnnonce();
            photo01.setNomLocalisation("image-offre8a.jpg");
            photo01.setNomPropre("Photo principale");
            annonce8.addPhoto(photo01);
            
            PhotoAnnonce photo02 = new PhotoAnnonce();
            photo02.setNomLocalisation("image-offre8b.jpg");
            photo02.setNomPropre("Photo principale");
            annonce8.addPhoto(photo02);
            
            // Ecole ecole3 = null;
            for (Iterator iterator = utilisateur4.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce8.setEcole(next.getEcole()); // laisser ceci
                ecole3 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce8);
    
        }
        
///////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////// ECOLE 4 ///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String nomEcole4 ="Cours Diderot";
        List<Ecole> listEcole4 = greEcole.obtenirEcoleParNom(nomEcole4);
        
        if(listEcole4.size()>0) {
            
            //////////////////////////////////////////
            //////////////// USER 1 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur5 = new Utilisateur();
            utilisateur5.setSexe("Mr");
            utilisateur5.setProfession("etu");
            utilisateur5.setDetailProf("");
            utilisateur5.setNom("Pinet");
            utilisateur5.setPrenom("Jeremy");
            utilisateur5.setAdresse("2 rue des Licornes");
            utilisateur5.setCp("06700");
            utilisateur5.setTel("0678142236");
            StrongPasswordEncryptor passwordEncryptor5 = new StrongPasswordEncryptor();
            utilisateur5.setEmail("jeremy@gmail.com");
            utilisateur5.setRecevoirOffre(true);
            String mdp5 = "jeremy";

            utilisateur5.setLogin("jeremy");
            mdp5 = passwordEncryptor5.encryptPassword(mdp5);
            utilisateur5.setMdp(mdp5);
            
            EcoleUtilisateur ecoleUtilisateur5 = new EcoleUtilisateur();
            ecoleUtilisateur5.setUtilisateur(utilisateur5);
            ecoleUtilisateur5.setEcole(listEcole4.get(0));
            utilisateur5.addEcoleUtilisateur(ecoleUtilisateur5);
             em.persist(utilisateur5);
             em.flush();
            
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce9 = new Annonce();           
            annonce9.setDateCreation(HelpClass.getCurrentDate());
            annonce9.setDescription("LIT ENFANT 90cm (Cadre + Matelas + Sommier) ");
            
            TypeAnnonce typeAnnonce9 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories9 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat9 = null;
            if(listesCategories9!=null && listesCategories9.size()>0){
                cat9 = listesCategories9.get(0);
            }
            
            annonce9.setTitre("LIT ENFANT 90cm (Cadre + Matelas + Sommier) ");
            annonce9.setCategorie(cat9);
            annonce9.setTypeAnnonce(typeAnnonce9);
            annonce9.setCout(200);
            annonce9.setEtat(false); // visible
            annonce9.setUtilisateur(utilisateur5);
            annonce9.setUrgente(true);
            annonce9.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo001 = new PhotoAnnonce();
            photo001.setNomLocalisation("image-offre9a.jpg");
            photo001.setNomPropre("Photo principale");
            annonce9.addPhoto(photo001);
            
            PhotoAnnonce photo002 = new PhotoAnnonce();
            photo002.setNomLocalisation("image-offre9b.jpg");
            photo002.setNomPropre("Photo2");
            annonce9.addPhoto(photo002);
            
            Ecole ecole4 = null;
            for (Iterator iterator = utilisateur5.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce9.setEcole(next.getEcole()); // laisser ceci
                ecole4 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce9);
            
            
            //////////////// ANNONCE 2 ////////////////
            Annonce annonce10 = new Annonce();
            annonce10.setDateCreation(HelpClass.getCurrentDate());
            annonce10.setDescription("Freelander 2.0 DI TURBO");
            
            TypeAnnonce typeAnnonce10 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories10 = greCategorie.rechercheCategorieNomCategories("CD / Musique");
            
            Categorie cat10 = null;
            if(listesCategories10!=null && listesCategories10.size()>0){
                cat10 = listesCategories10.get(0);
            }
            
            annonce10.setTitre("Freelander 2.0 DI TURBO");
            annonce10.setCategorie(cat10);
            annonce10.setTypeAnnonce(typeAnnonce10);
            annonce10.setCout(3600);
            annonce10.setEtat(false); // visible
            annonce10.setUtilisateur(utilisateur5);
            annonce10.setUrgente(true);
            annonce10.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo01 = new PhotoAnnonce();
            photo01.setNomLocalisation("image-offre10a.jpg");
            photo01.setNomPropre("Photo principale");
            annonce10.addPhoto(photo01);
            
            PhotoAnnonce photo02 = new PhotoAnnonce();
            photo02.setNomLocalisation("image-offre10b.jpg");
            photo02.setNomPropre("Photo 2");
            annonce10.addPhoto(photo02);
            
            // Ecole ecole4 = null;
            for (Iterator iterator = utilisateur5.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce10.setEcole(next.getEcole()); // laisser ceci
                ecole4 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce10);
    
        }
        
///////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////// ECOLE 5 ///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String nomEcole5 ="ESARC EVOLUTION";
        List<Ecole> listEcole5 = greEcole.obtenirEcoleParNom(nomEcole5);
        
        if(listEcole5.size()>0) {
            
            //////////////////////////////////////////
            //////////////// USER 1 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur6 = new Utilisateur();
            utilisateur6.setSexe("Mr");
            utilisateur6.setProfession("etu");
            utilisateur6.setDetailProf("");
            utilisateur6.setNom("Gueri");
            utilisateur6.setPrenom("Steven");
            utilisateur6.setAdresse("12 rue de Londres");
            utilisateur6.setCp("06870");
            utilisateur6.setTel("0678100116");
            StrongPasswordEncryptor passwordEncryptor6 = new StrongPasswordEncryptor();
            utilisateur6.setEmail("steven@gmail.com");
            utilisateur6.setRecevoirOffre(true);
            String mdp6 = "steven";

            utilisateur6.setLogin("steven");
            mdp6 = passwordEncryptor6.encryptPassword(mdp6);
            utilisateur6.setMdp(mdp6);
            
            EcoleUtilisateur ecoleUtilisateur6 = new EcoleUtilisateur();
            ecoleUtilisateur6.setUtilisateur(utilisateur6);
            ecoleUtilisateur6.setEcole(listEcole5.get(0));
            utilisateur6.addEcoleUtilisateur(ecoleUtilisateur6);
             em.persist(utilisateur6);
             em.flush();
            
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce11 = new Annonce();           
            annonce11.setDateCreation(HelpClass.getCurrentDate());
            annonce11.setDescription("Ordinateur bureau occasion HP DC8000 garanti");
            
            TypeAnnonce typeAnnonce11 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories11 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat11 = null;
            if(listesCategories11!=null && listesCategories11.size()>0){
                cat11 = listesCategories11.get(0);
            }
            
            annonce11.setTitre("Ordinateur bureau occasion HP DC8000 garanti");
            annonce11.setCategorie(cat11);
            annonce11.setTypeAnnonce(typeAnnonce11);
            annonce11.setCout(140);
            annonce11.setEtat(false); // visible
            annonce11.setUtilisateur(utilisateur6);
            annonce11.setUrgente(true);
            annonce11.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo001 = new PhotoAnnonce();
            photo001.setNomLocalisation("image-offre11a.jpg");
            photo001.setNomPropre("Photo principale");
            annonce11.addPhoto(photo001);
            
            PhotoAnnonce photo002 = new PhotoAnnonce();
            photo002.setNomLocalisation("image-offre11b.jpg");
            photo002.setNomPropre("Photo2");
            annonce11.addPhoto(photo002);
            
            Ecole ecole5 = null;
            for (Iterator iterator = utilisateur6.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce11.setEcole(next.getEcole()); // laisser ceci
                ecole5 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce11);
            
            
            //////////////// ANNONCE 2 ////////////////
            Annonce annonce12 = new Annonce();
            annonce12.setDateCreation(HelpClass.getCurrentDate());
            annonce12.setDescription("JOLI piano à queue YAMAHA Blanc Brillant");
            
            TypeAnnonce typeAnnonce12 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories12 = greCategorie.rechercheCategorieNomCategories("CD / Musique");
            
            Categorie cat12 = null;
            if(listesCategories12!=null && listesCategories12.size()>0){
                cat12 = listesCategories12.get(0);
            }
            
            annonce12.setTitre("JOLI piano à queue YAMAHA Blanc Brillant");
            annonce12.setCategorie(cat12);
            annonce12.setTypeAnnonce(typeAnnonce12);
            annonce12.setCout(8700);
            annonce12.setEtat(false); // visible
            annonce12.setUtilisateur(utilisateur6);
            annonce12.setUrgente(true);
            annonce12.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo01 = new PhotoAnnonce();
            photo01.setNomLocalisation("image-offre12a.jpg");
            photo01.setNomPropre("Photo principale");
            annonce12.addPhoto(photo01);
            
            PhotoAnnonce photo02 = new PhotoAnnonce();
            photo02.setNomLocalisation("image-offre12b.jpg");
            photo02.setNomPropre("Photo 2");
            annonce12.addPhoto(photo02);
            
            // Ecole ecole4 = null;
            for (Iterator iterator = utilisateur6.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce12.setEcole(next.getEcole()); // laisser ceci
                ecole5 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce12);
    
        }
        
///////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////// ECOLE 6 ///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String nomEcole6 ="ITECOM";
        List<Ecole> listEcole6 = greEcole.obtenirEcoleParNom(nomEcole6);
        
        if(listEcole6.size()>0) {
            
            //////////////////////////////////////////
            //////////////// USER 1 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur7 = new Utilisateur();
            utilisateur7.setSexe("Mme");
            utilisateur7.setProfession("etu");
            utilisateur7.setDetailProf("");
            utilisateur7.setNom("Barbe");
            utilisateur7.setPrenom("Brenda");
            utilisateur7.setAdresse("120 AV des Pictures");
            utilisateur7.setCp("06870");
            utilisateur7.setTel("0678114286");
            StrongPasswordEncryptor passwordEncryptor7 = new StrongPasswordEncryptor();
            utilisateur7.setEmail("brenda@gmail.com");
            utilisateur7.setRecevoirOffre(true);
            String mdp7 = "brenda";

            utilisateur7.setLogin("brenda");
            mdp7 = passwordEncryptor7.encryptPassword(mdp7);
            utilisateur7.setMdp(mdp7);
            
            EcoleUtilisateur ecoleUtilisateur7 = new EcoleUtilisateur();
            ecoleUtilisateur7.setUtilisateur(utilisateur7);
            ecoleUtilisateur7.setEcole(listEcole6.get(0));
            utilisateur7.addEcoleUtilisateur(ecoleUtilisateur7);
             em.persist(utilisateur7);
             em.flush();
            
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce13 = new Annonce();           
            annonce13.setDateCreation(HelpClass.getCurrentDate());
            annonce13.setDescription("Collection BALZAC");
            
            TypeAnnonce typeAnnonce13 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories13 = greCategorie.rechercheCategorieNomCategories("Chaussures");
            
            Categorie cat13 = null;
            if(listesCategories13!=null && listesCategories13.size()>0){
                cat13 = listesCategories13.get(0);
            }
            
            annonce13.setTitre("Collection BALZAC");
            annonce13.setCategorie(cat13);
            annonce13.setTypeAnnonce(typeAnnonce13);
            annonce13.setCout(4);
            annonce13.setEtat(false); // visible
            annonce13.setUtilisateur(utilisateur7);
            annonce13.setUrgente(true);
            annonce13.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo001 = new PhotoAnnonce();
            photo001.setNomLocalisation("image-offre13a.jpg");
            photo001.setNomPropre("Photo principale");
            annonce13.addPhoto(photo001);
            
            PhotoAnnonce photo002 = new PhotoAnnonce();
            photo002.setNomLocalisation("image-offre13b.jpg");
            photo002.setNomPropre("Photo2");
            annonce13.addPhoto(photo002);
            
            Ecole ecole6 = null;
            for (Iterator iterator = utilisateur7.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce13.setEcole(next.getEcole()); // laisser ceci
                ecole6 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce13);
            
            
            //////////////// ANNONCE 2 ////////////////
            Annonce annonce14 = new Annonce();
            annonce14.setDateCreation(HelpClass.getCurrentDate());
            annonce14.setDescription("Basse cort b4 défrettée");
            
            TypeAnnonce typeAnnonce14 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories14 = greCategorie.rechercheCategorieNomCategories("CD / Musique");
            
            Categorie cat14 = null;
            if(listesCategories14!=null && listesCategories14.size()>0){
                cat14 = listesCategories14.get(0);
            }
            
            annonce14.setTitre("Basse cort b4 défrettée");
            annonce14.setCategorie(cat14);
            annonce14.setTypeAnnonce(typeAnnonce14);
            annonce14.setCout(300);
            annonce14.setEtat(false); // visible
            annonce14.setUtilisateur(utilisateur7);
            annonce14.setUrgente(true);
            annonce14.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo01 = new PhotoAnnonce();
            photo01.setNomLocalisation("image-offre14a.jpg");
            photo01.setNomPropre("Photo principale");
            annonce14.addPhoto(photo01);
            
            PhotoAnnonce photo02 = new PhotoAnnonce();
            photo02.setNomLocalisation("image-offre14b.jpg");
            photo02.setNomPropre("Photo photo2");
            annonce14.addPhoto(photo02);
            
            // Ecole ecole6 = null;
            for (Iterator iterator = utilisateur7.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce14.setEcole(next.getEcole()); // laisser ceci
                ecole6 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce14);
    
        }
        
        
///////////////////////////////////////////////////////////////////////////////////////////////////////        
/////////////////////////////////////////////// ECOLE 7 ///////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String nomEcole7 ="Polytech Marseille";
        List<Ecole> listEcole7 = greEcole.obtenirEcoleParNom(nomEcole7);
        
        if(listEcole7.size()>0) {
            
            //////////////////////////////////////////
            //////////////// USER 1 //////////////////
            //////////////////////////////////////////
            Utilisateur utilisateur8 = new Utilisateur();
            utilisateur8.setSexe("Mr");
            utilisateur8.setProfession("etu");
            utilisateur8.setDetailProf("");
            utilisateur8.setNom("Micallef");
            utilisateur8.setPrenom("David");
            utilisateur8.setAdresse("3000 Rue de la Juiverie");
            utilisateur8.setCp("06590");
            utilisateur8.setTel("0613187429");
            StrongPasswordEncryptor passwordEncryptor8 = new StrongPasswordEncryptor();
            utilisateur8.setEmail("david@gmail.com");
            utilisateur8.setRecevoirOffre(true);
            String mdp8 = "david";

            utilisateur8.setLogin("david");
            mdp8 = passwordEncryptor8.encryptPassword(mdp8);
            utilisateur8.setMdp(mdp8);
            
            EcoleUtilisateur ecoleUtilisateur8 = new EcoleUtilisateur();
            ecoleUtilisateur8.setUtilisateur(utilisateur8);
            ecoleUtilisateur8.setEcole(listEcole7.get(0));
            utilisateur8.addEcoleUtilisateur(ecoleUtilisateur8);
             em.persist(utilisateur8);
             em.flush();
            
            //////////////// ANNONCE 1 ////////////////
            Annonce annonce15 = new Annonce();           
            annonce15.setDateCreation(HelpClass.getCurrentDate());
            annonce15.setDescription("Lot de 3 DVD humour");
            
            TypeAnnonce typeAnnonce15 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories15 = greCategorie.rechercheCategorieNomCategories("DVD / Films");
            
            Categorie cat15 = null;
            if(listesCategories15!=null && listesCategories15.size()>0){
                cat15 = listesCategories15.get(0);
            }
            
            annonce15.setTitre("Lot de 3 DVD humour");
            annonce15.setCategorie(cat15);
            annonce15.setTypeAnnonce(typeAnnonce15);
            annonce15.setCout(3);
            annonce15.setEtat(false); // visible
            annonce15.setUtilisateur(utilisateur8);
            annonce15.setUrgente(true);
            annonce15.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo001 = new PhotoAnnonce();
            photo001.setNomLocalisation("image-offre15a.jpg");
            photo001.setNomPropre("Photo principale");
            annonce15.addPhoto(photo001);
            
            PhotoAnnonce photo002 = new PhotoAnnonce();
            photo002.setNomLocalisation("image-offre15b.jpg");
            photo002.setNomPropre("Photo2");
            annonce15.addPhoto(photo002);
            
            Ecole ecole7 = null;
            for (Iterator iterator = utilisateur8.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce15.setEcole(next.getEcole()); // laisser ceci
                ecole7 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce15);
            
            
            //////////////// ANNONCE 2 ////////////////
            Annonce annonce16 = new Annonce();
            annonce16.setDateCreation(HelpClass.getCurrentDate());
            annonce16.setDescription("Vends 22 bouteilles de vins différents blanc et rouge 200€ le lot");
            
            TypeAnnonce typeAnnonce16 = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories16 = greCategorie.rechercheCategorieNomCategories("Vins & Gastronomie");
            
            Categorie cat16 = null;
            if(listesCategories16!=null && listesCategories16.size()>0){
                cat16 = listesCategories16.get(0);
            }
            
            annonce16.setTitre("Lot de bouteilles de vin");
            annonce16.setCategorie(cat16);
            annonce16.setTypeAnnonce(typeAnnonce16);
            annonce16.setCout(200);
            annonce16.setEtat(false); // visible
            annonce16.setUtilisateur(utilisateur8);
            annonce16.setUrgente(true);
            annonce16.setMarquerPhoneAnnce(true);
            
            PhotoAnnonce photo01 = new PhotoAnnonce();
            photo01.setNomLocalisation("image-offre16a.jpg");
            photo01.setNomPropre("Photo principale");
            annonce16.addPhoto(photo01);
            
            PhotoAnnonce photo02 = new PhotoAnnonce();
            photo02.setNomLocalisation("image-offre16b.jpg");
            photo02.setNomPropre("Photo photo2");
            annonce16.addPhoto(photo02);
            
            // Ecole ecole7 = null;
            for (Iterator iterator = utilisateur8.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce16.setEcole(next.getEcole()); // laisser ceci
                ecole7 = next.getEcole();
                break;
            }
            greAnnonce.persist(annonce16);
    
        }       
        
   }

}

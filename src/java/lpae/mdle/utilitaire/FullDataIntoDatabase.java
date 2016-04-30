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
   
   public void createUtilisateur()
   {
        String nomEcole ="Axe sud";
        List<Ecole> listEcole = greEcole.obtenirEcoleParNom(nomEcole);
        if(listEcole.size()>0)
        {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setSexe("Mr");
            utilisateur.setProfession("etu");
            utilisateur.setDetailProf("");
            utilisateur.setNom("mvouma");
            utilisateur.setPrenom("michel");
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
            
            Annonce annonce1 = new Annonce();
            annonce1.setDateCreation(HelpClass.getCurrentDate());

            //System.out.println(" ajout infos " + HelpClass.ajoutInformationNomPhoto());
            annonce1.setDescription("Sac cool facile à porter");
            
            TypeAnnonce typeAnnonce = greAnnonce.rechercheTypeAnnonceParLibelle("Offres");
            List<Categorie> listesCategories = greCategorie.rechercheCategorieNomCategories("Livres");
            
            Categorie cat = null;
            if(listesCategories!=null && listesCategories.size()>0)
            {
                cat = listesCategories.get(0);
            }
            annonce1.setTitre("Sac");
            annonce1.setCategorie(cat);
            annonce1.setTypeAnnonce(typeAnnonce);
            annonce1.setCout(19);
            annonce1.setEtat(false); // visible
            annonce1.setUtilisateur(utilisateur);
            annonce1.setUrgente(true);
            annonce1.setMarquerPhoneAnnce(true);
            
            /*PhotoAnnonce photo1 = new PhotoAnnonce();
            photo1.setNomLocalisation(MfileName1); 
            photo1.setNomPropre(fileName1);
            annonce1.addPhoto(photo1);*/
          
            Ecole ecole = null;
             for (Iterator iterator = utilisateur.getEcoleUtilisateurs().iterator(); iterator.hasNext();) {
                EcoleUtilisateur next = (EcoleUtilisateur) iterator.next();
                //annonce.setIdEcole(next.getEcole().getId()); // enlever ceci 
                annonce1.setEcole(next.getEcole()); // laisser ceci
                ecole = next.getEcole();
                break;

            }
             //Vêtements Chaussures
            greAnnonce.persist(annonce1);
            
           
        }
        
   }

}

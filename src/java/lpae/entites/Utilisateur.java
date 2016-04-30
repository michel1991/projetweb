/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpae.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author michel
 */
@Entity
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String  nom;
    
    private String prenom;

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public Utilisateur() {
    }
    
    private String profession;
    
    private String formation;
    
    private String detailCursus;
    
    private String cp;
    
    private String adresse;
    
    private String matricule;
    
    private String sexe;
    
    private String tel;
    
    private String email;
    
    private String login;
    
    private String mdp;
    
    private String emailEncode;
    
    
    
      public String getEmailEncode() {
        return emailEncode;
    }

    public void setEmailEncode(String emailEncode) {
        this.emailEncode = emailEncode;
    }

  
    public boolean isRecevoirOffre() {
        return recevoirOffre;
    }

    public void setRecevoirOffre(boolean recevoirOffre) {
        this.recevoirOffre = recevoirOffre;
    }

    public boolean isAcceptCondi() {
        return acceptCondi;
    }

    public void setAcceptCondi(boolean acceptCondi) {
        this.acceptCondi = acceptCondi;
    }
    
    private boolean recevoirOffre;
    
    private boolean acceptCondi;

    public String getDetailProf() {
        return detailProf;
    }

    public void setDetailProf(String detailProf) {
        this.detailProf = detailProf;
    }

    private String shaV;
    
    private int niveau;
    
    private String detailProf;

    public int getNiveau() {
        return niveau;
    }


    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    @OneToMany(mappedBy = "utilisateur", cascade ={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE} )
    private Collection<EcoleUtilisateur> ecoleUtilisateurs=new ArrayList<>();

    public Collection<EcoleUtilisateur> getEcoleUtilisateurs() {
        return ecoleUtilisateurs;
    }
    
    @OneToMany(mappedBy = "utilisateur", cascade ={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private  Collection<Annonce> annoces=new ArrayList<>();

    public void setEcoleUtilisateurs(Collection<EcoleUtilisateur> ecoleUtilisateurs) {
        this.ecoleUtilisateurs = ecoleUtilisateurs;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
   

    public String getShaV() {
        return shaV;
    }

    public void setShaV(String shaV) {
        this.shaV = shaV;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
    
    private boolean validation;
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    

    public String getDetailCursus() {
        return detailCursus;
    }

    public void setDetailCursus(String detailCursus) {
        this.detailCursus = detailCursus;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }
    
    public void addEcoleUtilisateur(EcoleUtilisateur ecoleUser)
    {
        if(ecoleUser!=null)
        {
            ecoleUser.setUtilisateur(this);
             this.ecoleUtilisateurs.add(ecoleUser);
        }
       
    }
    
    public void removeEcoleUtilisateur(EcoleUtilisateur ecoleUser)
    {
        if(ecoleUser!=null)
        {
            this.ecoleUtilisateurs.remove(ecoleUser);
        }
    }
    
    public void addAnnonce(Annonce annonce)
    {
        if(annonce!=null){
            annonce.setUtilisateur(this);
            this.annoces.add(annonce);
        }
    }
    
     public void removeAnnonce(Annonce annonce)
    {
        if(annonce!=null){
            this.annoces.remove(annonce);
        }
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lpae.entites.Utilisateur[ id=" + id + " ]";
    }
    
}

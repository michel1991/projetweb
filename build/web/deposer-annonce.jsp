<%-- 
    Document   : deposer-annonce
    Created on : Apr 1, 2016, 1:23:08 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/> 
    </head>

    <body>  
        <jsp:include page="menu.jsp"/>


        <!-- ///// AFFICHE TROC STUDENTS ///// -->
        <div class="header_bottom_area">
            <div class="contientFormImg"> 
                <img src="images/beta_banner_newad.jpg" alt="" class="center"/>
            </div>
        </div>

        <!-- ///// CONTENT CREER COMPTE ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row"> 
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="divbAide">
                            <div class="center ctCAnnonce">
                                <p><strong>Déposer une annonce sur TrocStudents.fr est GRATUIT.</strong><br/>
                                    Votre annonce va être contrôlée dans les 24h, et vous recevrez un email de validation une fois votre annonce en ligne. Elle restera sur le site pendant 60 jours<br />
                                    Pendant cette période, vous pourrez la supprimer à tout moment.<br />
                                    <span class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-cube"></i> Voir les règles de diffusion</a></span>

                                <p>Professionnels des catégories Véhicules, Immobilier, Maison, Loisirs, Emploi et Services et Matériel Professionnel, la création d'un Compte est GRATUITE et obligatoire pour pouvoir déposer vos annonces sur trocstudents.fr.<br />
                                    <span class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-info-circle"></i> En savoir plus</a></span>
                            </div>
                        </div>


                        <form class="form-horizontal center ctCAnnonce">


                            <!-- categorie -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">Catégorie</p>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="buttondropdown">Catégorie: </label>
                                    <div class="col-md-4">          
                                        <select id="country" class="selectpicker">
                                            <option value="0">-- Toutes catégories --</option> 
                                            <option style="background-color:#dcdcc3;" value="0">-- EMPLOI --</option> 
                                            <option value="4">Offres d'emploi</option>
                                            <option style="background-color:#dcdcc3;" value="0">-- VEHICULES --</option> 
                                            <option value="1">Voitures</option>
                                            <option value="2">Motos</option>
                                            <option value="3">Caravaning</option>
                                            <option value="3">Equipement Auto</option>
                                            <option value="3">Equipement Moto</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group" >
                                    <label class="col-md-4 control-label" for="radios">Vous êtes un:</label>
                                    <div class="col-md-4"> 
                                        <label class="radio-inline" for="radios-0">
                                            <input name="radios" id="radios-0" value="1" checked="checked" type="radio">
                                            Etudiant
                                        </label> 
                                        <label class="radio-inline" for="radios-1">
                                            <input name="radios" id="radios-1" value="2" type="radio">
                                            Pro
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group" >
                                    <label class="col-md-4 control-label" for="radios">Type d'annonce:</label>
                                    <div class="col-md-4"> 
                                        <label class="radio-inline" for="radios-0">
                                            <input name="radios" id="radios-0" value="1" checked="checked" type="radio">
                                            Offres
                                        </label> 
                                        <label class="radio-inline" for="radios-1">
                                            <input name="radios" id="radios-1" value="2" type="radio">
                                            Demandes
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <!-- Localisation -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">Localisation</p>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="buttondropdown">Région*: </label>
                                    <div class="col-md-4">          
                                        <select id="country" class="selectpicker">
                                            <option value="0">&laquo; Choisissez la r&eacute;gion &raquo;</option>
                                            <option value="1">Alsace</option>
                                            <option value="2">Aquitaine</option>
                                            <option value="3">Auvergne</option>
                                            <option value="4">Basse-Normandie</option>
                                            <option value="5">Bourgogne</option>
                                            <option value="6">Bretagne</option>
                                            <option value="7">Centre</option>
                                            <option value="8">Champagne-Ardenne</option>
                                            <option value="9">Corse</option>
                                            <option value="10">Franche-Comté</option>
                                            <option value="11">Haute-Normandie</option>
                                            <option value="12">Ile-de-France</option>
                                            <option value="13">Languedoc-Roussillon</option>
                                            <option value="14">Limousin</option>
                                            <option value="15">Lorraine</option>
                                            <option value="16">Midi-Pyrénées</option>
                                            <option value="17">Nord-Pas-de-Calais</option>
                                            <option value="18">Pays de la Loire</option>
                                            <option value="19">Picardie</option>
                                            <option value="20">Poitou-Charentes</option>
                                            <option value="21">Provence-Alpes-Côte d'Azur</option>
                                            <option value="22">Rhône-Alpes</option>
                                            <option value="23">Guadeloupe</option>
                                            <option value="24">Martinique</option>
                                            <option value="25">Guyane</option>
                                            <option value="26">Réunion</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="buttondropdown">Département*: </label>
                                    <div class="col-md-4">          
                                        <select id="country" class="selectpicker">
                                            <option value="0">Choisissez le département</option>
                                            <option value="1">Alpes-de-Haute-Provence</option>
                                            <option value="2">Hautes-Alpes</option>
                                            <option value="3">Alpes-Maritimes</option>
                                            <option value="4">Bouches du Rhône</option>
                                            <option value="4">Var</option>
                                            <option value="4">Vaucluse</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Code postal: </label>  

                                    <div class="form-group col-sm-2">
                                        <input type="password" data-minlength="6" class="form-control" id="inputPassword" placeholder="Code postal" required>
                                    </div>

                                    <div class="form-group col-sm-4">
                                        <input id="textinput" name="textinput" placeholder="Ville" class="form-control input-md" type="text">  
                                    </div>
                                </div>


                            </div>

                            <!-- Vos informations -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">Vos informations</p>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Votre pseudo:</label>  
                                    <div class="col-md-4">
                                        <input id="textinput" name="textinput" placeholder="Pseudo" class="form-control input-md" type="text">  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Email:</label>  
                                    <div class="col-md-4">
                                        <input id="textinput" name="textinput" placeholder="Email" class="form-control input-md" type="text">  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Téléphone:</label>  
                                    <div class="col-md-4">
                                        <input id="textinput" name="textinput" placeholder="Votre numéro" class="form-control input-md" type="text">  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="checkboxes"></label>
                                    <div class="col-md-4">
                                        <div class="checkbox">
                                            <label for="checkboxes-0">
                                                <input name="checkboxes" id="checkboxes-0" value="1" type="checkbox">
                                                Masquer le numéro de téléphone dans l'annonce.
                                            </label>
                                        </div>
                                        <div class="checkbox">
                                            <label for="checkboxes-1">
                                                <input name="checkboxes" id="checkboxes-1" value="2" type="checkbox">
                                                Je ne souhaite pas être sollicité par des sociétés étrangères au site trocstudents.fr.
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <!-- Votre annonce -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">Votre annonce</p>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Titre de l'annonce:</label>  
                                    <div class="col-md-4">
                                        <input id="textinput" name="textinput" placeholder="Votre titre" class="form-control input-md" type="text">  
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textarea">Texte de l'annonce:</label>
                                    <div class="col-md-4">                     
                                        <textarea class="form-control" id="textarea" name="textarea">Votre texte</textarea>
                                    </div>
                                </div>


                                <div class="form-group">	
                                    <label class="col-md-4 control-label" for="textarea">Photo principale:</label> 
                                    <div class="col-md-4">
                                        Une annonce avec photo est 7 fois plus consultée qu'une annonce sans photo.
                                    </div>	
                                </div>

                                <div class="form-group">

                                    <div class="center">

                                        <div class="pictureDA">
                                            <p class="titlePictDA"> - PHOTO PRINCIPALE - </p>
                                            <img id="blah1" src="images/appartus-photo.png" alt="" class="classBlah"/>
                                            <div class="fileUpload btn btn-primary divChoiceFile">
                                                <span>Choisir un fichier</span>
                                                <input id="uploadBtn1" type="file" class="upload" style="" />
                                            </div>
                                            <input id="uploadFile1" class="uplDFile"/>  
                                        </div>

                                        <div class="pictureDA">
                                            <p class="titlePictDA"> - PHOTO 2 - </p>
                                            <img id="blah2" src="images/appartus-photo.png" alt="" class="classBlah"/>
                                            <div class="fileUpload btn btn-primary divChoiceFile">
                                                <span>Choisir un fichier</span>
                                                <input id="uploadBtn2" type="file" class="upload" style="" />
                                            </div>
                                            <input id="uploadFile2" class="uplDFile"/>  
                                        </div>	

                                        <div class="pictureDA">
                                            <p class="titlePictDA"> - PHOTO 3 - </p>
                                            <img id="blah3" src="images/appartus-photo.png" alt="" class="classBlah"/>
                                            <div class="fileUpload btn btn-primary divChoiceFile">
                                                <span>Choisir un fichier</span>
                                                <input id="uploadBtn3" type="file" class="upload" style="" />
                                            </div>
                                            <input id="uploadFile3" class="uplDFile"/>  
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group center">	
                                    <button type="button" class="btn btn-warning"> VALIDER </button> 
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section> 

    <footer>
        <jsp:include page="footer.jsp"/> 
    </footer>
</body>

</html>
<%-- 
    Document   : creer-compte
    Created on : Apr 2, 2016, 3:58:20 PM
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

        <!-- ///// BARRE DE RECHERCHE ///// -->
        <jsp:include page="search-bar.jsp"/>

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
                                <p><strong>Création de compte</strong><br/>
                            </div>
                            <form class="form-horizontal center daN">
                                <!-- Les coordonnées -->
                                <div class="bColoraN">

                                    <p class="btn88 btn-primary88 btn-lg88 gradient88">Vos coordonnées</p>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buttondropdown">Civilité: </label>
                                        <div class="col-md-4">          
                                            <select id="country" class="selectpicker">
                                                <option value="0">&laquo; Choisissez la civilit&eacute; &raquo;</option>
                                                <option value="1">Mr</option>
                                                <option value="2">Mme</option>
                                                <option value="3">Mlle</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Nom*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="Nom" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Prénom*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="Prénom" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Pseudonyme*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="Votre pseudo" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="buttondropdown">Catégorie Socioprofessionnelle: </label>
                                        <div class="col-md-4">          
                                            <select id="country" class="selectpicker">
                                                <option value="0">&laquo; Choisissez la cat&eacute;gorie &raquo;</option>
                                                <option value="1">Cadre / Dirigeant</option>
                                                <option value="2">Profession lib&eacute;rale</option>
                                                <option value="3">Ind&eacute;pendant</option>
                                                <option value="4">Technicien/Agent de ma&icirc;trise</option>
                                                <option value="5">Professeur/Enseignant</option>
                                                <option value="6">Artisan</option>
                                                <option value="7">Employ&eacute; de bureau ou administratif</option>
                                                <option value="8">Service aux particuliers</option>
                                                <option value="9">Commer&ccedil;ant</option>
                                                <option value="10">Ouvrier</option>
                                                <option value="11">Retrait&eacute;</option>
                                                <option value="12">Etudiant</option>
                                                <option value="13">Femme/Homme au foyer</option>
                                                <option value="14">Militaire</option>
                                                <option value="15">Sans emploi</option>
                                            </select>
                                        </div>
                                    </div>


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
                                        <label class="col-md-4 control-label" for="textinput">Adresse*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Code Postal*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Ville*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Téléphone*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="birthday" class="col-md-4 control-label">Birthday: </label>
                                        <div class=" ">
                                            <div class=" ">
                                                <div class="form-group col-sm-2">
                                                    <input type="text" class="form-control" placeholder="Jour"/>
                                                </div>
                                                <div class="form-group col-sm-2">
                                                    <input type="text" class="form-control" placeholder="Mois"/>
                                                </div>
                                                <div class="form-group col-sm-2">
                                                    <input type="text" class="form-control" placeholder="Année"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    (*) Champs obligatoires 
                                </div>


                                <!-- Adresse mail -->
                                <div class="bColoraN">
                                    <p class="btn88 btn-primary88 btn-lg88 gradient88">Votre adresse e-mail</p>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">E-mail*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="mail" class="form-control input-md" type="text">  
                                        </div>
                                    </div>
                                </div>

                                <!-- Votre mot de passe -->
                                <div class="bColoraN">
                                    <p class="btn88 btn-primary88 btn-lg88 gradient88">Votre mot de passe</p>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Mot de passe:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Confirmez le mot de passe:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="checkboxes"></label>
                                    <div class="col-md-4">
                                        <div class="checkbox">
                                            <label for="checkboxes-0">
                                                <input name="checkboxes" id="checkboxes-0" value="1" type="checkbox">
                                                Je souhaite recevoir des offres des partenaires du site leboncoin.fr susceptibles de m'intéresser.
                                            </label>
                                        </div>
                                        <div class="checkbox">
                                            <label for="checkboxes-1">
                                                <input name="checkboxes" id="checkboxes-1" value="2" type="checkbox">
                                                « J'accepte les Conditions Générales de Vente ».
                                            </label>
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

    <jsp:include page="links-js.jsp"/> 

</body>

</html>
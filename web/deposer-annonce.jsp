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

                         <!--onsubmit="return deposerAnnoceFrontEnd();"-->
                         <form class="form-horizontal center ctCAnnonce" method="post" action="ControllerCentralDepotAnnoceFE" enctype="multipart/form-data" id="formDepotAnnonce" name="formAnnonce">


                            <!-- categorie -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">Catégorie</p>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="categorieAnnonce">Catégorie: </label>
                                    <div class="col-md-4">          
                                        <select id="categorieAnnonce" class="selectpicker form-control" required name="categorieAnnonce">
                                            <option value=""> Choisissez la catégorie </option> 
                                            
                                        </select>
                                        <input type="hidden" name="action" value="add"/>
                                    </div>
                                </div>

                                <!--<div class="form-group" >
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
                                </div>-->

                                <div class="form-group" >
                                    <label class="col-md-4 control-label" for="typeAnnonce">Type d'annonce:</label>
                                    <div class="col-md-4"> 
                                        <label class="radio-inline" for="radios-0">
                                            <input name="radios" id="radios-0" value="Offres" checked="checked" type="radio"><!-- NB:ne change pas la valeur de l'attibut value -->
                                            Offres
                                        </label> 
                                        <label class="radio-inline" for="radios-1">
                                            <input name="radios" id="radios-1" value="Recherches" type="radio">
                                            <!--Demandes-->
                                            Recherches<!-- NB:ne change pas la valeur de l'attibut value -->
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <!-- Localisation -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">
                                    Localisation
                                </p>

                                <div class="form-group">
                                    <!--<label class="col-md-4 control-label" for="buttondropdown">Région*: </label>-->
                                    <label class="col-md-4 control-label" for="ecoles">Ecole*:</label>  
                                    <div class="col-md-4">          
                                        <!--<select id="country" class="selectpicker">
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
                                        </select>-->
                                        <select id="ecoles" class="selectpicker form-control" required disabled>
                                            <option value="${requestScope.ecole.id}">${requestScope.ecole.nom}</option>
                                                
                                        </select>
                                    </div>
                                </div>

                                <!--<div class="form-group">
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
                                </div>-->

                                <!--<div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Code postal: </label>  

                                    <div class="form-group col-sm-2">
                                        <input type="password" data-minlength="6" class="form-control" id="inputPassword" placeholder="Code postal" required>
                                    </div>

                                    <div class="form-group col-sm-4">
                                        <input id="textinput" name="textinput" placeholder="Ville" class="form-control input-md" type="text">  
                                    </div>
                                </div>-->


                            </div>

                            <!-- Vos informations -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">Vos informations</p>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="pseudo">Votre pseudo:</label>  
                                    <div class="col-md-4">
                                        <input id="pseudo" name="pseudo" disabled placeholder="Pseudo" class="form-control input-md" type="text" value="${requestScope.utilisateur.login}">  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="email">Email:</label>  
                                    <div class="col-md-4">
                                        <input id="email" name="email" placeholder="Email" disabled class="form-control input-md disabled" type="email" value="${requestScope.utilisateur.email}">  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="tel">Téléphone:</label>  
                                    <div class="col-md-4">
                                        <input id="tel" name="tel" placeholder="Votre numéro" disabled class="form-control input-md disabled" type="text" value="${requestScope.utilisateur.tel}">  
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="checkboxes"></label>
                                    <div class="col-md-4">
                                        <div class="checkbox">
                                            <label for="checkboxesMarquerPhone">
                                                <input  id="checkboxesMarquerPhone" value="1" type="checkbox" name="MarquerPhone">
                                                Masquer le numéro de téléphone dans l'annonce.
                                            </label>
                                        </div>
                                        <div class="checkbox">
                                            <label for="checkboxesSouhaitePas">
                                                <input  id="checkboxesSouhaitePas" value="1" type="checkbox" name="anncePart">
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
                                    <label class="col-md-4 control-label" for="titreAnnonce">Titre de l'annonce:</label>  
                                    <div class="col-md-4">
                                        <input id="titreAnnonce" required name="titreAnnonce" placeholder="Votre titre" class="form-control input-md" type="text">  
                                    </div>
                                </div>

                                <!--<div class="form-group infoMotor">
                                    <label class="col-md-4 control-label" for="kmtrage">Kilom&eacute;trage:</label>  
                                    <div class="col-md-4">
                                        <input id="kmtrage" name="kmtrage" required class="form-control input-md" type="number" step="1">  
                                    </div>
                                </div>-->
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textAnnonce">Texte de l'annonce:</label><!--Texte de l'annonce:-->
                                    <div class="col-md-4">                     
                                        <textarea class="form-control" id="textAnnonce" name="textAnnonce" required></textarea><!--Votre texte-->
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="prix">Prix(&euro;):</label>  
                                    <div class="col-md-4">
                                        <input id="prix" name="prix"  class="form-control input-md" type="number" min="0" >  
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="urgenteDepotAnnonce"  class="col-md-4 control-label">
                                       
                                    </label>
                                    
                                    <div class="col-md-4">
                                        <input  id="urgenteDepotAnnonce" value="1" type="checkbox" name="urgenteDepotAnnonce">  Annonce urgente
                                    </div>
                                </div>


                                <div class="form-group">	
                                    <label class="col-md-4 control-label" for="labelPhoto">Photo principale:</label> 
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
                                                <input id="uploadBtn1" type="file" name="fichier1" multiple class="upload uploadBtn1" style="" onchange="readImagesAndPreview(this.files, 'blah1', 'uploadBtn1', 'link1');"/>
                                            </div>
                                            
                                            <div>
                                                <input id="uploadFile1" class="uplDFile"/>
                                                <a href="#" class="hidden linkClik" id="link1"><i class="fa fa-times"></i><span>Supprimer</span></a>
                                            </div>
                                            
                                            
                                        </div>

                                        <div class="pictureDA">
                                            <p class="titlePictDA"> - PHOTO 2 - </p>
                                            <img id="blah2" src="images/appartus-photo.png" alt="" class="classBlah"/>
                                            <div class="fileUpload btn btn-primary divChoiceFile">
                                                <span>Choisir un fichier</span>
                                                <input id="uploadBtn2" type="file" name="fichier2" class="upload" style="" onchange="readImagesAndPreview(this.files, 'blah2', 'upluoadFile2', 'link2');"/>
                                            </div>
                                            
                                            <div>
                                                <a href="#" class="linkClik hidden" id="link2"><i class="fa fa-times"></i><span>Supprimer</span></a>
                                                <input id="uploadFile2" class="uplDFile"/>
                                            </div>
                                              
                                        </div>	

                                        <div class="pictureDA">
                                            <p class="titlePictDA"> - PHOTO 3 - </p>
                                            <img id="blah3" src="images/appartus-photo.png" alt="" class="classBlah"/>
                                            <div class="fileUpload btn btn-primary divChoiceFile">
                                                <span>Choisir un fichier</span>
                                                <input id="uploadBtn3" type="file" name="fichier3" class="upload" style="" onchange="readImagesAndPreview(this.files, 'blah3', 'upluoadFile3', 'link3');"/>
                                            </div>
                                            <div>
                                                <input id="uploadFile3" class="uplDFile"/> 
                                                <a href="#" class="hidden" id="link3 linkClik"><i class="fa fa-times"></i><span>Supprimer</span></a>
                                            </div>
                                             
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group center">	
                                    <button type="submit" class="btn btn-warning" id="validerF"> VALIDER </button> 
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
    
        <%--<div class="modal fade" tabindex="-1" role="dialog" id="modalMessage">
        <div class="modal-dialog modal-sm">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><!--<span aria-hidden="true">&times;</span>--></button>
              <h4 class="modal-title">Message</h4>
            </div>
            <div class="modal-body">
              <p id="contenuMessage"></p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
    </div>--%>
    
        <%--
<script src="${pageContext.servletContext.contextPath}/resources/js/feutilitaire.js" type="text/javascript"></script>--%>
    <script src="${pageContext.servletContext.contextPath}/resources/js/deposerAnnoceTask.js" type="text/javascript"></script>
    
    <script>
             var path = '${pageContext.servletContext.contextPath}';//context de l'application
    </script>
</body>

</html>
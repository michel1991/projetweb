<%-- 
    Document   : modify-annonce
    Created on : Apr 30, 2016, 7:06:21 PM
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
                    
                    <br/>
                        
                    <h3><a href="ControllerCentralMesAnnonces"><i class="fa fa-chevron-left" aria-hidden="true"></i>Retour</a></h3> 
                    <h3>Modification de l'annonce : ${annonce.titre}</h3>
                     

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
                                        <input type="hidden" name="action" value="add"/><!-- je ne me rappelle plus à quoi il me sert celui là-->
                                        <input type="hidden" name="idCategorie" value="${requestScope.idCategorie}"/>
                                    </div>
                                </div>

                                <div class="form-group" >
                                    <label class="col-md-4 control-label" for="typeAnnonce">Type d'annonce:</label>
                                    <div class="col-md-4"> 
                                        <label class="radio-inline" for="radios-0">
                                            <input name="radios" id="radios-0" value="Offres"  ${requestScope.monTypeAnnonce!=null?'checked="checked"':''} type="radio"><!-- NB:ne change pas la valeur de l'attibut value -->
                                            Offres
                                        </label> 
                                        <label class="radio-inline" for="radios-1">
                                            <input name="radios" id="radios-1"  ${requestScope.monTypeAnnonce!=null?'checked="checked"':''} value="Recherches" type="radio">
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
                                        <select id="ecoles" class="selectpicker form-control" required disabled>
                                            <option value="${requestScope.ecole.id}">${requestScope.ecole.nom}</option>                                                
                                        </select>
                                    </div>
                                </div>

                            </div>

                            <!-- Votre annonce -->
                            <div class="bColoraN">
                                <p class="btn88 btn-primary88 btn-lg88 gradient88">Votre annonce</p>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="titreAnnonce">Titre de l'annonce:</label>  
                                    <div class="col-md-4">
                                        <textarea class="form-control" id="titreAnnonce" name="titreAnnonce" required>${annonce.titre}</textarea> 
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textAnnonce">Texte de l'annonce:</label><!--Texte de l'annonce:-->
                                    <div class="col-md-4">                     
                                        <textarea class="form-control" id="textAnnonce" name="textAnnonce" required>${annonce.description}</textarea><!--Votre texte-->
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="prix">Prix(&euro;):</label>  
                                    <div class="col-md-4">
                                        <input id="prix" name="prix"  class="form-control input-md" type="number" min="0" value="${annonce.cout}">  
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="urgenteDepotAnnonce"  class="col-md-4 control-label">
                                       
                                    </label>
                                    
                                    <div class="col-md-4">
                                        <input  id="urgenteDepotAnnonce" value="1" ${requestScope.urgenteAnnonce==1?'checked="checked"':''} type="checkbox" name="annonceUrgente">  Annonce urgente
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
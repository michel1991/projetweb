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
                            <form class="form-horizontal center daN" id="loginForm" onsubmit="return addCompteUtilisateurFrontEnd();">
                                <!-- Les coordonnées -->
                                <div class="bColoraN">

                                    <p class="btn88 btn-primary88 btn-lg88 gradient88">Vos coordonnées</p>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="civilite" required>Civilit&eacute;: </label>
                                        <div class="col-md-4">          
                                            <select id="civilite" class="selectpicker form-control" required>
                                                <option value="">&laquo; Choisissez la civilit&eacute; &raquo;</option>
                                                <option value="Mr">Mr</option>
                                                <option value="Mme">Mme</option>
                                                <option value="Mlle">Mlle</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="nom">Nom*:</label>  
                                        <div class="col-md-4">
                                            <input id="nom" required name="nom" placeholder="Nom" class="managerWidth form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="prenom">Prénom*:</label>  
                                        <div class="col-md-4">
                                            <input id="prenom" required name="prenom" placeholder="Prénom" class="managerWidth form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="login">Pseudonyme*:</label>  
                                        <div class="col-md-4">
                                            <input id="login" required name="login" placeholder="Votre pseudo" class="managerWidth form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="prof">Catégorie Socio-professionnelle: </label>
                                        <div class="col-md-4">          
                                            <select id="prof" class="selectpicker form-control" required >
                                                <option value="">&laquo; Choisissez la cat&eacute;gorie &raquo;</option>
                                                <option value="etu">
                                                    &Eacutetudiant
                                                </option>
                                                <option value="en">
                                                    Enseignant/Professeur
                                                </option>

                                                <option value="autre">
                                                    Autre
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group hidden autreProfession">
                                        <label class="col-md-4 control-label" for="descF">Pr&eacute;cision:</label>  
                                        <div class="col-md-4">
                                            <input id="preciP" name="preciP" placeholder="ex: Secretaire " class="managerWidth form-control input-md" type="text">  
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="region">Région: </label>
                                        <div class="col-md-4">          
                                            <select id="region" class="selectpicker form-control">
                                                <option value="defaut">&laquo; Choisissez la r&eacute;gion &raquo;</option>
                                                <c:forEach var="region" items="${requestScope['regions']}">
                                                    <option value="${region.id}">
                                                        ${region.nomRe}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="adresse">Adresse*:</label>  
                                        <div class="col-md-4">
                                            <input id="adresse" name="adresse" required placeholder="" class="managerWidth form-control input-md" type="text">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="cp">Code Postal*:</label>  
                                        <div class="col-md-4">
                                            <input id="cp" name="cp" placeholder="" class="managerWidth form-control input-md" type="text" required>  
                                        </div>
                                    </div>

                                    <!--<div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Ville*:</label>  
                                        <div class="col-md-4">
                                            <input id="textinput" name="textinput" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>-->

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="myPhone">Téléphone*:</label>  
                                        <div class="col-md-4">
                                            <input id="myPhone" name="myPhone" pattern="([0-9]{2}){5}" placeholder="e.x. 0617588925" class="managerWidth form-control input-md" type="text" required>  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="dateN" class="col-md-4 control-label">Date de naissance: </label>
                                        <div class=" ">
                                            <div class=" ">
                                                <div class="form-group col-sm-4"><!-- avant deux -->
                                                    <input type="date" id="dateN" class="managerWidth form-control" placeholder="" required/>
                                                </div>
                                                <!--<div class="form-group col-sm-2">
                                                    <input type="text" class="form-control" placeholder="Mois"/>
                                                </div>
                                                <div class="form-group col-sm-2">
                                                    <input type="text" class="form-control" placeholder="Année"/>
                                                </div>-->
                                            </div>
                                        </div>
                                    </div>

                                    (*) Champs obligatoires 
                                </div>


                                <!-- Adresse mail -->
                                <div class="bColoraN">
                                    <p class="btn88 btn-primary88 btn-lg88 gradient88">Votre adresse e-mail</p>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="email">E-mail*:</label>  
                                        <div class="col-md-4">
                                            <input id="email" name="email" placeholder="mail" class="managerWidth form-control input-md" type="email" required>  
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="bColoraN">
                                    <p class="btn88 btn-primary88 btn-lg88 gradient88">Formation/<br/>Enseignement</p>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="ecole">Ecole*:</label>  
                                        <div class="col-md-4">
                                            <select id="ecole" class="selectpicker form-control" required>
                                                <option value="">&laquo; Choisissez une &eacute;cole</option>
                                                
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group infosComplementaireEtu hidden">
                                        <label class="col-md-4 control-label" for="descF">Information compl&eacute;mentaire:</label>  
                                        <div class="col-md-4">
                                            <input id="descF" name="descF" placeholder="" class="form-control input-md" type="text">  
                                        </div>
                                    </div>
                                </div>

                                <!-- Votre mot de passe -->
                                <div class="bColoraN">
                                    <p class="btn88 btn-primary88 btn-lg88 gradient88">Votre mot de passe</p>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="mdp">Mot de passe:</label>  
                                        <div class="col-md-4"><!-- afficher un message pour le minimum -->
                                            <input id="mdp" name="mdp" placeholder="" class="managerWidth form-control input-md" type="password" required oninput="verificationMotDePasse();">  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="textinput">Confirmez le mot de passe:</label>  
                                        <div class="col-md-4">
                                            <input id="cmdp" name="cmdp" placeholder="" class="managerWidth form-control input-md" type="password" oninput="verificationMotDePasse();">  
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="checkboxes"></label>
                                    <div class="col-md-4">
                                        <div class="checkbox">
                                            <label for="checkboxes-0">
                                                <input name="checkboxes" id="checkboxes0" value="1" type="checkbox">
                                                Je souhaite recevoir des offres des partenaires du site leboncoin.fr susceptibles de m'intéresser.
                                            </label>
                                        </div>
                                        <div class="checkbox">
                                            <label for="checkboxes-1">
                                                <input name="checkboxes" id="checkboxes1" value="2" type="checkbox">
                                                « J'accepte les Conditions Générales de Vente ».
                                            </label>
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group center">	
                                    <button type="submit" class="btn btn-warning" disabled id="validerF"> VALIDER </button> 
                                    <button type="reset" class="btn btn-warning"> ANNULER </button> 
                                    <progress id="pr" value=100  max=1000></progress> 
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
    <script src="${pageContext.servletContext.contextPath}/resources/js/frontEndCompteUtilisateur.js" type="text/javascript"></script>
    <script>
    //var path = 'http://localhost:8080/LPAE';//context de l'application
        var path = '${pageContext.servletContext.contextPath}';//context de l'application
    </script>
    
</body>

</html>
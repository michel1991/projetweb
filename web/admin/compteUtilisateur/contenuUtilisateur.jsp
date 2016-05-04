<%-- 
    Document   : contenuUtilisateur
    Created on : 31 mars 2016, 17:49:36
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrateur</title>

        <link href="${pageContext.servletContext.contextPath}/resources/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/css/contenu-user.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <section class="wrapper">
            <h1 class="hidden">Gestion des utilisateurs</h1>
            <ul class="tabs">
              <li><a href="#tab1">Utilisateurs</a></li>
              <li><a href="#tab2">Cr&eacute;ation/Modification</a></li>
            </ul>
            <div class="clr"></div>
            <section class="block">
              <article id="tab1">
                    <table id="tableUtilisateur" class="table table-striped table-bordered" cellspacing="0" width="100%">
                        <thead>
                            <tr>
                                 <th>
                                    <input name="select_all" value="1" type="checkbox">
                                </th>

                                <th>
                                    Nom
                                </th>

                                <th>
                                    Pr&eacute;nom
                                </th>

                                <th>
                                    Email
                                </th>

                                <th class="">

                                </th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="userAdmin" items="${requestScope['usersGet']}"  varStatus="vsUne">
                                <tr>
                                    <td>
                                    </td>
                                    
                                    <td>
                                        ${userAdmin.nom}
                                    </td>
                                    
                                    <td>
                                       ${userAdmin.prenom}
                                    </td>

                                    <td>
                                       ${userAdmin.email} 
                                    </td>
                                    <td class="">
                                      
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
              </article>
              <article id="tab2">
                  <form class="contact_form" onsubmit="return addCompteUtilisateur();" id="formCompteUtilisateur">
                    <fieldset>
                        <label for="idUserCompte" class="formLabel hidden">idUser:</label>
                        <input type="hidden" id="idUserCompte" class="managerWidth hidden cleanData"/><br>
                       
                        <legend>Coordonn&eacute;es</legend>
                        <label for="civilite" class="formLabel">Civilit&eacute;:</label>
                        <select id="civilite" class="managerWidth cleanData" required >
                            <option value="defaut">
                                Choisir votre civilit&eacute;
                            </option>
                            <option value="Mlle">
                                Mlle
                            </option>
                            <option value="Mr">
                                Mr
                            </option>
                            <option value="Mme">
                                Mme
                            </option>  
                        </select><br/>

                        <label for="prof" class="formLabel" >Profession:</label>
                        <select id="prof" required class="managerWidth cleanData" onchange="choisirProfession();">
                            <option value="defaut">
                                Choisir votre profession
                            </option>
                            <option value="etu">
                                &Eacutetudiant
                            </option>
                            <option value="en">
                                Enseignant/Professeur
                            </option>

                            <option value="autre">
                                Autre
                            </option>
                        </select><br/>

                        <label for="preciP" class="formLabel labelHideProf hidden">Pr&eacute;cision profesion:</label>
                        <input type="text" id="preciP" class="managerWidth labelHideProf hidden cleanData"/><br>

                       <label for="nom" class="formLabel">Nom:</label>
                       <input type="text" id="nom" required class="managerWidth cleanData"/><br>

                       <label for="prenom" class="formLabel">Pr&eacute;nom:</label>
                       <input type="text" id="prenom" required class="managerWidth cleanData"/><br>

                       <label for="adresse" class="formLabel">Adresse:</label>
                       <input type="adresse" id="adresse" required class="managerWidth cleanData"/><br>

                       <label for="cp" class="formLabel">Code postal:</label>
                       <input type="cp" id="cp" required class="managerWidth cleanData" pattern="[0-9]{5}" /><br>

                       <label for="myPhone" class="formLabel">Phone number:</label>
                       <input type="tel" id="myPhone"
                              pattern="([0-9]{2}-?){5}" placeholder="" required class="managerWidth cleanData"/>
                       <span class="form_hint">Mod&egrave;le "e.g. 06-17-58-89-25-78"</span>
                       <br>

                       <label for="dateN" class="formLabel">Date de naissance:</label>
                       <input type="date" id="dateN" required style="" class="managerWidth cleanData"/><br><!--width: 250px;-->
                       
                       <label for="email" class="formLabel">Email:</label>
                       <input type="email" id="email" required class="managerWidth cleanData"/><br>
                    </fieldset>

                    <fieldset>
                        <legend>Identifiant de connection</legend>
                        <label for="login" class="formLabel">Login:</label>
                        <input type="text" id="login" required class="managerWidth cleanData" pattern="\w{5,}"/><br>
                       <label for="mdp" class="formLabel">Mot de passe:</label>
                       <input oninput="verificationMotDePasse();" type="password" id="mdp" required class="managerWidth cleanData" oninput="verificationMotDePasse();" /><br>

                       <label for="cmdp" class="formLabel">Confirmation:</label>
                       <input type="password" oninput="verificationMotDePasse();" id="cmdp" required class="managerWidth cleanData" oninput="verificationMotDePasse();" /><br>
                    </fieldset>

                    <fieldset>
                        <legend>Formation/Tutelle</legend>
                        <label for="ecole" class="formLabel">&Eacute;cole/Universit&eacute;:</label>
                        <select id="ecole" class="managerWidth cleanData"><!--managerWidth-->
                            <option value="defaut">
                                Ecole actuel
                            </option> 
                        </select><br/>
                        <label for="niveau" class="formLabel labelHide hidden">Niveau:</label>
                        <input type="text" id="niveau" class="managerWidth labelHide hidden cleanData" pattern="[1-9]"/><br>

                        <label for="descF" class="formLabel labelHide hidden">Description:</label>
                        <input type="text" id="descF" class="managerWidth labelHide hidden cleanData"/><br>
                    </fieldset>

                    <fieldset>
                        <legend>Enregistrement</legend>
                        <section class="action">
                              <input type="submit" value="Valider" class="submit"/>
                              <input type="reset" value="Effacer" class="submit" id="resetForm"/>
                                Traitement...  <progress id="pr" value=100  max=1000></progress> 
                        </section>
                        
                    </fieldset>
                </form>
              </article>

            </section>
        </section>
        
    <script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/polyfiller.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/compteUtilisateur.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui.min.js" type="text/javascript"></script>
    <script>
        
    </script>
    </body>
</html>

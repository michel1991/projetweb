<%-- 
    Document   : contenuUtilisateur
    Created on : 31 mars 2016, 17:49:36
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrateur</title>
        
        <style>
            .formLabel { 
                display: inline-block; 
                width: 400px; 
                text-align:right;
                margin-bottom:15px;
            }
            
            
            .submit {margin-left:450px;}
            
            /* Button Style */
            input.submit {
                background-color: #68b12f;
                background: -webkit-gradient(linear, left top, left bottom, from(#68b12f), to(#50911e));
                background: -webkit-linear-gradient(top, #68b12f, #50911e);
                background: -moz-linear-gradient(top, #68b12f, #50911e);
                background: -ms-linear-gradient(top, #68b12f, #50911e);
                background: -o-linear-gradient(top, #68b12f, #50911e);
                background: linear-gradient(top, #68b12f, #50911e);
                border: 1px solid #509111;
                border-bottom: 1px solid #5b992b;
                border-radius: 3px;
                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                -ms-border-radius: 3px;
                -o-border-radius: 3px;
                box-shadow: inset 0 1px 0 0 #9fd574;
                -webkit-box-shadow: 0 1px 0 0 #9fd574 inset ;
                -moz-box-shadow: 0 1px 0 0 #9fd574 inset;
                -ms-box-shadow: 0 1px 0 0 #9fd574 inset;
                -o-box-shadow: 0 1px 0 0 #9fd574 inset;
                color: white;
                font-weight: bold;
                padding: 6px 20px;
                text-align: center;
                text-shadow: 0 -1px 0 #396715;
            }
            input.submit:hover {
                opacity:.85;
                cursor: pointer; 
            }
            input.submit:active {
                border: 1px solid #20911e;
                box-shadow: 0 0 10px 5px #356b0b inset; 
                -webkit-box-shadow:0 0 10px 5px #356b0b inset ;
                -moz-box-shadow: 0 0 10px 5px #356b0b inset;
                -ms-box-shadow: 0 0 10px 5px #356b0b inset;
                -o-box-shadow: 0 0 10px 5px #356b0b inset;

            }
            
            .contact_form input:focus, .contact_form textarea:focus {
                padding-right:70px;
            }
            
            .contact_form input, .contact_form textarea { /* add this to the already existing style */
                -moz-transition: padding .25s; 
                -webkit-transition: padding .25s; 
                -o-transition: padding .25s;
                transition: padding .25s;
            }
            
            .contact_form input {
                height:20px; 
                 
            }
            
            /*message d'erreur buble'*/
            ::-webkit-validation-bubble-message {
                padding: 1em;
            }
            #niveau, input.submit{
             height:30px;    
            }
            
            .managerWidth{
                width:220px;
                padding:5px 8px;
                
                border:1px solid #aaa;
                box-shadow: 0px 0px 3px #ccc, 0 10px 15px #eee inset;
                border-radius:2px;
            }
            
            
            
            
            input:required{
                border: 1px solid lightsalmon;
            }
            input:optional {
                border: 1px solid black;
            }
            
            fieldset {
                border:1px solid;
                padding:20px;
            }
            
            input:invalid { 
                /*background-color: #B0BED9;*/
                box-shadow: 0 0 5px #d45252;
                border-color: #b03535;
                background: #fff url(images/invalid3.png) no-repeat 98% center;
            }
            input.managerWidth:valid { 
                /*background-color:white; 
                border: 2px solid #dff0d8;*/
                background: #fff url(images/valid.png) no-repeat 98% center;
                box-shadow: 0 0 5px #5cd053;
                border-color: #28921f;
            }
            
            :-moz-placeholder {
                color: blue;
            }

            ::-webkit-input-placeholder {
                color: blue;
            }
            *:focus {outline: none;}
            
             .contact_form label {font-family:Georgia, Times, "Times New Roman", serif;}
            .form_hint, .required_notification {font-size: 11px;}
            .form_hint {
                background: #d45252;
                border-radius: 3px 3px 3px 3px;
                color: white;
                margin-left:8px;
                padding: 1px 6px;
                z-index: 999; /* hints stay above all other elements */
                position: absolute; /* allows proper formatting if hint is two lines */
                display: none;
            }
            
            /* All Progress Bars */
            progress {
                /* Reset the default appearance */
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
            }

            /* Determinate */
            progress[value] {
                /* Reset the default appearance */
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
            }

            /* Indeterminate */
            progress:not([value]) {
                /* Reset the default appearance */
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
            }
            
            progress::-webkit-progress-bar {
                background: #EEE;
                box-shadow: 0 2px 3px rgba(0,0,0,0.2) inset;
                border-radius: 3px;
            }

            progress::-webkit-progress-value {
                background-color: green; // #CC0000
                border-radius: 3px;
            }
        </style>
    </head>
    <body>
        
        <form class="contact_form">
            <fieldset>
                <legend>Vos Coordonn&eacute;es</legend>
                <label for="civilite" class="formLabel">Civilit&eacute;:</label>
                <select id="civilite" class="managerWidth" required>
                    <option>
                        Choisir votre civilit&eacute;
                    </option>
                    <option value="Mlle">
                        Mlle
                    </option>
                    <option value="Mr">
                        Mme
                    </option>
                    <option value="Mme">
                        Mme
                    </option>  
                </select><br/>
               
                <label for="prof" class="formLabel" >Profession:</label>
                <select id="prof" required class="managerWidth">
                    <option>
                        Choisir votre profession
                    </option>
                    <option value="etu">
                        &Eacute;tudiant
                    </option>
                    <option value="en">
                        Enseignant/Professeur
                    </option>
                    
                    <option value="autre">
                        Autre
                    </option>
                </select><br/>
                
                <label for="preciP" class="formLabel">Pr&eacute;cision profesion:</label>
                <input type="text" id="preciP" class="managerWidth"/><br>
                
               <label for="nom" class="formLabel">Nom:</label>
               <input type="text" id="nom" required class="managerWidth"/><br>
               
               <label for="prenom" class="formLabel">Pr&eacute;nom:</label>
               <input type="text" id="prenom" required class="managerWidth"/><br>
               
               <label for="adresse" class="formLabel">Adresse:</label>
               <input type="adresse" id="prenom" required class="managerWidth"/><br>
               
               <label for="cp" class="formLabel">Code postal:</label>
               <input type="cp" id="prenom" required class="managerWidth"/><br>
               
               <label for="myPhone" class="formLabel">Phone number:</label>
               <input type="tel" id="myPhone"
                      pattern="([0-9]{2}-?){6}" placeholder="" required class="managerWidth"/>
               <span class="form_hint">Mod&egrave;le "e.g. 06-17-58-89-25-78"</span>
               <br>
               
               <label for="dateN" class="formLabel">Date de naissance:</label>
               <input type="date" id="dateN" required style="" class="managerWidth"/><br><!--width: 250px;-->
            </fieldset>
            
            <fieldset>
                <legend>Identifiant de connection</legend>
                <label for="login" class="formLabel">Login:</label>
                <input type="text" id="login" required class="managerWidth" pattern="\w{5,}"/><br>
               <label for="mdp" class="formLabel">Mot de passe:</label>
               <input type="password" id="mdp" required class="managerWidth" oninput="verificationMotDePasse();" /><br>
               
               <label for="cmdp" class="formLabel">Confirmation:</label>
               <input type="password" id="cmdp" required class="managerWidth" oninput="verificationMotDePasse();" /><br>
            </fieldset>
            
            <fieldset>
                <legend>Formation</legend>
                <label for="ecole" class="formLabel">&Eacute;cole/Universit&eacute;:</label>
                <select id="ecole" class="managerWidth">
                    <option>
                        Cursus actuel
                    </option>
                    <option value="skema">
                        Skema
                    </option>
                </select><br/>
                <label for="niveau" class="formLabel">Niveau:</label>
                <input type="number" id="niveau" class="managerWidth"/><br>
                
                <label for="descF" class="formLabel">Description:</label>
                <input type="text" id="descF" required class="managerWidth"/><br>
            </fieldset>
            
            <fieldset>
                <legend>Enregistrement</legend>
                <input type="submit" value="Valider" class="submit"/>
                Traitement...  <progress id="pr" value=100  max=1000></progress> 
            </fieldset>
        </form>
    <script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/polyfiller.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/compteUtilisateur.js" type="text/javascript"></script>
    <script>
        
    </script>
    </body>
</html>

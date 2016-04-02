<%-- 
    Document   : search-bar
    Created on : Apr 1, 2016, 1:03:39 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- ///// CONTENT BARRE DE RECHERCHE ///// -->
<div class="header_bottom_area displayHeader1">
    <div class="contientForm"> 
        <div class="shBox"> 

            <div class="firstlineBox">

                <div class="recherchezvous">
                    <input type="text" name="q" maxlength="500" id="textBox" class="" placeholder="Que recherchez-vous ?" /> 
                </div>

                <div class="catEtButton">
                    <select id="country" class="selectpicker">
                        <option value="0">-- Toutes catégories --</option> 
                        <option style="background-color:#dcdcc3;" value="0">-- EMPLOI --</option> 
                        <option value="4">Offres d'emploi</option>
                        <option style="background-color:#dcdcc3;" value="0">-- VEHICULES --</option> 
                        <option value="1">Voitures</option>
                        <option value="2" >Motos</option>
                        <option value="3" >Caravaning</option>
                        <option value="3" >Equipement Auto</option>
                        <option value="3" >Equipement Moto</option>
                    </select>
                </div>
                <div class="catEtButtonR">
                    <input type="button" value="RECHERCHER" id="rechercher">
                </div>

            </div>

            <div class="firstlineBox">
                <div class="catEtButton">

                    <input type="checkbox" id="ctitle" name="it" value="1" /><label class="inputIt"> Recherche dans le titre uniquement</label>  
                    <input type="checkbox" id="curgent" name="ur" value="1" /><label class="inputIt"> Annonces Urgentes uniquement</label>
                </div>


                <div class="catEtButton country2cat">
                    <select id="country" class="selectpicker">
                        <option value="4">Autour de moi</option>
                        <option value="1" selected>Provence-Alpes-Côte d'Azur</option>
                        <option value="2" >R&eacute;gions voisines</option>
                        <option value="3" >Toute la France</option>
                        <option style="background-color:#dcdcc3;" value="0">-- DEPARTEMENT --</option> 
                        <option value="104">Alpes-de-Haute-Provence</option>				
                        <option value="105">Hautes-Alpes</option>
                        <option value="106">Alpes-Maritimes</option>
                        <option value="113">Bouches-du-Rhône</option>
                        <option value="183">Var</option>
                        <option value="184">Vaucluse</option>
                    </select>
                </div>

                <div class="catEtButton country2cat">
                    <input id="textinput" name="textinput" placeholder="Ville ou code postal" class="form-control input-md" type="text">  
                </div>

            </div>
        </div>
    </div>
</div>
</div>



<!-- ///// CONTENT BARRE DE RECHERCHE MOBILE ///// -->
<div class="header_bottom_area displayHeader2">
    <div class="contientForm"> 
        <div class="col-md-6">
            <form class="form-horizontal" method="post">				                  
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-1">
                        <input id="" name="" type="text" placeholder="Que recherchez-vous ?" class="form-control">  
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="catEtButton country2cat">
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
                </div>
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="catEtButton country2cat">
                            <select id="country" class="selectpicker">
                                <option value="4">Autour de moi</option>
                                <option value="1" selected>Provence-Alpes-Côte d'Azur</option>
                                <option value="2" >R&eacute;gions voisines</option>
                                <option value="3" >Toute la France</option>
                                <option style="background-color:#dcdcc3;" value="0">-- DEPARTEMENT --</option> 
                                <option value="104">Alpes-de-Haute-Provence</option>				
                                <option value="105">Hautes-Alpes</option>
                                <option value="106">Alpes-Maritimes</option>
                                <option value="113">Bouches-du-Rhône</option>
                                <option value="183">Var</option>
                                <option value="184">Vaucluse</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="catEtButton country2cat">
                            <input id="textinput" name="textinput" placeholder="Ville ou code postal" class="form-control input-md" type="text">  
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-10 col-md-offset-1">
                        <div class="catEtButton">
                            <input type="checkbox" id="ctitle" name="it" value="1" /><label class="inputIt"> Recherche dans le titre uniquement</label>  <br/>
                            <input type="checkbox" id="curgent" name="ur" value="1" /><label class="inputIt"> Annonces Urgentes uniquement</label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12 text-center">
                        <input type="button" value="RECHERCHER" id="rechercher">
                    </div>
                </div>
            </form>        
        </div>
    </div>
</div>
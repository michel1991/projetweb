<%-- 
    Document   : qsn
    Created on : Apr 1, 2016, 1:50:30 AM
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

        <!--  ///// CONTENT ARTICLE 1 ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">  
                    <div class="col-md-12 col-sm-12 col-xs-12">

                        <div class="divbAide">

                            <div class="center ctAide">
                                <div class="lineSpcregl fontB">ACTUS - LA BOUTIQUE PREMIUM</div> 
                                <HR>
                                
                                <div class="f_blog_heading">
                                   <a href="blog-right-sidebar.html">La boutique premium Troc Student</a>
                                </div>
                                <div class="f_blog_menu">
                                   <ul>
                                       <li><a href=""><i class="fa fa-pencil-square-o"></i>Par Mvouma Michel</a></li>
                                       <li><a href=""><i class="fa fa-calendar"></i>18 Avr 2016</a></li>
                                   </ul>
                                </div>
                                <HR>
                                
                                <img src="images/banner_article1.jpg" alt="" /><br/><br/>
                                
                                <p> 
                                    Affichez votre logo sur chacune de vos annonces.
                                    Bénéficiez d'une page vitrine sur leboncoin.fr pour présenter votre entreprise (horaires, localisation, site web, savoir-faire...).
                                    Regroupez sur une même page toutes vos annonces liées à votre activité.
                                    Gérez votre budget pour booster la performance de vos annonces.
                                </p>
 
                                <p>
                                    Annonceur Professionnel ? Nouveau : Le compte pro est désormais accessible aux rubriques Emploi, Services et Matériel Professionnel.
                                    La création d'un Compte Pro est gratuite et obligatoire pour tous les professionnels.
                                    Ce service vous permet de déposer plus simplement et rapidement vos annonces et d'améliorer leur gestion.

                                    Ses avantages : Un tableau de bord pour piloter l'ensemble de vos annonces en ligne, 
                                    Un système de paiement simplifié et avantageux grâce à l'achat de crédits
                                </p>

 
                            </div>    	
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
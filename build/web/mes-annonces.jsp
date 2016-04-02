<%-- 
    Document   : mes-annonces
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

        <!--  ///// CONTENT MES ANNONCES ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">  
                    <div class="col-md-12 col-sm-12 col-xs-12">

                        <div class="divbAide">

                            <div class="center ctAide">
                                <div class="lineSpcregl fontB">MES ANNONCES</div> 
                                <HR>
                                
                                <p class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-heart"></i> Sauvegarder l'annonce</a></p><br/>

                                <p>Pour sauvegarder des annonces, cliquez sur le lien « Sauvegarder l'annonce » sur la page de présentation du produit qui vous intéresse.
                                   Si l'annonce n'est plus active sur le site, elle disparaîtra automatiquement de votre sélection.
                                </p>
                                <p><span class="ColorBlues">Attention :</span> si vous supprimez vos cookies, vous perdrez toutes vos annonces sauvegardées.</p>
                                


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
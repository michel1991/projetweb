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

        <!--  ///// CONTENT HELP ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">  
                    <div class="col-md-12 col-sm-12 col-xs-12">

                        <div class="divbAide">

                            <div class="center ctAide">
                                <div class="lineSpcregl fontB">FOIRE AUX QUESTIONS</div> 
                                <HR>

                                <p>Bienvenue sur la page d’aide du site Leboncoin.fr. Cette page permet de répondre à vos questions les plus courantes.</p>

                                <p>Si vous êtes un <span class="fontB">professionnel</span>, nous vous invitons à consulter notre <span class="fontColors">page d’aide spécifique à l’utilisation du compte pro.</span></p>

                                <p>
                                    Si votre annonce a été refusée ou que vous ne savez pas comment la rédiger, nous vous invitons à consulter les <span class="fontColors">règles de diffusion des annonces</span> sur le site.
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
<%-- 
    Document   : mes-annonces
    Created on : Apr 1, 2016, 1:50:30 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/> 
    </head>

    <body>  
        <jsp:include page="menu.jsp"/>

        <!-- ///// CONTENT MES ANNONCES ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">  
                    <div class="col-md-12 col-sm-12 col-xs-12">      
                        <div class="divbAide">
                            <div class="center ctAide">






                                <div class="lineSpcregl fontB">MES ANNONCES</div> 
                                <HR>
                                <p class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-heart"></i> Modifier mes annonces</a></p><br/>
                                <p>Pour modifier des annonces, cliquez sur le lien « Modifier l'annonce » et vous serez redirigé vers la page de modification de cette annonce.
                                    Si l'annonce n'est plus active sur le site, elle disparaîtra automatiquement de votre sélection.
                                </p>
                                <p><span class="ColorBlues">Attention :</span> si vous supprimez vos cookies, vous perdrez toutes vos annonces sauvegardées.</p>





                                <!-- ////////// LISTE DES ANNONCES ////////// -->
                                <div class="row" style="background-color:red;">


                                    <div class="featered_products">
                                        <div role="tabpanel">
                                            <c:set var="vPhotosMesAnnonces" value="${requestScope['photosMesAnnonces']}" scope="page"/>
                                            <!-- Tab panes -->
                                            <div class="tab-content">
                                                <div role="tabpanel" class="tab-pane active" id="homeft">
                                                    <div id=" " class="cc_one1">
                                                        <!-- DEBUT INSERTION DES ANNONCES VIA LE TALEAU DES ANNONCES -->
                                                        <c:forEach var="monAnnonce" items="${requestScope['annoncesMesAnnonces']}"  varStatus="vsUne">
                                                            <c:set var="photoMonAnnonce" value="${vPhotosMesAnnonces[vsUne.index]}" />

                                                            <div class="weekly_featured888"><!-- debut d'une ligne-->
                                                                <div class="single_weekly_featured">
                                                                    <div class="row">

                                                                        <div class="col-md-5 col-sm-5 col-xs-5"><!-- pour l'image-->                                                                             
                                                                            <div class=" ">
                                                                                <div class="single_weekly_img">
                                                                                    <div class="weekly_overlay"></div>
                                                                                    <img src="resources/imagesAnnonces/${photoMonAnnonce.nomLocalisation}" alt="" class="imgOffer"/><!--images/feature4.jpg-->

                                                                                </div>
                                                                                <div class="single_weekly_img_hover">
                                                                                    <div class="weekly_overlay"></div>                       
                                                                                    <img src="resources/imagesAnnonces/${photoMonAnnonce.nomLocalisation}" alt="" class="imgOffer"/>
                                                                                </div>
                                                                            </div>
                                                                        </div>

                                                                        <div class="col-md-7 col-sm-7 col-xs-7 no_col_padding" style="background-color:blue;">
                                                                            <div class="featured_info">
                                                                                <a href="#">${monAnnonce.titre} </a>
                                                                                <p>Publiée le  <fmt:formatDate value="${monAnnonce.dateCreation}" pattern="dd/MM/yyyy HH:mm:ss"/></p>
                                                                                <span class="amount">${monAnnonce.cout}&euro;</span><!-- €-->
                                                                            </div>
                                                                            <div class="sidebar_cart inlineBk">
                                                                                <a href="ControllerCentrerGererMesAnnonces?action=freshToAll&keyPlot=${monAnnonce.id}">Modifier cette annonce</a>  <!--product.jsp-->
                                                                            </div>

                                                                            <div class="sidebar_cart inlineBk">
                                                                                <a href="#" role="button" data-toggle="modal" data-target="#login-modal">Supprimer l'annonce</a>
                                                                            </div>

                                                                            <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                                                                <div class="modal-dialog">
                                                                                    <div class="modal-content">

                                                                                        <div class="modal-header" align="center">
                                                                                            Voulez-vous vraiment supprimer cette annonce ?
                                                                                        </div>
                                                                                        <div id="div-forms">
                                                                                            <div class="modal-footer">
                                                                                                <div class="divaddCartsl inlineBk"><!-- pourrais lancer gmail -->
                                                                                                    <a href="#" class="bgdCDelete addCartsl"><i class="fa fa-times" aria-hidden="true"></i> supprimer</a><!-- marquer l'espace avec le <i> -->
                                                                                                </div>
                                                                                                <button type="button" data-dismiss="modal" class="btn"> annuler</button>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>


                                                                        </div>
                                                                        <!-- END # MODAL LOGIN -->



                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div><!-- fin d'une ligne -->

                                                    </c:forEach>
                                                    <!-- FIN INSERTION DES ANNONCES -->

                                                    <!-- GESTION DE LA PAGINATION --> 
                                                    <c:if test="${requestScope['annoncesMesAnnonces']!=null && requestScope.pagination>0}">
                                                        <ul class="pagination">
                                                            <c:forEach var="compte"  begin="0" end="${requestScope.pagination-1}">

                                                                <c:url value="ControllerCentralMesAnnonces" var="servletMesAnnoncesUrl">
                                                                    <c:param name="action" value="MesAnnonces" />
                                                                    <c:param name="key" value="${compte}" />
                                                                </c:url>
                                                                <li><a href="<c:out value="${servletMesAnnoncesUrl}" />">${compte+1}</a></li>

                                                            </c:forEach>

                                                        </ul> 
                                                    </c:if>
                                                    <!-- GESTION DE LA PAGINATION -->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>





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


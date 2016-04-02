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

        <!-- ///// CONTENT FORMULAIRE ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">  
                    <div class="col-md-12 col-sm-12 col-xs-12">

                        <div class="marg05">
                            <!-- <div class="center"> -->

                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="well well-sm">
                                            <form class="form-horizontal" method="post">
                                                <fieldset>
                                                    <legend class="text-center header">Contactez-nous!</legend>
                                                    <div class="form-group">
                                                        <div class="col-md-10 col-md-offset-1">
                                                            <input id="fname" name="name" type="text" placeholder="Prénom" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-md-10 col-md-offset-1">
                                                            <input id="lname" name="name" type="text" placeholder="Nom" class="form-control">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-md-10 col-md-offset-1">
                                                            <input id="email" name="email" type="text" placeholder="Adresse mail" class="form-control">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-md-10 col-md-offset-1">
                                                            <input id="phone" name="phone" type="text" placeholder="Téléphone" class="form-control">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-md-10 col-md-offset-1">
                                                            <textarea class="form-control" id="message" name="message" placeholder="Entrez votre message.." rows="7"></textarea>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-md-12 text-center">
                                                            <button type="submit" class="btn btn-primary btn-lg">VALIDER</button>
                                                        </div>
                                                    </div>
                                                </fieldset>
                                            </form>
                                        </div>
                                    </div>
                                    <!-- ///// CONTENT MAP + ADRESSE ///// -->
                                    <div class="col-md-6">
                                        <div>
                                            <div class="panel panel-default">
                                                <div class="text-center header">Siège social</div>
                                                <div class="panel-body text-center">
                                                    <h4>Addresse</h4>
                                                    <div>
                                                        Troc Students<br/>
                                                        8, rue Lavoisier,<br/>
                                                        75008 Paris<br/>
                                                        contact@trocstudent.fr<br/>
                                                    </div>
                                                    <hr />
                                                    <div id="map1" class="map">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>		
                            <!-- </div>  -->   	
                        </div>

                    </div>
                </div>
            </div>
        </section>

        <footer>
            <jsp:include page="footer.jsp"/> 
        </footer>

        <jsp:include page="links-js.jsp"/> 

        <!-- ///// MAP CONTACT ///// -->
        <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript">
            jQuery(function ($) {
                function init_map1() {
                    var myLocation = new google.maps.LatLng(48.873971, 2.321404199999961);
                    var mapOptions = {
                        center: myLocation,
                        zoom: 16
                    };
                    var marker = new google.maps.Marker({
                        position: myLocation,
                        title: "Property Location"
                    });
                    var map = new google.maps.Map(document.getElementById("map1"),
                            mapOptions);
                    marker.setMap(map);
                }
                init_map1();
            });
        </script>

    </body>

</html>
<%-- 
    Document   : menu
    Created on : Apr 1, 2016, 12:25:35 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!-- ///// CONTENT SIDEBAR  ///// -->
<div class="header_top_area">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12  ">
                <div class="header_top_cc_left  ">
                    <ul>
                        <li><a href="#"><i class="fa fa-phone"></i>Contact: +337 94 88 53 68</a></li>
                        <li><a href=""><img alt="" src="images/french.png"> Français</a>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12  ">
                <div class="header_top_cc_right  ">
                    <ul>
                        </li>
                        <li>
                        <li class="active"><a href="creer-compte.jsp">Créer un compte</a></li>
                        <li><a href="">|</a></li> 
                        <li class="dropdown">
                            <a href="index.html" class="dropdown-toggle" data-toggle="dropdown">Se connecter <b class="caret"></b></a>
                            <ul class="dropdown-menu dropMn">
                                <li>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                                <div class="form-group">
                                                    <label class="sr-only" for="exampleInputEmail2">Adresse mail</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Adresse mail" required>
                                                </div>
                                                <div class="form-group">
                                                    <label class="sr-only" for="exampleInputPassword2">Mot de passe</label>
                                                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Mot de passe" required>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox">Se souvenir de moi
                                                    </label>
                                                </div>
                                                <div class="form-group">
                                                    <button type="submit" class="btn btn-success btn-block">Se connecter</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>			      
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- ///// CONTENT MENU  ///// -->
<div class="header_middle_area">
    <div class="container">
        <div class="row">
            <div class="col-md-388 col-sm-2 col-xs-12">
                <div class="header_logo">
                    <a href="index.jsp"><img src="images/logo.png" alt="logo" id="img_logo"/></a>
                </div>
            </div>
            <div class="col-md-788 col-sm-8 col-xs-12">
                <div class="header_middle_right">
                    <nav class="mainmenu">
                        <ul>
                            <li><a href="index.jsp">Accueil</a></li>
                            <li><a href="deposer-annonce.jsp">Déposer une annonce</a></li>
                            <li><a href="offres.jsp">Offres</a></li>
                            <li><a href="demandes.jsp">Demandes</a></li>
                            <li><a href="mes-annonces.jsp">Mes annonces</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="col-md-288 col-sm-2 col-xs-12">
                <div class="header_middle_cc_search">
                    <ul>
                        <li><a href="">|</a></li>
                        <li><a href="cart.html"><i class="fa fa-shopping-cart"></i>(2) </a>
                            <div class="cart_number_drd">
                                <div class="single_add_cart_design">
                                    <div class="s_add_cart_left">
                                        <div class="add_cart_h_img">
                                            <a href=""><img src="images/1011663_fro.jpg" alt="" /></a>
                                        </div>
                                        <div class="add_cart_h_txt">
                                            <a href="product-left-sidebar.html">Floral Print Buttoned</a>
                                            <p>Quantity: 1</p>
                                        </div>
                                    </div>
                                    <div class="s_add_cart_left_h">
                                        <p>£25.00</p>
                                        <a class="fa fa-times" href=""></a>
                                    </div>
                                </div>
                                <div class="single_add_cart_design">
                                    <div class="s_add_cart_left">
                                        <div class="add_cart_h_img">
                                            <a href=""><img src="images/1014254_full1.jpg" alt="" /></a>
                                        </div>
                                        <div class="add_cart_h_txt">
                                            <a href="product-left-sidebar.html">Floral Print Buttoned</a>
                                            <p>Quantity: 1</p>
                                        </div>
                                    </div>
                                    <div class="s_add_cart_left_h">
                                        <p>£25.00</p>
                                        <a class="fa fa-times" href=""></a>
                                    </div>
                                </div>
                                <div class="single_add_cart_design sp_des">
                                    <div class="s_add_cart_left_bld">
                                        <p>Subtotal</p>
                                    </div>
                                    <div class="s_add_cart_left_h bold_h">
                                        <p>£55.00</p>
                                    </div>
                                </div>
                                <div class="bottom_add_c_h">
                                    <ul>
                                        <li><a href="cart.html"><i class="fa fa-shopping-cart"></i>View Cart</a></li>
                                        <li><a href="checkout.html">Checkout<i class="fa fa-angle-right"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- ///// CONTENT MENU MOBILE  ///// -->
<div class="cc_mobile_navigation">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="only-for-mobile">
                    <div class="col-xs-12">
                        <ul class="ofm">
                            <li class="m_nav"><i class="fa fa-bars"></i> Navigation</li>
                        </ul>
                        <!-- MOBILE MENU -->
                        <div class="mobi-menu">
                            <div id='cssmenu'>
                                <ul>
                                    <li class='has-sub'>
                                        <a href='index.html'><span>Accueil</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Déposer une annonce</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Offres</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Demandes</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Mes annonces</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Boutiques</span></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

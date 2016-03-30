<%-- 
    Document   : nav
    Created on : Mar 7, 2016, 1:51:44 AM
    Author     : Mélissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ol class="breadcrumb">
    <li class="active"><i class="fa fa-dashboard"></i> Tableau de bord</li><%-- ${requestScope.totalElement}--%>
</ol>
<div class="alert alert-success alert-dismissable">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    Bienvenue à Michel Buffa par Manager User! N'hésitez pas à utiliser notre tableau de bord et à naviguer à travers nos fonctionnalités ! Très simple d'utilisation pour gérer vos nouveaux utilisateurs de façon dynamique, alors éclatez-vous à fond ! L'Equipe Manager User, Mélissa Begyn et Michel Mvouma.
</div>
<div class="row">
    <div class="col-lg-3">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-6">
                        <i class="fa fa-comments fa-5x"></i>
                    </div>
                    <div class="col-xs-6 text-right">
                        <p class="announcement-heading">n°1</p>
                        <p class="announcement-text">Créez!</p>
                    </div>
                </div>
            </div>
            <a href="ServletUsers?action=formulaireCreerUtilisateur&flatM=CRU">
                <div class="panel-footer announcement-bottom">
                    <div class="row">
                        <div class="col-xs-6">
                            Créer un utilisateur
                        </div>
                        <div class="col-xs-6 text-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="panel panel-warning">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-6">
                        <i class="fa fa-check fa-5x"></i>
                    </div>
                    <div class="col-xs-6 text-right">
                        <p class="announcement-heading">n°2</p>
                        <p class="announcement-text">Consultez!</p>
                    </div>
                </div>
            </div>
            <a href="ServletUsers?action=listerLesUtilisateurs&flatM=ATU">
                <div class="panel-footer announcement-bottom">
                    <div class="row">
                        <div class="col-xs-6">
                            Voir vos utilisateurs
                        </div>
                        <div class="col-xs-6 text-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="panel panel-danger">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-6">
                        <i class="fa fa-tasks fa-5x"></i>
                    </div>
                    <div class="col-xs-6 text-right">
                        <p class="announcement-heading">n°3</p>
                        <p class="announcement-text">Modifiez!</p>
                    </div>
                </div>
            </div>
            <a href="ServletUsers?action=listerLesUtilisateurs&flatM=MU">
                <div class="panel-footer announcement-bottom">
                    <div class="row">
                        <div class="col-xs-6">
                            Modifier un user
                        </div>
                        <div class="col-xs-6 text-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </div>

</div><!-- /.row -->
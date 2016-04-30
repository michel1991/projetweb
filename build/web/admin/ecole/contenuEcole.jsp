<%-- 
    Document   : contenuTypeAnnonce
    Created on : 28 mars 2016, 00:03:45
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="cssManAdmin">
<div class="text-center">
    <div class="row">
       
        <div class="col-md-12">
            <div class="text-center">
                <form role="form"  onsubmit="return addEcole();" id="formEcole"><!-- mettre la méthode à post return  addTypeCategorie();-->

                    <label for="nom" class="css-input01">Nom:  </label> <input type="text" class="css-input1" name="nom"  value="" required id="nom"/><br/>
                    <label for="nom" class="css-input01">CP:  </label> <input type="text" class="css-input1" name="cp"  value="" required id="cp"/><br/>
                    <label for="nom" class="css-input01">Adresse:  </label> <input type="text" class="css-input1" name="adresse"  value="" required id="adresse"/><br/>
                    
              
                    
                    
                    <label for="" class="cache"></label> <input type="hidden" name="idEcole" value="" id="idEcole"/>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Action
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                          <li>
                              <button type="submit" id="save" data-loading-text="Ajout..." class="btn btn-primary" autocomplete="off">
                                Ajouter
                              </button>
                              
                          </li>
                          <li role="separator" class="divider"></li>
                          <li>
                              <button type="submit" id="modif" data-loading-text="Modif..." class="btn btn-warning" autocomplete="off">
                                Modifier
                              </button>
                          </li>
                          <li role="separator" class="divider"></li>
                          <li>
                             <button type="button" id="supprim" data-loading-text="Sup..." class="btn btn-danger" autocomplete="off">
                                Supprimer
                              </button>
                          </li>
                        </ul>
                    </div>

                </form>
                </div>
        </div>
      
    </div>
   
</div>

    <div class="modal fade" tabindex="-1" role="dialog" id="modalMessage">
        <div class="modal-dialog modal-sm">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Message</h4>
            </div>
            <div class="modal-body">
              <p id="contenuMessage"></p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


<table id="tableEcoles" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                     <th>
                        <input name="select_all" value="1" type="checkbox">
                    </th>
                    
                    <th>
                        Nom
                    </th>
                    
                    <th>
                        CP
                    </th>
                    
                    <th>
                        Adresse
                    </th>
                
                    <th class="">
                        
                    </th>
                   
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="ecole" items="${requestScope['ecoles']}">
                    <tr>
                        <td>
                        </td>
                        <td>
                            ${ecole.nom}
                        </td>
                        <td>
                            ${ecole.cp}
                        </td>
                        
                        <td>
                            ${ecole.adresse}
                        </td>
                        <td class="">
                           ${ecole.id}
                        </td>
                    
                    </tr>
                </c:forEach>
            </tbody>
             
</table>
    
</div>

<script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/ecole.js" type="text/javascript"></script>
 
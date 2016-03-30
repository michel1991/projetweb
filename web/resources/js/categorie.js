/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var path = '${pageContext.servletContext.contextPath}';//context de l'application
     //console.log(path.replace('/',''));
      var table=null;
      var idCategorieSupprimer = [];
      var donneesCategories = [];
      
    $(function(){
        
        $("#modif").attr("disabled", "disabled");
        var rows_selected = [];
        table = $('#tableCategorie').DataTable(
        {
            'columnDefs': [{
            'targets': 0,
            'searchable': false,
            'orderable': false,
            'width': '1%',
            'className': 'dt-body-center',
            'render': function (data, type, full, meta){
                return '<input type="checkbox">';
            }
          },
            {
              "targets": [ 3 ],
              "visible": false,
              "searchable": false
           }, // pour l'id de la categorie
           
           {
              "targets": [ 4 ],
              "visible": false,
              "searchable": false
           }, // pour les types de categories id 
           
           {
              "targets": [ 2 ],
              "visible": true,
              "searchable": true
           }
          
      ],
          'order': [1, 'asc'],
          
           'rowCallback': function(row, data, dataIndex)
            {
              // Get row ID
              var rowId = data[0];
              // If row ID is in the list of selected row IDs
              if($.inArray(rowId, rows_selected) !== -1){
                 $(row).find('input[type="checkbox"]').prop('checked', true);
                 $(row).addClass('selected');
              }
              
            }
        }); // fin du databale
        
         $('#supprim').click(function(){
            /**
            * remplissage du tableau avec les identifiants à supprimer
            */
           var tableauData = table.rows('.selected').data();
          idCategorieSupprimer=[];
           for(var i =0; i<tableauData.length; i++)
           {
               var tableauIntermediaire =tableauData[i];
               if(tableauIntermediaire[3]!==null)
               {
                   idCategorieSupprimer.push(tableauIntermediaire[3]);
               }
              
           }
           table.rows('.selected').remove().draw();
           if(idCategorieSupprimer.length>0)
           {
                supprimerCategorie(idCategorieSupprimer);
           }else{
               $('#contenuMessage').text("Aucune colonne selectionée");
              $('#modalMessage').modal('show');
           }
          
           
        });
        
       
        function updateDataTableSelectAllCtrl(table)
        {
            var $table             = table.table().node();
            var $chkbox_all        = $('tbody input[type="checkbox"]', $table);
            var $chkbox_checked    = $('tbody input[type="checkbox"]:checked', $table);
            var chkbox_select_all  = $('thead input[name="select_all"]', $table).get(0);

            // If none of the checkboxes are checked
            if($chkbox_checked.length === 0)
            {
               chkbox_select_all.checked = false;
               if('indeterminate' in chkbox_select_all)
               {
                  chkbox_select_all.indeterminate = false;
               }
             // If all of the checkboxes are checked
            } else if ($chkbox_checked.length === $chkbox_all.length)
            {
               chkbox_select_all.checked = true;
               if('indeterminate' in chkbox_select_all)
               {
                  chkbox_select_all.indeterminate = false;
               }
                // If some of the checkboxes are checked
            } else 
            {
                chkbox_select_all.checked = true;
                if('indeterminate' in chkbox_select_all){
                   chkbox_select_all.indeterminate = true;
                }
            }
        }
        
        // Handle click on checkbox
        $('#tableCategorie tbody').on('click', 'input[type="checkbox"]', function(e)
        {
           var $row = $(this).closest('tr');

           // Get row data
           var data = table.row($row).data();

           // Get row ID
           var rowId = data[0];
           // Determine whether row ID is in the list of selected row IDs 
           var index = $.inArray(rowId, rows_selected);

           // If checkbox is checked and row ID is not in list of selected row IDs
           if(this.checked && index === -1){
              rows_selected.push(rowId);

           // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
           } else if (!this.checked && index !== -1){
              rows_selected.splice(index, 1);
           }

           if(this.checked){
              $row.addClass('selected');
           } else {
              $row.removeClass('selected');
           }
           
          
          /*
           * verifie si le nombre de ligne selectionné = 1 pour pourvoir afficher la modification
           */
          
           if(table.rows('.selected').data().length===1)
           {
               $('#typeCategorie option').eq(0).removeAttr('selected');
               var resultat = table.rows('.selected').data();
               var tableauResultat = resultat[0];
               
               
               if(tableauResultat[1]!==null)
               {
                   //console.log("value update " + tableauResultat[1]);
                   //document.getElementById("libelle").setAttribute('value',tableauResultat[1]);
                   $('#libelle').val(tableauResultat[1]);
               }
                
                if(tableauResultat[3]!==null)
                {
                    $('#idCategorie').val(tableauResultat[3]);
                    //document.getElementById("idCategorie").setAttribute('value',tableauResultat[3]); 
                }
                $('#typeCategorie').val(tableauResultat[4]);
                
               $("#modif").removeAttr("disabled"); 
           }else{
               $('#typeCategorie option').eq(0).removeAttr('selected');
               $('#typeCategorie option').eq(0).attr('selected', 'selected'); //gerer le select la premiere selection
               $('#libelle').val('');
               $('#idCategorie').val('');
               $("#modif").attr("disabled", "disabled");
           }
           updateDataTableSelectAllCtrl(table);

           // Prevent click event from propagating to parent
           e.stopPropagation();
        });
        
        // Handle click on table cells with checkboxes
        $('#tableCategorie').on('click', 'tbody td, thead th:first-child', function(e){
           $(this).parent().find('input[type="checkbox"]').trigger('click');
        });
        
        // Handle click on "Select all" control
        $('thead input[name="select_all"]', table.table().container()).on('click', function(e){
           if(this.checked){
              $('#tableCategorie tbody input[type="checkbox"]:not(:checked)').trigger('click');
           } else {
              $('#tableCategorie tbody input[type="checkbox"]:checked').trigger('click');
           }

           // Prevent click event from propagating to parent
           e.stopPropagation();
        });
        
        // Handle table draw event
        table.on('draw', function(){
           // Update state of "Select all" control
           updateDataTableSelectAllCtrl(table);
        });
        
        // remplissage du tableau
        getDataCategorie();
    });
    //document.getElementById("nomRegion").setAttribute('value','My default value');
    
    // Ajouter une region
    function addCategorie() 
    {
        //$('#linkupdate').hide();
        var categorie = {};
        categorie.libelle =document.querySelector("#libelle").value;
        categorie.id =document.querySelector("#idCategorie").value;
        categorie.typeCategorie =document.querySelector("#typeCategorie").value;
        
        if($('#sousAnnonce').is(':checked'))
        {
            categorie.sousAnnoce ="1";//cocher
        }else{
            categorie.sousAnnoce ="0"; // non cocher
        }
        
        var url =''+path+'/ControllerCentralCategorie?action=add';
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.onloadend = function () 
        {
            var categorieR = JSON.parse(this.response);
            //console.log("reponse " +JSON.stringify(categorieR));
            if(typeof categorieR !='undefined')//== "undefined"
            {
                if(categorieR.id!==null)
                {
                    if(typeof categorieR.op !='undefined' &&  categorieR.op==='add')
                    {
                        table.row.add( [ '', categorieR.libelle,categorieR.libelleTypeCat, categorieR.id, categorieR.idTypeCat]).draw();
                        $('#contenuMessage').text("Insertion reussie");
                        $('#modalMessage').modal('show');
                        donneesCategories.push(categorieR);
                    }else if(typeof categorieR.op !='undefined' && categorieR.op==='upd')
                    {
                       $('#contenuMessage').text("Modification reussie");
                        $('#modalMessage').modal('show');
                        
                        table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
                            var d = this.data();

                             // update data source for the row
                            //console.log( d.counter++ + ' ' +rowIdx + ' ' + d + ' ' + tableLoop)
                            console.log(d[3] + ' '+ categorieR.id);
                            if(d[3]==categorieR.id)
                            {
                                //console.log("trouver ");
                                d[1]=categorieR.libelle;
                                d[2]=categorieR.libelleTypeCat;

                            }

                           table.row( this ).data(d).draw();
                           
                        } );
                    }
                    
                    $('input[type="text"]').each(function()
                        {
                            $(this).val('');
                        }
                    );
                    $('#idCategorie').val('');
            
                   $('input[type="checkbox"]').each(function()
                        {
                            $(this).prop('checked', false);
                        }
                    );
                }
                
            }else{
                if(categorieR.op==='add')
                {
                    $('#contenuMessage').text("Echec insertion");
                    $('#modalMessage').modal('show');
                }else if(categorieR.op==='upd')
                {
                    $('#contenuMessage').text("Echec Modification");
                    $('#modalMessage').modal('show');
                }
            }
            
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        console.log("send " +JSON.stringify(categorie));
        xhr.send(JSON.stringify(categorie));

        return false;
    }
    
    function getDataCategorie()
    {
        var url =''+path+'/ControllerCentralCategorie?action=data';
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.onloadend = function () 
        {
            var datas =  JSON.parse(this.response);
            donneesCategories  = datas;
            //console.log("reponse " +JSON.stringify(datas));
            if(typeof datas !='undefined')
            {
                for(var i =0; i<datas.length; i++)
                {
                    table.row.add(['', datas[i].libelle, datas[i].libelleTypeCat, datas[i].id, datas[i].idTypeCat]).draw();
                }
            }
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send("");
    }
    
    function supprimerCategorie(tableauId)
    {
        var url =''+path+'/ControllerCentralCategorie?action=delete';
        //console.log(JSON.stringify(tableauId));
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);

        xhr.onloadend = function () 
        {
            //console.log(JSON.parse(this.response));
            if(JSON.parse(this.response)==0)
            {
                $('#contenuMessage').text("Suppression reussie");
            }else{
                $('#contenuMessage').text("Impossible de suprimer");
            }
            $('#modalMessage').modal('show');
            
             $('input[type="text"]').each(function()
                {
                    $(this).val('');
                });
                $('#idCategorie').val('');
                
            $('input[type="checkbox"]').each(function()
                    {
                        $(this).prop('checked', false);
                    }
                );
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send(JSON.stringify(tableauId));
        return false;
    }
    
    function cocherCaseAnnonce()
    {
        
    }
    
    
    
    
   







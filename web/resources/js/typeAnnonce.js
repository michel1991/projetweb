
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
      var idTypeAnnonceSupprimer = [];
      var donneesCategories = [];
      
    $(function(){
        
        $("#modif").attr("disabled", "disabled");
        var rows_selected = [];
        table = $('#tableTypeAnnonce').DataTable(
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
              "targets": [ 2 ],
              "visible": false,
              "searchable": false
           }// pour l'id de la categorie
           
           
          
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
          idTypeAnnonceSupprimer=[];
           for(var i =0; i<tableauData.length; i++)
           {
               var tableauIntermediaire =tableauData[i];
               if(tableauIntermediaire[3]!==null)
               {
                   idTypeAnnonceSupprimer.push(tableauIntermediaire[3]);
               }
              
           }
           table.rows('.selected').remove().draw();
           if(idTypeAnnonceSupprimer.length>0)
           {
               supprimerTypeAnnonce(idTypeAnnonceSupprimer);
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
        $('#tableTypeAnnonce tbody').on('click', 'input[type="checkbox"]', function(e)
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
               
               var resultat = table.rows('.selected').data();
               var tableauResultat = resultat[0];
               
               
               if(tableauResultat[1]!==null)
               {
                   $('#libelle').val(tableauResultat[1]);
               }
                
                if(tableauResultat[2]!==null)
                {
                    $('#idTypeAnnonce').val(tableauResultat[2]);
                    //document.getElementById("idCategorie").setAttribute('value',tableauResultat[3]); 
                }
                
                
               $("#modif").removeAttr("disabled"); 
           }else{
              
               $('#libelle').val('');
               $('#idTypeAnnonce').val('');
               $("#modif").attr("disabled", "disabled");
           }
           updateDataTableSelectAllCtrl(table);

           // Prevent click event from propagating to parent
           e.stopPropagation();
        });
        
        // Handle click on table cells with checkboxes
        $('#tableTypeAnnonce').on('click', 'tbody td, thead th:first-child', function(e){
           $(this).parent().find('input[type="checkbox"]').trigger('click');
        });
        
        // Handle click on "Select all" control
        $('thead input[name="select_all"]', table.table().container()).on('click', function(e){
           if(this.checked){
              $('#tableTypeAnnonce tbody input[type="checkbox"]:not(:checked)').trigger('click');
           } else {
              $('#tableTypeAnnonce tbody input[type="checkbox"]:checked').trigger('click');
           }

           // Prevent click event from propagating to parent
           e.stopPropagation();
        });
        
        // Handle table draw event
        table.on('draw', function(){
           // Update state of "Select all" control
           updateDataTableSelectAllCtrl(table);
        });
        
    });
    //document.getElementById("nomRegion").setAttribute('value','My default value');
    
    // Ajouter une region
    function addTypeAnnonce() 
    {
        //$('#linkupdate').hide();
        var typeAnnonce = {};
        typeAnnonce.libelle =document.querySelector("#libelle").value;
        typeAnnonce.id =document.querySelector("#idTypeAnnonce").value;
        
        var url =''+path+'/ControllerCentralTypeAnnonce?action=add';
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.onloadend = function () 
        {
            var typeAnnonceR = JSON.parse(this.response);
            //console.log("reponse " +JSON.stringify(typeAnnonce));
            if(typeof typeAnnonceR !='undefined')//== "undefined"
            {
                if(typeAnnonceR.id!==null)
                {
                    if(typeof typeAnnonceR.op !='undefined' &&  typeAnnonceR.op==='add')
                    {
                        table.row.add( [ '', typeAnnonceR.libelle, typeAnnonceR.id]).draw();
                        $('#contenuMessage').text("Insertion reussie");
                        $('#modalMessage').modal('show');
                        donneesCategories.push(typeAnnonceR);
                    }else if(typeof typeAnnonceR.op !='undefined' && typeAnnonceR.op==='upd')
                    {
                       $('#contenuMessage').text("Modification reussie");
                        $('#modalMessage').modal('show');
                        
                        table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
                            var d = this.data();

                             
                            console.log(d[2] + ' '+ typeAnnonceR.id);
                            if(d[2]==typeAnnonceR.id)
                            {
                                //console.log("trouver ");
                                d[1]=typeAnnonceR.libelle;
                            }

                           table.row( this ).data(d).draw();
                           
                        } );
                    }
                    
                    $('input[type="text"]').each(function()
                        {
                            $(this).val('');
                        }
                    );
                    $('#idTypeAnnonce').val('');
            
                }
                
            }else{
                if(typeAnnonceR.op==='add')
                {
                    $('#contenuMessage').text("Echec insertion");
                    $('#modalMessage').modal('show');
                }else if(typeAnnonceR.op==='upd')
                {
                    $('#contenuMessage').text("Echec Modification");
                    $('#modalMessage').modal('show');
                }
            }
            
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        //console.log("send " +JSON.stringify(typeAnnonce));
        xhr.send(JSON.stringify(typeAnnonce));

        return false;
    }
   
    function supprimerTypeAnnonce(tableauId)
    {
        var url =''+path+'/ControllerCentralTypeAnnonce?action=delete';
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
                $('#idTypeAnnonce').val('');
                
            
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send(JSON.stringify(tableauId));
        return false;
    }
    
    function cocherCaseAnnonce()
    {
        
    }
    
    
    
    
   









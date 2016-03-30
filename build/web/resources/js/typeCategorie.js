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
      var idTypeCategorieSupprimer = [];
      
    $(function(){
        $("#linkAdd").popover({
            html: true, 
            content: function() 
            {
              return $('#popover-content').html();
            }
        });
         //$('#nomRegion').val('michel');
         $('#modalMessage').modal('hide');
         
        $("#linkupdate").popover({
            html: true, 
            content: function() 
            {
              return $('#popover-contentUpdate').html();
            }
        });
        
       
        $('#linkupdate').hide();
        //$('.cache').hide();
        
        // Array holding selected row IDs
        var rows_selected = [];
        table = $('#tableRegion').DataTable(
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
           },
           
           {
              "targets": [ 2 ],
              "visible": false,
              "searchable": false
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
        
         $('#supprimerRegion').click(function(){
            /**
            * remplissage du tableau avec les identifiants à supprimer
            */
           var tableauData = table.rows('.selected').data();
          idTypeCategorieSupprimer=[];
           for(var i =0; i<tableauData.length; i++)
           {
               var tableauIntermediaire =tableauData[i];
               if(tableauIntermediaire[3]!==null)
               {
                   idTypeCategorieSupprimer.push(tableauIntermediaire[3]);
               }
              
           }
           table.rows('.selected').remove().draw();
           if(idTypeCategorieSupprimer.length>0)
           {
                supprimerTypeCategorie(idTypeCategorieSupprimer);
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
        $('#tableRegion tbody').on('click', 'input[type="checkbox"]', function(e)
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
               $('#linkupdate').popover('show');
               $('#linkupdate').show();//popover-contentUpdate
               var resultat = table.rows('.selected').data();
               var tableauResultat = resultat[0];
               
               if(tableauResultat[1]!==null)
               {
                   document.getElementById("nomTypUpdate").setAttribute('value',tableauResultat[1]);
               }
                
                if(tableauResultat[3]!==null)
                {
                    document.getElementById("idTypUpdate").setAttribute('value',tableauResultat[3]); 
                }   
                
           }else{
               $('#linkupdate').hide();
               $('#linkupdate').popover('hide');
           }
           
           
           
           updateDataTableSelectAllCtrl(table);

           // Prevent click event from propagating to parent
           e.stopPropagation();
        });
        
        // Handle click on table cells with checkboxes
        $('#tableRegion').on('click', 'tbody td, thead th:first-child', function(e){
           $(this).parent().find('input[type="checkbox"]').trigger('click');
        });
        
        // Handle click on "Select all" control
        $('thead input[name="select_all"]', table.table().container()).on('click', function(e){
           if(this.checked){
              $('#tableRegion tbody input[type="checkbox"]:not(:checked)').trigger('click');
           } else {
              $('#tableRegion tbody input[type="checkbox"]:checked').trigger('click');
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
    function addTypeCategorie() 
    {
        //$('#linkupdate').hide();
        var typeCategorie = {};
        typeCategorie.nomTyp =document.querySelector("#nomTyp").value;
        var url =''+path+'/ControllerCentralTypeCategorie?action=add';
        
        $('input[type="text"]').each(function(){
            if($(this).val()!=='' && $(this).attr('id')==='nomTyp')
            {
                typeCategorie.nomTyp=$(this).val();
                //console.log('value ' + $(this).val() +' id ' + $(this).attr('id') +' index ' + index);
            }
            
        });
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);

        xhr.onloadend = function () 
        {
            //Mise à jour du dataTable
            //Mise à jour du formulaire de donnée
            var typeCategorieR = JSON.parse(this.response);
            if(typeof typeCategorieR !='undefined')//== "undefined"
            {
                if(typeCategorieR.id!==null)
                {
                    table.row.add( [ '', typeCategorieR.nomTyp, typeCategorieR.dateCreation, typeCategorieR.id]).draw();
                    $('input[type="text"]').each(function()
                    {
                        if($(this).val()!=='' && $(this).attr('id')==='nomTyp')
                        {
                            $(this).val('');
                        }
                   });
                   
                   $('#contenuMessage').text("Insertion reussie");
                   $('#modalMessage').modal('show');
                }
                
            }
            
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send(JSON.stringify(typeCategorie));

        return false;
    }
    
    function supprimerTypeCategorie(tableauId)
    {
        var url =''+path+'/ControllerCentralTypeCategorie?action=delete';
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);

        xhr.onloadend = function () 
        {
            console.log(JSON.parse(this.response));
            if(JSON.parse(this.response)==0)
            {
                $('#contenuMessage').text("Suppression reussie");
            }else{
                $('#contenuMessage').text("Impossible de suprimer");
            }
            $('#modalMessage').modal('show');
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send(JSON.stringify(tableauId));
        return false;
    }
    
    function updateTypeCategorie() 
    {
        var typeCategorie = {};
        
        var url =''+path+'/ControllerCentralTypeCategorie?action=update'; 
        $('input[type="text"]').each(function(){
            if($(this).val()!=='' && $(this).attr('id')==='nomTypUpdate')
            {
                typeCategorie.nomTyp=$(this).val();
                //console.log('value ' + $(this).val() +' id ' + $(this).attr('id') +' index ' + index);
            }
            
            if($(this).val()!=='' && $(this).attr('id')==='idTypUpdate')
            {
                typeCategorie.id=$(this).val();
            }
            
        });
        console.log("id go " + typeCategorie.id + typeCategorie.nomTyp);
        var xhr = new XMLHttpRequest();
        
        if(typeCategorie.id!==null && typeCategorie.nomTyp!==null && typeCategorie.nomTyp.length>0)
        {
           xhr.open('POST', url, true);
            xhr.onloadend = function () 
            {
                var typeCategorieR = JSON.parse(this.response);
                //console.log("update " + JSON.stringify(typeCategorieR));
                if(typeof typeCategorieR !='undefined')//== "undefined"
                {
                    if(typeCategorieR.id!==null)
                    {

                       $('#contenuMessage').text("Modification reussie");
                       $('#modalMessage').modal('show');

                       table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
                            var d = this.data();

                             // update data source for the row
                            //console.log( d.counter++ + ' ' +rowIdx + ' ' + d + ' ' + tableLoop)
                            console.log(d[3] + ' '+ typeCategorieR.id);
                            if(d[3]==typeCategorieR.id)
                            {
                                //console.log("trouver ");
                                d[1]=typeCategorieR.nomTyp;

                            }

                           table.row( this ).data(d).draw();
                           
                        } );

                        //table.draw();
                    }

                }

            };
            xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
            xhr.send(JSON.stringify(typeCategorie)); 
        }
        
        return false;
    }
   




/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {
    console.log( "document loaded" );
    //$('#bouton-connexion').on( 'click', function () { // Fonction appelée lors du clic sur le bouton
    
    if(window.location.pathname==="/medium.html"){  
        // Appel AJAX
        $.ajax({
            url: './ActionServlet',
            method: 'POST',
            data: {
                todo: 'listermedium'
            },
            dataType: 'json'
        })
        .done( function (response) { // Fonction appelée en cas d'appel AJAX réussi
            console.log('Response',response); // LOG dans Console Javascript
                document.mediums = response.mediums;
                // TODO: afficher les informations du client dans la notification
                // Exemple: Connexion de Ada Lovelace (ID 1)
                $.each(response.mediums, function(key, med){
                    var new_text = '<li class="list-group-item medium" role="button" data-id="'+ med.id +'">' +'Denomination : '+ med.denomination;
                   
                    new_text += ' Type : ' + med.type;
                    new_text += ' Genre : ' + med.genre;
                    new_text += '</li>';
                    
                    $("#liste").append(new_text);
                    
                    
                });
                $(".medium").on("click", function(){
                    var id = $(this).attr("data-id");
                    $.each(document.mediums, function(key, med){
                       if(id == med.id){
                           console.log("found");
                           $("#presentation").text(med.presentation);
                           $("#denomination").text(med.denomination);
                           
                           $("#genre").text(med.genre);
                           $("#chosen").attr("data-id", med.id);
                       } 
                    });
                });

        })
        .fail( function (error) { // Fonction appelée en cas d'erreur lors de l'appel AJAX
            console.log('Error',error); // LOG dans Console Javascript
            alert("Erreur lors de l'appel AJAX");
        })
        .always( function () { // Fonction toujours appelée

        });
        
        
        $("#btn-choix").on("click", function(){
            if($("#chosen").attr("data-id") === undefined){
                console.log("pb");
            }
            else{
                $.ajax({
                    url: './ActionServlet',
                    method: 'POST',
                    data: {
                        todo: 'enregistrer-demande-consultation',
                        "medium-id": $("#chosen").attr("data-id")
                    },
                    dataType: 'json'
                })
                .done(function(response){
                    if(response.success){
                        alert("Votre medium vous contactera sous peu ! ");
                    }else{
                        alert("Il y a eu un probleme dans la demande, veuillez reeasayer plus tard");
                    }
                });
            }
        });
        
        
    }
    
   // });
    /////////////////////////////////////////////////
    //$('#bouton-Stat').on( 'click', function () { // Fonction appelée lors du clic sur le bouton
    if(window.location.pathname==="/statistiques.html"){  
                 
        // Appel AJAX
        $.ajax({
            url: './ActionServlet',
            method: 'POST',
            data: {
                todo: 'obtenir-top-medium'
            },
            dataType: 'json'
        })
        .done( function (response) { // Fonction appelée en cas d'appel AJAX réussi
            console.log('Response',response); // LOG dans Console Javascript

                // TODO: afficher les informations du client dans la notification
                // Exemple: Connexion de Ada Lovelace (ID 1)
                $.each(response.mediums, function(key, med){
                    var new_text = '<div class="jumbotron medium">' +'Denomination : <b>'+ med.denomination + '</b><br>';
                   
                    new_text += ' Type : ' + med.type + '<br>';
                    new_text += ' Genre : ' + med.genre + '<br>';
                    new_text += ' nb consultations : <b>' + med.nbConsulation + '</b><br>'
                    new_text += '</div>';
                    
                    $("#jumbotron-list").append(new_text);
                    
                    
                });


        })
        .fail( function (error) { // Fonction appelée en cas d'erreur lors de l'appel AJAX
            console.log('Error',error); // LOG dans Console Javascript
            alert("Erreur lors de l'appel AJAX");
        })
        .always( function () { // Fonction toujours appelée

        });
        
        
        $.ajax({
            url: './ActionServlet',
            method : 'POST',
            data :{
                todo: 'top-employe'
            },
            dataType: 'json'
        })
        .done(function(response){
            if(response.success){
                $.each(response.employes, function(key, emp){
                    var new_text = '<div class="jumbotron employe">' +'Nom : <b>'+ emp.prenom + ' ' + emp.nom + '</b><br>';
                   
                    new_text += ' nombre de Consultation : ' + emp["nb-consultation"] + '<br>';
                    new_text += ' Genre : ' + emp.genre + '<br>';
                    new_text += '</div>';
                    
                    $(".stat-employe").append(new_text);
                });
            }
        })
        
    }
});

$( window ).on( "load", function() {
    console.log( "window loaded" );
});
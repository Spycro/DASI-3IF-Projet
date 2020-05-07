/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {
    console.log( "document loaded" );
     $('#bouton-connexion').on( 'click', function () { // Fonction appelée lors du clic sur le bouton

                 
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

                // TODO: afficher les informations du client dans la notification
                // Exemple: Connexion de Ada Lovelace (ID 1)
                $.each(response.mediums, function(key, med){
                   
                    
                    $("#liste").append("<p>" + med.denomination + "</p>");
                    $("#liste").append("<p>Type : " + med.type + "</p>");
                    $("#liste").append("<p>Presentation : " + med.presentation + "</p>");
                    
                    if(med.type === "astrologue"){
                        $("#liste").append("<p>Formation : " + med.formation + "</p>");
                        $("#liste").append("<p>Promotion : " + med.promotion + "</p>");
                    }
                    if(med.type === "spirite"){
                        $("#liste").append("<p>Support : " + med.support + "</p>");
                    }
                    
                });


        })
        .fail( function (error) { // Fonction appelée en cas d'erreur lors de l'appel AJAX
            console.log('Error',error); // LOG dans Console Javascript
            alert("Erreur lors de l'appel AJAX");
        })
        .always( function () { // Fonction toujours appelée

        });
    });
});

$( window ).on( "load", function() {
    console.log( "window loaded" );
});
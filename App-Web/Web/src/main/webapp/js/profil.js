/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//taken from https://stackoverflow.com/questions/3930199/how-to-run-a-jquery-or-javascript-before-page-start-to-load
function redirectHandler(condition, url){
  if(condition){
    window.location = url;
  }else{
    return false;
  }
}

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
                    var new_text = '<li class="list-group-item medium">' +'Denomination : '+ med.denomination;
                   
                    new_text += ' Type : ' + med.type;
                    new_text += ' Genre : ' + med.genre;
                    new_text += '</li>';
                    
                    $("#liste").append(new_text);
                    
                    
                });


        })
        .fail( function (error) { // Fonction appelée en cas d'erreur lors de l'appel AJAX
            console.log('Error',error); // LOG dans Console Javascript
            alert("Erreur lors de l'appel AJAX");
        })
        .always( function () { // Fonction toujours appelée

        });
    });
    /////////////////////////////////////////////////
});

$( window ).on( "load", function() {
    console.log( "window loaded" );
});
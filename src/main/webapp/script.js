//Fetches notes from server as a JSON array
function loadNotes(){
    fetch("rest/noterest").then(function(noteresponse){
        //extracts json object
        noteresponse.json().then((function(notes){
            //fetches template
            fetch("note.mustache").then(function(templateresponse){
                //extracts template as plain text
                templateresponse.text().then(function(template){
                    //Renders template with json object - injects objects as notes
                    var html = Mustache.render(template, {noter:notes});
                    //replaces body contents with rendered template
                    document.getElementById("main").innerHTML = html;
                })
            })
        }))
    });

}

function createNote(inputField){
    input = document.getElementById(inputField).value;
    fetch("rest/noterest",{method:'post',
        body:JSON.stringify({tekst:input}),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    }).then(function(){
        loadNotes();
    })

}

function deleteNote(e){
    fetch("rest/noterest/" +e,{method:'delete'}).then(function(){
        loadNotes();
    })
}
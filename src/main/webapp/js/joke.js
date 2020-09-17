let url = 'api/joke/';

//Get All Jokes Fetch
document.getElementById("getAllJokes").addEventListener("click", function (event) {
    event.preventDefault();
        fetch(url + 'all')
            .then(res => res.json()) 
            .then(data => {
                 //console.log("data", data);
                 document.getElementById("jokeTable").innerHTML = html+makeTableAllJokes()(data); //Renders joke table
                 //console.log(makeTable(data));
            });
    });
document.getElementById("jokeByID").addEventListener("click", function (event) {
    event.preventDefault();
        fetch(url + document.getElementById("inputID").value)
            .then(res => res.json()) 
            .then(data => {
                 // console.log("data", data);
                 document.getElementById("jokeTable").innerHTML = html+makeTableForSpecificJoke(data); //Renders joke table
                 //console.log(makeTableForSpecificJoke(data));
            });
    });
document.getElementById("randomJoke").addEventListener("click", function (event) {
    event.preventDefault();
        fetch(url + 'random')
            .then(res => res.json()) 
            .then(data => {
                 //console.log("data", data);
                 document.getElementById("jokeTable").innerHTML = html+makeTableForSpecificJoke(data); //Renders joke table
                 //console.log(makeTableForSpecificJoke(data));
            });
    });
    
function makeTableForSpecificJoke(data){
        return(`<tr><td>
                 ${data.id} 
                 </td><td> 
                 ${data.joke}
                 </td><td>
                 ${data.topic} 
                 </td>`);
};

    function makeTableAllJokes(data) {
        createTable = data.map(function (e) {
                return (
                    `<tr><td>
                    ${e.id} 
                    </td><td> 
                    ${e.joke}
                    </td><td>
                    ${e.topic} 
                    </td>`
                );
            }).join(" ");
            
        return createTable;
    }
const html = '<thead><th>ID</th><th>Joke</th><th>Topic</th></thead>';


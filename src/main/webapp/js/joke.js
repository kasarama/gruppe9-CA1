const jokeDiv = document.getElementById("forJokes");
const jokeByIDBtn = document.getElementById("jokeByID");
const randomJokeBtn = document.getElementById("randomJoke");
const getAllJokesBtn = document.getElementById("getAllJokes");
const inputIDTextField = document.getElementById("inputID");

//let url = 'https://dosmarter.tech/api/joke/all';
//let url = '/api/joke/';
let url = 'https://www.noellzane.dk/ROOT-1.0.1/api/joke/'


document.getElementById("getAllJokes").addEventListener("click", function (event) {
    event.preventDefault();
        fetch(url + 'all')
            .then(res => res.json()) 
            .then(data => {
                //console.log("data", data);
                 document.getElementById("jokeTable").innerHTML = html+makeTable(data);
                 //console.log(makeTable(data));
            })
    });
document.getElementById("jokeByID").addEventListener("click", function (event) {
    event.preventDefault();
        fetch(url + document.getElementById("inputID").value)
            .then(res => res.json()) 
            .then(data => {
                // console.log("data", data);
                 document.getElementById("jokeTable").innerHTML = html+ `<tr><td>
                 ${data.id} 
                 </td><td> 
                 ${data.joke}
                 </td><td>
                 ${data.topic} 
                 </td>`
                //  console.log(makeTable(data));
            })
    });
document.getElementById("randomJoke").addEventListener("click", function (event) {
    event.preventDefault();
        fetch(url + 'random')
            .then(res => res.json()) 
            .then(data => {
                //console.log("data", data);
                 document.getElementById("jokeTable").innerHTML = html+`<tr><td>
                 ${data.id} 
                 </td><td> 
                 ${data.joke}
                 </td><td>
                 ${data.topic} 
                 </td>`
                 //console.log(makeTable(data));;
            })
    });

    function makeTable(data) {
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
            })
            .join(" ");
        return createTable;
    }
const html = '<thead><th>ID</th><th>Joke</th><th>Topic</th></thead>';


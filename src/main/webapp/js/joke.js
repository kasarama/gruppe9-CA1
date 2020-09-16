const jokeDiv = document.getElementById("forJokes");
const jokeByIDBtn = document.getElementById("jokeByID");
const randomJokeBtn = document.getElementById("randomJoke");
const getAllJokesBtn = document.getElementById("getAllJokes");
const inputIDTextField = document.getElementById("inputID");

let url = '/api/joke/';

getAllJokesBtn.addEventListener("click", function (event) {
    event.preventDefault();
    fetch(url + 'all')
    console.log(url)
    
        .then(res => res.json()) //in flow1, just do it
        .then(data => {
            // Inside this callback, and only here, the response data is available
            console.log("data", data);
            document.getElementById("forJokes").innerHTML = data;
            // forJoke.innerHTML = data;
            let result = '';


        })


    });
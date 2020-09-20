

            function fetchOnLoad() {
                
                fetch("api/album/all")
                        .then(res => res.json())
                        .then(data => {
                            console.log("data", data);
                            all = data.map(n => listAlbumDivs(n));
                            document.getElementById("galleri").innerHTML = all;
                            document.getElementById("albumQ").innerHTML = "We've got " + all.length + " albums"
                        });
            }



             maxYear = document.getElementById("maxYear").value;
             minYear = document.getElementById("minYear").value;



            function fromBeforeYear(n) {
                console.log("From before: " + maxYear);
                if (n.year < document.getElementById("maxYear").value)
                    return n;
            }
            function fromAfterYear(n) {
                console.log("From after " + minYear);

                if (n.year > document.getElementById("minYear").value)
                    return n;
            }


            buttMax = document.getElementById("beforeYear");
            buttMax.addEventListener("click", function (event) {
                event.preventDefault();
                fetch("api/album/all")
                        .then(res => res.json()) //in flow1, just do it
                        .then(data => {
                            filtered=data.filter(fromBeforeYear);
                                        console.log(filtered);

                            older = filtered.map(n => listAlbumDivs(n));
                            document.getElementById("galleri").innerHTML = older;
                            document.getElementById("albumQ").innerHTML = "There is " + older.length + " albums from before " + maxYear;
                        });
            });


            buttMin = document.getElementById("afterYear");
            buttMin.addEventListener("click", function (event) {
                event.preventDefault();
                fetch("api/album/all")
                        .then(res => res.json()) //in flow1, just do it
                        .then(data => {
                           filteredN= data.filter(fromAfterYear);
                    console.log("after filter:" + data);
                            newer = filteredN.map(n => listAlbumDivs(n));
                            document.getElementById("galleri").innerHTML = newer;
                            document.getElementById("albumQ").innerHTML = "There is " + newer.length + " albums from after " + minYear;
                        });
            });




            var SortbyTitle = function (a, b) {
                if (a.title < b.title)
                    return -1;
                if (a.title > b.title)
                    return 1;
                return 0;
            }

            buttTitle = document.getElementById("sortByTitle");
            buttTitle.addEventListener("click", function (event) {
                event.preventDefault();
                console.log("sortby title");

                fetch("api/album/all")
                        .then(res => res.json()) //in flow1, just do it
                        .then(data => {
                            console.log("fatching for title");
                            data.sort(SortbyTitle);
                            console.log(data);
                            sortedT = data.map(n => listAlbumDivs(n));


                            document.getElementById("galleri").innerHTML = sortedT;


                        });
            });




            var SortbyPublisher = function (a, b) {
                if (a.publisher < b.publisher)
                    return -1;
                if (a.publisher > b.publisher)
                    return 1;
                return 0;
            }

            buttPublisher = document.getElementById("sortByPublisher");
            buttPublisher.addEventListener("click", function (event) {
                event.preventDefault();
                console.log("sortby publisher");

                fetch("api/album/all")
                        .then(res => res.json()) //in flow1, just do it
                        .then(data => {
                            console.log("fatching for title");
                            data.sort(SortbyPublisher);
                            console.log(data);
                            sortedP = data.map(n => listAlbumDivs(n));


                            document.getElementById("galleri").innerHTML = sortedP;


                        });
            });










            function listAlbumDivs(album) {
                return (`                
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card h-100">
                        <img class="card-img-top" src="img/album${album.id % 10}.jpg" alt="http://placehold.it/500x325">
                        <div class="card-body">
                            <h4 class="card-title">${album.title}</h4>
                            <table class="table">
                                <tr>
                                    <th scope="row">publisher</th>
                                    <td>${album.publisher}</td>
                                </tr>        
                                <tr>
                                    <th scope="row">year</th>
                                    <td>${album.year}</td>     
                                </tr>
                                <tr>
                                    <th scope="row">adition</th>
                                    <td>${album.edition}</td>     
                                </tr>
                                <tr>
                                    <th scope="row">country</th>
                                    <td>${album.country}</td>     
                                </tr>
                                <tr>
                                    <th scope="row">price</th>
                                    <td>${album.price}</td>     
                                </tr>
                                <tr>
                                    <th scope="row">status</th>
                                    <td>${album.status}</td>     
                                </tr>
                            </table>

                        </div>
                        <div class="card-footer">
                            <a href="Album.html" class="btn btn-primary" id="singleAlbum" onclick="goToAlbum(${album.id})">Find Out More!</a>
                        </div>
                    </div>
                </div>`);


            }
            ;



            function goToAlbum(id) {
                window.singleAlbumID = id;

            }





/**
 * @author magda
 */
count = 0;
            let allStudentsRecordInputBtn = document.getElementById("allStudentsBtn");
            let studentTableString = ":)";
            
            allStudentsRecordInputBtn.addEventListener("click", function (event) {
                // event.preventDefault();
                fatchAllStudents();
                count++;
            });


            function fatchAllStudents() {
                //let url = "https://dosmarter.tech/Gruppe9-CA1/api/groupmembers/all"
              //  let url = "http://localhost:8080/api/groupmembers/all";
               let url = "https://dosmarter.tech/api/groupmembers/all";
                fetch(url)
                        .then(res => res.json())
                        .then(data => {
                            studentTableString = data.map(n => "<tr><th>" + n.name + "</th><th>" + n.id + "</th><th>" + n.color + "</th></tr>").join("");
                            console.log("data", data);
                             document.getElementById("studentsTable").innerHTML = studentTableString;
              //  document.getElementById("count").innerHTML = count;
                        })
               
            }
            ;



function showCourses(){
   // alert("these are ur courses")
    fetch("http://localhost:8080/courses")
    .then((response) => response.json())
    .then((courses) =>{
         const dataTable = document.getElementById("coursetable")

         courses.forEach(course => {
            var row = `<tr>
            <td>${course.courseId}</td>
            <td>${course.curseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`

            dataTable.innerHTML+=row;
         });  
    });  
}


// function showCourses(){

//     fetch("http://localhost:8080/courses")
//     .then((response) => response.json())
//     .then((courses) => {
//          const dataTable = document.querySelector("#courseTable1 tbody"); // safer

//          courses.forEach(course => {
//             const row = `<tr>
//               <td>${course.courseId}</td>
//               <td>${course.curseName}</td>
//               <td>${course.trainer}</td>
//               <td>${course.durationInWeeks}</td>
//             </tr>`;
//             dataTable.innerHTML += row;
//          });  
//     });  
// }



function showEnrolledStudents(){
   // alert("these are ur courses")
    fetch("http://localhost:8080/courses/enrolled")
    .then((response) => response.json())
    .then((students) =>{
         const dataTable = document.getElementById("enrolledtable")

         students.forEach(student => {
            var row = `<tr>
            <td>${student.name}</td>
            <td>${student.emailId}</td>
            <td>${student.courseName}</td>
            </tr>`

            dataTable.innerHTML+=row;
         });  
    });  
}

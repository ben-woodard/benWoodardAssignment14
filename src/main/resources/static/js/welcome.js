createUser();

function createUser() {
    if (sessionStorage.getItem("userName") === null) {
        const name = prompt("Please Enter Your Name");
        const user = {
            'name': name
        }
        sessionStorage.setItem("userName", name);
       fetch('/user/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        }).then(response => {
            console.log(response);
            location.reload();
        })
    }
}




// usernameTextBox.addEventListener('blur', () => {
//     const user = {
//         'username': usernameTextBox.value
//     }
//     checkIfUserExists(user)
//
// })
//
// async function checkIfUserExists(user) {
//     let responseEntity =  await fetch('/users/exists', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(user)
//     })
//     let userExists = await responseEntity.json()
//     if (userExists === true) {
//         //this user already exists
//         console.log("username already exists")
//         usernameTextBox.focus()
//         showErrorAnimation().then((message) => {
//             console.log("were now in the callback function");
//             console.log(message);
//             document.body.style.backgroundColor = 'rgb(255,255,255)';
//         })
//     }
// }
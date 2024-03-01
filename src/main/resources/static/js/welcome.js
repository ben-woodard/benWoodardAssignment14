greetUser();

function greetUser() {
    if (sessionStorage.getItem("userName") === null) {
        const name = prompt("Please Enter Your Name");
        sessionStorage.setItem("userName", name);
        const storageName = sessionStorage.getItem("userName")
        createUser(storageName);
    }
}

function createUser(storageName) {
    const user = {
        'name': storageName
    }
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





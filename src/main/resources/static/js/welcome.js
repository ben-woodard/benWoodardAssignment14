greetUser();

function greetUser() {
    if (sessionStorage.getItem("userName") === null) {
        let name = prompt("Please Enter Your Name");
        if (name === '' || name === 'null' || name === null || name === undefined) {
            const newName = promptForNewUserName();
            saveNameToSessionAndCreateUser(newName);
        } else {
            saveNameToSessionAndCreateUser(name);
        }
    }
}

function promptForNewUserName() {
    const name = prompt("This username is unavailable, please enter another");
    return name;
}

function saveNameToSessionAndCreateUser(name) {
    sessionStorage.setItem("userName", name);
    const storageName = sessionStorage.getItem("userName")
    createUser(storageName);
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

checkForSessionName();
setInterval(checkForSessionName, 1000);

function checkForSessionName() {
    if (sessionStorage.getItem("userName") === "null" || sessionStorage.getItem("userName") === null ||
        sessionStorage.getItem("userName").length === 0 || sessionStorage.getItem("userName").length === undefined) {
        sessionStorage.clear();
        return window.location.replace("http://localhost:8080/welcome")
    }
}

const createChannelButton = document.getElementById('create-channel');
createChannelButton.addEventListener('click', createNewChannel)

function createNewChannel() {
    let channelName = prompt("Please Input A Channel Name");
    while (channelName === null || channelName === '') {
        channelName = prompt("Please Type A Channel Name With At least 1 character");
    }
    const channel = {
        "channelName": channelName
    }
    fetch('/channel/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(channel)
    })
        .then(response => response.json())
        .then(channel => {
            console.log(channel);
            if (channel.channelId != null) {
                location.reload()
            } else {
                alert("There was an error creating your channel")
                location.reload()
            }
        })
        .catch(error => console.log("there was an error creating a channel", error));
}

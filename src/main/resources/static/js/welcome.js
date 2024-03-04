if (sessionStorage.getItem("userName") === null) {
    let name = prompt("please type your name");
    if (name == '' || name === null) {
        let newName = prompt("please type a name with at least one character")
        sessionStorage.setItem("userName", newName);
        createUser();
    } else {
        sessionStorage.setItem("userName", name);
        createUser();
    }
}
async function createUser() {
    let name = sessionStorage.getItem("userName")
    const user = {
        'name': name
    }
    try {
        let responseEntity = await fetch('/users/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
        let returnedUser = await responseEntity.json();
        await sessionStorage.setItem("user", JSON.stringify(returnedUser));
        await location.reload();
    } catch (error) {
        console.log(error);
    }
}

const createChannelButton = document.getElementById('create-channel');
createChannelButton.addEventListener('click', createNewChannel)

function createNewChannel() {
    let channelName = prompt("Please Input A Channel Name");
    if (channelName === null || channelName === '') {
        channelName = prompt("Please Type A Channel Name With At least 1 character");
    }
    const channel = {
        "channelName": channelName
    }
    fetch('/channels/create', {
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

// checkForSessionName();
// setInterval(checkForSessionName, 1000);
//
// function checkForSessionName() {
//     if (sessionStorage.getItem("userName") === "null" || sessionStorage.getItem("userName") === null ||
//         sessionStorage.getItem("userName").length === 0 || sessionStorage.getItem("userName").length === undefined) {
//         sessionStorage.clear();
//         return window.location.replace("http://localhost:8080/welcome")
//     }
// }
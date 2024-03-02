const messageBody = document.getElementById("messageBody");
let messageText = document.getElementById('message-text');
const channelName = document.getElementById("channel-name").innerText;
const name = sessionStorage.getItem("userName");


setInterval(checkForSessionName, 500);

function checkForSessionName() {
    if(sessionStorage.getItem("userName") === "null" || sessionStorage.getItem("userName") === null) {
        return window.location.replace("http://localhost:8080/welcome")
    }
}
messageBody.addEventListener('submit', () => {

        const message = {
            "messageText": messageText.value,
            "channel": {
                "channelName": channelName
            },
            "user": {
                "name": name
            }
        }
        console.log(message)
        fetch('/message/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        }).then(response => {
            console.log(response)
        })

})

fetchNewContent();
setInterval(fetchNewContent, 500);
const textBox = document.getElementById('new-text');

function fetchNewContent() {
    return fetch(`/message/${channelName}`)
        .then(response => response.json())
        .then(message => {
            console.log(message)
            textBox.innerHTML = '';
            message.forEach(message => {
                const newMessage = document.createElement('div');
                newMessage.innerHTML = `<b> ${message.user.name}:</b> ${message.messageText}`
                textBox.appendChild(newMessage);
            })
        })
        .catch(error => console.log("There was an error:", error))
}

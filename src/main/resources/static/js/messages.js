messageBody = document.getElementById("messageBody");
const channelName = document.getElementById("channel-name").innerText;
const user = sessionStorage.getItem("userName");

messageBody.addEventListener('keydown', () => {

    if (event.key === 'Enter') {
        const message = {
            "messageText": messageBody.value,
            "channel": channelName,
            "user": user
        }
        console.log(message)
        fetch('/message/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        }).then(response => {
            console.log(response);
            location.reload();
        })
    }
})
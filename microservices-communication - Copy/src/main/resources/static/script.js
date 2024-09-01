//    function sendMessage(buttonNumber) {
//        const messageInput = document.getElementById('messageInput');
//        const displayField = document.getElementById('displayField');
//        const message = messageInput.value;
//
//        if (message.trim() === '') {
//            alert('Please enter a message before sending.');
//            return;
//        }
//
//        const newMessage = document.createElement('div');
//        newMessage.classList.add('mb-2', 'p-2', 'bg-blue-100', 'rounded');
//        newMessage.textContent = `Message from Button ${buttonNumber}: ${message}`;
//
//        displayField.appendChild(newMessage);
//        messageInput.value = '';
//    }

document.addEventListener('DOMContentLoaded', (event) => {
    connect(event);
});


const messageInput = document.getElementById('messageInput');
const displayField = document.getElementById('displayField');
var stompClient = null;
//var socket = new SockJS('/server');
//stompClient = Stomp.over(socket);
//stompClient.connect({}, onConnected, onError);

function connect(event) {
    var socket = new SockJS('http://localhost:8003/server');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected, onError);
    event.preventDefault();
}


function onConnected() {
    stompClient.subscribe('/topic/group', onMessageReceived);

}

function onError(error) {
    console.log("error occur    ->"+error.message)
    // alert("connection lost retrying")
    setTimeout(() => {
        connect(event);
    }, 3000);
}


function sendMessage(buttomText) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var message = {
    
            message: messageInput.value,
            method: buttomText
        };
        console.log(message.body)
        stompClient.send("/app/message", {}, JSON.stringify(message));
        messageInput.value = '';
    }
    event.preventDefault();
}

function onMessageReceived(payload){
    console.log("payload ->"+payload)
    var messageBody = JSON.parse(payload.body);

       const newMessage = document.createElement('div');
       newMessage.classList.add('mb-2', 'p-2', 'bg-blue-100', 'rounded');
       newMessage.textContent = `Message ${messageBody.message}: ${messageBody.method}`;

       displayField.appendChild(newMessage);
    //    messageInput.value = '';

}




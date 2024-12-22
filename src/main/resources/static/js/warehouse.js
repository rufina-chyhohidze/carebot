window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

const socket = new SockJS('/ws');  // Connect to WebSocket
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected to WebSocket:', frame);
    stompClient.subscribe('/topic/warehouse-updates', function (message) {
        console.log('Message received:', message.body);
        location.reload();  // Reload the page on receiving message
    });
});


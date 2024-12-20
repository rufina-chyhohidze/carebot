const socket = new SockJS('/ws');  // Connect to WebSocket
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected to WebSocket:', frame);
    stompClient.subscribe('/topic/warehouse-updates', function (message) {
        console.log('Message received:', message.body);
        location.reload();  // Reload the page on receiving message
    });
});
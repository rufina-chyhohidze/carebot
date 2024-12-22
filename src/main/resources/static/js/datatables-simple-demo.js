window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

// let process = document.getElementById('process');
// let continueMovingCar = true;


const socket = new SockJS('/ws');  // Connect to WebSocket
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected to WebSocket:', frame);
    stompClient.subscribe('/topic/start-delivery-progress', function (message) {
        console.log('Message received:', message.body);
        location.reload();
    });
});



// stompClient.connect({}, function (frame) {
//     console.log('Connected to WebSocket:', frame);
//     stompClient.subscribe('/topic/car-stuck', function (message) {
//         console.log('Message received:', message.body);
//         process.style.backgroundColor = "red";
//         process.innerHTML = "CAR STUCK";
//         continueMovingCar = false;
//     });
// });
//
// stompClient.connect({}, function (frame) {
//     console.log('Connected to WebSocket:', frame);
//     stompClient.subscribe('/topic/car-continue', function (message) {
//         console.log('Message received:', message.body);
//         process.style.backgroundColor = "green";
//         process.innerHTML = "IN PROGRESS";
//         continueMovingCar = true;
//     });
// });

// carMovement();


// function carMovement() {
//     try {
//         let marginLeft = -73;
//         let carMoving = document.getElementById("car-moving");
//
//         const intervalId = setInterval(() => {
//             if (continueMovingCar) {
//                 marginLeft += 0.1;
//                 carMoving.style.marginLeft = marginLeft + '%';
//             }
//
//             if (marginLeft >= -5) {
//                 clearInterval(intervalId); // Stop the interval
//                 console.log("Finished incrementing!");
//             }
//         }, 10);
//
//     } catch (Error) {
//         console.error('Car Movement Error: ', Error.toString());
//     }
// }

// We use a websocket to automatically reload the item-request page and the warehouse page when a new item request is entered
const socket = new SockJS('/ws');  // Connect to WebSocket
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected to WebSocket:', frame);
    stompClient.subscribe('/topic/start-delivery-progress', function (message) {
        console.log('Message received:', message.body);
        location.reload();
    });
});


/** The following code is still needed for later (needs fixing)

// let progressBar = document.getElementById("progress-bar");
// let fillProgressBar = document.getElementById("fill-progress-bar");
// fillProgressBar.style.width = "0%";


// let detailsProgressBar = [
//     document.getElementById("details1"),
//     document.getElementById("details2"),
//     document.getElementById("details3"),
//     document.getElementById("details4"),
//     document.getElementById("details5"),
//     document.getElementById("details")
// ];
  
// let greenPercentage = 0;
  
// detailsProgressBar.forEach((progressBar) => {
// if (progressBar) { // Ensure the element exists
//     progressBar.style.background = `linear-gradient(to right, green 0%, green ${greenPercentage}%, white ${greenPercentage}%, white 100%)`;
//     }
// });


// document.getElementById("details").style.background =  `linear-gradient(to right, green 0%, green ${greenPercentage}%, white ${greenPercentage}%, white 100%)`;


// function startProgressBarForDelivery(itemRequestNumber) {
//     let fillProgressBar = document.getElementById(`details${itemRequestNumber}`);

//     const intervalId = setInterval(() => {
//         greenPercentage += 0.1;
//         fillProgressBar.style.background = `linear-gradient(to right, green 0%, green ${greenPercentage}%, white ${greenPercentage}%, white 100%)`;

//         if (greenPercentage >= 100) {
//             clearInterval(intervalId); // Stop the interval
//             console.log("Finished incrementing!");
//         }
//     }, 10);

//     greenPercentage = 0;
    
// }**/
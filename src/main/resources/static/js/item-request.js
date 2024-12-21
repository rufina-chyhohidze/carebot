//  script to select only one item and one path
document.querySelectorAll('.btn-check').forEach((input) => {
    input.addEventListener('change', () => {
        if (input.name === 'item') {
            document.querySelectorAll('input[name="item"] + label.card')
                .forEach((card) => card.classList.remove('selected'));
        }
        if (input.name === 'path') {
            document.querySelectorAll('input[name="path"] + label.card')
                .forEach((card) => card.classList.remove('selected'));
        }

        const associatedLabel = document.querySelector(`label[for="${input.id}"]`);
        associatedLabel.classList.add('selected');
    });
});

// script to show the details of uncompleted requests
document.querySelectorAll('.request-item').forEach(item => {
    item.addEventListener('click', function() {
        const details = this.querySelector('.details');
        details.style.display = (details.style.display === 'none' || details.style.display === '') ? 'block' : 'none';
    });
});

// script to show and hide uncompleted requests
document.addEventListener('DOMContentLoaded', function() {
    const showRequestsBtn = document.getElementById('showRequestsBtn');
    const requestList = document.getElementById('request-list');
    const requestItems = document.querySelectorAll('.request-item');

    requestList.style.display = 'none';

    showRequestsBtn.addEventListener('click', function() {
        if (requestList.style.display === 'none') {
            requestList.style.display = 'block';
            showRequestsBtn.innerText = 'Hide Last Requests';

            let count = 0;
            requestItems.forEach(item => {
                if (count < 5) {
                    item.style.display = 'block';
                    count++;
                } else {
                    item.style.display = 'none';
                }
            });
        } else {
            requestList.style.display = 'none';
            showRequestsBtn.innerText = 'Show Last Requests';
        }
    });
});




// let progressBar = document.getElementById("progress-bar");
// let fillProgressBar = document.getElementById("fill-progress-bar");
// fillProgressBar.style.width = "0%";
    



const socket = new SockJS('/ws');  // Connect to WebSocket
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected to WebSocket:', frame);
    stompClient.subscribe('/topic/start-delivery-progress', function (message) {
        console.log('Message received:', message.body);
        location.reload();
        // startProgressBarForDelivery(message.body);
    });
});



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
    
// }
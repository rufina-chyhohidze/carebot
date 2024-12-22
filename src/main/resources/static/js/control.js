function sendCommand(command) {
    const url = `http://192.168.129.0:8081/data/mode/${command}`;
    fetch(url, {
        method: "GET",
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error("Something went wrong");
            }
        })
        .then(data => {
            console.log("Response received:", data);
        })
        .catch(error => {
            console.error("Error:", error);
        });
}

function setupButton(buttonId, command) {
    const button = document.getElementById(buttonId);

    // Send command when button is pressed
    button.addEventListener("mousedown", function () {
        sendCommand(command);
    });

    // Send "stop" when button is released
    button.addEventListener("mouseup", function () {
        sendCommand("stop");
    });

    // Touchscreen support
    button.addEventListener("touchstart", function () {
        sendCommand(command);
    });

    button.addEventListener("touchend", function () {
        sendCommand("stop");
    });
}

// Setup buttons
setupButton("forwardsButton", "forwards");
setupButton("backwardsButton", "backwards");
setupButton("leftButton", "left");
setupButton("rightButton", "right");
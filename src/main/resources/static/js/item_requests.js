
    document.addEventListener("DOMContentLoaded", () => {
    fetch('/item-request/stats')
        .then(response => response.json())
        .then(data => {
            const labels = Object.keys(data); // Item names
            const values = Object.values(data); // Request counts

            // Create the chart
            const ctx = document.getElementById('itemChart').getContext('2d');
            new Chart(ctx, {
                type: 'bar', // Use 'pie', 'line', etc., for other types of charts
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Number of Requests',
                        data: values,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    plugins: {
                        legend: {
                            display: true,
                            position: 'top'
                        }
                    }
                }
            });
        })
        .catch(error => console.error('Error fetching chart data:', error));
});
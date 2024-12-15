document.addEventListener("DOMContentLoaded", () => {
    const graphConfigs = [
        {
            id: 'graph1',
            url: '/statistics/graph1',
            type: 'bar',
            label: 'Number of Requests',
            backgroundColor: 'rgba(255, 204, 0, 0.5)',
            borderColor: '#ffcc00'
        },
        {
            id: 'graph2',
            url: '/statistics/graph2',
            type: 'bar', // Change type as needed (e.g., 'bar', 'scatter')
            label: 'Time Taken Per Delivery (minutes)',
            backgroundColor: 'rgba(255, 204, 0, 0.5)',
            borderColor: '#ffcc00'
        },
        {
            id: 'graph3',
            url: '/statistics/graph3',
            type: 'pie',
            label: 'Number of Obstacles',
            backgroundColor: 'rgba(255, 204, 0, 0.5)',
            borderColor: '#ffcc00',
            showLabelsOnPieces: true
        },
        {
            id: 'graph4',
            url: '/statistics/graph4',
            type: 'doughnut',
            label: 'Most Requested Item',
            backgroundColor: 'rgba(255, 204, 0, 0.5)',
            borderColor: '#ffcc00',
            showLabelsOnPieces: true
        },
        {
            id: 'graph5',
            url: '/statistics/graph5',
            type: 'bar',
            label: 'Number of Requests Per Month',
            backgroundColor: 'rgba(255, 204, 0, 0.5)',
            borderColor: '#ffcc00'
        }
    ];

    function fetchAndRenderChart({ id, url, type, label, backgroundColor, borderColor, showLabelsOnPieces }) {
        fetch(url)
            .then(response => response.json())
            .then(data => {

                const labels = Object.keys(data);
                const values = Object.values(data);


                const ctx = document.getElementById(id).getContext('2d');
                const config = {
                    type: type,
                    data: {
                        labels: labels,
                        datasets: [{
                            label: label,
                            data: values,
                            backgroundColor: Array.isArray(backgroundColor) ? backgroundColor : labels.map(() => backgroundColor),
                            borderColor: Array.isArray(borderColor) ? borderColor : labels.map(() => borderColor),
                            borderWidth: 1
                        }]
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                display: !showLabelsOnPieces, // hide legend if labels are shown on the chart
                                position: 'top',
                                labels: {
                                    color: '#ffffff'
                                }
                            }
                        },
                        scales: {
                            x: {
                                ticks: { color: '#ffffff' },
                                grid: { color: '#444444' }
                            },
                            y: {
                                beginAtZero: true,
                                ticks: { color: '#ffffff' },
                                grid: { color: '#444444' }
                            }
                        }
                    }
                };

                if (showLabelsOnPieces) {
                    config.options.plugins.datalabels = {
                        color: '#ffffff',
                        font: { size: 14 },
                        formatter: (value, context) => context.chart.data.labels[context.dataIndex]
                    };
                    config.plugins = [ChartDataLabels];
                }

                new Chart(ctx, config);
            })
            .catch(error => console.error(`Error fetching data for ${id}:`, error));
    }

    graphConfigs.forEach(fetchAndRenderChart);



    // Graph 6
    fetch('/statistics/graph6')
        .then(response => response.json())
        .then(data => {
            const labels = [...new Set(Object.values(data).flatMap(itemData => Object.keys(itemData)))];
            const datasets = Object.entries(data).map(([itemName, monthlyData], index) => ({
                label: itemName,
                data: labels.map(month => monthlyData[month] || 0),
                borderColor: ['#4bc0c0', '#ff6384', '#9966ff', '#ff9f40', '#36a2eb'][index % 5],
                backgroundColor: ['rgba(75, 192, 192, 0.2)', 'rgba(255, 99, 132, 0.2)', 'rgba(153, 102, 255, 0.2)', 'rgba(255, 159, 64, 0.2)', 'rgba(54, 162, 235, 0.2)'][index % 5],
                borderWidth: 1
            }));

            const ctx = document.getElementById('graph6').getContext('2d');
            new Chart(ctx, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: datasets
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            display: true,
                            position: 'top',
                            labels: {
                                color: '#ffffff'
                            }
                        }
                    },
                    scales: {
                        x: {
                            ticks: { color: '#ffffff' },
                            grid: { color: '#444444' }
                        },
                        y: {
                            beginAtZero: true,
                            ticks: { color: '#ffffff' },
                            grid: { color: '#444444' }
                        }
                    }
                }
            });
        })
        .catch(error => console.error('Error fetching data for graph6:', error));

    setInterval(() => {
        graphConfigs.forEach(fetchAndRenderChart); // refresh all descriptive charts
        fetch('/statistics/graph6') // refresh graph6
            .then(response => response.json())
            .then(data => {
                const labels = [...new Set(Object.values(data).flatMap(itemData => Object.keys(itemData)))];
                const datasets = Object.entries(data).map(([itemName, monthlyData], index) => ({
                    label: itemName,
                    data: labels.map(month => monthlyData[month] || 0),
                    borderColor: ['#4bc0c0', '#ff6384', '#9966ff', '#ff9f40', '#36a2eb'][index % 5],
                    backgroundColor: ['rgba(75, 192, 192, 0.2)', 'rgba(255, 99, 132, 0.2)', 'rgba(153, 102, 255, 0.2)', 'rgba(255, 159, 64, 0.2)', 'rgba(54, 162, 235, 0.2)'][index % 5],
                    borderWidth: 1
                }));

                const ctx = document.getElementById('graph6').getContext('2d');
                new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: labels,
                        datasets: datasets
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                display: true,
                                position: 'top',
                                labels: {
                                    color: '#ffffff'
                                }
                            }
                        },
                        scales: {
                            x: {
                                ticks: { color: '#ffffff' },
                                grid: { color: '#444444' }
                            },
                            y: {
                                beginAtZero: true,
                                ticks: { color: '#ffffff' },
                                grid: { color: '#444444' }
                            }
                        }
                    }
                });
            })
            .catch(error => console.error('Error refreshing data for graph6:', error));
    }, 3000);  // refresh every 3 seconds
});






// GRAPH 7


//     async function updateGraphs() {
//         try {
//             const response = await fetch('/statistics'); // Replace with your actual data endpoint
//             const data = await response.json();
//
//             // Update graphs dynamically with new data
//             graph1.data = data.graph1;
//             graph1.update();
//             graph2.data = data.graph2;
//             graph2.update();
//             graph3.data = data.graph3;
//             graph3.update();
//             graph4.data = data.graph4;
//             graph4.update();
//             graph5.data = data.graph5;
//             graph5.update();
//             graph6.data = data.graph6;
//             graph6.update();
//             graph7.data = data.graph7;
//             graph7.update();
//         } catch (error) {
//             console.error('Error fetching data:', error);
//         }
//     }
//
//     // Call the update function periodically
//     setInterval(updateGraphs, 3000); // Update every 3 seconds
// });

/*!
 
// Scripts
// */

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});
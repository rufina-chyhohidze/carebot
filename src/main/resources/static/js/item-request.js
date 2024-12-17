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

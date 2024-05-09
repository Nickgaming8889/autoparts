$(document).ready(function() {
    // Fetch data from server
    $.ajax({
        url: 'http://localhost:8080/autoparts', // Endpoint to fetch products from server
        type: 'GET',
        success: function(data) {
            // Render products in table
            renderProducts(data);
        }
    });

    // Function to render products in table
    function renderProducts(products) {
        var tableBody = $('#productTableBody');
        tableBody.empty(); // Clear previous data
        
        // Iterate over products and create table rows
        products.forEach(function(product) {
            var row = '<tr>' +
                        '<td>' + product.id + '</td>' +
                        '<td>' + product.name + '</td>' +
                        '<td>' + product.price + '</td>' +
                      '</tr>';
            tableBody.append(row);
        });
    }
});

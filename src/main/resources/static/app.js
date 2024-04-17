document.addEventListener("DOMContentLoaded", function () {
    fetch('/products')
        .then(response => response.json())
        .then(products => {
            const productList = document.getElementById('product-list');
            products.forEach(product => {
                const productElement = document.createElement('div');
                productElement.innerHTML = `<h3>${product.name}</h3><p>${product.description}</p><p>Price: ${product.price}</p>`;
                productList.appendChild(productElement);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
});
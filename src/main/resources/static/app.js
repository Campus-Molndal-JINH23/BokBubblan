document.addEventListener("DOMContentLoaded", function () {
    fetch('/products')
        .then(response => response.json())
        .then(products => {
            const productList = document.getElementById('product-list');
            productList.innerHTML = ''; // Clear existing content
            products.forEach(product => {
                const productElement = document.createElement('div');
                productElement.classList.add('product');

                const productDetails = document.createElement('div');
                productDetails.classList.add('product-details');

                const productName = document.createElement('h3');
                productName.textContent = product.name;

                const productDescription = document.createElement('p');
                productDescription.textContent = product.description;

                const productPrice = document.createElement('p');
                productPrice.textContent = `Price: ${product.price}`;

                const productCategory = document.createElement('p');
                productCategory.textContent = `Category: ${product.category}`;

                productDetails.appendChild(productName);
                productDetails.appendChild(productDescription);
                productDetails.appendChild(productPrice);
                productDetails.appendChild(productCategory);

                productElement.appendChild(productDetails);
                productList.appendChild(productElement);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
});
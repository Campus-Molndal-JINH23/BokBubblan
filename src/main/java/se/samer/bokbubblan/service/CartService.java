package se.samer.bokbubblan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.samer.bokbubblan.model.Cart;
import se.samer.bokbubblan.model.Product;
import se.samer.bokbubblan.repository.CartRepository;

@Service
@SessionScope
public class CartService {
    private final CartRepository cartRepository;
    private Cart cart = new Cart();

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    //hämta
    public Cart getCart() {
        return cart;
    }

    //lägga till
    public void addToCart(Product product) {
        //skapa ny och kopiera från attribut
        Product productCopy = new Product();
        productCopy.setId(product.getId());
        productCopy.setTitle(product.getTitle());
        //kopiera priser
        productCopy.setPrice(product.getPrice());
        //lägg till i kundvagn
        cart.getProducts().add(productCopy);
    }



    //ta bort
    public void removeFromCart(Product product) {
        Cart cart = getCart();
        System.out.println("Kundvagn innan borttagning: " + cart.getProducts()); //enbart för felsökning i terminal
        cart.getProducts().remove(product);
        System.out.println("Produkt som tas bort: " + product); //enbart för felsökning i terminal
        System.out.println("Kundvagn efter borttagning: " + cart.getProducts()); //enbart för felsökning i terminal
        cartRepository.save(cart);
    }


    //uppdatera
    public void updateCart(Product product, int quantity) {
        Cart cart = getCart();
        if (cart.getProducts().contains(product)) {
        }
        CartRepository.save(cart);
    }

    //tömma
    public void clearCart() {
        Cart cart = getCart();
        cart.getProducts().clear();
        CartRepository.save(cart);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        //loopa igenom för totalpriser
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice();
        }

        //lägg till 75kr på totalopriset
        totalPrice += 75.0; // Leveranskostnad: 75 kr

        return totalPrice;
    }

}

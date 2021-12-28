package com.example.eshop.service.Impl;

import com.example.eshop.model.Product;
import com.example.eshop.model.ShoppingCart;
import com.example.eshop.model.User;
import com.example.eshop.model.enumerations.ShoppingCartStatus;
import com.example.eshop.model.exceptions.ProductAlreadyInShoppingCartException;
import com.example.eshop.model.exceptions.ProductNotFoundException;
import com.example.eshop.model.exceptions.ShoppingCartNotFoundException;
import com.example.eshop.model.exceptions.UserNotFoundException;
import com.example.eshop.repository.impl.InMemoryShoppingCartRepository;
import com.example.eshop.repository.impl.InMemoryUserRepository;
import com.example.eshop.repository.jpa.ShoppingCartRepository;
import com.example.eshop.repository.jpa.UserRepository;
import com.example.eshop.service.ProductService;
import com.example.eshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl (ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart (Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart (String username) {

        User user = this.userRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));

        return this.shoppingCartRepository.findByUserAndStatus(user, ShoppingCartStatus.CREATED).orElseGet(()->{
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        if(shoppingCart.getProducts().stream().filter(i -> i.getId().equals(productId)).collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId,username);
        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}


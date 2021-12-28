package com.example.eshop.repository.jpa;

import com.example.eshop.model.ShoppingCart;
import com.example.eshop.model.User;
import com.example.eshop.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}

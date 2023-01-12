package com.example.topgamesdata.repositories;

import com.example.topgamesdata.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}


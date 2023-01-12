package com.example.topgamesdata.repositories;

import com.example.topgamesdata.model.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins, Long> {
    Admins findByUsername(String username);
}


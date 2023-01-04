package com.example.topgamesdata.repositories;

import com.example.topgamesdata.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}


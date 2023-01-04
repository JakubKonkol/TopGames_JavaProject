package com.example.topgamesdata.repositories;

import com.example.topgamesdata.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

package com.example.topgamesdata.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long gameId;
    private String date;
    private String status;

    public Order() {
    }

    public Order(Long userId, Long gameId, String date, String status) {
        this.userId = userId;
        this.gameId = gameId;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}

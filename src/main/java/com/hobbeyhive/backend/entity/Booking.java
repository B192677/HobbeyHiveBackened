package com.hobbeyhive.backend.entity;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long workshopId;
    private String title;
    private Double price;

    private String userName;
    private String userEmail;

    // Constructors
    public Booking() {}

    public Booking(Long workshopId, String title, Double price, String userName, String userEmail) {
        this.workshopId = workshopId;
        this.title = title;
        this.price = price;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Getters and setters
    public Long getId() { return id; }
    public Long getWorkshopId() { return workshopId; }
    public void setWorkshopId(Long workshopId) { this.workshopId = workshopId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}

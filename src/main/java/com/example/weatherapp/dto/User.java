package com.example.weatherapp.dto;

import com.example.weatherapp.util.Locations;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Column(name = "id")
    @Id
    @SequenceGenerator( name = "userIdGenerator",
                        sequenceName = "user_id_seq",
                        schema = "public",
                        initialValue = 3,
                        allocationSize = 10

    )
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "userIdGenerator")
    private Long id;

    @Column(name = "user_full_name",nullable = false)
    private String fullName;

    @Column(name = "user_location",nullable = false)
    @Enumerated(EnumType.STRING)
    private Locations location;

    public User() {
    }

    public User(String fullName, Locations location) {
        this.fullName = fullName;
        this.location = location;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

}

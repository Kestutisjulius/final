package com.java.bend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String companyName;
    private String registrationNumber;
    private String vatNumber;
    private String telephoneNumber;
    private String address;
    private String email;
    private String bankData;
    private String username; //prisijungimo vardas
    private String password;
    private Boolean admin;
    private Boolean enabled;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name = "authority_ID")
    private Authority authority;



}
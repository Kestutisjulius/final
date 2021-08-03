package com.java.bend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "authority")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String authority;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

}
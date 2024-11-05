//package com.example.task.entities;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Entity
//@Table(name = "roles")
//@Data
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    @ManyToMany
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<UserEntity> users;
//
//
//}

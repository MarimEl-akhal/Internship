package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userName" , nullable = false )
    private String username;

    @Column(name = "password" , nullable = false )
    private String password;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Task> task;




}

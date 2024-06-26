package com.lcwd.electronic.store.entites;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Column (name="user_name")
    private String name;
    @Column (name="user_email",unique=true)
    private String email;
    @Column(name="user_password", length=10)
    private String password;

    private String gender;

    @Column(length=1000)
    private String about;
    @Column(name="user_image_name ")
    private String imageName;
     @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Order> orders= new ArrayList<>();
}

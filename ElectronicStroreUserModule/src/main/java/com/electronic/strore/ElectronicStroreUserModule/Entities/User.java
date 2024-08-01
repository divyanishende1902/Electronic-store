package com.electronic.strore.ElectronicStroreUserModule.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Users")
public class User {
    @Id
    private String userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "email",unique=true)
    private String email;
    @Column(name = "password",length=10)
    private String password;
    private String gender;
    @Column(length =1000)
    private String about;
    @Column(name="user_image_name")
    private String imageName;


}

package com.electronic.strore.ElectronicStroreUserModule.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {

        private String userId;
        private String name;
        private String email;
        private String password;
        private String gender;
        private String about;
        private String imageName;

    }

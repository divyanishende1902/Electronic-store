package com.electronic.strore.ElectronicStroreUserModule.Services;

import com.electronic.strore.ElectronicStroreUserModule.DTOs.UserDto;

import java.util.List;

public interface UserService {
    //create

    UserDto createUser(UserDto userDto);

    //update
    UserDto updateUser (UserDto userDto, String userId);

    //delete
    void deleteUser(String userId);

    //get all users
    List<UserDto> getAllUser();

    //get one user by id
    UserDto getUserById(String userId);

    //get one user by email
    UserDto getUserByEmail(String email);

    //serach user
    List<UserDto> searchUser(String keyword);
    //other user specific User
}

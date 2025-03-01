package com.electronic.strore.ElectronicStroreUserModule.Services.serviceImpl;

import com.electronic.strore.ElectronicStroreUserModule.DTOs.UserDto;
import com.electronic.strore.ElectronicStroreUserModule.Entities.User;
import com.electronic.strore.ElectronicStroreUserModule.Repositories.UserRepository;
import com.electronic.strore.ElectronicStroreUserModule.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepository userRepository;

   @Autowired
   private ModelMapper mapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //generate uniqueId in string format
        String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);
        User user = dtoToEntity(userDto);
        User savedUser =userRepository.save(user);
        UserDto newDto = entityToDto(savedUser);
        return newDto;
    }



    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with given Id!!"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());
        user.setImageName(userDto.getImageName());
        User updatedUser = userRepository.save(user);
        UserDto updatedDto = entityToDto(updatedUser);
        return updatedDto;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found With given Id!!"));
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> dtoList = users.stream()
                .map(user -> entityToDto(user))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with given id!!"));
        return entityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("user not found with given email!!"));
        return entityToDto(user);
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
    List<User> users = userRepository.findByNameContaining(keyword);
    List<UserDto> dtoList = users.stream()
           .map(user -> entityToDto(user))
           .collect(Collectors.toList());

   return dtoList;
    }

    private UserDto entityToDto(User savedUser) {
        //UserDto userDto = UserDto.builder()
         //     .userId(savedUser.getUserId())
         //       .name(savedUser.getName())
          //      .email(savedUser.getEmail())
          //      .password(savedUser.getPassword())
          //      .about(savedUser.getAbout())
          //      .gender(savedUser.getGender())
         //       .imageName(savedUser.getImageName())
         //       .build();
        return mapper.map(savedUser, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
     //   User user = User.builder()
    //            .userId(userDto.getUserId())
     //           .name(userDto.getName())
     //           .email(userDto.getEmail())
     //           .password(userDto.getPassword())
     //           .about(userDto.getAbout())
      //          .gender(userDto.getGender())
      //          .build();

        return mapper.map(userDto, User.class);
    }
}

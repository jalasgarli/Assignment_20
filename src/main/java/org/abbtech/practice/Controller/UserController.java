package org.abbtech.practice.Controller;

import jakarta.validation.Valid;
import org.abbtech.practice.DTO.UserDTO;
import org.abbtech.practice.Entity.User;
import org.abbtech.practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        User userSaved = userService.createUser(user);

        UserDTO newUserDto = new UserDTO();
        newUserDto.setEmail(userSaved.getEmail());
        newUserDto.setUsername(userSaved.getUsername());

        return new ResponseEntity<>(newUserDto, HttpStatus.CREATED);
    }
}

package ru.asteises.otherbdtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asteises.otherbdtest.model.UserDto;
import ru.asteises.otherbdtest.service.UserService;

@RestController
@RequestMapping("/bd")
public class Controller {

    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registration(UserDto userDto) {

        return ResponseEntity.ok(userService.registration(userDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {

        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
}

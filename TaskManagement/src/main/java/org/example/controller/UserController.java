package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDto userDto) {
        return  ResponseEntity.status(HttpStatus.OK).build();
    }


}
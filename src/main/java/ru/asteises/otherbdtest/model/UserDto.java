package ru.asteises.otherbdtest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private UUID id;

    private String surname;

    private String email;

    private String password;
}

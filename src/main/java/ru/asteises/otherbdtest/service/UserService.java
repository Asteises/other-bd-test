package ru.asteises.otherbdtest.service;

import org.springframework.stereotype.Service;
import ru.asteises.otherbdtest.mapper.UserMapper;
import ru.asteises.otherbdtest.model.User;
import ru.asteises.otherbdtest.model.UserDto;
import ru.asteises.otherbdtest.storage.UserJdbcStorage;
import ru.asteises.otherbdtest.storage.UserJpaStorage;

import java.util.Stack;
import java.util.UUID;

@Service
public class UserService {

    private UserJpaStorage userJpaStorage;
    private UserJdbcStorage userJdbcStorage;

    private static Stack<Integer> stack;

    public String registration(UserDto userDto) {
        return null;
    }

    public UserDto getUserById(String userId) {

        UUID id = UUID.fromString(userId);
        User user;

        //private static Stack<Integer> stack; используем статический стек...

        if (stack.isEmpty()) {
            user = userJpaStorage.findById(id).orElseThrow(RuntimeException::new);
            stack.push(1);
        } else {
            user = userJdbcStorage.findUserById(id);
            stack.pop();
        }

        return UserMapper.INSTANCE.toDto(user);
    }
}

package ru.asteises.otherbdtest.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.asteises.otherbdtest.model.User;
import ru.asteises.otherbdtest.model.UserDto;

import java.util.Collections;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class, Collections.class})
public abstract class UserMapper {

    protected static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "password", expression = "java(encoder.encode(userDto.getPassword()))")
    public abstract User toUser(UserDto userDto);

    @InheritInverseConfiguration
    @Mapping(target = "password", ignore = true)
    public abstract UserDto toDto(User user);
}

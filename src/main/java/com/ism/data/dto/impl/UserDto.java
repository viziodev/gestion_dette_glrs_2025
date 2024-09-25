package com.ism.data.dto.impl;

import java.util.List;

import com.ism.data.dto.DtoInterface;
import com.ism.data.entities.User;
import com.ism.data.enums.RoleEnum;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto implements DtoInterface<User, UserDto> {

    private int id;
    private String login;
    private String prenom;
    private String nom;
    private String password;
    private RoleEnum role;
    private boolean etat;

    @Builder
    public UserDto(User user) {
        this.toDto(user);
    }

    @Override
    public UserDto toDto(User data) {
        return UserDto.builder()
                .id(data.getId())
                .login(data.getLogin())
                .etat(data.isEtat())
                .nom(data.getNom())
                .prenom(data.getPrenom())
                .password(data.getPassword())
                .role(data.getRole())
                .build();
       }

    @Override
    public List<UserDto> toListDto(List<User> list) {
        return list.stream()
                .map(this::toDto)
                .toList();
    }

}

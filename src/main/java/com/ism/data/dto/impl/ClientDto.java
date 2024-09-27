package com.ism.data.dto.impl;

import java.util.List;

import com.ism.data.dto.DtoInterface;
import com.ism.data.entities.Client;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto implements DtoInterface<Client, ClientDto> {

    private int id;
    private String surname;
    private String telephone;
    private String adresse;
    private UserDto user;

    @Builder
    public ClientDto() {

    }

    @Builder
    public ClientDto(Client client) {
        toDto(client);
    }

    @Override
    public ClientDto toDto(Client data) {
        // System.out.println(data);
        UserDto userDto = data != null && data.getUser() == null ? null : new UserDto(data.getUser());
        System.out.println(userDto);
        return ClientDto.builder()
                .id(data.getId())
                .adresse(data.getAdresse())
                .telephone(data.getTelephone())
                .user(userDto)
                .build();
    }

    @Override
    public List<ClientDto> toListDto(List<Client> list) {
        return list.stream()
                .map(this::toDto)
                .toList();
    }

}

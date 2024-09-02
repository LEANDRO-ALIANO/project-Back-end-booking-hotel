package com.reservahotel.Dtos;

import com.reservahotel.entities.Destiny;

public record UserDto(String firstName, String lastName, String document, String email, String password) {
}

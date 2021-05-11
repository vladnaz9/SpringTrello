package org.example.trello.api.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFormDto {

    private String username;
    private String password;
    private String email;
}

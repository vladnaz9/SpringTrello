package org.example.trello.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeskDto   {
    private Long id;
    private Date created;
    private String description;
    private String name;
    private Date updated;
    private List<UserDto> listOfUsers;
}

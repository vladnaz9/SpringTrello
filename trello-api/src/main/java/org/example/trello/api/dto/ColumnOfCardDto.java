package org.example.trello.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColumnOfCardDto {
    private Long id;
    private String nameOfColumn;
    private Long deskId;
    private List<CardDto> cardDtoList;
}

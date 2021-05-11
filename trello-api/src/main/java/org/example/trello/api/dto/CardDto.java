package org.example.trello.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {
private Long id;
private Date created;
private String name;
private Long userId;
private Long columnOfCardId;
}

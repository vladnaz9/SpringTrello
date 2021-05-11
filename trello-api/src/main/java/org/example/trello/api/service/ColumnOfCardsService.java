package org.example.trello.api.service;

import org.example.trello.api.dto.ColumnOfCardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColumnOfCardsService {
    Page<ColumnOfCardDto> getAll(Pageable page);

    ColumnOfCardDto getById(Long id);

    ColumnOfCardDto save(ColumnOfCardDto columnOfCard);

    void delete(Long id);

    List<ColumnOfCardDto> getAll();
}

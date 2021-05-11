package org.example.trello.api.service;

import org.example.trello.api.dto.CardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService {
    Page<CardDto> getById(Long id, Pageable page);
    CardDto save(CardDto card);
    void delete(Long id);
}

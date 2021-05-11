package org.example.trello.impl.service;

import org.example.trello.api.dto.ColumnOfCardDto;
import org.example.trello.api.service.ColumnOfCardsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ColumnOfCardsServiceImpl implements ColumnOfCardsService {
    @Override
    public Page<ColumnOfCardDto> getAll(Pageable page) {
        return null;
    }

    @Override
    public ColumnOfCardDto getById(Long id) {
        return null;
    }

    @Override
    public ColumnOfCardDto save(ColumnOfCardDto columnOfCard) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ColumnOfCardDto> getAll() {
        return null;
    }
}

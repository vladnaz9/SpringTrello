package org.example.trello.impl.service;

import org.example.trello.api.dto.CardDto;
import org.example.trello.api.service.CardService;
import org.example.trello.impl.jpa.repository.CardRepository;
import org.example.trello.impl.jpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CardServiceImpl implements CardService {


    private CardRepository cardRepository;

    private UserRepository userRepository;


    private ModelMapper modelMapper;


    @Override
    public Page<CardDto> getById(Long id, Pageable page) {
        return null;
    }

    @Override
    public CardDto save(CardDto card) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

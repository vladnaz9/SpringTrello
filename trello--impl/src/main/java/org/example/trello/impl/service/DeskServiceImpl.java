package org.example.trello.impl.service;

import org.example.trello.api.dto.DeskDto;
import org.example.trello.api.service.DeskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DeskServiceImpl implements DeskService {
    @Override
    public Page<DeskDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public DeskDto getById(Long id) {
        return null;
    }

    @Override
    public DeskDto save(DeskDto desk) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

package org.example.trello.api.service;

import org.example.trello.api.dto.DeskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeskService {
    Page<DeskDto> getAll(Pageable pageable);

    DeskDto getById(Long id);

    DeskDto save(DeskDto desk);

    void delete(Long id);

//TODO работа с участниками
    /*

    UserDTO saveParticipant(Long userId, Long boardId);

    void deleteParticipant(Long workspaceId, Long userId);

    List<UserDTO> getAllParticipants();
     */
}

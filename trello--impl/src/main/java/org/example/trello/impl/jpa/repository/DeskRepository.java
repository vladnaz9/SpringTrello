package org.example.trello.impl.jpa.repository;

import org.example.trello.impl.entity.DeskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface DeskRepository extends JpaRepository<DeskEntity, Long> {
    Optional<DeskEntity> findById(Long deskId);

}

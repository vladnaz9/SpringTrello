package org.example.trello.impl.jpa.repository;

import org.example.trello.impl.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
}

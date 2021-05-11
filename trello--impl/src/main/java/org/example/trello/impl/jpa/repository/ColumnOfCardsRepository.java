package org.example.trello.impl.jpa.repository;

import org.example.trello.impl.entity.ColumnOfCardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnOfCardsRepository extends JpaRepository<ColumnOfCardsEntity,Long> {
}

package org.example.trello.impl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "desk")
public class DeskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String description;
    @CreatedDate
//    @Column(name = "created")
    private Date created;

    @LastModifiedDate
//    @Column(name = "updated")
    private Date updated;


    @ManyToMany
    @JoinTable(name = "user_desk",
            joinColumns = @JoinColumn(name = "desk_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
    private List<UserEntity> users;

    @OneToMany(mappedBy = "desk")
    private List<ColumnOfCardsEntity> cards;
}


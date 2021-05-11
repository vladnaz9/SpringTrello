package org.example.trello.impl.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class UserEntity {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Provider provider;


    public enum Role{
        USER,ADMIN
    }
    public enum Provider {
        LOCAL, GOOGLE
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }


    @ManyToMany(mappedBy = "users")
    private List<DeskEntity> desks;
}

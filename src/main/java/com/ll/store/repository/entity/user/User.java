package com.ll.store.repository.entity.user;

import com.ll.store.service.dto.user.UserResponseDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(){
    }

    public UserResponseDto convertEntityToResponseDto(){
        return new UserResponseDto(id, userName, email, password);
    }

}

package com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;
    @ManyToMany(mappedBy = "chats")
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "chat")
    private List<Message> messages = new ArrayList<>();

//    @OneToMany(mappedBy = "account")
//    private List<Transaction> transactions = new ArrayList<>();
//
//    @ManyToOne
//    @JoinColumn(name="account_id")
//    private Account account;

}

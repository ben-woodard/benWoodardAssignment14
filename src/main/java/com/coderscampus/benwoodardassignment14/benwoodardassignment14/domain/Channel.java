package com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain;

import com.fasterxml.jackson.annotation.*;
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
@Table(name = "channels")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Channel {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long channelId;
    private String channelName;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "channels")
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "channel", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Message> messages = new ArrayList<>();


    //    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
//    @JoinTable(name = "user_account",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "account_id"))
//    private List<Account> accounts = new ArrayList<>();
//    @OneToOne(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
//    private Address address;

//    @OneToMany(mappedBy = "account")
//    private List<Transaction> transactions = new ArrayList<>();
//    @ManyToMany(mappedBy = "accounts")
//    private List<User> users = new ArrayList<>();
}

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
@Table(name = "channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long channelId;
    private String channelName;
    @ManyToMany(mappedBy = "channels")
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "channel")
    private List<Message> messages = new ArrayList<>();


}

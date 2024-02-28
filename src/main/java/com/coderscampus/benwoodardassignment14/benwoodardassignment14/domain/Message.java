package com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name = "messages")
public class Message {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    @Column(length = 300)
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

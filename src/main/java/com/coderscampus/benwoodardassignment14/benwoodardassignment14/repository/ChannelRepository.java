package com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    @Override
    @Query("select c from Channel c")
    List<Channel> findAll();

    Optional<Channel> findByChannelName(String channelName);
}

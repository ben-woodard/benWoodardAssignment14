package com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    @Query("select c.channelName from Channel c where c.channelId IS NOT NULL")
    List<String> findAllChannelNames();

    Optional<Channel> findByChannelName(String channelName);
}

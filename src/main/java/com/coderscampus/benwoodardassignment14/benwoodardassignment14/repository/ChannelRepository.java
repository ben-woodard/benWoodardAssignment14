package com.coderscampus.benwoodardassignment14.benwoodardassignment14.repository;

import com.coderscampus.benwoodardassignment14.benwoodardassignment14.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}

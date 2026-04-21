package com.nagendra.campuseventportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagendra.campuseventportal.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
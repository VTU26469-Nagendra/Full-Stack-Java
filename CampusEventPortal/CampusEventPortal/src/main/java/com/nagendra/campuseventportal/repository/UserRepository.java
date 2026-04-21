package com.nagendra.campuseventportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagendra.campuseventportal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // ✅ THIS IS REQUIRED
    User findByVtuNo(int vtuNo);
}
package com.nagendra.campuseventportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagendra.campuseventportal.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

} 
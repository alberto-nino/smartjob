package com.demo.smartjob.models.repository;

import com.demo.smartjob.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}

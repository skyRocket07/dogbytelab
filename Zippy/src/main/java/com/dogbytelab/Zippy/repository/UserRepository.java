package com.dogbytelab.Zippy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dogbytelab.Zippy.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUsernameOrEmail(String username, String email);

}

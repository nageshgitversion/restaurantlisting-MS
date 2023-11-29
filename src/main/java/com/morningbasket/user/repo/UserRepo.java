package com.morningbasket.user.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morningbasket.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Serializable>{

}

package com.moviemanager.moviemanager.repositories;

import com.moviemanager.moviemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUserName(@Param("username") String username);


}

package com.example.weatherapp.repos;

import com.example.weatherapp.dto.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    @Query("Select u FROM User u WHERE u.id = ?1")
    Optional<User> findById(Long id);
}

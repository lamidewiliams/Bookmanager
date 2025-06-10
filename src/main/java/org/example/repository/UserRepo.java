package org.example.repository;

import org.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users ,Long> {
    Boolean existByUniqueId(String UniqueId);
    Users findByUniqueId(String UniqueId);
}

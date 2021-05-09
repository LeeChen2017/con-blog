package com.example.jpa.demo.exp1;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    
    List<User> findByName(String name);

    List<User> findByEmailAndName(String email , String name);
}

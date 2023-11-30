package com.example.MidTerm.repositories;

import com.example.MidTerm.models.Card;
import com.example.MidTerm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {


    List<Card> findAllByUser(User user);
}

package com.example.MidTerm.repositories;

import com.example.MidTerm.models.Address;
import com.example.MidTerm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddresRepository extends JpaRepository<Address, Integer> {

    List<Address> findAllByUser(User user);

}

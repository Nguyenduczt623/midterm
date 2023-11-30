package com.example.MidTerm.repositories;

import com.example.MidTerm.models.CustomerInfo;
import com.example.MidTerm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer> {
    CustomerInfo findByUser(User user);

    CustomerInfo findByEmail(String email);

}

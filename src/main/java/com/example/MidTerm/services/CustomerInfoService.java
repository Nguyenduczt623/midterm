package com.example.MidTerm.services;

import com.example.MidTerm.models.CustomerInfo;
import com.example.MidTerm.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerInfoService {
    CustomerInfo findByUser(User user);

    CustomerInfo findByEmail(String email);

    List<CustomerInfo> findAll();

    CustomerInfo findCustomerInfoByUserID(Integer id);

    void saveInfo(CustomerInfo info);

    void deletInfoById(Integer id);

    Page<CustomerInfo> pagingCustomerInfo(int offset, int pagesize);

    CustomerInfo getByID(Integer id);
}

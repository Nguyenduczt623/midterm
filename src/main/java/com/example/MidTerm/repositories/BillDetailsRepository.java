package com.example.MidTerm.repositories;

import com.example.MidTerm.models.Bill;
import com.example.MidTerm.models.BillDetail;
import com.example.MidTerm.models.Product;
import com.example.MidTerm.models.keys.BillDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillDetailsRepository extends JpaRepository<BillDetail, BillDetailKey> {
    Optional<BillDetail> findBillDetailsByProductIdAndBillId(Product productId, Bill billId);

    List<BillDetail> findAllByBillId(Bill billId);

    List<BillDetail> findAll();

    void deleteBillDetailByBillIdAndProductId(Bill bill, Product product);
}
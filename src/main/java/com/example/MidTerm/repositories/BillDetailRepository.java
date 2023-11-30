package com.example.MidTerm.repositories;

import com.example.MidTerm.models.BillDetail;
import com.example.MidTerm.models.keys.BillDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailKey> {
}

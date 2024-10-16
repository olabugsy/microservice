package com.olawalealex.payment_Service.repository;

import com.olawalealex.payment_Service.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<TransactionDetails, Long> {

}

package com.olawalealex.payment_Service.entity;

import com.olawalealex.payment_Service.model.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "transaction_details")
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "orderid", nullable = false)
    private long orderid;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_mode", nullable = false)
    private PaymentMode paymentMode;
    @Column(name = "reference_number", nullable = false)
    private String referenceNumber;
    @Column(name = "payment_date", nullable = false)
    private Instant paymentDate;
    @Column(name = "payment_status", length = 255, nullable = false)
    private String PaymentStatus;
    @Column(name = "amount", nullable = false)
    private long amount;
}

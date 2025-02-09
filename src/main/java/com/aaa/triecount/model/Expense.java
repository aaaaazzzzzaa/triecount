package com.aaa.triecount.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    private Long id;
    private String name;
    private Long settlementId; // 정산은 여러 개의 지출을 가질 수 있다.
    private Long paymentMemberId; // 어떤 유저의 정산인지
    private BigDecimal amount;
    private LocalDateTime expenseDatatime;
}

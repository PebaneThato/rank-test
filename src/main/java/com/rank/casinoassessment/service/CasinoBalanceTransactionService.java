package com.rank.casinoassessment.service;

import com.rank.casinoassessment.domain.entity.Balance;
import com.rank.casinoassessment.domain.entity.Transaction;
import com.rank.casinoassessment.domain.repository.BalanceRepository;
import com.rank.casinoassessment.domain.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CasinoBalanceTransactionService {
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Balance getBalanceByPlayerId(Integer playerId) {
        return  balanceRepository.findFirstByPlayerId(playerId);
    }

    public Balance updateBalance(Integer playerId, BigDecimal balance, String transactionType) {
        Balance currentBalance = getBalanceByPlayerId(playerId);
        currentBalance.setBalance(balance);
        currentBalance.setTransactionType(transactionType);
        return balanceRepository.save(currentBalance);
    }

    public List<Transaction> findTop10ByUsername(String username){
        return  transactionRepository.findTop10ByUsername(username);
    }
}

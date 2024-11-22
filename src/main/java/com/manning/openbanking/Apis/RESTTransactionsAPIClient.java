package com.manning.openbanking.Apis;

import io.manning.openbanking.models.OBReadTransaction6;
import com.manning.openbanking.adapters.openbanking.OBTransactionAdapter;
import com.manning.openbanking.entities.Transaction;
import com.manning.openbanking.repositories.TransactionApiClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Repository
public class RESTTransactionsAPIClient implements TransactionApiClient{
    
    private final WebClient client;

    private final OBTransactionAdapter adapter = new OBTransactionAdapter();

    @Autowired
    public RESTTransactionsAPIClient(WebClient client) {
        this.client = client;
    }
    
    @Override
    public List<Transaction> findAllByAccountNumber(Integer accountNumber) {
        OBReadTransaction6 
                     res = client.get()
                    .uri("accounts/" + accountNumber + "/transactions")
                    .retrieve()
                    .bodyToMono(OBReadTransaction6.class)
                    .block()
            ;
        if (res == null || res.getData() == null) {
            return Collections.emptyList();
        }

        return res.getData()
                .getTransaction()
                .stream()
                .map(adapter::adapt)
                .collect(toList());
    }



}
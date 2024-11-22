package com.manning.openbanking.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import com.manning.openbanking.OpenbankingApplication;
import com.manning.openbanking.entities.Transaction;
import com.manning.openbanking.repositories.MerchantDetailsRepository;
import com.manning.openbanking.repositories.TransactionApiClient;



@SpringBootTest(classes = {OpenbankingApplication.class})
@Testcontainers
public class TransactionServiceTest {

    @Mock
    private TransactionApiClient transactionApiClient;

    @Mock
    private MerchantDetailsRepository merchantDetailsRepository;

    @InjectMocks
    private TransactionService transactionService;

    // @Autowired
    // private TransactionRepository transactionRepository;


    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
        .withDatabaseName("open_banking_manning")
        .withUsername("root")
        .withPassword("root");


        @BeforeAll
    public static void setUp() {
        // Asegúrate de que el contenedor está listo y accesible
        System.out.println("MySQL container started at: " + mysqlContainer.getJdbcUrl());
    }

    // @Test
    // public void testGetTransactions(){

    //     Integer accountNumber = 123456789;

    //     List<Transaction> transactions = transactionService.findAllByAccountNumber(accountNumber);

    //     //assertTrue(transactions.size() >= 3 && transactions.size() <= 5);
    //    assertTrue(transactions.size() > 1);
        
    // }


    //   @DisplayName("test TransactionService with mock TransactionApiClient")
    // @Test
    // public void testTransactionCount() throws Exception {
    //     when(transactionApiClient.findAllByAccountNumber(any()))
    //             .thenReturn(List.of(new Transaction()));

    //     assertEquals(1, transactionService.findAllByAccountNumber(1234567).size());
    // }
}

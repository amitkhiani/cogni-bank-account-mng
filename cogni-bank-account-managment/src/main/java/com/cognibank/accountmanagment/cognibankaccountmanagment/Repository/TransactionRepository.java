package com.cognibank.accountmanagment.cognibankaccountmanagment.Repository;

import com.cognibank.accountmanagment.cognibankaccountmanagment.Model.Account;
import com.cognibank.accountmanagment.cognibankaccountmanagment.Model.AccountType;
import com.cognibank.accountmanagment.cognibankaccountmanagment.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = "select * from transaction where customer_id = :customer_id",nativeQuery = true)
    List<Transaction> findTransactionsByCustomerId(@Param("customer_id") String id);

    @Query(value = "select * from transaction where customer_id = :customer_id AND type = :acountType",nativeQuery = true)
    List<Transaction> findTransactionsByCustomerIdAndAccountType(@Param("customer_id") String id,
                                                                 @Param("accountType")AccountType type);

}
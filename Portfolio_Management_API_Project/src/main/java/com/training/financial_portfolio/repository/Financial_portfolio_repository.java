package com.training.financial_portfolio.repository;

import com.training.financial_portfolio.entities.Financial_portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Financial_portfolio_repository extends JpaRepository<Financial_portfolio, Long> {

    List<Financial_portfolio> findByUserName(String UserName);
//    List<Financial_portfolio> findFinancial_portfolioByuser_name(String user_name);
    List<Financial_portfolio> findByBankAccount(String BankAccount);
    List<Financial_portfolio> findByPortfolio(String Portfolio);
}

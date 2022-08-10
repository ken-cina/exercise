package com.training.financial_portfolio.service;

import com.training.financial_portfolio.entities.Financial_portfolio;
import com.training.financial_portfolio.repository.Financial_portfolio_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Financial_portfolio_service {
    @Autowired
    Financial_portfolio_repository financial_portfolio_repository;

    // find item by some properties
    public List<Financial_portfolio> findAll() {

        return financial_portfolio_repository.findAll();
    }

    public Financial_portfolio findById(long id) {

        return financial_portfolio_repository.findById(id).get();
    }

    public List<Financial_portfolio> findByUserName(String UserName) {
        return financial_portfolio_repository.findByUserName(UserName);
    }
    public List<Financial_portfolio> findByBankAccount(String BankAccount) {
        return financial_portfolio_repository.findByBankAccount(BankAccount);
    }
    public List<Financial_portfolio> findByPortfolio(String Portfolio) {
        return financial_portfolio_repository.findByPortfolio(Portfolio);
    }

//    public List<Financial_portfolio> find_by_user_name(String user_name) {
//        return financial_portfolio_repository.find_by_user_name(user_name);
//    }
//    public List<Financial_portfolio> find_by_bank_account(String bank_account) {
//        return financial_portfolio_repository.find_by_bank_account(bank_account);
//    }
//    public List<Financial_portfolio> find_by_portfolio(String portfolio) {
//        return financial_portfolio_repository.find_by_portfolio(portfolio);
//    }

    // save, update, and delete
    public Financial_portfolio save(Financial_portfolio financial_portfolio) {
        return financial_portfolio_repository.save(financial_portfolio);
    }

    public Financial_portfolio update(Financial_portfolio financial_portfolio) {
        financial_portfolio_repository.findById(financial_portfolio.getID()).get();

        return financial_portfolio_repository.save(financial_portfolio);
    }

    public void delete(long id) {

        financial_portfolio_repository.deleteById(id);
    }
}

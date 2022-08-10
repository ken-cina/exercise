package com.training.financial_portfolio.controller;

import com.training.financial_portfolio.entities.Financial_portfolio;
import com.training.financial_portfolio.service.Financial_portfolio_service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/portfolio")
public class Financial_portfolio_controller {

    private static final Logger LOG = LoggerFactory.getLogger(Financial_portfolio_controller.class);

    @Autowired
    private Financial_portfolio_service financial_portfolio_service;

    @GetMapping
    public List<Financial_portfolio> findAll() {

        return financial_portfolio_service.findAll();
    }

//    @GetMapping("{id:[0-9]+}")
//    public ResponseEntity<Financial_portfolio> findById(@PathVariable long id) {
    @GetMapping("findById")
    public ResponseEntity<Financial_portfolio> findById(@RequestParam long id) {
        System.out.println("findById");
        try {
            return new ResponseEntity<>(financial_portfolio_service.findById(id), HttpStatus.OK);
        } catch(NoSuchElementException ex) {
            // return 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("findByUserName")
//    public ResponseEntity<List<Financial_portfolio>> findByUserName(@PathVariable String user_name) {
    public ResponseEntity<List<Financial_portfolio>> findByUserName(@RequestParam String user_name) {
        System.out.println("findByUserName");
        return new ResponseEntity<>(financial_portfolio_service.findByUserName(user_name), HttpStatus.OK);
//        try {
//            return new ResponseEntity<>(financial_portfolio_service.findByUserName(user_name), HttpStatus.OK);
//        } catch(NoSuchElementException ex) {
//            // return 404
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }
    @GetMapping("findByBankAccount")
    public ResponseEntity<List<Financial_portfolio>> findByBankAccount(@RequestParam String bankAccount) {
        System.out.println("findByBankAccount");
        return new ResponseEntity<>(financial_portfolio_service.findByBankAccount(bankAccount), HttpStatus.OK);
    }
    @GetMapping("findByPortfolio")
    public ResponseEntity<List<Financial_portfolio>> findByPortfolio(@RequestParam String portfolio) {
        System.out.println("findByPortfolio");
        return new ResponseEntity<>(financial_portfolio_service.findByPortfolio(portfolio), HttpStatus.OK);

    }

//    @GetMapping("{bank_account:[0-9]+}")
//    public ResponseEntity<List<Financial_portfolio>> findByBank_account(@PathVariable String bank_account) {
//        System.out.println("findByBank_account");
//        try {
//            return new ResponseEntity<>(financial_portfolio_service.find_by_bank_account(bank_account), HttpStatus.OK);
//        } catch(NoSuchElementException ex) {
//            // return 404
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping("{portfolio:[a-zA-Z &]+}")
//    public ResponseEntity<List<Financial_portfolio>> findByPortfolio(@PathVariable String portfolio) {
//        System.out.println("findByPortfolio");
//        try {
//            return new ResponseEntity<>(financial_portfolio_service.find_by_portfolio(portfolio), HttpStatus.OK);
//        } catch(NoSuchElementException ex) {
//            // return 404
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping
    public ResponseEntity<Financial_portfolio> create(@RequestBody Financial_portfolio financial_portfolio) {
        LOG.debug("Create shipper: [" + financial_portfolio + "]");
        return new ResponseEntity<>(financial_portfolio_service.save(financial_portfolio), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Financial_portfolio> update(@RequestBody Financial_portfolio financial_portfolio) {
        try {
            return new ResponseEntity<>(financial_portfolio_service.update(financial_portfolio), HttpStatus.OK);
        } catch(NoSuchElementException ex) {
            LOG.debug("update for unknown id: [" + financial_portfolio + "]");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        try {
            financial_portfolio_service.delete(id);
        } catch(EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

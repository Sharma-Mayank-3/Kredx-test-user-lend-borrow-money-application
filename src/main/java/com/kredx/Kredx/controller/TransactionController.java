package com.kredx.Kredx.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TransactionController {
    @PostMapping("/borrow")
    public ResponseEntity<String> borrow(@RequestBody Borrowing borrowing) {
        // Implement borrow logic using TransactionService
    }

    @PostMapping("/lend")
    public ResponseEntity<String> lend(@RequestBody Lending lending) {
        // Implement lend logic using TransactionService
    }
}

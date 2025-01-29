package com.library_management.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library_management.entity.CheckOut;
import com.library_management.service.CheckOutService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CheckOutController {
    @Autowired
    private CheckOutService checkOutService;

    @GetMapping("/checkouts")
    public ResponseEntity<List<CheckOut>> getAllCheckOuts() {
        return ResponseEntity.ok(checkOutService.getAllCheckOuts());
    }

    @GetMapping("/checkouts/{checkOutId}")
    public ResponseEntity<CheckOut> getCheckOut(@PathVariable("checkOutId") UUID checkOutId) {
        CheckOut checkOut = checkOutService.getCheckOut(checkOutId);
        return checkOut != null ? ResponseEntity.ok(checkOut) : ResponseEntity.notFound().build();
    }

    @PostMapping("/checkouts")
    public ResponseEntity<CheckOut> addCheckOut(@RequestBody CheckOut checkOut) {
        return ResponseEntity.ok(checkOutService.addCheckOut(checkOut));
    }

    @DeleteMapping("/checkouts/{checkOutId}")
    public ResponseEntity<String> deleteCheckOut(@PathVariable("checkOutId") UUID checkOutId) {
        CheckOut checkOutToDelete = checkOutService.getCheckOut(checkOutId);
        if (checkOutToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        checkOutService.deleteCheckOut(checkOutId);
        return ResponseEntity.ok("CheckOut record with ID " + checkOutId + " has been deleted.");
    }
}
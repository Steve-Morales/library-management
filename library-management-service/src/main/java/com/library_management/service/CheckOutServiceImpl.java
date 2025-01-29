package com.library_management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management.entity.CheckOut;
import com.library_management.repository.CheckOutRepository;

@Service
public class CheckOutServiceImpl implements CheckOutService{
	@Autowired
    private CheckOutRepository checkOutRepository;

    public List<CheckOut> getAllCheckOuts() {
        return checkOutRepository.findAll();
    }

    public CheckOut getCheckOut(UUID id) {
        return checkOutRepository.findById(id).orElse(null);
    }

    public CheckOut addCheckOut(CheckOut checkOut) {
        return checkOutRepository.save(checkOut);
    }

    public void deleteCheckOut(UUID id) {
        checkOutRepository.deleteById(id);
    }
}

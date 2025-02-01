package com.library_management.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management.entity.CheckOut;
import com.library_management.repository.CheckOutRepository;

@Service
public class CheckOutServiceImpl implements CheckOutService{
	@Autowired
    private CheckOutRepository checkOutRepository;

	@Override
    public List<CheckOut> getAllCheckOuts() {
        return (List<CheckOut>) checkOutRepository.findAll();
    }

	@Override
    public CheckOut getCheckOut(UUID id) {
		Optional<CheckOut> checkOut = checkOutRepository.findById(id);
		if (checkOut.isPresent()) {
			return checkOut.get();
		} else {
			throw new RuntimeException("CheckOut not found with ID: " + id);
		}
    }
	
	@Override
	public CheckOut updateCheckOut(CheckOut checkOut) 
	{
		return checkOutRepository.save(checkOut);
	}

	@Override
    public CheckOut addCheckOut(CheckOut checkOut) {
        return checkOutRepository.save(checkOut);
    }

	@Override
    public String deleteCheckOut(CheckOut checkOut) {
        checkOutRepository.delete(checkOut);
        return "CheckOut with ID " + checkOut.toString() + " has been deleted.";
    }
}

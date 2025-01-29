package com.library_management.service;

import java.util.List;
import java.util.UUID;

import com.library_management.entity.CheckOut;

public interface CheckOutService {
	List<CheckOut> getAllCheckOuts();
	CheckOut getCheckOut(UUID id);
	CheckOut addCheckOut(CheckOut checkOut);
	void deleteCheckOut(UUID id);
}

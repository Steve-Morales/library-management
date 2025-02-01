package com.library_management.repository;
import org.springframework.data.repository.CrudRepository;

import com.library_management.entity.CheckOut;

import java.util.UUID;

public interface CheckOutRepository extends CrudRepository<CheckOut, UUID> {
	
}

package com.library_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library_management.entity.CheckOut;

import java.util.UUID;

public interface CheckOutRepository extends JpaRepository<CheckOut, UUID> {
	
}

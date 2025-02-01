package com.library_management.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library_management.entity.Book;
import com.library_management.entity.CheckOut;
import com.library_management.entity.Person;
import com.library_management.service.BookService;
import com.library_management.service.CheckOutService;
import com.library_management.service.PersonService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CheckOutController {
    @Autowired
    private CheckOutService checkOutService;
    @Autowired
    private BookService bookService;
    @Autowired
    private PersonService personService;

    @GetMapping("/checkouts")
    public ResponseEntity<List<CheckOut>> getAllCheckOuts() {
        return ResponseEntity.ok(checkOutService.getAllCheckOuts());
    }

    @GetMapping("/checkouts/{checkOutId}")
    public ResponseEntity<CheckOut> getCheckOut(@PathVariable("checkOutId") UUID checkOutId) {
        return ResponseEntity.ok(checkOutService.getCheckOut(checkOutId));
    }

    @PostMapping("/checkouts")
    public ResponseEntity<CheckOut> addCheckOut(@RequestBody Map<String, Object> requestBody) {
    	System.out.println(requestBody);
    	UUID bookID = UUID.fromString((String) requestBody.get("book_book_id"));
    	UUID personid = UUID.fromString((String) requestBody.get("person_personid"));
    	
    	String dateStr = (String) requestBody.get("check_out_date");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date checkoutDate = null;
		try {
			checkoutDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Book book = bookService.getBook(bookID);
    	Person person = personService.getPerson(personid);
    	
    	if(person == null || book == null) 
    	{
    		return ResponseEntity.badRequest().body(null);
    	}
    	
    	CheckOut checkout = new CheckOut();
    	checkout.setBook(book);
    	checkout.setPerson(person);
        checkout.setCheckoutDate(checkoutDate);
    	
        return ResponseEntity.ok(checkOutService.addCheckOut(checkout));
    }
    
    @PostMapping("/checkouts/{checkOutId}")
    public ResponseEntity<CheckOut> updateCheckOut(@PathVariable("checkOutId") UUID checkOutId, @RequestBody CheckOut checkOut) {
        return ResponseEntity.ok(checkOutService.updateCheckOut(checkOut));
    }

    @DeleteMapping("/checkouts/{checkOutId}")
    public ResponseEntity<String> deleteCheckOut(@PathVariable("checkOutId") UUID checkOutId) {
        CheckOut checkOutToDelete = checkOutService.getCheckOut(checkOutId);
        if(checkOutToDelete == null) { ResponseEntity.ok(null); }
        return ResponseEntity.ok(checkOutService.deleteCheckOut(checkOutToDelete));
    }
}
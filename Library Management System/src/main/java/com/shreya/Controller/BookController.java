package com.shreya.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.shreya.entity.Book;
import com.shreya.repository.BookRepository;

@Controller
//@RequestMapping("/library")
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@RequestMapping("/home")
	public String home (Model model) {
		model.addAttribute("appName", "Library");
		return "home";
	}
	@RequestMapping("/display")
	public String displayBookInfo(Model model) {
		
		List<Book> allBooks = (List<Book>) bookRepo.findAll();
		model.addAttribute("books", allBooks);
		
		if(allBooks.isEmpty()) {
			model.addAttribute("msg","Unfortunately, the library is empty now. Lets" +"contribute by adding some books");
		}
		
		else {
			if(model.getAttribute("msg")==null)
				model.addAttribute("msg","Welcome to the library");
		}
		return "displayBook";
	}
	@GetMapping("/borrowForm/{id}")
	public String borrowForm(@PathVariable String id,Model model) {
		Book book =bookRepo.findById(Integer.parseInt(id)).get();
		model.addAttribute("book",book);
		return "borrowBook";
	}
	
	@PostMapping("/borrow")
	public String borrow(@RequestParam int id,Model model) {
		Book book= bookRepo.findById(id).get();
		bookRepo.save(book);
		model.addAttribute("msg","Book borrowed successfully. please return within a months time");
		return displayBookInfo(model);
	}
	
	@GetMapping("/addBookForm")
	public String addBookForm(Model model) {
		model.addAttribute("book","");
		return "addBook";
	}
	
	@PostMapping("/addBookForm")
	public String addBook(@ModelAttribute("book") Book book,Model model) {
		System.out.println(book);
		bookRepo.save(book);
		model.addAttribute("msg"," Book added successfully.Thanks");
		
	    //return displayBookInfo(model);
		
		return "addBook";
	}
	

}

package com.shreya.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.shreya.entity.*;
public interface BookRepository extends CrudRepository<Book,Integer>{
	
    public List<Book> findByName(String name);
    
}

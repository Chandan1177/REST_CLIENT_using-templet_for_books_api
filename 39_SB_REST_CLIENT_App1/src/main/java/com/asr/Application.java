package com.asr;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.asr.entity.Book;
import com.asr.entity.Books;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		String url="http://localhost:8080/books";
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Books> booksentity=rt.getForEntity(url, Books.class);
		Books books=booksentity.getBody();
		List<Book> book=books.getBooks();
		book.forEach(e->{
			System.out.println(e);
		});
	}

}

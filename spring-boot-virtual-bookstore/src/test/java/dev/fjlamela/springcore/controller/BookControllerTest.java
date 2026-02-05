package dev.fjlamela.springcore.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import dev.fjlamela.springcore.domain.Book;
import dev.fjlamela.springcore.service.BookService;

@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	public void getBooks_shouldReturnOk() throws Exception {
		when(bookService.listBooks()).thenReturn(List.of());
		mockMvc.perform(get("/books")).andExpect(status().isOk());
	}

	@Test
	public void getBook_shouldReturnEmptyList() throws Exception {
		when(bookService.listBooks()).thenReturn(List.of());

		mockMvc.perform(get("/books")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$").isEmpty());
	}

	@Test
	public void getBooks_shouldReturnOneBook() throws Exception {
		Book book = new Book("The Old Man and the Sea", "Ernest Hemingway", "978-0684801223", 1952);

		when(bookService.listBooks()).thenReturn(List.of(book));

		mockMvc.perform(get("/books")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].title").value("The Old Man and the Sea"))
				.andExpect(jsonPath("$[0].author").value("Ernest Hemingway"))
				.andExpect(jsonPath("$[0].isbn").value("978-0684801223"))
				.andExpect(jsonPath("$[0].publicationYear").value(1952));

	}
}

package com.alex.database.services;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.alex.database.domain.entities.BookEntity;

public interface BookService {

    BookEntity createUpdateBook(String isbn, BookEntity bookEntity);

    // List<BookEntity> findAll();

    Optional<BookEntity> findOne(String isbn);

    boolean isExists(String isbn);

    BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    void delete(String isbn);

    Page<BookEntity> findAll(Pageable pageable);

    int getNumberOfBooksByAuthorId(Long authorId);
}

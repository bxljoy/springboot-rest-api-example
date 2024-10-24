package com.alex.database.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.alex.database.TestDataUtil;
import com.alex.database.domain.entities.AuthorEntity;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorServiceIntegrationTests {

    private final AuthorService authorService;

    @Autowired
    public AuthorServiceIntegrationTests(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Test
    public void testThatFindAll() {
        AuthorEntity authorA = TestDataUtil.createTestAuthor(1L, "Alex", 40);
        authorService.save(authorA);

        AuthorEntity authorB = TestDataUtil.createTestAuthor(2L, "Jess", 40);
        authorService.save(authorB);

        AuthorEntity authorC = TestDataUtil.createTestAuthor(3L, "Dora", 8);
        authorService.save(authorC);

        List<AuthorEntity> result = authorService.findAll();

        assertThat(result).hasSize(3).contains(authorA, authorB, authorC)
                .doesNotContain(TestDataUtil.createTestAuthor(4L, "Haha", 1));
    }

}

package com.eeehit.board;

import com.eeehit.board.domain.Article;
import com.eeehit.board.domain.Role;
import com.eeehit.board.domain.User;
import com.eeehit.board.repository.ArticleRepository;
import com.eeehit.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableAutoConfiguration
@EnableRedisHttpSession
public class BoardApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        userRepository.save(new User("Trinity", "hello", Role.ADMIN));
        userRepository.save(new User("Hello", "hello", Role.USER));
        userRepository.save(new User("TEST", "hello", Role.USER));
        articleRepository.save(new Article("aaaa", "bbb"));
        articleRepository.save(new Article("222", "aaaaaaaaa"));
        articleRepository.save(new Article("harry potter", "good"));
    }
}

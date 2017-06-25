package com.eeehit.board;

import com.eeehit.board.article.Article;
import com.eeehit.board.user.role.Role;
import com.eeehit.board.user.user.User;
import com.eeehit.board.article.ArticleRepository;
import com.eeehit.board.user.user.UserRepository;
import com.eeehit.board.user.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableAutoConfiguration
@EnableRedisHttpSession
public class BoardApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        articleRepository.save(new Article("aaaa", "bbb"));
        articleRepository.save(new Article("222", "aaaaaaaaa"));
        articleRepository.save(new Article("harry potter", "good"));
        roleService.addRole("ROLE_ADMIN");
        roleService.addRole("ROLE_USER");

        Set<Role> adminRole = new HashSet<>();
        adminRole.add(new Role("ROLE_ADMIN"));
        adminRole.add(new Role("ROLE_USER"));

        Set<Role> userRole = new HashSet<>();
        userRole.add(new Role("ROLE_USER"));

        Set<Role> userRole2 = new HashSet<>();
        userRole2.add(new Role("ROLE_USER"));

	    userRepository.save(new User("Trinity", "hello", adminRole));
        userRepository.save(new User("Hello", "hello", userRole));
        userRepository.save(new User("TEST", "hello", userRole2));
    }
}

package com.example.demo;

import com.example.entiy.User;
import com.example.services.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Test
	public void contextLoads() {
//		userRepository.save(new User("AAA",1));

//        userRepository.save(new User("HHH",1));

//        userRepository.save(new User("CCC",2));

//        userRepository.save(new User("DDDDDDD",3));
	}
}

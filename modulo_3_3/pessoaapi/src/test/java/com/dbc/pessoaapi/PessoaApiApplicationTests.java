package com.dbc.pessoaapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class PessoaApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void generatePass(){
		System.out.println(new BCryptPasswordEncoder().encode("bi@nc@"));
	}

}

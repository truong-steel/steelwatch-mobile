package com.vti.steelwatch;

import com.vti.steelwatch.entity.Role;
import com.vti.steelwatch.entity.User;
import com.vti.steelwatch.repository.RoleRepository;
import com.vti.steelwatch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class SteelWatchStoreApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SteelWatchStoreApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		var admin = roleRepository.findByType(Role.Type.ADMIN);
		var account = new User();
		account.setName("ADMIN");
		account.setUsername("admin");
		account.setEmail("admin@gmail.com");
		account.setPassword(passwordEncoder.encode("123456"));
		account.setRoles(Set.of(admin));
		userRepository.save(account);
	}
}

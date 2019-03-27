package com.mhalab.eve;

import com.mhalab.eve.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

// TODO: https://stackoverflow.com/questions/49963618/postgresql-clob-datatype
// TODO: https://stackoverflow.com/questions/28588311/correct-jpa-annotation-for-postgresqls-text-type-without-hibernate-annotations

@SpringBootApplication
public class EveApplication {
	private final static Logger logger = LoggerFactory.getLogger(EveApplication.class);

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(EveApplication.class, args);
		logger.info("Hello");
		logger.info(new BCryptPasswordEncoder().encode("aaa"));
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Person owner1 = new Person("Michał", "Hauzer");
			Person owner2 = new Person("Monika", "Hauzer");
			personRepository.save(owner1);
			personRepository.save(owner2);

			logger.info("onwer1=" + owner1.toString());

			taskRepository.save(new Task("Brush your teeth", owner1));
			taskRepository.save(new Task("Take a shower", owner1));
			taskRepository.save(new Task("Read the Peterson book", owner1));
			taskRepository.save(new Task("Learn full stack development", owner1, StatusType.IN_PROGRESS));
			taskRepository.save(new Task("Watch Netflix", owner2));
			taskRepository.save(new Task("Take a shower", owner2));

			List<Task> tasks = taskRepository.findByStatus(StatusType.IN_PROGRESS);

			for (Task task : tasks) {
				logger.info(task.getDescription());
			}

			userAccountRepository.save(new UserAccount("admin", "admin", "ADMIN"));
			userAccountRepository.save(new UserAccount("mhauzer", "aaa", "USER"));
		};
	}
}

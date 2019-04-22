package test.clyde.demoh2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import test.clyde.demoh2.student.Student;
import test.clyde.demoh2.student.StudentRepository;

@SpringBootApplication
public class DemoH2Application implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting -> {}", repository.save(new Student("John", "A1234657")));
		logger.info("Inserting -> {}", repository.save(new Student("John1", "A1234659")));
		logger.info("Inserting -> {}", repository.save(new Student("John2", "A1234660")));

		logger.info("Update 10003 -> {}", repository.save(new Student(10001L, "Name-Updated", "New-Passport")));

		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
	}

}

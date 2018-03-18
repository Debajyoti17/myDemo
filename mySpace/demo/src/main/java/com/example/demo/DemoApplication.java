package com.example.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Employee;
import com.example.demo.model.Note;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.NoteRepository;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	NoteRepository noteRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {
			String[] beans = appContext.getBeanDefinitionNames();
			Arrays.stream(beans).sorted().forEach(System.out::print);
		};
	}

	@Bean
	public List<Employee> getEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
			 empList.add(employeeRepository.save(new Employee(1L, "Dev", "Noida", 1000, 20, "Dev")));
			 empList.add(employeeRepository.save(new Employee(1L, "Shiv", "Gurgaon", 2000, 23, "Support")));
			 empList.add(employeeRepository.save(new Employee(1L, "Varun", "Mumbai", 3000, 25, "Testing")));
			 empList.add(employeeRepository.save(new Employee(1L, "Sara", "Delhi", 6000, 29, "Database")));
			 empList.add(employeeRepository.save(new Employee(1L, "Daniel", "Kolkata", 8000, 24, "Production")));
			 empList.add(employeeRepository.save(new Employee(1L, "Vishal", "Chennai", 4000, 26, "Management")));
			 
			 return empList;
	}
	
//	@Bean
	public List<Note> getNote() {
		List<Note> noteList = new ArrayList<Note>();
		noteList.add(noteRepository.save(new Note(1L, "yes", "My Day", "I am happy")));
		noteList.add(noteRepository.save(new Note(2L, "yes", "My Tour", "I am in Noida")));
		noteList.add(noteRepository.save(new Note(3L, "yes", "My Job", "I am in Sopra Steria")));
		noteList.add(noteRepository.save(new Note(4L, "yes", "My Hobby", "Listening music")));
		noteList.add(noteRepository.save(new Note(5L, "yes", "My Wish", "I wish......")));

		return noteList;
}

}

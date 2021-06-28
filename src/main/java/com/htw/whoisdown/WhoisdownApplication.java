package com.htw.whoisdown;

import com.htw.whoisdown.model.Event;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class WhoisdownApplication {
//
//	@Autowired
//	private EventRepo testRepo;

	public static void main(String[] args) {
		SpringApplication.run(WhoisdownApplication.class, args);
	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		List<Event> list = testRepo.findAll();
//		list.stream().forEach(e -> System.out.println(e.toString()));
//	}

}

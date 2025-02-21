package com.prisc.summer_screen;

import com.prisc.summer_screen.model.SeriesInfo;
import com.prisc.summer_screen.service.DataConverter;
import com.prisc.summer_screen.service.OmdbApiConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CommandLineRunner interface define actions to be executed as soon the application is started
 */

@SpringBootApplication
public class SummerScreenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SummerScreenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var apiConsumer = new OmdbApiConsumer();
		var json = apiConsumer.getData("The Office");
		DataConverter mapper = new DataConverter();
		SeriesInfo serie = mapper.jsonToObject(json, SeriesInfo.class);
		System.out.println(serie);
	}
}

package com.prisc.summer_screen;

import com.prisc.summer_screen.view.View;
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

		View summerScreenView = new View();
		summerScreenView.initSummerScreen();

	}
}

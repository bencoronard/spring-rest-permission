package dev.hireben.demo.rest.permission;

import org.springframework.boot.SpringApplication;

public class TestPermissionApplication {

	public static void main(String[] args) {
		SpringApplication.from(PermissionApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

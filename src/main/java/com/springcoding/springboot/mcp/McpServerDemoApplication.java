package com.springcoding.springboot.mcp;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpServerDemoApplication.class, args);
	}

	@Bean
	public List<ToolCallback> bookTools(BookService bookService) {
		return List.of(ToolCallbacks.from(bookService));
	}
}

package cn.cactusli.compute.domain;

import cn.cactusli.compute.domain.service.ComputerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@Slf4j
@SpringBootApplication
public class McpServerComputeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(McpServerComputeApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider computerTools(ComputerService computerService) {
        return MethodToolCallbackProvider.builder().toolObjects(computerService).build();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("mcp server computer success!");
    }
}

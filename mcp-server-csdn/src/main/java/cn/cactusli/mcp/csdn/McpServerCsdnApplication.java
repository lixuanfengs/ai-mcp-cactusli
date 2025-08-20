package cn.cactusli.mcp.csdn;

import cn.cactusli.mcp.csdn.domain.service.CSDNArticleService;
import cn.cactusli.mcp.csdn.infrastructure.gateway.ICSDNService;
import cn.cactusli.mcp.csdn.types.properties.CSDNApiProperties;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Slf4j
@SpringBootApplication
public class McpServerCsdnApplication implements CommandLineRunner {

    @Resource
    private CSDNApiProperties csdnApiProperties;

    public static void main(String[] args) {
        SpringApplication.run(McpServerCsdnApplication.class, args);
    }

    @Bean
    public ICSDNService csdnService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bizapi.csdn.net/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit.create(ICSDNService.class);
    }

    @Bean
    public ToolCallbackProvider csdnTools(CSDNArticleService csdnArticleService) {
        return MethodToolCallbackProvider.builder().toolObjects(csdnArticleService).build();
    }

    @Override
    public void run(String... args) {
        log.info("check csdn cookie ...");
        if (csdnApiProperties.getCookie() == null) {
            log.warn("csdn cookie key is null, please set it in application.yml");
        } else {
            log.info("csdn cookie  key is {}", csdnApiProperties.getCookie());
        }
    }
}

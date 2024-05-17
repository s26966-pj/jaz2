package pl.pjatk.kamlit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigurationClass {
    @Bean
    public PojoClass pojoClass() {
        return new PojoClass();
    }

    @Bean
    public List<String> defaultData() {
        return List.of("s1","s2","s3","s4","s5");
    }

}

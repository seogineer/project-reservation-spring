package reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "reservation.dao",  "reservation.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}

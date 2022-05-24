package annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("annotations")
@PropertySource("classpath:sport.properties")
public class SportConfig {
    //define bean for our SadFortuneService
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    //define bean for our SwimCoach and inject dependencies
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}

package com.wyr.genootschap;

import com.wyr.genootschap.repository.UserRepository;
import com.wyr.genootschap.repository.WyrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GenootschapApplication implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WyrRepository wyrRepository;


    public static void main(String[] args) {
        SpringApplication.run(GenootschapApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173", "http://localhost:4173/");
            }
        };
    }

    @Override
    public void run(String... args) throws Exception {

        /*wyr w = wyrRepository.findByTitle("test");

        reaction a = new reaction("Aap");
        reaction o = new reaction("olifant", "10");

        List<reaction> list = new ArrayList<>();
        list.add(o);
        list.add(a);
        w.setReactions(list);

        wyrRepository.save(w);*/


    }


}

package com.td.movietdapi;

import com.td.movietdapi.enableCORS.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTdapiApplication {

    public static void main(String[] args) {

        SpringApplication.run(MovieTdapiApplication.class, args);
    }

   public CorsConfig corsConfig(){
        return new CorsConfig();
    }

/*    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") // Update with your allowed origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }*/

}

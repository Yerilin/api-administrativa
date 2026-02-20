package ar.utn.ba.ddsi.apiadmi.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://front-metamapa-lo3l.vercel.app",
                        "https://api-publica-2axc.onrender.com",
                        "http://localhost:3000",
                        "http://localhost:5173",
                        "https://api-publica-rnpq.onrender.com",
                        "https://front-metamapa-dun.vercel.app"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
package ar.utn.ba.ddsi.apiadmi.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
        CorsConfiguration config = new CorsConfiguration();

        // 1. Permitir credenciales
        config.setAllowCredentials(true);

        // 2. Orígenes permitidos (Tu frontend en producción y local)
        config.setAllowedOrigins(Arrays.asList(
                "https://front-metamapa-lo3l.vercel.app",
                "https://api-publica-2axc.onrender.com",
                "http://localhost:3000",
                "http://localhost:5173",
                "https://api-publica-rnpq.onrender.com",
                //El unico que funciona no quise sacar los demás para que no rompa.
                "https://front-metamapa-dun.vercel.app"
        ));

        // 3. Cabeceras y métodos permitidos (OPTIONS es obligatorio)
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        config.setAllowCredentials(true);

        // 4. Aplicar a toda la API
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // 5. REGISTRAR EL FILTRO CON MÁXIMA PRIORIDAD
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

        // ESTA LÍNEA ES LA CLAVE: Lo pone antes que tu @Order(1)
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}


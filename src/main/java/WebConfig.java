import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Ajusta el patrón a las rutas que desees permitir
            .allowedOrigins("https://cheery-dasik-60d356.netlify.app/")  // Cambia esta URL con la de tu sitio Netlify
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos HTTP permitidos
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
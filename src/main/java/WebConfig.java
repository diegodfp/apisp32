import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("https://cheery-dasik-60d356.netlify.app")  // Quita la barra final
            .allowedMethods("*")  // Permitir todos los métodos HTTP
            .allowedHeaders("*")  // Permitir todas las cabeceras
            .exposedHeaders("Authorization")  // Exponer cabeceras necesarias
            .allowCredentials(true);  // Permitir credenciales (si usas autenticación)
    }
}
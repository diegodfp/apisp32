import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permite CORS en todas las rutas
            .allowedOrigins("*")    // Permite solicitudes desde cualquier origen
            .allowedMethods("*")    // Permite todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
            .allowedHeaders("*")    // Permite todas las cabeceras
            .allowCredentials(false);  // No requiere credenciales
    }
}

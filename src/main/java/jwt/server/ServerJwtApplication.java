package jwt.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ServerJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerJwtApplication.class, args);
    }

}

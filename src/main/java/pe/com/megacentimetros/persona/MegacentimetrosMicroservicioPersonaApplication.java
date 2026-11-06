package pe.com.megacentimetros.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MegacentimetrosMicroservicioPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegacentimetrosMicroservicioPersonaApplication.class, args);
	}

}

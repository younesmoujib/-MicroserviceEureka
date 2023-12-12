package ma.ensa.Client;

import ma.ensa.Client.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import ma.ensa.Client.repository.ClientRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(Long.parseLong("1"), "younes moujib", Float.parseFloat("23")));
			clientRepository.save(new Client(Long.parseLong("2"), "yahya mourid",
					Float.parseFloat("22")));
			clientRepository.save(new Client(Long.parseLong("3"), "rakine ayoub",
					Float.parseFloat("22")));

		};
	}

}
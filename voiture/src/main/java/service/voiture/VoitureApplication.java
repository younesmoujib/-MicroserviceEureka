package service.voiture;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import service.voiture.entities.Voiture;
import service.voiture.repositories.VoitureRepository;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}
	@FeignClient(name="SERVICE-CLIENT")
	public interface ClientService{
	@GetMapping(path="/client/{id}")
	public Client ClientById(@PathVariable Long id);
	}

	
	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository,ClientService clientService) {
		return args -> {
			
	 Client c1 = clientService.ClientById(1L);
	 Client c2 = clientService.ClientById(2L);
	 Client c3 = clientService.ClientById(3L);
	

		voitureRepository.save(new Voiture(Long.parseLong("1"), "bm", "2017","ag1234",c1.getId(),null));
		voitureRepository.save(new Voiture(Long.parseLong("2"), "bugatti", "2020","cvd1458",c2.getId(),null));
		voitureRepository.save(new Voiture(Long.parseLong("3"), "mercedes", "2025","zx1487",c3.getId(),null));
		
		 };
		 }


}

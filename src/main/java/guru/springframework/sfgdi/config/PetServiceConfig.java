/**
 * 
 */
package guru.springframework.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import guru.springframework.sfgdi.services.PetService;
import guru.springframework.sfgdi.services.PetServiceFactory;

/**
 * @author dcividin
 *
 */
@Configuration
public class PetServiceConfig {
	
	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}
	
	@Profile("cat")
	@Bean
	PetService catPetService(PetServiceFactory factory) {
		return factory.getpetService(PetServiceFactory.PetType.CAT);
	}
	
	@Profile({"dog", "default"})
	@Bean
	PetService dogPetService(PetServiceFactory factory) {
		return factory.getpetService(PetServiceFactory.PetType.DOG);
	}
}

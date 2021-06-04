/**
 * 
 */
package guru.springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.I18NSpanishService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;

/**
 * @author dcividin
 *
 */
@PropertySource("classpath:datasource.properties")
@Configuration
public class GreetingServiceConfig {
	
	@Bean
	FakeDataSource fakeDataSource(
			@Value("${guru.username}") String username,
			@Value("${guru.password}") String password,
			@Value("${guru.jdbcurl}") String jdbcUrl) {
		FakeDataSource fakeDataSource = new FakeDataSource();
		
		fakeDataSource.setUsername(username);
		fakeDataSource.setPassword(password);
		fakeDataSource.setJdbcUrl(jdbcUrl);
		
		return fakeDataSource;
	}
	
	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}
	
	/**
	 * Look since Spring use the method name to qualify the bean, in this case we can not set the name to the bean annotation
	 * @return
	 */
	@Profile("EN")
	@Bean
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository repository) {
		return new I18nEnglishGreetingService(repository);
	}
	
	/**
	 * here since we already have a method named "i18nService" we qualify the bean with the name.
	 * since there are two bean with same name, is the profile annotation to drive spring to pick up the right one
	 * if no profile set, wins the bean with profile annotation with "default" value
	 * @return
	 */
	@Profile({"ES", "default"})
	@Bean("i18nService")
	I18NSpanishService i18NSpanishService() {
		return new I18NSpanishService();
	}
	
	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}
	
	@Bean
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}
	
	@Bean
	PropertyInjectedGreetingService propertyInjectedGreetingService() {
		return new PropertyInjectedGreetingService();
	}
	
	@Bean
	SetterInjectedGreetingService setterInjectedGreetingService() {
		return new SetterInjectedGreetingService();
	}
}

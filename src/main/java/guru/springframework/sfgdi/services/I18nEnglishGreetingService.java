package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;

/**
 * Created by jt on 12/27/19.
 */
public class I18nEnglishGreetingService implements GreetingService {
	private final EnglishGreetingRepository repository;
	
    /**
	 * @param repository
	 */
	public I18nEnglishGreetingService(EnglishGreetingRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
    public String sayGreeting() {
        return repository.getGreeting();
    }
}

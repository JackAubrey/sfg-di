/**
 * 
 */
package guru.springframework.sfgdi.repositories;

/**
 * @author dcividin
 *
 */
public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

	@Override
	public String getGreeting() {
		return "Hello World - EN";
	}

}

/**
 * 
 */
package guru.springframework.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author dcividin
 *
 */
@ConfigurationProperties("guru")
@ConstructorBinding // tells to spring to use the constructor
// this kind of configuration wants @EnableConfigurationProperties(SfgiConstructorConfiguration.class)
// in one @Configuration class
public class SfgiConstructorConfiguration {
	private final String username;
	private final String password;
	private final String jdbcUrl;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param jdbcUrl
	 */
	public SfgiConstructorConfiguration(String username, String password, String jdbcUrl) {
		super();
		this.username = username;
		this.password = password;
		this.jdbcUrl = jdbcUrl;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the jdbcUrl
	 */
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	@Override
	public String toString() {
		return "SfgiConstructorConfiguration [username=" + username + ", password=" + password + ", jdbcUrl=" + jdbcUrl
				+ "]";
	}
}

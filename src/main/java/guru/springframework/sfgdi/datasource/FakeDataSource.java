/**
 * 
 */
package guru.springframework.sfgdi.datasource;

/**
 * @author dcividin
 *
 */
public class FakeDataSource {
	private String username;
	private String password;
	private String jdbcUrl;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the jdbcUrl
	 */
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	/**
	 * @param jdbcUrl the jdbcUrl to set
	 */
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	
	@Override
	public String toString() {
		return "FakeDataSource [username=" + username + ", password=" + password + ", jdbcUrl=" + jdbcUrl + "]";
	}
}

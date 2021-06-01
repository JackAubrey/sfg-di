/**
 * 
 */
package guru.springframework.sfgdi.components;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author dcividin
 *
 */
@Component
public class SingletonBean {
	
	private static final Logger log = LoggerFactory.getLogger(SingletonBean.class);
	private static AtomicInteger sequence = new AtomicInteger();
	
	private int seqValue = 0;
	
	public SingletonBean() {
		log.info("Creating Singletone Bean");
		seqValue = sequence.incrementAndGet();
	}
	
	public String getMyScope() {
		return "I'm a Singletone "+seqValue;
	}
}

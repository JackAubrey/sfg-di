/**
 * 
 */
package guru.springframework.sfgdi.components;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author dcividin
 *
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {
	
	private static final Logger log = LoggerFactory.getLogger(PrototypeBean.class);
	private static AtomicInteger sequence = new AtomicInteger();
	
	private int seqValue = 0;
	
	public PrototypeBean() {
		log.info("Creating Prototype Bean");
		seqValue = sequence.incrementAndGet();
	}
	
	public String getMyScope() {
		return "I'm a Prototype "+seqValue;
	}
}

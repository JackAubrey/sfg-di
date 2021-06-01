package guru.springframework.sfgdi;

import guru.springframework.sfgdi.components.PrototypeBean;
import guru.springframework.sfgdi.components.SingletonBean;
import guru.springframework.sfgdi.controllers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SfgDiApplication.class);


	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		log.info("--- The Best Pet is ---");
		log.info(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		log.info(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		log.info("------- Primary Bean");
		log.info(myController.sayHello());

		log.info("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		log.info(propertyInjectedController.getGreeting());

		log.info("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		log.info(setterInjectedController.getGreeting());

		log.info("-------- Constructor" );
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		log.info(constructorInjectedController.getGreeting());
		
		log.info("Get Singletone instance 01: {} ", ctx.getBean(SingletonBean.class).getMyScope());
		log.info("Get Singletone instance 02: {} ", ctx.getBean(SingletonBean.class).getMyScope());
		log.info("Get Singletone instance 03: {} ", ctx.getBean(SingletonBean.class).getMyScope());
		
		log.info("Get Prototype instance 01: {} ", ctx.getBean(PrototypeBean.class).getMyScope());
		log.info("Get Prototype instance 02: {} ", ctx.getBean(PrototypeBean.class).getMyScope());
		log.info("Get Prototype instance 03: {} ", ctx.getBean(PrototypeBean.class).getMyScope());
	}

}

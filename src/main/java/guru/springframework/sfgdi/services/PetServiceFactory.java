/**
 * 
 */
package guru.springframework.sfgdi.services;

/**
 * @author dcividin
 *
 */
public class PetServiceFactory {
	public enum PetType {
		DOG, CAT
	}
	
	public PetService getpetService(PetType petType) {
		switch (petType) {
			case CAT:
				return new CatPetService();
	
			default:
				return new DogPetService();
		}
	}
}

package duel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class SkillTest 
{
	//Test des aptitudes globales
	@Test
	void when_totalOfAllAptitudesAreInferiorToTheMax_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(24, 25, 25, 25));
	}
	
	@Test
	void when_totalOfAllAptitudesAreEqualToTheMax_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(25, 25, 25, 25));
	}
	
	@Test
	void when_totalOfAllAptitudesAreSuperiorToTheMax_then_doesNotcreateAptitudesObject() 
	{
		assertThrows(IllegalArgumentException.class, () -> new Aptitudes(26, 25, 25, 25));
	}
	
	//Test de l'aptitude de la force
	@Test
	void when_strengthValueIsSuperiorTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(1, 25, 25, 25));
	}
	
	@Test
	void when_strengthValueIsEqualTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(0, 25, 25, 25));
	}
	
	@Test
	void when_strengthValueIsInferiorTo0_then_doesNotcreateAptitudesObject() 
	{
		assertThrows(IllegalArgumentException.class, () -> new Aptitudes(-1, 25, 25, 25));
	}
	
	//Test de l'aptitude de la dexterite
	@Test
	void when_dexterityValueIsSuperiorTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(25, 1, 25, 25));
	}
		
	@Test
	void when_dexterityValueIsEqualTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(25, 0, 25, 25));
	}
		
	@Test
	void when_dexterityValueIsInferiorTo0_then_doesNotcreateAptitudesObject() 
	{
		assertThrows(IllegalArgumentException.class, () -> new Aptitudes(25, -1, 25, 25));
	}
	
	//Test de l'aptitude de l'intelligence
	@Test
	void when_intelligenceValueIsSuperiorTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(25, 25, 1, 25));
	}
			
	@Test
	void  when_intelligenceValueIsEqualTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(25, 25, 0, 25));
	}
			
	@Test
	void when_intelligenceValueIsInferiorTo0_then_doesNotcreateAptitudesObject() 
	{
		assertThrows(IllegalArgumentException.class, () -> new Aptitudes(25, 25, -1, 25));
	}
		
	//Test de l'aptitude de la concentration
	@Test
	void when_focusValueIsSuperiorTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(25, 25, 25, 1));
	}
			
	@Test
	void when_focusValueIsEqualTo0_then_createAptitudesObject() 
	{
		assertDoesNotThrow(() -> new Aptitudes(25, 25, 25, 0));
	}
			
	@Test
	void when_focusValueIsInferiorTo0_then_doesNotcreateAptitudesObject() 
	{
		assertThrows(IllegalArgumentException.class, () -> new Aptitudes(25, 25, 25, -1));
	}
}

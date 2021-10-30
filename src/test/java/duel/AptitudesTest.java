package duel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class AptitudesTest 
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
	
	//augmentation et diminution de toutes les aptitudes
	@Test
	void when_callIncreaseAllAptitudes_then_allAptitudesValueAreIncreaseBy1()
	{
		Aptitudes aptitude = new Aptitudes(2, 2, 2, 2);
		aptitude.increaseAllAptitudes();
		testAptitudes(aptitude, 3);
	}
	
	@Test
	void when_callDecreaseAllAptitudes_then_allAptitudesValueAreDecreaseBy1()
	{
		Aptitudes aptitude = new Aptitudes(2, 2, 2, 2);
		aptitude.decreaseAllAptitudes();
		testAptitudes(aptitude, 1);
	}
	
	@Test
	void when_callDecreaseAllAptitudesAndAptitudeValueIsAt1_then_aptitudeValueIsStillAt1()
	{
		Aptitudes aptitude = new Aptitudes(1, 1, 1, 1);
		aptitude.decreaseAllAptitudes();
		testAptitudes(aptitude, 1);
	}
	
	//autre test
	@Test
	void when_callsTotalOfAllAptitudes_then_returnsTotalOfAllAptitudes()
	{
		int expectedTotal = 100;
		Aptitudes aptitudes = new Aptitudes(25, 25, 25, 25);
		assertEquals(expectedTotal, aptitudes.getTotalAptitudes());
	}
	
	//pour permettre de tester toutes les aptitudes
	private void testAptitudes(Aptitudes aptitudes, int expectedValue)
	{
		assertEquals(aptitudes.getStrength(), expectedValue);
		assertEquals(aptitudes.getDexterity(), expectedValue);
		assertEquals(aptitudes.getIntelligence(), expectedValue);
		assertEquals(aptitudes.getFocus(), expectedValue);
	}
}
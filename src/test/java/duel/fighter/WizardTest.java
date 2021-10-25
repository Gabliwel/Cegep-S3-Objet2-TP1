package duel.fighter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import skill.SkillMock;

public class WizardTest 
{
	public static final int ADDED_VALUE = 15;
	public static final int ANY_VALUE = 5;
	//orde des atributs dans l'object "Aptitudes": force - dextérité - intelligence - concentration
	//Test de l'intelligence du mage
	@Test
	void when_intelligenceIsEqualOrBiggerThanTheBiggestAptitudeBetweenStrengthAndDexterityPlusAddedValue_then_returnsNewWizard() 
	{
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE-1, ANY_VALUE, ANY_VALUE+ADDED_VALUE, 25), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE-1, ANY_VALUE+ADDED_VALUE, 25), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE, ANY_VALUE+ADDED_VALUE, 25), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE, ANY_VALUE+ADDED_VALUE+1, 25), new SkillMock(), new SkillMock()));
	}
		
	@Test
	void when_intelligenceIsLowerThanTheBiggestAptitudeBetweenStregthAndDexterityPlusAddedValue_then_doesNotCreateWizard() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard("", new Aptitudes(ANY_VALUE-1, ANY_VALUE, ANY_VALUE+ADDED_VALUE-1, 25), new SkillMock(), new SkillMock()));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE-1, ANY_VALUE+ADDED_VALUE-1, 25), new SkillMock(), new SkillMock()));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE, ANY_VALUE+ADDED_VALUE-1, 25), new SkillMock(), new SkillMock()));
	}
	
	//Test de la concentration du mage
	@Test
	void when_focusIsEqualOrBiggerThanTheBiggestAptitudeBetweenStrengthAndDexterityPlusAddedValue_then_returnsNewWizard() 
	{
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE-1, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE-1, 25, ANY_VALUE+ADDED_VALUE), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE+1), new SkillMock(), new SkillMock()));
	}
			
	@Test
	void when_focusIsLowerThanTheBiggestAptitudeBetweenStregthAndDexterityPlusAddedValue_then_doesNotCreateWizard() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard("", new Aptitudes(ANY_VALUE-1, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE-1), new SkillMock(), new SkillMock()));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE-1, 25, ANY_VALUE+ADDED_VALUE-1), new SkillMock(), new SkillMock()));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard("", new Aptitudes(ANY_VALUE, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE-1), new SkillMock(), new SkillMock()));
	}
}
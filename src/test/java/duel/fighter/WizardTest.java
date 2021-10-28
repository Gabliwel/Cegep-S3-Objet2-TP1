package duel.fighter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import skill.Skill;
import skill.mock.SkillMock;

public class WizardTest 
{
	public static final String ANY_NAME = "BOB";
	public static final int ADDED_VALUE = 15;
	public static final int ANY_VALUE = 5;
	public static final List<Skill> ANY_SKILL_LIST = Arrays.asList(new SkillMock(), new SkillMock());
	
	//orde des atributs dans l'object "Aptitudes": force - dextérité - intelligence - concentration
	//Test de l'intelligence du mage
	@Test
	void when_intelligenceIsEqualOrBiggerThanTheBiggestAptitudeBetweenStrengthAndDexterityPlusAddedValue_then_returnsNewWizard() 
	{
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE-1, ANY_VALUE, ANY_VALUE+ADDED_VALUE, 25), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE-1, ANY_VALUE+ADDED_VALUE, 25), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE, ANY_VALUE+ADDED_VALUE, 25), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE, ANY_VALUE+ADDED_VALUE+1, 25), ANY_SKILL_LIST));
	}
		
	@Test
	void when_intelligenceIsLowerThanTheBiggestAptitudeBetweenStregthAndDexterityPlusAddedValue_then_doesNotCreateWizard() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE-1, ANY_VALUE, ANY_VALUE+ADDED_VALUE-1, 25), ANY_SKILL_LIST));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE-1, ANY_VALUE+ADDED_VALUE-1, 25), ANY_SKILL_LIST));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE, ANY_VALUE+ADDED_VALUE-1, 25), ANY_SKILL_LIST));
	}
	
	//Test de la concentration du mage
	@Test
	void when_focusIsEqualOrBiggerThanTheBiggestAptitudeBetweenStrengthAndDexterityPlusAddedValue_then_returnsNewWizard() 
	{
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE-1, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE-1, 25, ANY_VALUE+ADDED_VALUE), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE+1), ANY_SKILL_LIST));
	}
			
	@Test
	void when_focusIsLowerThanTheBiggestAptitudeBetweenStregthAndDexterityPlusAddedValue_then_doesNotCreateWizard() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE-1, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE-1), ANY_SKILL_LIST));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE-1, 25, ANY_VALUE+ADDED_VALUE-1), ANY_SKILL_LIST));
		assertThrows(IllegalArgumentException.class, () -> 
		new Wizard(ANY_NAME, new Aptitudes(ANY_VALUE, ANY_VALUE, 25, ANY_VALUE+ADDED_VALUE-1), ANY_SKILL_LIST));
	}
}
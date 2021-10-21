package duel.fighter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import skill.SkillMock;

public class AthleteTest 
{
	public static final int MAX_ATHLETE_ATTRIBUTE_VALUE = 20;
	
	//orde des atributs dans l'object "Aptitudes": force - dextérité - intelligence - concentration
	//Test de la force de l'athlète
	@Test
	void when_strengthIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(MAX_ATHLETE_ATTRIBUTE_VALUE, 20, 20, 20), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(MAX_ATHLETE_ATTRIBUTE_VALUE+1, 20, 20, 20), new SkillMock(), new SkillMock()));
	}
	
	@Test
	void when_strengthIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Athlete("", new Aptitudes(MAX_ATHLETE_ATTRIBUTE_VALUE-1, 20, 20, 20), new SkillMock(), new SkillMock()));
	}
	
	//Test de la dextérité de l'athlète
	@Test
	void when_dexterityIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(20, MAX_ATHLETE_ATTRIBUTE_VALUE, 20, 20), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(20, MAX_ATHLETE_ATTRIBUTE_VALUE+1, 20, 20), new SkillMock(), new SkillMock()));
	}
		
	@Test
	void when_dexterityIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> new 
				Athlete("", new Aptitudes(20, MAX_ATHLETE_ATTRIBUTE_VALUE-1, 20, 20), new SkillMock(), new SkillMock()));
	}
		
	//Test de l'inteligence de l'athlète
	@Test
	void when_intelligenceIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE, 20), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE+1, 20), new SkillMock(), new SkillMock()));
	}
		
	@Test
	void when_intelligenceIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Athlete("", new Aptitudes(20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE-1, 20), new SkillMock(), new SkillMock()));
	}
		
	//Test de la concentration de l'athlète
	@Test
	void when_focusIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(20, 20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE), new SkillMock(), new SkillMock()));
		assertDoesNotThrow(() -> 
		new Athlete("", new Aptitudes(20, 20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE+1), new SkillMock(), new SkillMock()));
	}
		
	@Test
	void when_focusIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Athlete("", new Aptitudes(20, 20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE-1), new SkillMock(), new SkillMock()));
	}
}
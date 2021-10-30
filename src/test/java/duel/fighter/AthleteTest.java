package duel.fighter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import skill.Skill;
import skill.mock.SkillMock;

public class AthleteTest 
{
	public static final String ANY_NAME = "BOB";
	public static final int MAX_ATHLETE_ATTRIBUTE_VALUE = 20;
	public static final List<Skill> ANY_SKILL_LIST = Arrays.asList(new SkillMock(), new SkillMock());
	
	//orde des atributs dans l'object "Aptitudes": force - dextérité - intelligence - concentration
	//Test de la force de l'athlète
	@Test
	void when_strengthIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(MAX_ATHLETE_ATTRIBUTE_VALUE, 20, 20, 20), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(MAX_ATHLETE_ATTRIBUTE_VALUE+1, 20, 20, 20), ANY_SKILL_LIST));
	}
	
	@Test
	void when_strengthIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Athlete(ANY_NAME, new Aptitudes(MAX_ATHLETE_ATTRIBUTE_VALUE-1, 20, 20, 20), ANY_SKILL_LIST));
	}
	
	//Test de la dextérité de l'athlète
	@Test
	void when_dexterityIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(20, MAX_ATHLETE_ATTRIBUTE_VALUE, 20, 20), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(20, MAX_ATHLETE_ATTRIBUTE_VALUE+1, 20, 20), ANY_SKILL_LIST));
	}
		
	@Test
	void when_dexterityIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> new 
				Athlete(ANY_NAME, new Aptitudes(20, MAX_ATHLETE_ATTRIBUTE_VALUE-1, 20, 20), ANY_SKILL_LIST));
	}
		
	//Test de l'inteligence de l'athlète
	@Test
	void when_intelligenceIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE, 20), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE+1, 20), ANY_SKILL_LIST));
	}
		
	@Test
	void when_intelligenceIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Athlete(ANY_NAME, new Aptitudes(20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE-1, 20), ANY_SKILL_LIST));
	}
		
	//Test de la concentration de l'athlète
	@Test
	void when_focusIsEqualOrBiggerThanMaxAthleteAttributeValue_then_returnsNewAthlete() 
	{
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(20, 20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Athlete(ANY_NAME, new Aptitudes(20, 20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE+1), ANY_SKILL_LIST));
	}
		
	@Test
	void when_focusIsLessThanMaxAthleteAttributeValue_then_doesNotCreateAthlete() 
	{
		assertThrows(IllegalArgumentException.class, () -> 
		new Athlete(ANY_NAME, new Aptitudes(20, 20, 20, MAX_ATHLETE_ATTRIBUTE_VALUE-1), ANY_SKILL_LIST));
	}
}
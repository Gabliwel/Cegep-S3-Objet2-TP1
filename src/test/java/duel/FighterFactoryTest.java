package duel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import duel.fighter.*;
import skill.Skill;
import skill.mock.SkillMock;

public class FighterFactoryTest 
{
	public static final String ANY_NAME = "BOB";
	public static final List<Skill> ANY_SKILL_LIST = Arrays.asList(new SkillMock(), new SkillMock());
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsValideAthlete_then_returnAthlete() 
	{
		Athlete athlete = new Athlete(ANY_NAME, new Aptitudes(20, 20, 20, 20), ANY_SKILL_LIST);
		FighterFactory factory = new FighterFactory();
		assertEquals(athlete.getClass(), 
				factory.giveMeStrategyForFighter(FighterType.ATHLETE, ANY_NAME, 
						new Aptitudes(20, 20, 20, 20), ANY_SKILL_LIST).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsValideWarrior_then_returnWarrior() 
	{
		Warrior warrior = new Warrior(ANY_NAME, new Aptitudes(25, 15, 5, 0), ANY_SKILL_LIST);
		FighterFactory factory = new FighterFactory();
		assertEquals(warrior.getClass(), 
				factory.giveMeStrategyForFighter(FighterType.WARRIOR, ANY_NAME, 
						new Aptitudes(25, 15, 5, 0), ANY_SKILL_LIST).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsValideWizard_then_returnWizard() 
	{
		Wizard wizard = new Wizard(ANY_NAME, new Aptitudes(10, 10, 25, 25), ANY_SKILL_LIST);
		FighterFactory factory = new FighterFactory();
		assertEquals(wizard.getClass(), 
				factory.giveMeStrategyForFighter(FighterType.WIZARD, ANY_NAME, 
						new Aptitudes(10, 10, 25, 25), ANY_SKILL_LIST).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsNull_then_doesNotReturnFighterAndThrowsException() 
	{
		FighterFactory factory = new FighterFactory();
		assertThrows(IllegalArgumentException.class, () ->
				factory.giveMeStrategyForFighter(null, ANY_NAME, 
						new Aptitudes(10, 10, 25, 25), ANY_SKILL_LIST).getClass());
	}
	
	
}
package duel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import duel.fighter.*;

public class FighterFactoryTest 
{
	@Test
	void  when_givenStragtegyTypeInFactoryIsValideAthlete_then_returnAthlete() 
	{
		Athlete athlete = new Athlete("", new Aptitudes(20, 20, 20, 20), new SkillMock(), new SkillMock());
		FighterFactory factory = new FighterFactory();
		assertEquals(athlete.getClass(), 
				factory.giveMeStrategyForFighter(FighterType.Athlete, "bob", 
						new Aptitudes(20, 20, 20, 20), new SkillMock(), new SkillMock()).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsValideWarrior_then_returnWarrior() 
	{
		Warrior athlete = new Warrior("", new Aptitudes(25, 15, 5, 0), new SkillMock(), new SkillMock());
		FighterFactory factory = new FighterFactory();
		assertEquals(athlete.getClass(), 
				factory.giveMeStrategyForFighter(FighterType.Warrior, "bob", 
						new Aptitudes(25, 15, 5, 0), new SkillMock(), new SkillMock()).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsValideWizard_then_returnWizard() 
	{
		Wizard athlete = new Wizard("", new Aptitudes(10, 10, 25, 25), new SkillMock(), new SkillMock());
		FighterFactory factory = new FighterFactory();
		assertEquals(athlete.getClass(), 
				factory.giveMeStrategyForFighter(FighterType.Wizard, "bob", 
						new Aptitudes(10, 10, 25, 25), new SkillMock(), new SkillMock()).getClass());
	}
}
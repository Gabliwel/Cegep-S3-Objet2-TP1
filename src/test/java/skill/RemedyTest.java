package skill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import duel.Aptitudes;
import duel.FighterMock;

public class RemedyTest 
{
	@Test
	void when_checkIfRemedyIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(new Remedy(50).isAttackType());
	}
	
	@Test
	void when_checkIfRemedyIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(new Remedy(50).isParadeType());
	}
	
	@Test
	void when_checkIfRemedyIsAnHealingTypeSkill_then_returnsTrue()
	{
		assertTrue(new Remedy(50).isHealingType());
	}
	
	@Test
	void when_getsRemedyPower_then_returnsRemedyPowerBasedOnValueAndFighterAptitude()
	{
		int skillValue = 50;
		int focus = 4;
		Remedy skill = new Remedy(skillValue);
		FighterMock fighter = new FighterMock("", new Aptitudes(1, 2, 3, focus), skill, new SkillMock());
		int expectedResult = focus * skillValue / 100;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
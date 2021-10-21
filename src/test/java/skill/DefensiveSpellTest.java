package skill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import duel.FighterMock;

public class DefensiveSpellTest 
{
	@Test
	void when_checkIfDefensiveSpellIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(new DefensiveSpell(50).isAttackType());
	}
	
	@Test
	void when_checkIfDefensiveSpellIsAParadeTypeSkill_then_returnsTrue()
	{
		assertTrue(new DefensiveSpell(50).isParadeType());
	}
	
	@Test
	void when_checkIfDefensiveSpellIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(new DefensiveSpell(50).isHealingType());
	}
	
	@Test
	void when_getsDefensiveSpellPower_then_returnsDefensiveSpellPowerBasedOnValueAndFighterAptitude()
	{
		int skillValue = 50;
		int intelligence = 3;
		DefensiveSpell skill = new DefensiveSpell(skillValue);
		FighterMock fighter = new FighterMock("", new Aptitudes(1, 2, intelligence, 4), skill, new SkillMock());
		int expectedResult = (intelligence * skillValue / 100)*3;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
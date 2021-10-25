package skill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import duel.FighterMock;

public class HealerSpellTest 
{
	@Test
	void when_checkIfHealerSpellIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(new HealerSpell(50).isAttackType());
	}
	
	@Test
	void when_checkIfHealerSpellIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(new HealerSpell(50).isParadeType());
	}
	
	@Test
	void when_checkIfHealerSpellIsAnHealingTypeSkill_then_returnsTrue()
	{
		assertTrue(new HealerSpell(50).isHealingType());
	}
	
	@Test
	void when_getsHealerSpellPower_then_returnsHealerSpellPowerBasedOnValueAndFighterAptitude()
	{
		int skillValue = 50;
		int intelligence = 3;
		HealerSpell skill = new HealerSpell(skillValue);
		FighterMock fighter = new FighterMock("", new Aptitudes(1, 2, intelligence, 4), skill, new SkillMock());
		int expectedResult = intelligence * skillValue / 100;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
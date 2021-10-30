package skill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import duel.FighterMock;
import skill.mock.SkillMock;

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
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(skill);
		FighterMock fighter = new FighterMock("", new Aptitudes(1, 2, intelligence, 4), skillList);
		int expectedResult = intelligence * skillValue / 100;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
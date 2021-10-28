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

public class OffensiveSpellTest 
{
	@Test
	void when_checkIfOffensiveSpellIsAnAttackTypeSkill_then_returnsTrue()
	{
		assertTrue(new OffensiveSpell(50).isAttackType());
	}
	
	@Test
	void when_checkIfOffensiveSpellIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(new OffensiveSpell(50).isParadeType());
	}
	
	@Test
	void when_checkIfOffensiveSpellIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(new OffensiveSpell(50).isHealingType());
	}
	
	@Test
	void when_getsOffensiveSpellPower_then_returnsOffenisveSpellPowerBasedOnValueAndFighterAptitude()
	{
		int skillValue = 50;
		int intelligence = 3;
		OffensiveSpell skill = new OffensiveSpell(skillValue);
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(skill);
		FighterMock fighter = new FighterMock("", new Aptitudes(1, 2, intelligence, 4), skillList);
		int expectedResult = (intelligence * skillValue / 100)*3;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
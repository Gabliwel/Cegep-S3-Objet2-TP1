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

public class SwordTest 
{
	@Test
	void when_checkSwordIsAnAttackTypeSkill_then_returnsTrue()
	{
		assertTrue(new Sword(50).isAttackType());
	}
	
	@Test
	void when_checkIfSwordIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(new Sword(50).isParadeType());
	}
	
	@Test
	void when_checkIfSwordIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(new Sword(50).isHealingType());
	}
	
	@Test
	void when_getsSwordPower_then_returnsOffenisveSpellPowerBasedOnValueAndFighterAptitude()
	{
		int skillValue = 50;
		int strengtht = 1;
		Sword skill = new Sword(skillValue);
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(skill);
		FighterMock fighter = new FighterMock("", new Aptitudes(strengtht, 2, 3, 4), skillList);
		int expectedResult = strengtht * skillValue / 100;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
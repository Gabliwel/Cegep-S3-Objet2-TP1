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
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(skill);
		FighterMock fighter = new FighterMock("", new Aptitudes(1, 2, 3, focus), skillList);
		int expectedResult = focus * skillValue / 100;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
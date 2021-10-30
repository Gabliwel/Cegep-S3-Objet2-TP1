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

public class ShieldTest 
{
	@Test
	void when_checkIfShieldIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(new Shield(50).isAttackType());
	}
	
	@Test
	void when_checkIfShieldIsAParadeTypeSkill_then_returnsTrue()
	{
		assertTrue(new Shield(50).isParadeType());
	}
	
	@Test
	void when_checkIfShieldIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(new Shield(50).isHealingType());
	}
	
	@Test
	void when_getsShieldPower_then_returnsShieldPowerBasedOnValueAndFighterAptitude()
	{
		int skillValue = 50;
		int dexterity = 2;
		Shield skill = new Shield(skillValue);
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(skill);
		FighterMock fighter = new FighterMock("", new Aptitudes(1, dexterity, 3, 4), skillList);
		int expectedResult = dexterity * skillValue / 100;
		int result = skill.getPower(fighter);
		assertEquals(expectedResult, result);
	}
}
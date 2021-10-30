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
	public static final Shield ANY_SHIELD = new Shield(50);
	
	@Test
	void when_checkIfShieldIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_SHIELD.isAttackType());
	}
	
	@Test
	void when_checkIfShieldIsAParadeTypeSkill_then_returnsTrue()
	{
		assertTrue(ANY_SHIELD.isParadeType());
	}
	
	@Test
	void when_checkIfShieldIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_SHIELD.isHealingType());
	}
	
	@Test
	void when_getsShieldPower_then_returnsShieldPowerBasedOnValueAndFighterAptitude()
	{
		//Arrange
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(ANY_SHIELD);
		FighterMock fighter = new FighterMock("", new Aptitudes(5, 2, 5, 5), skillList);
		int expectedResult = 1;
		
		//Act
		int result = ANY_SHIELD.getPower(fighter);
		
		//Assert
		assertEquals(expectedResult, result);
	}
}
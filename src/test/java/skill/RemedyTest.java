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
	public static final Remedy ANY_REMDY = new Remedy(50);
	
	@Test
	void when_checkIfRemedyIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_REMDY.isAttackType());
	}
	
	@Test
	void when_checkIfRemedyIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_REMDY.isParadeType());
	}
	
	@Test
	void when_checkIfRemedyIsAnHealingTypeSkill_then_returnsTrue()
	{
		assertTrue(ANY_REMDY.isHealingType());
	}
	
	@Test
	void when_getsRemedyPower_then_returnsRemedyPowerBasedOnValueAndFighterAptitude()
	{
		//Arrange
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(ANY_REMDY);
		FighterMock fighter = new FighterMock("", new Aptitudes(5, 5, 5, 2), skillList);
		int expectedResult = 1;
		
		//Act
		int result = ANY_REMDY.getPower(fighter);
		
		//Assert
		assertEquals(expectedResult, result);
	}
}
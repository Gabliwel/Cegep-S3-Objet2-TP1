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
	public static final Sword ANY_SWORD = new Sword(50);
	
	@Test
	void when_checkSwordIsAnAttackTypeSkill_then_returnsTrue()
	{
		assertTrue(ANY_SWORD.isAttackType());
	}
	
	@Test
	void when_checkIfSwordIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_SWORD.isParadeType());
	}
	
	@Test
	void when_checkIfSwordIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_SWORD.isHealingType());
	}
	
	@Test
	void when_getsSwordPower_then_returnsOffenisveSpellPowerBasedOnValueAndFighterAptitude()
	{
		//Arrange
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(ANY_SWORD);
		FighterMock fighter = new FighterMock("", new Aptitudes(2, 5, 5, 5), skillList);
		int expectedResult = 1;
		
		//Act
		int result = ANY_SWORD.getPower(fighter);
		
		//Assert
		assertEquals(expectedResult, result);
	}
}
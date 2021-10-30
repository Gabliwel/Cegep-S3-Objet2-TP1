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

public class DefensiveSpellTest 
{
	public static final DefensiveSpell ANY_DEFENSIVE_SPELL = new DefensiveSpell(50);
	
	@Test
	void when_checkIfDefensiveSpellIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_DEFENSIVE_SPELL.isAttackType());
	}
	
	@Test
	void when_checkIfDefensiveSpellIsAParadeTypeSkill_then_returnsTrue()
	{
		assertTrue(ANY_DEFENSIVE_SPELL.isParadeType());
	}
	
	@Test
	void when_checkIfDefensiveSpellIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_DEFENSIVE_SPELL.isHealingType());
	}
	
	@Test
	void when_getsDefensiveSpellPower_then_returnsDefensiveSpellPowerBasedOnValueAndFighterAptitude()
	{
		//Arrange
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(ANY_DEFENSIVE_SPELL);
		FighterMock fighter = new FighterMock("", new Aptitudes(5, 5, 2, 5), skillList);
		int expectedResult = 3;
		
		//Act
		int result = ANY_DEFENSIVE_SPELL.getPower(fighter);
		
		//Assert
		assertEquals(expectedResult, result);
	}
}
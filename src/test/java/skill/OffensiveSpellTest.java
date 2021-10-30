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
	public static final OffensiveSpell ANY_OFFENSIVESPELL = new OffensiveSpell(50);
	@Test
	void when_checkIfOffensiveSpellIsAnAttackTypeSkill_then_returnsTrue()
	{
		assertTrue(ANY_OFFENSIVESPELL.isAttackType());
	}
	
	@Test
	void when_checkIfOffensiveSpellIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_OFFENSIVESPELL.isParadeType());
	}
	
	@Test
	void when_checkIfOffensiveSpellIsAnHealingTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_OFFENSIVESPELL.isHealingType());
	}
	
	@Test
	void when_getsOffensiveSpellPower_then_returnsOffenisveSpellPowerBasedOnValueAndFighterAptitude()
	{
		//Arrange
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(ANY_OFFENSIVESPELL);
		FighterMock fighter = new FighterMock("", new Aptitudes(5, 5, 2, 5), skillList);
		int expectedResult = 3;
		
		//Act
		int result = ANY_OFFENSIVESPELL.getPower(fighter);
		
		//Assert
		assertEquals(expectedResult, result);
	}
}
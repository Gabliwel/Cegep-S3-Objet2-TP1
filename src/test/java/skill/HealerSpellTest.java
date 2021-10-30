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
	public static final HealerSpell ANY_HEALER_SPELL = new HealerSpell(50);
	
	@Test
	void when_checkIfHealerSpellIsAnAttackTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_HEALER_SPELL.isAttackType());
	}
	
	@Test
	void when_checkIfHealerSpellIsAParadeTypeSkill_then_returnsFalse()
	{
		assertFalse(ANY_HEALER_SPELL.isParadeType());
	}
	
	@Test
	void when_checkIfHealerSpellIsAnHealingTypeSkill_then_returnsTrue()
	{
		assertTrue(ANY_HEALER_SPELL.isHealingType());
	}
	
	@Test
	void when_getsHealerSpellPower_then_returnsHealerSpellPowerBasedOnValueAndFighterAptitude()
	{
		//Arrange
		List<Skill> skillList = new ArrayList<Skill>();
		skillList.add(new SkillMock());
		skillList.add(ANY_HEALER_SPELL);
		FighterMock fighter = new FighterMock("", new Aptitudes(5, 5, 2, 5), skillList);
		int expectedResult = 1;
		
		//Act
		int result = ANY_HEALER_SPELL.getPower(fighter);
		
		//Assert
		assertEquals(expectedResult, result);
	}
}
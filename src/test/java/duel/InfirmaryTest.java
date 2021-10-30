package duel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import skill.Skill;
import skill.mock.HealSkillMock;
import skill.mock.SkillMock;

public class InfirmaryTest 
{
	public static final Infirmary INFIRMARY = new Infirmary();
	public static final int TOTAL_APTITUDES = 100;
	public static final Aptitudes ANY_APTITUDES = new Aptitudes(25, 25, 25, 25);
	public static final String ANY_NAME = "BOB";
	public static final HealSkillMock ANY_HEAL_SKILL = new HealSkillMock();
	public static final List<Skill> ANY_SKILL_LIST = Arrays.asList(new SkillMock(), ANY_HEAL_SKILL);
	
	@Test
	void when_givenFighterInInfirmaryIsNull_then_errorIsThrownAndNoOneIsHealed()
	{
		assertThrows(IllegalArgumentException.class, () -> INFIRMARY.heal(null, ANY_HEAL_SKILL));
	}
	
	@Test
	void when_givenFighterInInfirmaryIsDead_then_errorIsThrownAndNoOneIsHealed()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		fighter.decreaseHealthPoints(200);
		assertThrows(IllegalArgumentException.class, () -> INFIRMARY.heal(fighter, ANY_HEAL_SKILL));
	}
	
	@Test
	void when_givenSkillInInfirmaryIsNull_then_errorIsThrownAndNoOneIsHealed()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		assertThrows(IllegalArgumentException.class, () -> INFIRMARY.heal(fighter, null));
	}
	
	@Test
	void when_givenSkillInInfirmaryIsNotHealingType_then_errorIsThrownAndNoOneIsHealed()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		assertThrows(IllegalArgumentException.class, () -> INFIRMARY.heal(fighter, new SkillMock()));
	}
	
	@Test
	void when_givenSkillInInfirmaryIsNoInFighterSkills_then_errorIsThrownAndNoOneIsHealed()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		assertThrows(IllegalArgumentException.class, () -> INFIRMARY.heal(fighter, new HealSkillMock()));
	}
	
	@Test
	void when_givenFighterIsHealed_then_fighterLooseUsedHealSkillAndGainSkillPowerAsHealth()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		INFIRMARY.heal(fighter, ANY_HEAL_SKILL);
		//Le force du HealSkillMock est de 1
		assertEquals(fighter.getHealthPoints(), TOTAL_APTITUDES +1);
		assertFalse(fighter.hasTheSkill(ANY_HEAL_SKILL));
	}
}
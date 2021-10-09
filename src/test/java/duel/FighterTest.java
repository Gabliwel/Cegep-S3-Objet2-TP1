package duel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FighterTest 
{
	public static final Aptitudes ANY_APTITUDES = new Aptitudes(25, 25, 25, 25);
	public static final int DEAD_HEALTH_VALUE = 0;
	
	//test de la valeur des points de vie
	@Test
	void when_createNewFighter_then_healthIsEqualTo200MinusAllAttributes() 
	{
		FighterMock fighter = new FighterMock("", ANY_APTITUDES, new SkillMock(), new SkillMock());
		int health = fighter.getHealthPoints();
		int expectedHealth = 200 - (fighter.getDexterity()+fighter.getFocus()+fighter.getIntelligence()+fighter.getStrength());
		assertEquals(expectedHealth, health);
	}
	
	@Test
	void when_fighterIsAttacked_then_healthIsEqualToFighterHealthMinusAttack() 
	{
		FighterMock fighter = new FighterMock("", ANY_APTITUDES, new SkillMock(), new SkillMock());
		int attack = 20;
		int expectedHealth = fighter.getHealthPoints()-attack;
		fighter.decreaseHealthPoints(attack);
		int health = fighter.getHealthPoints();
		assertEquals(expectedHealth, health);
	}
	
	@Test
	void when_fighterDamageIsEqualToHealth_then_healthIsEqualToDeadHeakthValue() 
	{
		FighterMock fighter = new FighterMock("", ANY_APTITUDES, new SkillMock(), new SkillMock());
		int attack = 100;
		fighter.decreaseHealthPoints(attack);
		int health = fighter.getHealthPoints();
		assertEquals(DEAD_HEALTH_VALUE, health);
	}
	
	@Test
	void when_fighterHasDeadHealthValue_then_fighterIsNotAlive() 
	{
		FighterMock fighter = new FighterMock("", ANY_APTITUDES, new SkillMock(), new SkillMock());
		int attack = 100;
		fighter.decreaseHealthPoints(attack);
		assertFalse(fighter.isAlive());
	}
	
	@Test
	void when_fighterHasMoreHealthThanDeadHealthValue_then_fighterIsAlive() 
	{
		FighterMock fighter = new FighterMock("", ANY_APTITUDES, new SkillMock(), new SkillMock());
		int attack = 99;
		assertTrue(fighter.isAlive());
		fighter.decreaseHealthPoints(attack);
		assertTrue(fighter.isAlive());
	}
	
	//test des capacitées
	@Test
	void when_fighterSearchForSkillThatNeverHasBeenGiven_then_fighterHasNotTheSkill() 
	{
		SkillMock skill1 = new SkillMock();
		SkillMock skill2 = new SkillMock();
		SkillMock skill3 = new SkillMock();
		FighterMock fighter = new FighterMock("", ANY_APTITUDES, skill1, skill2);
		assertFalse(fighter.hasTheSkill(skill3));
	}
	
	@Test
	void when_fighterSearchForSkillThatHasBeenGiven_then_fighterHasTheSkill() 
	{
		SkillMock skill1 = new SkillMock();
		SkillMock skill2 = new SkillMock();
		FighterMock fighter = new FighterMock("", ANY_APTITUDES, skill1, skill2);
		assertTrue(fighter.hasTheSkill(skill2));
	}
}
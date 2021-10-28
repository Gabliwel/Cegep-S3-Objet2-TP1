package duel;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import skill.Skill;
import skill.mock.AttackSkillMock;
import skill.mock.HealSkillMock;
import skill.mock.ParadeSkillMock;
import skill.mock.SkillMock;

public class FighterTest 
{
	public static final String ANY_NAME = "BOB";
	public static final Aptitudes ANY_APTITUDES = new Aptitudes(25, 25, 25, 25);
	public static final int DEAD_HEALTH_VALUE = 0;
	public static final List<Skill> ANY_SKILL_LIST = Arrays.asList(new SkillMock(), new SkillMock());
	
	//test de la valeur des points de vie
	@Test
	void when_createNewFighter_then_healthIsEqualTo200MinusAllAttributes() 
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		int health = fighter.getHealthPoints();
		int expectedHealth = 200 - (fighter.getDexterity()+fighter.getFocus()+fighter.getIntelligence()+fighter.getStrength());
		assertEquals(expectedHealth, health);
	}
	
	@Test
	void when_fighterIsAttacked_then_healthIsEqualToFighterHealthMinusAttack() 
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		int attack = 20;
		int expectedHealth = fighter.getHealthPoints()-attack;
		fighter.decreaseHealthPoints(attack);
		int health = fighter.getHealthPoints();
		assertEquals(expectedHealth, health);
	}
	
	@Test
	void when_fighterDamageIsEqualToHealth_then_healthIsEqualToDeadHeakthValue() 
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		int attack = 100;
		fighter.decreaseHealthPoints(attack);
		int health = fighter.getHealthPoints();
		assertEquals(DEAD_HEALTH_VALUE, health);
	}
	
	@Test
	void when_fighterHasDeadHealthValue_then_fighterIsNotAlive() 
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		int attack = 100;
		fighter.decreaseHealthPoints(attack);
		assertFalse(fighter.isAlive());
	}
	
	@Test
	void when_fighterHasMoreHealthThanDeadHealthValue_then_fighterIsAlive() 
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
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
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(skill1);
		skills.add(skill2);
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertFalse(fighter.hasTheSkill(skill3));
	}
	
	@Test
	void when_fighterSearchForSkillThatHasBeenGiven_then_fighterHasTheSkill() 
	{
		SkillMock skill1 = new SkillMock();
		SkillMock skill2 = new SkillMock();
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(skill1);
		skills.add(skill2);
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertTrue(fighter.hasTheSkill(skill2));
	}
	
	//test de la liste de skill
	@Test
	void when_fighterHasValidSkillList_then_figtherIsCreated()
	{
		assertDoesNotThrow(() -> new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST));
	}
	
	@Test
	void when_fighterHasNullSkillList_then_figtherIsNotCreated()
	{
		assertThrows(IllegalArgumentException.class, () -> new FighterMock(ANY_NAME, ANY_APTITUDES, null));
	}
	
	@Test
	void when_fighterHasLessOrMoreThan2SkillInSkillList_then_figtherIsNotCreated()
	{
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(new SkillMock());
		
		assertThrows(IllegalArgumentException.class, () -> new FighterMock(ANY_NAME, ANY_APTITUDES, skills));
		
		skills.add(new SkillMock());
		skills.add(new SkillMock());
		
		assertThrows(IllegalArgumentException.class, () -> new FighterMock(ANY_NAME, ANY_APTITUDES, skills));
	}
	
	@Test
	void when_fighterHasNullSkillInSkillList_then_figtherIsNotCreated()
	{
		List<Skill> list1 = Arrays.asList(null, new SkillMock());
		List<Skill> list2 = Arrays.asList(new SkillMock(), null);
		List<Skill> list3 = Arrays.asList(null, null);
		
		assertThrows(IllegalArgumentException.class, () -> new FighterMock(ANY_NAME, ANY_APTITUDES, list1));
		assertThrows(IllegalArgumentException.class, () -> new FighterMock(ANY_NAME, ANY_APTITUDES, list2));
		assertThrows(IllegalArgumentException.class, () -> new FighterMock(ANY_NAME, ANY_APTITUDES, list3));
	}
	
	//test de la gestion des skills
	@Test
	void when_fighterRemovesSkill_then_fighterDoesntHaveTheSkillAnymore()
	{
		SkillMock skill = new SkillMock();
		List<Skill> skills = Arrays.asList(new SkillMock(), skill);
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		fighter.removeSkill(skill);
		assertFalse(fighter.hasTheSkill(skill));
	}
	
	@Test
	void when_fighterHasAttackTypeSkill_then_fighterCanAttackAndDefend()
	{
		List<Skill> skills = Arrays.asList(new SkillMock(), new AttackSkillMock(1));
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertTrue(fighter.canAttack());
		assertTrue(fighter.canDefend());
	}
	
	@Test
	void when_fighterHasHealSkillOrParadeSkill_then_fighterCantAttack()
	{
		List<Skill> skills = Arrays.asList(new ParadeSkillMock(), new HealSkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertFalse(fighter.canAttack());
	}
	
	@Test
	void when_fighterHasParadeSkill_then_fighterCanDefend()
	{
		List<Skill> skills = Arrays.asList(new ParadeSkillMock(), new SkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertTrue(fighter.canDefend());
	}
	
	@Test
	void when_fighterHasHealSkill_then_fighterCantDefend()
	{
		List<Skill> skills = Arrays.asList(new SkillMock(), new HealSkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertFalse(fighter.canDefend());
	}
	
	@Test
	void when_getAttackAndFighterHasHealSkillOrParadeSkill_then_fighterCantGetAttack()
	{
		List<Skill> skills = Arrays.asList(new ParadeSkillMock(), new HealSkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertThrows(IllegalArgumentException.class, () -> fighter.getAttack());
	}
	
	@Test
	void when_getAttackAndFighterHasAttackSkill_then_fighterCanGetAttack()
	{
		List<Skill> skills = Arrays.asList(new AttackSkillMock(1), new SkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertDoesNotThrow(() -> fighter.getAttack());
	}
	
	@Test
	void when_getDefenseAndFighterHasAttackSkill_then_fighterCanGetDefense()
	{
		List<Skill> skills = Arrays.asList(new AttackSkillMock(1), new SkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertDoesNotThrow(() -> fighter.getDefense());
	}
	
	@Test
	void when_getDefenseAndFighterHasParadeSkill_then_fighterCanGetDefense()
	{
		List<Skill> skills = Arrays.asList(new ParadeSkillMock(), new SkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertDoesNotThrow(() -> fighter.getDefense());
	}
	
	@Test
	void when_getDefenseAndFighterHasHealSkill_then_fighterCantGetDenfense()
	{
		List<Skill> skills = Arrays.asList(new SkillMock(), new HealSkillMock());
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, skills);
		assertThrows(IllegalArgumentException.class, () -> fighter.getDefense());
	}
}
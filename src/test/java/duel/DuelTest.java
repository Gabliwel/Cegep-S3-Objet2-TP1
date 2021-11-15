package duel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import skill.Skill;
import skill.mock.AttackSkillMock;
import skill.mock.SkillMock;

public class DuelTest 
{
	public static final int MAX_HEALTH = 200;
	public static final int TOTAL_APTITUDES = 100;
	public static final Aptitudes ANY_APTITUDES = new Aptitudes(25, 25, 25, 25);
	public static final String ANY_NAME = "BOB";
	public static final List<Skill> ANY_SKILL_LIST = Arrays.asList(new SkillMock(), new SkillMock());
	
	@Test
	void when_creatingDuelAndInitiatorFighterIsNull_then_doesNotCreateDuel()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		assertThrows(IllegalArgumentException.class, () -> new Duel(fighter, null));
	}
	
	@Test
	void when_creatingDuelAndProvokedFighterIsNull_then_doesNotCreateDuel()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		assertThrows(IllegalArgumentException.class, () -> new Duel(null, fighter));
	}
	
	@Test
	void when_creatingDuelAndProvokedFighterAndInitiatorAreTheSameFighter_then_doesNotCreateDuel()
	{
		FighterMock fighter = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		assertThrows(IllegalArgumentException.class, () -> new Duel(fighter, fighter));
	}
	
	@Test
	void when_doingDuelAndProvokedFighterIsDead_then_duelCannotBeDoneAndThrowException()
	{
		FighterMock initiator = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		FighterMock provoked = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		Duel duel = new Duel(initiator, provoked);
		provoked.decreaseHealthPoints(200);
		assertThrows(IllegalArgumentException.class, () -> duel.fight(new SkillMock()));
	}
	
	@Test
	void when_doingDuelAndInitiatorFighterIsDead_then_duelCannotBeDoneAndThrowException()
	{
		FighterMock initiator = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		FighterMock provoked = new FighterMock(ANY_NAME, ANY_APTITUDES, ANY_SKILL_LIST);
		Duel duel = new Duel(initiator, provoked);
		initiator.decreaseHealthPoints(200);
		assertThrows(IllegalArgumentException.class, () -> duel.fight(new SkillMock()));
	}
	
	@Test
	void when_doingDuelAndInitiatorFighterCantAttack_then_provokedFigtherWinsRewardAndInitiatorLooseNoHealth()
	{
		//FIXME: Évite toi du setup pour rien en surchargeant des constructeurs!
		FighterMock initiator = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), ANY_SKILL_LIST);
		FighterMock provoked = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), ANY_SKILL_LIST);
		Duel duel = new Duel(initiator, provoked);
		SkillMock reward = new SkillMock();
		duel.fight(reward);
		assertTrue(provoked.hasTheSkill(reward));
		testAptitudes(provoked, 26);
		testAptitudes(initiator, 24);
		assertEquals(initiator.getHealthPoints(), MAX_HEALTH - TOTAL_APTITUDES);
	}
	
	@Test
	void when_doingDuelAndInitiatorCanAttackAndProkedCantDefend_then_initiatorWinsRewardAndProvokedLooseNoHealth()
	{
		List<Skill> skillInitiator = Arrays.asList(new SkillMock(), new AttackSkillMock(1));
		FighterMock initiator = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), skillInitiator);
		FighterMock provoked = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), ANY_SKILL_LIST);
		Duel duel = new Duel(initiator, provoked);
		SkillMock reward = new SkillMock();
		duel.fight(reward);
		assertTrue(initiator.hasTheSkill(reward));
		testAptitudes(provoked, 24);
		testAptitudes(initiator, 26);
		assertEquals(provoked.getHealthPoints(), MAX_HEALTH - TOTAL_APTITUDES);
	}
	
	@Test
	void when_doingDuelAndInitiatorHasHigherPowerThenProvoked_then_initiatorWinsRewardAndProvokedLooseHealth()
	{
		List<Skill> skillInitiator = Arrays.asList(new SkillMock(), new AttackSkillMock(2));
		List<Skill> skillProvoked = Arrays.asList(new SkillMock(), new AttackSkillMock(1));
		FighterMock initiator = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), skillInitiator);
		FighterMock provoked = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), skillProvoked);
		Duel duel = new Duel(initiator, provoked);
		SkillMock reward = new SkillMock();
		duel.fight(reward);
		assertTrue(initiator.hasTheSkill(reward));
		testAptitudes(provoked, 24);
		testAptitudes(initiator, 26);
		assertEquals(provoked.getHealthPoints(), MAX_HEALTH - TOTAL_APTITUDES - 2);
	}
	
	@Test
	void when_doingDuelAndInitiatorHasEqualPowerThenProvoked_then_initiatorWinsRewardAndProvokedLooseHealth()
	{
		List<Skill> skillInitiator = Arrays.asList(new SkillMock(), new AttackSkillMock(1));
		List<Skill> skillProvoked = Arrays.asList(new SkillMock(), new AttackSkillMock(1));
		FighterMock initiator = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), skillInitiator);
		FighterMock provoked = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), skillProvoked);
		Duel duel = new Duel(initiator, provoked);
		SkillMock reward = new SkillMock();
		duel.fight(reward);
		assertTrue(initiator.hasTheSkill(reward));
		testAptitudes(provoked, 24);
		testAptitudes(initiator, 26);
		assertEquals(provoked.getHealthPoints(), MAX_HEALTH - TOTAL_APTITUDES - 1);
	}
	
	@Test
	void when_doingDuelAndInitiatorHasLowerPowerThenProvoked_then_provokedWinsRewardAndInitiatorLooseHealth()
	{
		List<Skill> skillInitiator = Arrays.asList(new SkillMock(), new AttackSkillMock(1));
		List<Skill> skillProvoked = Arrays.asList(new SkillMock(), new AttackSkillMock(2));
		FighterMock initiator = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), skillInitiator);
		FighterMock provoked = new FighterMock(ANY_NAME, new Aptitudes(25, 25, 25, 25), skillProvoked);
		Duel duel = new Duel(initiator, provoked);
		SkillMock reward = new SkillMock();
		duel.fight(reward);
		assertTrue(provoked.hasTheSkill(reward));
		testAptitudes(initiator, 24);
		testAptitudes(provoked, 26);
		assertEquals(initiator.getHealthPoints(), MAX_HEALTH - TOTAL_APTITUDES - 2);
	}
	
	//pour permettre de tester toutes les aptitudes d'un fighter donné
	private void testAptitudes(FighterMock fighter, int expectedValue)
	{
		assertEquals(fighter.getStrength(), expectedValue);
		assertEquals(fighter.getDexterity(), expectedValue);
		assertEquals(fighter.getIntelligence(), expectedValue);
		assertEquals(fighter.getFocus(), expectedValue);
	}
}
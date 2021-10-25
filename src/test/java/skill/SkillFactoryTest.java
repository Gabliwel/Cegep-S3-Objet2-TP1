package skill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import skill.type.*;

public class SkillFactoryTest 
{
	//Attack skill type method
	@Test
	void  when_givenStragtegyTypeInFactoryForAttackSkillIsSword_then_returnNewSword() 
	{
		Sword skill = new Sword(50);
		SkillFactory factory = new SkillFactory();
		assertEquals(skill.getClass(), factory.giveMeStrategyForAttackSkill(AttackSkillType.SWORD, 50).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryForAttackSkillIsOffensiveSpell_then_returnNewOffensiveSpell() 
	{
		OffensiveSpell skill = new OffensiveSpell(50);
		SkillFactory factory = new SkillFactory();
		assertEquals(skill.getClass(), factory.giveMeStrategyForAttackSkill(AttackSkillType.OFFENSIVE_SPELL, 50).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryForAttackSkillIsNull_then_illegalArgumentExceptionIsThrown() 
	{
		SkillFactory factory = new SkillFactory();
		assertThrows(IllegalArgumentException.class, () -> factory.giveMeStrategyForAttackSkill(null, 50));
	}
	
	//Parade skill type method
	@Test
	void  when_givenStragtegyTypeInFactoryForParadeSkillIsShield_then_returnNewShield() 
	{
		Shield skill = new Shield(50);
		SkillFactory factory = new SkillFactory();
		assertEquals(skill.getClass(), factory.giveMeStrategyForParadeSkill(ParadeSkillType.SHIELD, 50).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryForParadeSkillIsDefensiveSpell_then_returnNewDefensiveSpell() 
	{
		DefensiveSpell skill = new DefensiveSpell(50);
		SkillFactory factory = new SkillFactory();
		assertEquals(skill.getClass(), factory.giveMeStrategyForParadeSkill(ParadeSkillType.DEFENSIVE_SPELL, 50).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryForParadeSkillIsNull_then_illegalArgumentExceptionIsThrown() 
	{
		SkillFactory factory = new SkillFactory();
		assertThrows(IllegalArgumentException.class, () -> factory.giveMeStrategyForParadeSkill(null, 50));
	}
	
	//Healing skill type method
	@Test
	void  when_givenStragtegyTypeInFactoryForHealingSkillIsRemedy_then_returnNewRemedy() 
	{
		Remedy skill = new Remedy(50);
		SkillFactory factory = new SkillFactory();
		assertEquals(skill.getClass(), factory.giveMeStrategyForHealingSkill(HealingSkillType.REMEDY, 50).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryForHealingSkillIsHealerSpell_then_returnNewHealerSpell() 
	{
		HealerSpell skill = new HealerSpell(50);
		SkillFactory factory = new SkillFactory();
		assertEquals(skill.getClass(), factory.giveMeStrategyForHealingSkill(HealingSkillType.HEALER_SPELL, 50).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryForHealingSkillIsNull_then_illegalArgumentExceptionIsThrown() 
	{
		SkillFactory factory = new SkillFactory();
		assertThrows(IllegalArgumentException.class, () -> factory.giveMeStrategyForHealingSkill(null, 50));
	}
}
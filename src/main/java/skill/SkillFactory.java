package skill;

import duel.Skill;
import skill.type.*;

public class SkillFactory 
{
	public Skill giveMeStrategyForAttackSkill(AttackSkillType type, int value)
	{
		if(type != null)
		{
			Skill skill = switch(type)
			{
				case SWORD -> new Sword(value);
				case OFFENSIVE_SPELL -> new OffensiveSpell(value);
			};
			return skill;
		}
		throw new IllegalArgumentException("The attack skill type should be defined");
	}
	
	public Skill giveMeStrategyForParadeSkill(ParadeSkillType type, int value)
	{
		if(type != null)
		{
			Skill skill = switch(type)
			{
				case SHIELD -> new Shield(value);
				case DEFENSIVE_SPELL -> new DefensiveSpell(value);
			};
			return skill;
		}
		throw new IllegalArgumentException("The parade skill type should be defined");
	}
	
	public Skill giveMeStrategyForHealingSkill(HealingSkillType type, int value)
	{
		if(type != null)
		{
			Skill skill = switch(type)
			{
				case HEALER_SPELL -> new HealerSpell(value);
				case REMEDY -> new Remedy(value);
			};
			return skill;
		}
		throw new IllegalArgumentException("The healing skill type should be defined");
	}
}
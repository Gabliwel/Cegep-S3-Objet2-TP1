package skill.mock;

import duel.Fighter;
import skill.Skill;

public class AttackSkillMock implements Skill
{
	private int power;
	
	public AttackSkillMock(int power) 
	{
		this.power = power;
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return this.power;
	}

	@Override
	public String toString() 
	{
		return "";
	}

	@Override
	public boolean isAttackType() 
	{
		return true;
	}

	@Override
	public boolean isParadeType() 
	{
		return false;
	}

	@Override
	public boolean isHealingType() 
	{
		return false;
	}
}
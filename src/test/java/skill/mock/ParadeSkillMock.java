package skill.mock;

import duel.Fighter;
import skill.Skill;

public class ParadeSkillMock implements Skill
{
	@Override
	public int getPower(Fighter fighter) 
	{
		return 1;
	}
	
	@Override
	public String toString() 
	{
		return "";
	}

	@Override
	public boolean isAttackType() 
	{
		return false;
	}

	@Override
	public boolean isParadeType() 
	{
		return true;
	}

	@Override
	public boolean isHealingType() 
	{
		return false;
	}
}
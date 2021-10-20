package duel;

public class SkillMock implements Skill
{
	@Override
	public int getPower(Fighter fighter) 
	{
		return 0;
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
		return false;
	}

	@Override
	public boolean isHealingType() 
	{
		return false;
	}
}
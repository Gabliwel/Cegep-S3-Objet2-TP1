package skill;
import duel.Fighter;
import duel.Skill;

public class OffensiveSpell extends BasicSkill implements Skill
{
	public OffensiveSpell(int efficiency)
	{
		super(efficiency);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return (fighter.getIntelligence() * super.getValue() / 100) * 3;
	}
	
	@Override
	public String toString() 
	{
		return "Offensive spell efficiency = " + super.getValue() + "\n";
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
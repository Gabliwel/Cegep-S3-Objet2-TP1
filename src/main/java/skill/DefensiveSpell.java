package skill;
import duel.Fighter;

public class DefensiveSpell extends BasicSkill implements Skill
{	
	public DefensiveSpell(int intensity)
	{
		super(intensity);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return (fighter.getIntelligence() * super.getValue() / 100) * 3;
	}

	@Override
	public String toString() 
	{
		return "Defensive spell intensity = " + super.getValue() + "\n";
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
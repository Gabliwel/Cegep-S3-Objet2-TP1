package skill;
import duel.Fighter;

public class OffensiveSpell extends BasicSkill implements Skill
{
	public OffensiveSpell(int efficiency)
	{
		super(efficiency);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		//FIXME: Constante magique, à extraire! (G25)
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
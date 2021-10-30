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
		return (fighter.getIntelligence() * super.getValue() / DIVISION_VALUE) * MULTIPLICATION_VALUE;
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
}
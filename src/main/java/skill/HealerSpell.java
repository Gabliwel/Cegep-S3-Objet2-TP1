package skill;
import duel.Fighter;

public class HealerSpell extends BasicSkill implements Skill
{	
	public HealerSpell(int energie)
	{
		super(energie);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return fighter.getIntelligence() * super.getValue() / DIVISION_VALUE;
	}
	
	@Override
	public String toString() 
	{
		return "Healer spell energie = " + super.getValue() + "\n";
	}
	
	@Override
	public boolean isHealingType() 
	{
		return true;
	}
}
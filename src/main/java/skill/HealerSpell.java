package skill;
import duel.Fighter;
import duel.Skill;

public class HealerSpell extends BasicSkill implements Skill
{	
	public HealerSpell(int energie)
	{
		super(energie);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return fighter.getIntelligence() * super.getValue() / 100;
	}
	
	@Override
	public String toString() 
	{
		return "Healer spell energie = " + super.getValue() + "\n";
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
		return true;
	}
}
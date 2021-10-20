package skill;
import duel.Fighter;
import duel.Skill;

public class Shield extends BasicSkill implements Skill
{
	public Shield(int protection)
	{
		super(protection);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return fighter.getDexterity() * super.getValue() / 100;
	}
	
	@Override
	public String toString() 
	{
		return "Shield protection = " + super.getValue() + "\n";
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
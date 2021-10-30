package skill;
import duel.Fighter;

public class Remedy extends BasicSkill implements Skill
{
	public Remedy(int strenght)
	{
		super(strenght);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return fighter.getFocus() * super.getValue() / DIVISION_VALUE;
	}
	
	@Override
	public String toString() 
	{
		return "Remedy strenght = " + super.getValue() + "\n";
	}

	@Override
	public boolean isHealingType() 
	{
		return true;
	}
}
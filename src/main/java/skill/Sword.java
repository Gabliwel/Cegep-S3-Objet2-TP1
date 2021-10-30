package skill;
import duel.Fighter;

public class Sword extends BasicSkill implements Skill
{
	public Sword(int impact)
	{
		super(impact);
	}

	@Override
	public int getPower(Fighter fighter) 
	{
		return fighter.getStrength() * super.getValue() / DIVISION_VALUE;
	}
	
	@Override
	public String toString() 
	{
		return "Sword impact = " + super.getValue() + "\n";
	}
	
	@Override
	public boolean isAttackType() 
	{
		return true;
	}
}
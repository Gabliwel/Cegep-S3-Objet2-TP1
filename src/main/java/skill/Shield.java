package skill;
import duel.Fighter;

public class Shield extends BasicSkill implements Skill
{
	public Shield(int protection)
	{
		super(protection);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return fighter.getDexterity() * super.getValue() / DIVISION_VALUE;
	}
	
	@Override
	public String toString() 
	{
		return "Shield protection = " + super.getValue() + "\n";
	}
	
	@Override
	public boolean isParadeType() 
	{
		return true;
	}
}
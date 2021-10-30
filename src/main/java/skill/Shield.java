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
		//FIXME: Constante magique, à extraire! (G25)
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
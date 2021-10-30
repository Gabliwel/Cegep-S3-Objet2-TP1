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
		//FIXME: Constante magique, à extraire! (G25)
		return fighter.getFocus() * super.getValue() / 100;
	}
	
	@Override
	public String toString() 
	{
		return "Remedy strenght = " + super.getValue() + "\n";
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
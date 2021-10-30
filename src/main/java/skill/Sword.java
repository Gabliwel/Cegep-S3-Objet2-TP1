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
		//FIXME: Constante magique, à extraire! (G25)
		return fighter.getStrength() * super.getValue() / 100;
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
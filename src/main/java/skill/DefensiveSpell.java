package skill;
import duel.Fighter;

public class DefensiveSpell extends BasicSkill implements Skill
{	
	public DefensiveSpell(int intensity)
	{
		super(intensity);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		return (fighter.getIntelligence() * super.getValue() / DIVISION_VALUE) * MULTIPLICATION_VALUE;
	}

	@Override
	public String toString() 
	{
		return "Defensive spell intensity = " + super.getValue() + "\n";
	}
	
	@Override
	public boolean isParadeType() 
	{
		return true;
	}
}
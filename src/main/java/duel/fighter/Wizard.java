package duel.fighter;

import duel.Aptitudes;
import duel.Fighter;
import duel.Skill;

public class Wizard extends Fighter
{
	public Wizard(String name, Aptitudes aptitudes, Skill skill1, Skill skill2) 
	{
		super(name, aptitudes, skill1, skill2);
		validateAthleteAptitudes();
	}
	
	private void validateAthleteAptitudes()
	{
		if(getIntelligence() < Math.max(getStrength(), getDexterity()) + 15 || getFocus() < Math.max(getStrength(), getDexterity()) + 15)
		{
			throw new IllegalArgumentException("Wizard must respect wizard atributes rules");
		}
	}
}
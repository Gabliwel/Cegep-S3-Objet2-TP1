package duel.fighter;

import duel.Aptitudes;
import duel.Fighter;
import duel.Skill;

public class Warrior extends Fighter
{
	
	public Warrior(String name, Aptitudes aptitudes, Skill skill1, Skill skill2) 
	{
		super(name, aptitudes, skill1, skill2);
		validateAthleteAptitudes();
	}
	
	private void validateAthleteAptitudes()
	{
		//FIXME: Constante magique, � extraire! (G25)
		if(getStrength() < getDexterity() + 10 || getDexterity() + 10 < getIntelligence() + 10 || getIntelligence() + 10 < getFocus())
		{
			throw new IllegalArgumentException("Warrior must respect warrior atributes rules");
		}
	}
}
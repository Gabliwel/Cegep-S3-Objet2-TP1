package duel.fighter;

import duel.Aptitudes;
import duel.Fighter;
import duel.Skill;

public class Athlete extends Fighter
{
	public static final int MAX_ATHLETE_ATTRIBUTE_VALUE = 20;
	
	public Athlete(String name, Aptitudes aptitudes, Skill skill1, Skill skill2) 
	{
		super(name, aptitudes, skill1, skill2);
		validateAthleteAptitudes();
	}

	private void validateAthleteAptitudes()
	{
		if(getStrength() < MAX_ATHLETE_ATTRIBUTE_VALUE || getDexterity() < MAX_ATHLETE_ATTRIBUTE_VALUE 
				|| getIntelligence() < MAX_ATHLETE_ATTRIBUTE_VALUE || getFocus() < MAX_ATHLETE_ATTRIBUTE_VALUE)
		{
			throw new IllegalArgumentException("Athlete must respect athlete atributes rules");
		}
	}
}
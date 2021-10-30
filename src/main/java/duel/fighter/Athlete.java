package duel.fighter;

import java.util.List;

import duel.Aptitudes;
import duel.Fighter;
import skill.Skill;

public class Athlete extends Fighter
{
	public static final int MAX_ATHLETE_ATTRIBUTE_VALUE = 20;
	
	public Athlete(String name, Aptitudes aptitudes, List<Skill> skills) 
	{
		super(name, aptitudes, skills);
	}

	@Override
	public void validateFighterAptitudes(Aptitudes aptitudes)
	{
		if(aptitudes.getStrength() < MAX_ATHLETE_ATTRIBUTE_VALUE || aptitudes.getDexterity() < MAX_ATHLETE_ATTRIBUTE_VALUE 
				|| aptitudes.getIntelligence() < MAX_ATHLETE_ATTRIBUTE_VALUE || aptitudes.getFocus() < MAX_ATHLETE_ATTRIBUTE_VALUE)
		{
			throw new IllegalArgumentException("Athlete must respect athlete atributes rules");
		}
	}
}
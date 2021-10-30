package duel.fighter;

import java.util.List;

import duel.Aptitudes;
import duel.Fighter;
import skill.Skill;

public class Warrior extends Fighter
{
	public static final int WARRIOR_ADDED_VALUE = 10;
	
	public Warrior(String name, Aptitudes aptitudes, List<Skill> skills) 
	{
		super(name, aptitudes, skills);
	}
	
	@Override
	public void validateFighterAptitudes(Aptitudes aptitudes)
	{
		if(aptitudes.getStrength() < aptitudes.getDexterity() + WARRIOR_ADDED_VALUE 
				|| aptitudes.getDexterity() + WARRIOR_ADDED_VALUE < aptitudes.getIntelligence() + WARRIOR_ADDED_VALUE 
				|| aptitudes.getIntelligence() + WARRIOR_ADDED_VALUE < aptitudes.getFocus())
		{
			throw new IllegalArgumentException("Warrior must respect warrior atributes rules");
		}
	}
}
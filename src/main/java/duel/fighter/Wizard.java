package duel.fighter;

import java.util.List;

import duel.Aptitudes;
import duel.Fighter;
import skill.Skill;

public class Wizard extends Fighter
{
	public static final int WIZARD_ADDED_VALUE = 15;
	
	public Wizard(String name, Aptitudes aptitudes, List<Skill> skills) 
	{
		super(name, aptitudes, skills);
	}
	
	@Override
	public void validateFighterAptitudes(Aptitudes aptitudes)
	{
		if(aptitudes.getIntelligence() < Math.max(aptitudes.getStrength(), aptitudes.getDexterity()) + WIZARD_ADDED_VALUE 
				|| aptitudes.getFocus() < Math.max(aptitudes.getStrength(), aptitudes.getDexterity()) + WIZARD_ADDED_VALUE)
		{
			throw new IllegalArgumentException("Wizard must respect wizard atributes rules");
		}
	}
}
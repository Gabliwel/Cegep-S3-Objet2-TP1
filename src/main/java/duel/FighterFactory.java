package duel;

import java.util.List;

import duel.fighter.*;
import skill.Skill;

public class FighterFactory 
{
	public Fighter giveMeStrategyForFighter(FighterType type, String name, Aptitudes aptitudes, List<Skill> skills)
	{
		if(type != null)
		{
			Fighter fighter = switch(type)
			{
				case ATHLETE -> new Athlete(name, aptitudes, skills);
				case WARRIOR -> new Warrior(name, aptitudes, skills);
				case WIZARD -> new Wizard(name, aptitudes, skills);
			};
			return fighter;
		}
		throw new IllegalArgumentException("Fighter type must exist");
	}
}

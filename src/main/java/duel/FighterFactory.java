package duel;

import duel.fighter.*;
import skill.Skill;

public class FighterFactory 
{
	public Fighter giveMeStrategyForFighter(FighterType type, String name, Aptitudes aptitudes, Skill skill1, Skill skill2)
	{
		Fighter fighter;
		if(type == FighterType.Athlete)
		{
			fighter = new Athlete(name, aptitudes, skill1, skill2);
		}
		else if(type == FighterType.Warrior)
		{
			fighter = new Warrior(name, aptitudes, skill1, skill2);
		}
		else if(type == FighterType.Wizard)
		{
			fighter = new Wizard(name, aptitudes, skill1, skill2);
		}
		else
		{
			throw new IllegalArgumentException("Fighter type must exist");
		}
		return fighter;
	}
}

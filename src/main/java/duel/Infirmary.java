package duel;

import skill.Skill;

public class Infirmary 
{
	//FIXME: Je pense qu'au lieu de passer la skill en param�tre de la m�thode, j'aurais �t� la chercher dans Fighter une fois la v�rification pass�e.
	public void heal(Fighter fighter, Skill skill)
	{
		checkFighter(fighter);
		checkSkill(skill);
		checkFighterHasTheSkill(fighter, skill);
		
		fighter.increaseHealthPoints(skill.getPower(fighter));
		fighter.removeSkill(skill);
	}
	
	private void checkFighter(Fighter fighter)
	{
		if(fighter==null)
		{
			throw new IllegalArgumentException("The fighter must not be null");
		} //FIXME: Wow!  Je pense que tu es le premier (sur 15) � v�rifier si le guerrier est vivant!
		if(!fighter.isAlive())
		{
			throw new IllegalArgumentException("The fighter must be still alive");
		}
	}
	
	private void checkSkill(Skill skill)
	{
		if(skill==null)
		{
			throw new IllegalArgumentException("The skill must not be null");
		}
		if(!skill.isHealingType())
		{
			throw new IllegalArgumentException("The skill must be healing type");
		}
	}
	
	private void checkFighterHasTheSkill(Fighter fighter, Skill skill)
	{
		if(!fighter.hasTheSkill(skill))
		{
			throw new IllegalArgumentException("The fighter must have the given skill");
		}
	}
}
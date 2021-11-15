package duel;

import skill.Skill;

public class Duel 
{
	private Fighter initiator;
	private Fighter provoked;
	
	public Duel(Fighter initiator, Fighter provoked)
	{
		checkFighter(initiator);
		checkFighter(provoked);
		checkIfFigtherAreDifferent(initiator, provoked);
		this.initiator = initiator;
		this.provoked = provoked;
	}

	public void fight(Skill reward)
	{
		checkIfAlive(initiator);
		checkIfAlive(provoked);
		
		//FIXME: Si tu te fais une référence à winner et loser dans cette méthode et que tu l'initialise avec des valeurs (par exemple, winner = attacker et loser = defender, il y a des cas qui sont
		//déjà traités dans le defaut.  Ça te permet aussi
		if(initiator.canAttack())
		{
			if(provoked.canDefend())
			{
				int initiatorPower = initiator.getAttack();
				int provokedPower = provoked.getDefense();
				if(initiatorPower >= provokedPower)
				{
					provoked.decreaseHealthPoints(initiatorPower);
					endOfDuel(initiator, provoked, reward);

				}
				else //donc si initiatorPower < provokedPower
				{
					initiator.decreaseHealthPoints(provokedPower);
					endOfDuel(provoked, initiator, reward);
				}
			}
			//Si le provoqué n'a pas de défense, il perd
			else
			{
				endOfDuel(initiator, provoked, reward);
			}
		}
		//Si le provocant n'a pas d'arme, il perd
		else
		{
			endOfDuel(provoked, initiator, reward);
		}
	}
	
	private void endOfDuel(Fighter winner, Fighter loser, Skill reward)
	{
		//FIXME: Excellente délégation au Fighter!
		winner.increaseAllAptitudes();
		winner.addSkill(reward);
		loser.decreaseAllAptitudes();
	}
	
	//FIXME: Excellentes validations!
	private void checkIfAlive(Fighter fighter) 
	{
		if(!fighter.isAlive())
		{
			throw new IllegalArgumentException("Fighter can't be dead and fight");
		}
	}

	private void checkFighter(Fighter fighter) 
	{
		if(fighter == null)
		{
			throw new IllegalArgumentException("Fighter can't be null");
		}
	}
	
	private void checkIfFigtherAreDifferent(Fighter fighter1, Fighter fighter2) 
	{
		if(fighter1 == fighter2)
		{
			throw new IllegalArgumentException("Fighter can't fight himself");
		}
	}
	
	@Override
	public String toString()
	{
		return "Duel Fighters:\n" + this.initiator.toString() + this.provoked.toString();
	}
}
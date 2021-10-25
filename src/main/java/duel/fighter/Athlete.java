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

	//FIXME: Cette structure est bonne, mais non-contraignante.  Si on ajoute un autre type de Fighter, comme un Thief, rien ne force ce Thief � faire une validation.
	//Alors que si cette m�thode est une m�thode abstraite de la super classe et appel�e dans le super constructeur, on force le Thief � �tre conscient de sa validation.
	private void validateAthleteAptitudes()
	{
		if(getStrength() < MAX_ATHLETE_ATTRIBUTE_VALUE || getDexterity() < MAX_ATHLETE_ATTRIBUTE_VALUE 
				|| getIntelligence() < MAX_ATHLETE_ATTRIBUTE_VALUE || getFocus() < MAX_ATHLETE_ATTRIBUTE_VALUE)
		{
			throw new IllegalArgumentException("Athlete must respect athlete atributes rules");
		}
	}
}
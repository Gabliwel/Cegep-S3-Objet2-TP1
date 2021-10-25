package duel;

import java.util.ArrayList;

public abstract class Fighter 
{
	public static final int INITIAL_HEALTH = 200;
	public static final int DEAD_HEALTH_VALUE = 0;
	
	private String name;
	private Aptitudes aptitudes;
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private int healthPoint;
	
	//FIXME: Trop de paramètres dans la fonction (F1), tu peux utiliser une liste de skills
	public Fighter(String name, Aptitudes aptitudes, Skill skill1, Skill skill2)
	{
		this.name = name;
		this.aptitudes = aptitudes;
		skills.add(skill1);
		skills.add(skill2);
		//FIXME: Tu peux extraire tes additions d'aptitude dans une belle méthode de la classe aptitude :)
		this.healthPoint = INITIAL_HEALTH - (getStrength() + getDexterity() + getIntelligence() + getFocus());
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getStrength()
	{
		return this.aptitudes.getStrength();
	}
	
	public int getDexterity()
	{
		return this.aptitudes.getDexterity();
	}
	
	public int getIntelligence()
	{
		return this.aptitudes.getIntelligence();
	}
	
	public int getFocus()
	{
		return this.aptitudes.getFocus();
	}
	
	public int getHealthPoints()
	{
		return this.healthPoint;
	}
	
	public void decreaseHealthPoints(int damage) 
	{
		if(healthPoint - damage > DEAD_HEALTH_VALUE)
		{
			this.healthPoint -= damage;
		}
		else
		{
			this.healthPoint = DEAD_HEALTH_VALUE;
		}
	}
	
	public boolean isAlive()
	{
		return this.healthPoint != DEAD_HEALTH_VALUE;
	}
	
	public boolean hasTheSkill(Skill skill)
	{
		//FIXME: DRY -> il existe déjà, dans l'interface List, une méthode 'contains' qui vérifie si un item est dans la liste! 
		for(Skill skillInList: skills)
		{
			if(skillInList == skill)
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		String firstPart = "Fighter " + name + "{\n" + aptitudes.toString();
		String middlePart = "";
		int i = 1;
		for(Skill skillInList: skills)
		{
			middlePart += "   (Skill #" + i + ")" + skillInList.toString();
			i++;
		}
		String endPart = "   Healthpoint = " + healthPoint + "\n}\n";
		return firstPart + middlePart + endPart;
	}
}
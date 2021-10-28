package duel;

import java.util.ArrayList;
import java.util.List;

import skill.Skill;

public abstract class Fighter 
{
	public static final int INITIAL_HEALTH = 200;
	public static final int DEAD_HEALTH_VALUE = 0;
	public static final int DEFAULT_NUMBER_OF_SKILL = 2;
	
	private String name;
	private Aptitudes aptitudes;
	private ArrayList<Skill> skills;
	private int healthPoint;
	
	public Fighter(String name, Aptitudes aptitudes, List<Skill> skills)
	{
		validateFighterAptitudes(aptitudes);
		validateSkillList(skills);
		
		this.name = name;
		this.aptitudes = aptitudes;
		this.skills = new ArrayList<Skill>(skills);
		this.healthPoint = INITIAL_HEALTH - aptitudes.getTotalAptitudes();
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
	
	public void increaseAllAptitudes()
	{
		aptitudes.increaseAllAptitudes();
	}
	
	public void decreaseAllAptitudes()
	{
		aptitudes.decreaseAllAptitudes();
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
	
	public void increaseHealthPoints(int heal) 
	{
		this.healthPoint += heal;
	}
	
	public boolean isAlive()
	{
		return this.healthPoint != DEAD_HEALTH_VALUE;
	}
	
	public boolean hasTheSkill(Skill skill)
	{
		return skills.contains(skill);
	}
	
	public void removeSkill(Skill skill)
	{
		skills.remove(skill);
	}
	
	public boolean canAttack()
	{
		for(Skill skill : skills)
		{
			if(skill.isAttackType())
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean canDefend()
	{
		for(Skill skill : skills)
		{
			if(skill.isParadeType()||skill.isAttackType())
			{
				return true;
			}
		}
		return false;
	}
	
	public int getAttack()
	{
		for(Skill skill : skills)
		{
			if(skill.isAttackType())
			{
				return skill.getPower(this);
			}
		}
		throw new IllegalArgumentException("The skill list has no attack skill");
	}
	
	public int getDefense()
	{
		for(Skill skill : skills)
		{
			if(skill.isAttackType()||skill.isParadeType())
			{
				return skill.getPower(this);
			}
		}
		throw new IllegalArgumentException("The skill list has no attack or parade skill");
	}
	
	public void addSkill(Skill newSkill)
	{
		skills.add(newSkill);
	}
	
	public abstract void validateFighterAptitudes(Aptitudes aptitudes);
	
	private void validateSkillList(List<Skill> skills) 
	{
		if(skills == null || skills.size()!=DEFAULT_NUMBER_OF_SKILL)
		{
			throw new IllegalArgumentException("The skill list must have two skills");
		}
		if(skills.get(0) == null || skills.get(1) == null)
		{
			throw new IllegalArgumentException("The skills in the list should not be null");
		}
		
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
package duel;

public class Aptitudes 
{
	public static final int MAX_APTITUDES_POINTS = 100;
	public static final int MIN_APTITUDE_VALUE = 1;
	
	private int strength;
	private int dexterity;
	private int intelligence;
	private int focus;
	
	public Aptitudes(int strength, int dexterity, int intelligence, int focus)
	{
		validateAptitudes(strength, dexterity, intelligence, focus);
		this.strength = strength;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.focus = focus;
	}
	
	public int getStrength()
	{
		return this.strength;
	}
	
	public int getDexterity()
	{
		return this.dexterity;
	}
	
	public int getIntelligence()
	{
		return this.intelligence;
	}
	
	public int getFocus()
	{
		return this.focus;
	}
	
	
	public void increaseAllAptitudes()
	{
		this.strength++;
		this.dexterity++;
		this.intelligence++;
		this.focus++;
	}
	
	public void decreaseAllAptitudes()
	{
		if(this.strength!=MIN_APTITUDE_VALUE)
		{
			this.strength--;
		}
		if(this.dexterity!=MIN_APTITUDE_VALUE)
		{
			this.dexterity--;
		}
		if(this.intelligence!=MIN_APTITUDE_VALUE)
		{
			this.intelligence--;
		}
		if(this.focus!=MIN_APTITUDE_VALUE)
		{
			this.focus--;
		}
	}
	
	public int getTotalAptitudes()
	{
		return this.strength + this.dexterity + this.intelligence + this.focus;
	}
	
	private void validateAptitudes(int strength, int dexterity, int intelligence, int focus)
	{
		if(strength < 0 || dexterity < 0 || intelligence < 0 || focus < 0)
		{
			throw new IllegalArgumentException("An aptitude should have a positve value");
		}
		if(strength + dexterity + intelligence + focus > MAX_APTITUDES_POINTS)
		{
			throw new IllegalArgumentException("The total of the aptitudes should be inferior or equal to 100");
		}
	}
	
	@Override
	public String toString()
	{
		return "   Aptitude:\n"
				+ "      Strenght = " + strength + "\n" 
				+ "      Dexterity = " + dexterity + "\n"
				+ "      Intelligence = " + intelligence + "\n" 
				+ "      Focus = " + focus + "\n";
	}
}
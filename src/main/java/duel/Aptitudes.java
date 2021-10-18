package duel;

public class Aptitudes 
{
	public static final int MAX_APTITUDES_POINTS = 100;
	
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
		return "Aptitudes:";
	}
}
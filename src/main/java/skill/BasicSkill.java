package skill;

public abstract class BasicSkill
{
	private int value;
	
	public BasicSkill(int value)
	{
		validateSkillValue(value);
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}

	private void validateSkillValue(int value) 
	{
		//FIXME: Constante magique, � extraire! (G25)
		//FIXME: Encapsule la condition dans une m�thode (G28) 
		if(20 > value || value > 100)
		{
			throw new IllegalArgumentException("Skill value must respect min of 20 and max of 100");
		}
	}
	
	@Override
	public abstract String toString();
}
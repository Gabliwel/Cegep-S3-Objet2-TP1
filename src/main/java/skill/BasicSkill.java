package skill;

public abstract class BasicSkill
{
	public static final int MIN_VALUE = 20;
	public static final int MAX_VALUE = 100;
	public static final int DIVISION_VALUE = 100;
	public static final int MULTIPLICATION_VALUE = 3;
	
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
	
	public boolean isAttackType() 
	{
		return false;
	}

	public boolean isParadeType() 
	{
		return false;
	}

	public boolean isHealingType() 
	{
		return false;
	}

	private void validateSkillValue(int value) 
	{
		if(isInvalidValue(value))
		{
			throw new IllegalArgumentException("Skill value must respect min of 20 and max of 100");
		}
	}
	
	private boolean isInvalidValue(int value)
	{
		return MIN_VALUE > value || value > MAX_VALUE;
	}
	
	@Override
	public abstract String toString();
}
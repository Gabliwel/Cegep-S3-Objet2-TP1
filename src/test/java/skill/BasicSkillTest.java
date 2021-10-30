package skill;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class BasicSkillTest 
{
	public final int min = 20;
	public final int max = 100;
	
	//test de la validation avec le minimun
	@Test
	void when_skillValueIsHigherThanMin_then_skillIsCreated()
	{
		//FIXME: Test faible...  Est-ce que j'ai bien mis la bonne valeur à la bonne place?
		assertDoesNotThrow(() -> new BasicSkillMock(min+1));
	}
	
	@Test
	void when_skillValueIsEqualToMin_then_skillIsCreated()
	{
		assertDoesNotThrow(() -> new BasicSkillMock(min));
	}
	
	@Test
	void when_skillValueIsSmallerThanMin_then_skillIsNotCreated()
	{
		assertThrows(IllegalArgumentException.class, () -> new BasicSkillMock(min-1));
	}
	
	//test de validation avec le maximun
	@Test
	void when_skillValueIsSmallerThanMax_then_skillIsCreated()
	{
		assertDoesNotThrow(() -> new BasicSkillMock(max-1));
	}
	
	@Test
	void when_skillValueIsEqualToMax_then_skillIsCreated()
	{
		assertDoesNotThrow(() -> new BasicSkillMock(max));
	}
	
	@Test
	void when_skillValueIsBiggerThanMax_then_skillIsNotCreated()
	{
		assertThrows(IllegalArgumentException.class, () -> new BasicSkillMock(max+1));
	}
}
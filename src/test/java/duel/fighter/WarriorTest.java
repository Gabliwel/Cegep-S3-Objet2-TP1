package duel.fighter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import duel.Aptitudes;
import skill.Skill;
import skill.mock.SkillMock;

public class WarriorTest 
{
	public static final String ANY_NAME = "BOB";
	public static final int ADDED_VALUE = 10;
	public static final List<Skill> ANY_SKILL_LIST = Arrays.asList(new SkillMock(), new SkillMock());
	
	//orde des atributs dans l'object "Aptitudes": force - dextérité - intelligence - concentration
	//test de l'attribut de la force
	@Test
	void when_strengthValueIsBiggerOrEqualToDexterityPlusAddedValue_then_returnsNewWarrior() 
	{
		int dexterity = 14;
		assertDoesNotThrow(() -> 
		new Warrior(ANY_NAME, new Aptitudes(dexterity+ADDED_VALUE, dexterity, 0, 0), ANY_SKILL_LIST));
		assertDoesNotThrow(() ->
		new Warrior(ANY_NAME, new Aptitudes(dexterity+ADDED_VALUE+1, dexterity, 0, 0), ANY_SKILL_LIST));
	}
	
	@Test
	void when_strengthValueIsSmallerThanDexterityPlusAddedValue_then_doesNotReturnsNewWarrior() 
	{
		int dexterity = 14;
		assertThrows(IllegalArgumentException.class, () -> 
		new Warrior(ANY_NAME, new Aptitudes(dexterity+ADDED_VALUE-1, dexterity, 0, 0), ANY_SKILL_LIST));
	}
	
	//test de l'attribut de la dexterite
	@Test
	void when_dexterityPlusAddedValueIsBiggerOrEqualToIntelligencePlusAddedValue_then_returnsNewWarrior() 
	{
		int intelligence = 2;
		assertDoesNotThrow(() -> 
		new Warrior(ANY_NAME, new Aptitudes(25, intelligence+ADDED_VALUE, intelligence+ADDED_VALUE, 0), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Warrior(ANY_NAME, new Aptitudes(25, intelligence+ADDED_VALUE+1, intelligence+ADDED_VALUE, 0), ANY_SKILL_LIST));
	}
	
	@Test
	void when_dexterityPlusAddedValueIsSmallerThanIntelligencePlusAddedValue_then_doesNotReturnsNewWarrior() 
	{
		int intelligence = 2;
		assertThrows(IllegalArgumentException.class, () ->
		new Warrior(ANY_NAME, new Aptitudes(25, intelligence+ADDED_VALUE-1, intelligence+ADDED_VALUE, 0), ANY_SKILL_LIST));
	}
	
	//test de l'attribut de l'intelligence
	@Test
	void when_IntelligencePlusAddedValueIsBiggerOrEqualToFocus_then_returnsNewWarrior() 
	{
		int focus = 2;
		assertDoesNotThrow(() -> 
		new Warrior(ANY_NAME, new Aptitudes(25, 15, focus, focus+ADDED_VALUE), ANY_SKILL_LIST));
		assertDoesNotThrow(() -> 
		new Warrior(ANY_NAME, new Aptitudes(25, 15, focus+1, focus+ADDED_VALUE), ANY_SKILL_LIST));
	}
		
	@Test
	void when_IntelligencePlusAddedValueIsSmallerThanFocus_then_doesNotReturnsNewWarrior() 
	{
		int focus = 2;
		assertThrows(IllegalArgumentException.class, () -> 
		new Warrior(ANY_NAME, new Aptitudes(25, 15, focus-1, focus+ADDED_VALUE), ANY_SKILL_LIST));
	}
}
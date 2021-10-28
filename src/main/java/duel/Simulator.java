package duel;

import java.util.ArrayList;
import java.util.List;

import duel.fighter.*;
import skill.*;

public class Simulator 
{
	private static ArrayList<Fighter> collectionOfFighter = new ArrayList<Fighter>();
	private static Remedy remedy2 = new Remedy(30);
	
	public static void main(String[] args)
	{
		System.out.println("======================Fighters===========================");
		createSpellsAndFighters();
		printCollection();
		System.out.println("======================Duels===========================");
		makeAndPrintDuel();
		System.out.println("======================Infirmary(Before)===========================");
		System.out.println(collectionOfFighter.get(3).toString());
		makeAndUseInfirmaryOnFighter();
		System.out.println("======================Infirmary(After)===========================");
		System.out.println(collectionOfFighter.get(3).toString());
	}

	private static void createSpellsAndFighters()
	{
		//création de capacités(avec une valeur valide)
		Skill sword1 = new Sword(50);
		Skill sword2 = new Sword(99);
		Skill shield = new Shield(50);
		Skill remedy1 = new Remedy(99);
		
		//création de combatants(avec des aptitudes valides) et ajout de ceux-ci à la collection
		collectionOfFighter.add(new Athlete("Big Bob", new Aptitudes(20, 20, 20, 20), createSkillList(sword1, shield)));
		collectionOfFighter.add(new Athlete("Small Bob", new Aptitudes(25, 25, 25, 25), createSkillList(sword1, remedy1)));
		collectionOfFighter.add(new Warrior("Gontrant", new Aptitudes(75, 3, 2, 1), createSkillList(sword2, sword1)));
		collectionOfFighter.add(new Wizard("Lalalilalou", new Aptitudes(1, 1, 20, 20), createSkillList(remedy1, remedy2)));
	}
	
	private static void makeAndPrintDuel() 
	{
		Duel duel1 = new Duel(collectionOfFighter.get(0), collectionOfFighter.get(1));
		duel1.fight(new Remedy(99));
		System.out.println(duel1.toString());
		
		Duel duel2 = new Duel(collectionOfFighter.get(2), collectionOfFighter.get(3));
		duel2.fight(new Remedy(99));
		System.out.println(duel2.toString());
	}
	
	private static void makeAndUseInfirmaryOnFighter() 
	{
		Infirmary infirmary = new Infirmary();
		infirmary.heal(collectionOfFighter.get(3), remedy2);
	}
	
	//crée une liste de skill valide pour le fighter à partir de deux 2 skills
	private static List<Skill> createSkillList(Skill skill1, Skill skill2) 
	{
		List<Skill> list = new ArrayList<Skill>();
		list.add(skill1);
		list.add(skill2);
		return list;
	}
	
	private static void printCollection() 
	{
		for(Fighter fighter: collectionOfFighter)
		{
			System.out.println(fighter.toString());
		}
	}
}

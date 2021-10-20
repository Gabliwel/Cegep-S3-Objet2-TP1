package duel;

import java.util.ArrayList;

import duel.fighter.*;
import skill.*;

public class Simulator 
{
	private static ArrayList<Fighter> collectionOfFighter = new ArrayList<Fighter>();
	
	public static void main(String[] args)
	{
		createSpellsAndFighters();
		printCollection();
	}

	private static void createSpellsAndFighters()
	{
		//création de capacités(avec une valeur valide)
		Skill sword1 = new Sword(50);
		Skill sword2 = new Sword(99);
		Skill shield = new Shield(50);
		Skill remedy = new Remedy(99);
		
		//création de combatants(avec des aptitudes valides) et ajout de ceux-ci à la collection
		collectionOfFighter.add(new Athlete("Big Bob", new Aptitudes(20, 20, 20, 20), sword1, shield));
		collectionOfFighter.add(new Athlete("Small Bob", new Aptitudes(25, 25, 25, 25), sword1, remedy));
		collectionOfFighter.add(new Warrior("Gontrant", new Aptitudes(75, 3, 2, 1), sword2, sword1));
		collectionOfFighter.add(new Wizard("Lalalilalou", new Aptitudes(1, 1, 20, 20), shield, remedy));
	}
	
	private static void printCollection() 
	{
		for(Fighter fighter: collectionOfFighter)
		{
			System.out.println(fighter.toString());
		}
	}
}

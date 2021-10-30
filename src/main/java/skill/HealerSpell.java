package skill;
import duel.Fighter;

public class HealerSpell extends BasicSkill implements Skill
{	
	public HealerSpell(int energie)
	{
		super(energie);
	}
	
	@Override
	public int getPower(Fighter fighter) 
	{
		//FIXME: Constante magique, � extraire! (G25)
		return fighter.getIntelligence() * super.getValue() / 100;
	}
	
	@Override
	public String toString() 
	{
		return "Healer spell energie = " + super.getValue() + "\n";
	}
	
	//FIXME: DRY -> Tu peux �viter de r�p�ter les 'return false' en les d�finissant dans ton parent, BasicSkill
	//Si ton BasicSkill retourne faux partout, la seule m�thode que tu as besoin de changer dans ton enfant,
	//c'est celle qui correspond � son type.
	@Override
	public boolean isAttackType() 
	{
		return false;
	}

	@Override
	public boolean isParadeType() 
	{
		return false;
	}

	@Override
	public boolean isHealingType() 
	{
		return true;
	}
}
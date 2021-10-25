package skill;

import duel.Fighter;

public interface Skill 
{
	public int getPower(Fighter fighter);
	public String toString();
	public boolean isAttackType();
	public boolean isParadeType();
	public boolean isHealingType();
}
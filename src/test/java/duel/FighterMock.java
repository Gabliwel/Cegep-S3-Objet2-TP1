package duel;

import java.util.List;

import skill.Skill;

public class FighterMock extends Fighter
{
	public FighterMock(String name, Aptitudes aptitudes, List<Skill> skills) 
	{
		super(name, aptitudes, skills);
	}

	@Override
	public void validateFighterAptitudes(Aptitudes aptitudes) {}
}
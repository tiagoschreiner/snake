
public class Info {
	/*falta colocar tempo*/
	private int pontos, bonus, dific;
	public Info()
	{
		pontos = 0;
		bonus = 0;
		dific = 0;
	}
	
	public void aumentaPonto()
	{
		pontos += 10;
	}
	
	public void aumentaBonus()
	{
		bonus += 20;
	}
	
	public void setDific(int dific)
	{
		this.dific = dific;
	}
	
	public int getBonus()
	{
		return bonus;
	}
	
	public int getPontos()
	{
		return pontos;
	}
	
	public int getDific()
	{
		return dific;
	}
}

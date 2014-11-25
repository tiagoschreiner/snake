import java.util.ArrayList;


public class Cobra {
	
	private int posCabeca;
	private ArrayList<Integer> corpo;
	
	public Cobra()
	{
		posCabeca = 38;
		corpo = new ArrayList<Integer>();
	}
	
	public void atualizaPos(int posCabeca)
	{
		this.posCabeca = posCabeca;
	}
	
	public int getPosicao()
	{
		return posCabeca;
	}
	
	public ArrayList<Integer> getCorpo()
	{
		return corpo;
	}
}

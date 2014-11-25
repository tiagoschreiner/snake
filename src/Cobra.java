import java.util.ArrayList;


public class Cobra {
	
	private int posCabeca, tamanho;
	private ArrayList<Integer> corpo;
	
	public Cobra()
	{
		tamanho = 0;
		posCabeca = 38;
	}
	
	public void atualizaPos(int posCabeca)
	{
		this.posCabeca = posCabeca;
	}
	
	public void aumentaTam()
	{
		this.tamanho ++;
	}
	
	public int getPosicao()
	{
		return posCabeca;
	}
	
	public int getTamanho()
	{
		return this.tamanho;
	}
}

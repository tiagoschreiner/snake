
public class Cobra {
	
	private int posCabeca, tamanho; 
	
	public Cobra()
	{
		tamanho = 1;
		posCabeca = 38;
	}
	
	public void atualizaPos(int posCabeca)
	{
		this.posCabeca = posCabeca;
	}
	
	public void atualizaTam(int tamanho)
	{
		this.tamanho = tamanho;
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

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

	/*verifica se a cobra comeu a comida*/
	public boolean verificaComida(int posComida)
	{
		if(posComida == this.posCabeca)
			return  true;
		else
			return false;
	}
	
	/*verifica se a cobra bateu na parede*/
	public boolean verificaParede(ArrayList<Integer> parede, int tamParede)
	{
		int i;
		for(i = 0; i < tamParede; i++){
			if(parede.get(i) == this.posCabeca)
				return true;
		}
		return false;
	}
	
}

import java.util.ArrayList;

public class Cobra {
	
	private int posCabeca;
	private ArrayList<Integer> corpo;
	
	public Cobra()
	{
		posCabeca = 18;
		corpo = new ArrayList<Integer>();
		corpo.add(3);
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

	public void aumentaCorpo()
	{
		corpo.add(1, posCabeca);
	}
	
	private boolean verificaCollSelf()
	{
		int i;
		if(corpo.size() > 2)
			for(i = 2; i < corpo.size(); i++)
				if(corpo.get(i) == posCabeca)
					return true;
		
		return false;
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
	private boolean verificaParede(ArrayList<Integer> parede)
	{
		int i;
		for(i = 0; i < parede.size(); i++){
			if(parede.get(i) == this.posCabeca)
				return true;
		}
		return false;
	}
	
	public boolean verificaColisao(ArrayList<Integer> parede)
	{
		if(verificaParede(parede) || verificaCollSelf())
			return true;
		else 
			return false;
	}
	
}




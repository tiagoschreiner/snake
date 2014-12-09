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
	
	/*atualiza a posicao da cabeca da cobra*/
	public void atualizaPos(int posCabeca)
	{
		this.posCabeca = posCabeca;
	}
	
	/*retorna a posucao da cabeca da cobra*/
	public int getPosicao()
	{
		return posCabeca;
	}
	
	/*retorna o arrayList do corpo*/
	public ArrayList<Integer> getCorpo()
	{
		return corpo;
	}

	/*aumenta o tamanho do corpo*/
	public void aumentaCorpo()
	{
		corpo.add(1, posCabeca);
	}
	
	/*verifica se a cobra comeu a comida*/
	public boolean comeu(int posComida)
	{
		if(posComida == this.posCabeca)
			return  true;
		else
			return false;
	}
	
	public boolean colidiu(ArrayList<Integer> parede)
	{
		if(verificaParede(parede) || verificaCollSelf())
			return true;
		else 
			return false;
	}

	/*verifica se a cabeca colidiu com o corpo da cobra*/
	private boolean verificaCollSelf()
	{
		int i;
		if(corpo.size() > 2)
			for(i = 2; i < corpo.size(); i++)
				if(corpo.get(i) == posCabeca)
					return true;
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
}




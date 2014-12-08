import java.util.*;

public class Comida {

	private int posicao, tipo/*normal || bonus*/;
	
	public Comida()
	{
		posicao = 32;
	}
	
	public void mudaPosicao()
	{
		int aux;
		Random rand = new Random();
		posicao = rand.nextInt(208);
		aux = rand.nextInt(207);
		if(aux >= 100 && aux <= 125)
			tipo = 1;
		else
			tipo = 0;
	}
	
	public int getPosicao()
	{
		return posicao;
	}
	public int getTipo()
	{
		return  tipo;
	}
	
	public boolean verificaParede(ArrayList<Integer> parede)
	{
		int i;
		for(i = 0; i < parede.size(); i++){
			if(parede.get(i) == this.posicao)
				return true;	
		}
				
		return false;
	}
	
	public boolean verificaCobra(int posCobra)
	{
		if(posCobra == this.posicao)
			return true;
		else
			return false;
	}
}

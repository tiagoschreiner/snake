import java.util.*;

public class Comida {

	private int posicao, tipo/*normal || bonus*/;
	
	public Comida()
	{
		posicao = 32;
	}
	
	public int getPosicao()
	{
		return posicao;
	}
	
	public int getTipo()
	{
		return  tipo;
	}
	
	/*junta os metodos privados listados abaixo*/
	public void novaPosicao(ArrayList<Integer> parede, ArrayList<Integer> corpoCobra, int posCobra)
	{
		int flag = 0;
		while(flag == 0){
			mudaPosicao();
			if(verificaCobra(posCobra) && verificaParede(parede) && verificaRabo(corpoCobra))
				flag = 0;
			else
				flag = 1;
		}
	}
	
	/*escolhe uma nova posicao para a comida*/
	private void mudaPosicao()
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
	
	/*verifica se a comida nasceu em cima do corpo da cobra*/
	private boolean verificaRabo(ArrayList<Integer> corpoCobra)
	{
		int i;
		for(i = 0; i < corpoCobra.size(); i++)
			if(corpoCobra.get(i) == this.posicao)
				return true;
		
		return false;
	}
	
	/*verifica se a comida nasceu em cima da cabeca da cobra*/
	private boolean verificaCobra(int posCobra)
	{
		if(posCobra == this.posicao)
			return true;
		else
			return false;
	}
	
	/*verifica se a comida nasceu em cima da parede*/
	private boolean verificaParede(ArrayList<Integer> parede)
	{
		int i;
		for(i = 0; i < parede.size(); i++){
			if(parede.get(i) == this.posicao)
				return true;	
		}
				
		return false;
	}
}

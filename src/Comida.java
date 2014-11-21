import java.util.*;

public class Comida {

	private int posicao, tipo/*normal || bonus*/;
	
	public Comida()
	{
		Random rand = new Random();
		posicao = rand.nextInt(208);
	}
	
	public void mudaPosicao()
	{
		int aux;
		Random rand = new Random();
		posicao = rand.nextInt(208);
		aux = rand.nextInt(208);
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
}

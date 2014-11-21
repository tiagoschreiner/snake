import java.util.ArrayList;
import java.util.Random;

public class Parede {
	private int tamanho;
	private ArrayList<Integer> parede;
	
	public Parede()
	{
		parede = new ArrayList<Integer>(); 
		tamanho = 0;
	}
	
	public void mudaParede()
	{
		int i, direcao;
		parede.clear();
		Random rand = new Random();
		tamanho = rand.nextInt(5);
		if(tamanho == 0)
			tamanho ++;
		direcao = rand.nextInt(2);
		parede.add(rand.nextInt(208));
		for(i = 1; i < tamanho; i++){
			if(direcao == 0)/*parede horizontal*/
				parede.add(parede.get(i - 1) + 1);
			else
				parede.add(parede.get(i - 1) + 16);/*parede vertical*/
		}
	}
	
	public ArrayList<Integer> getParede()
	{
		return parede;
	}
	
	public int getTamanho()
	{
		return tamanho;
	}
}

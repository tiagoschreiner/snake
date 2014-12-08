import java.util.ArrayList;

public class Parede {
	private int tamanho;
	private ArrayList<Integer> parede;
	
	public Parede()
	{
		int i;
		tamanho = 7;
		parede = new ArrayList<Integer>();
		for(i = 0; i < tamanho; i++)
			parede.add(100 + i);
		
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

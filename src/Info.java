import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Info {
	
	private int pontos, dific;
	
	public Info()
	{
		pontos = 0;
		dific = 0;
	}
	
	public void aumentaPonto(int tipo)
	{
		/*0 - normal|| 1 - bonus*/
		if(tipo == 0)
			pontos += 10;
		else
			pontos += 15;
	}
	
	public void setDific(int dific)
	{
		this.dific = dific;
	}
	
	public int getPontos()
	{
		return pontos;
	}
	
	public int getDific()
	{
		return dific;
	}

	public void salvaInfo(String nome)
	{
		try{
			PrintWriter file = new PrintWriter(new FileWriter("rank.txt", true), true);
			
			file.println(nome + ":" + pontos);
			
			file.close();
            
		}
		catch(IOException ioException){
			JOptionPane.showMessageDialog(null,"Erro ao abrir arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static ArrayList<Jogador> getRank()
	{
		int meio, i, i2, max;
		String str;
		Jogador jogador, aux;
		ArrayList<Jogador> rank = new ArrayList<Jogador>();
		
		try{
			BufferedReader lerRank = new BufferedReader(new FileReader("rank.txt")); 
			while(lerRank.ready()){
				str = lerRank.readLine();
				meio = str.indexOf(":");
				jogador = new Jogador(str.substring(0,meio), Integer.parseInt(str.substring(meio + 1)));
				rank.add(jogador);
			}
			lerRank.close();
		}
		catch(IOException ioException){
			JOptionPane.showMessageDialog(null,"Nao foi possivel abrir o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		/*ordena o vetor*/
		for(i = 0; i < rank.size() - 1; i++){
			max = i;
			for(i2 = i + 1; i2 < rank.size(); i2 ++)
				if(rank.get(i2).getPonto() > rank.get(max).getPonto())
					max = i2;
			
			if(i != max){
				aux = rank.get(i);
				rank.set(i, rank.get(max));
				rank.set(max, aux);
			}
		}
		
		return rank;
	}

}

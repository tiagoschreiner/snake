import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Info {
	
	private int pontos, bonus, dific;

	
	public Info()
	{
		pontos = 0;
		bonus = 0;
		dific = 0;
	}
	
	public void aumentaPonto()
	{
		pontos += 10;
	}
	
	public void aumentaBonus()
	{
		bonus += 20;
	}
	
	public void setDific(int dific)
	{
		this.dific = dific;
	}
	
	public int getBonus()
	{
		return bonus;
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
			
			file.append(nome + " " + pontos + " " + bonus + " " + dific + "\n");
			
			file.close();
            
		}
		catch(IOException ioException){
			JOptionPane.showMessageDialog(null,"Erro ao abrir arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static ArrayList<String> getRank()
	{
		ArrayList<String> rank = new ArrayList<String>();
		
		try{
			BufferedReader lerRank = new BufferedReader(new FileReader("rank.txt")); 
			
			lerRank.mark(100);
			while(lerRank.readLine() != null){
				lerRank.reset();
				rank.add(lerRank.readLine());
				lerRank.mark(100);
			}
			lerRank.close();
		}
		catch(IOException ioException){
			JOptionPane.showMessageDialog(null,"Nao foi possivel abrir o Rank", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		return rank;
	}
}

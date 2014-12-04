import java.io.*;

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
}

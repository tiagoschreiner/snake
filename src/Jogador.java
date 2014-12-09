public class Jogador {
	private String nome;
	private int pontos;
	
	public Jogador(String nome, int pontos)
	{
		this.nome = nome;
		this.pontos = pontos;		
	}
	
	public int getPonto()
	{
		return pontos;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	
}

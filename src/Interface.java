import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;


public class Interface implements MouseListener
{	
	private JButton bVerRank, bNovoJogo, bSair;
	private JFrame janelaInicio, janelaRank;
	private JPanel painelInicio, painelRank;
	
	public Interface()
	{
		int telaX = Toolkit.getDefaultToolkit().getScreenSize().width;
		int telaY = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		janelaInicio = new JFrame("Snake");
		janelaInicio.setSize(400, 400);
		janelaInicio.setLocation(telaX / 3,telaY / 4);
		janelaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		criaBotoes();
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
	
		painelInicio = new JPanel();
		painelInicio.setLayout(layout);
		painelInicio.setBackground(Color.BLACK);
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weighty = 0.1;
		painelInicio.add(bNovoJogo, cons);
		cons.weighty = 0.001;
		cons.gridx = 0;
		cons.gridy = 1;
		painelInicio.add(bVerRank, cons);
		cons.gridx = 0;
		cons.gridy = 2;
		cons.weighty = 0.1;
		painelInicio.add(bSair, cons);
		
		janelaInicio.add(painelInicio);
		
		
		janelaInicio.setVisible(true);
	}

	private void novoJogo()
	{
		Jogo jogo = new Jogo();
		new Thread(jogo).start();
	}
	
	private void criaBotoes()
	{
		bNovoJogo = new JButton("Novo Jogo");
		bNovoJogo.setOpaque(true);
		bNovoJogo.setBackground(Color.DARK_GRAY);
		bNovoJogo.setForeground(Color.WHITE);
		bNovoJogo.addMouseListener(this);
		bNovoJogo.setName("bNovoJogo");
		
		bVerRank = new JButton("Ver Rank");
		bVerRank.setOpaque(true);
		bVerRank.setBackground(Color.DARK_GRAY);
		bVerRank.setForeground(Color.WHITE);
		bVerRank.addMouseListener(this);
		bVerRank.setName("bVerRank");
		
		bSair = new JButton("Sair");
		bSair.setOpaque(true);
		bSair.setBackground(Color.DARK_GRAY);
		bSair.setForeground(Color.WHITE);
		bSair.addMouseListener(this);
		bSair.setName("bSair");
	}
	
	private void rank()
	{
		int telaX = Toolkit.getDefaultToolkit().getScreenSize().width;
		int telaY = Toolkit.getDefaultToolkit().getScreenSize().height;
		int i;
		
		janelaRank = new JFrame("Rank");
		janelaRank.setSize(telaX - 750, telaY - 250);
		janelaRank.setLocation(telaX / 4, telaY / 6);
		painelRank = new JPanel();
		painelRank.setBackground(Color.BLACK);
		janelaRank.setContentPane(painelRank);
		
		ArrayList<Jogador> rank;
		rank = Info.getRank();
		
		String colunas[] = {"Nome","Pontos"};
		String dados[][] = new String[rank.size()][2];
		
		for(i = 0; i < rank.size(); i++){
			dados[i][0] = rank.get(i).getNome();
			dados[i][1] = rank.get(i).getPonto() + "";
		}
		
		JTable tabela = new JTable(dados,colunas);
		
		JTextArea lista = new JTextArea();
		
		lista.setRows(rank.size());
		
		for(i = 0; i < rank.size(); i++)
			lista.append(rank.get(i).getNome() + " : " + rank.get(i).getPonto() + "\n");
		
		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setPreferredSize(new Dimension(300, telaY - 300));
		scroll.setOpaque(true);
		scroll.setBackground(Color.BLACK);
		
		painelRank.add(scroll);
		
		janelaRank.setVisible(true);
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if(e.getComponent().getName() == "bNovoJogo")
			novoJogo();
		else if(e.getComponent().getName() == "bVerRank")
			rank();
		else if(e.getComponent().getName() == "bSair")
			System.exit(0);
	}
	
	/*metodos de listener nao usados*/
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}
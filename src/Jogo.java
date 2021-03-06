import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Jogo implements Runnable, KeyListener{

	private ArrayList<JLabel> cubo;
	private ArrayList<Integer> limites;
	private JFrame janela;
	private JPanel painelJogo, painelInfo;
	private JLabel lPontos, lPontosInfo, lDific, lDificInfo;
	private Cobra cobra;
	private Info info;
	private Comida comida;
	private Parede parede;
	private char dirAtual;
	private int delay;
	
	public Jogo()
	{
		int i;
		int telaX = Toolkit.getDefaultToolkit().getScreenSize().width;
		int telaY = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		cubo = new ArrayList<JLabel>();
		limites = new ArrayList<Integer>();
		delay = 800;
		
		janela = new JFrame("Snake");
		janela.setLayout(new BorderLayout(2, 1));
		janela.setSize(700, 500);
		janela.setLocation(telaX / 4, telaY / 6);
		
		painelJogo = new JPanel(new GridLayout(13,20));
		painelJogo.setBackground(Color.DARK_GRAY);
		
		painelInfo = new JPanel(new GridBagLayout());
		painelInfo.setBackground(Color.BLACK);
		
		interfaceInfo();
		
		janela.add(painelJogo, BorderLayout.CENTER);
		janela.add(painelInfo, BorderLayout.WEST);
		
		janela.addKeyListener(this);
		
		/*cria os labels*/
		for(i = 0; i < 208; i += 1){
			cubo.add(new JLabel(""));
			cubo.get(i).setBackground(Color.BLACK);
			cubo.get(i).setOpaque(true);
			painelJogo.add(cubo.get(i));
		}
		
		/*cria um array com os labels que sao o limite*/
		for(i = 0; i < 16; i ++)/*parte cima*/
			limites.add(i);
		for(i = 193; i <= 208; i ++)/*parte baixo*/
			limites.add(i);
		for(i = 0; i < 193; i += 16)/*lado esquerdo*/
			limites.add(i);
		for(i = 15; i <= 208; i += 16)/*lado direito*/
			limites.add(i);
		/*0-15(cimna)16-31(baixo)32-44(esquerdo)45-57(direita)*/
		
		cobra = new Cobra();
		info = new Info();
		comida = new Comida();
		parede = new Parede();
		atualizaComida(comida.getPosicao(), comida.getTipo());
		setParede();
		
		cubo.get(cobra.getPosicao()).setBackground(Color.GREEN);
		dirAtual = 's';
		
		janela.setVisible(true);
	}
	
	private void interfaceInfo()
	{
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		
		painelInfo.setLayout(layout);
		
		lPontos = new JLabel("Pontos");
		lPontos.setForeground(Color.WHITE);
		cons.gridx = 0;
		cons.gridy = 1;
		cons.insets = new Insets(0,20,0,20);
		painelInfo.add(lPontos, cons);
		
		lPontosInfo = new JLabel("0");
		lPontosInfo.setForeground(Color.WHITE);
		cons.gridx = 0;
		cons.gridy = 2;
		cons.ipady = 10;
		painelInfo.add(lPontosInfo, cons);
		
		
		lDific = new JLabel("Dificuldade");
		lDific.setForeground(Color.WHITE);
		cons.gridx = 0;
		cons.gridy = 3;
		cons.ipady = 10;
		painelInfo.add(lDific, cons);
		
		lDificInfo = new JLabel("0");
		lDificInfo.setForeground(Color.WHITE);
		cons.gridx = 0;
		cons.gridy = 4;
		cons.ipady = 10;
		painelInfo.add(lDificInfo, cons);
		
	}
	
	/*thread*/
	public void run()
	{
		int pontos;
		while(true){
			
			moveCobra();
			
			/*verifica se a cobra comeu a comida*/
			if(cobra.comeu( comida.getPosicao() )){
				/*verifica tipo de comida que foi comida, 0 normal - 1 bonus*/
				if(comida.getTipo() == 0)
					info.aumentaPonto(0);
				else
					info.aumentaPonto(1);
				
				/*muda posicao da comida*/
				comida.novaPosicao(parede.getParede(), cobra.getCorpo(), cobra.getPosicao());
				
				/*atualiza nova posico*/
				atualizaComida(comida.getPosicao(), comida.getTipo());
				cobra.aumentaCorpo();
			}
			
			/*verifica se a cobra bateu na parede ou se bateu nela mesma*/
			if(cobra.colidiu(parede.getParede())){
				
				if(JOptionPane.showConfirmDialog(janela, "Salvar as informacoes ?") == 0)
					info.salvaInfo( JOptionPane.showInputDialog("Digite seu nome : ") ); 
				
				Thread.currentThread().interrupt();
				janela.dispatchEvent(new WindowEvent(janela, WindowEvent.WINDOW_CLOSING));
				break;
			}
			
			pontos = info.getPontos();
			
			if(pontos <= 50){
				delay = 500;
				info.setDific(1);
			}else if(pontos > 50 && pontos <= 100){
				delay = 400;
				info.setDific(2);
			}else if(pontos > 100 && pontos <= 150){
				delay = 300;
				info.setDific(3);
			}else if(pontos > 150 && pontos <= 200){
				delay = 200;
				info.setDific(4);
			}else if(pontos > 200 && pontos <= 250){
				delay = 100;
				info.setDific(5);
			}else{
				delay = 50;
				info.setDific(6);
			}
			
			lDificInfo.setText("" + info.getDific());
			lPontosInfo.setText("" + info.getPontos());
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
	/*printa a cobra na nova posicao*/
	private void moveCobra()
	{
		int i, ind, ultimo = 0;
		i = cobra.getPosicao();
		
		/*recebe o array q corresponde ao corpo da cobra*/
		ArrayList<Integer> corpo = cobra.getCorpo();
		
		/*pega o ultimo atual para pintar de preto depois*/
		ultimo = corpo.get( corpo.size() - 1);
		
		if(!(corpo.size() == 1))
			for(ind = corpo.size() - 1; ind > 0; ind--)
				corpo.set(ind, corpo.get(ind - 1));
		
		corpo.set(0, i);
		
		for(ind = 0; ind < corpo.size(); ind++)
			cubo.get(corpo.get(ind)).setBackground(Color.BLUE);

		cubo.get(ultimo).setBackground(Color.BLACK);
		
		if(dirAtual == 'w'){
			if(limites.contains(i) && (i >= 0) && (i < 16)){/*atingiu a parte de cima*/
				cubo.get(192 + i).setBackground(Color.GREEN);
				cobra.atualizaPos(192 + i);
			}else{
				cubo.get(i - 16).setBackground(Color.GREEN);
				cobra.atualizaPos(i - 16);
			}
		}
		else if(dirAtual == 'a'){
			if(verificaLimite(32, 44, i)){/*atingiu o lado esquerdo*/
				cubo.get(i + 15).setBackground(Color.GREEN);
				cobra.atualizaPos(i + 15);
			}else{
				cubo.get(i - 1).setBackground(Color.GREEN);
				cobra.atualizaPos(i - 1);
			}
		}
		else if(dirAtual == 's'){
			if((limites.contains(i)) && (i >= 192) && (i < 208)){/*atingiu a parte de baixo*/
				cubo.get(i - 192).setBackground(Color.GREEN);
				cobra.atualizaPos(i - 192);
			}else{
				cubo.get(i + 16).setBackground(Color.GREEN);
				cobra.atualizaPos(i + 16);
			}
		}
		else if(dirAtual == 'd'){
			if(verificaLimite(45, 57, i)){/*atingiu o lado direito*/
				cubo.get(i - 15).setBackground(Color.GREEN);
				cobra.atualizaPos(i - 15);
			}else{
				cubo.get(i + 1).setBackground(Color.GREEN);
				cobra.atualizaPos(i + 1);
			}
		}
	}

	/*verifica se atingiu o limite do campo do jogo*/
	private boolean verificaLimite(int min, int max, int posAtual)
	{
		/*min e max s�o usados para saber o limite a ser verificado
		 * posAtual usado para compara se chegou no limite ou nao*/
		for(; min <= max; min++){
			if(limites.get(min) == posAtual)
				return true;
		}
			return false;
	}
	
	private void setParede()
	{
		int i;
		for(i = 0; i < parede.getTamanho(); i++)
			cubo.get(  parede.getParede().get(i)  ).setBackground(Color.GRAY);
	}
	
	private void atualizaComida(int posComida, int tipoComida)
	{
		int i;
		for(i = 0; i < cubo.size(); i += 1){
			if(cubo.get(i).getBackground() == Color.RED){
				cubo.get(i).setBackground(Color.BLACK);
				break;
			}
		}
		if(tipoComida == 0)
			cubo.get(posComida).setBackground(Color.RED);
		else
			cubo.get(posComida).setBackground(Color.ORANGE);
	}
	
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar() == 'd')
			if(!(dirAtual == 'a'))
				dirAtual = 'd';
		 
		if(e.getKeyChar() == 'w')
			if(!(dirAtual == 's'))
				dirAtual = 'w';
		
		if(e.getKeyChar() == 's')
			if(!(dirAtual == 'w'))
				dirAtual = 's';
		
		if(e.getKeyChar() == 'a')
			if(!(dirAtual == 'd'))
				dirAtual = 'a';
	}
	
	public void keyPressed(KeyEvent e){}
	
	public void keyReleased(KeyEvent e){}
}

package trabalho;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PrincipalGeniusModelo {

	static List<Integer> vetorComputador = new ArrayList<>();
	static List<Integer> vetorJogador = new ArrayList<>();

	JToggleButton botaoPiscar = null;
	JToggleButton botaoVerde = null;
	JToggleButton botaoAzul = null;
	JToggleButton botaoVermelho = null;
	JToggleButton botaoLaranja = null;

	JToggleButton[] vetorBotao = new JToggleButton[4];

	Boolean match = true;

	public static void main(String[] args) {
		new PrincipalGeniusModelo().processar();

	}

	static JLabel score = new JLabel();
	static JLabel pontos = new JLabel();
	static int ponto = 0;

	public void processar() {

		ImageIcon verde = new ImageIcon("verde.png");
		verde.setImage(verde.getImage().getScaledInstance(100, 100, 200));
		ImageIcon azul = new ImageIcon("azul.png");
		azul.setImage(azul.getImage().getScaledInstance(100, 100, 200));
		ImageIcon laranja = new ImageIcon("amarelo.png");
		laranja.setImage(laranja.getImage().getScaledInstance(100, 100, 200));
		ImageIcon vermelho = new ImageIcon("vermelho.png");
		vermelho.setImage(vermelho.getImage().getScaledInstance(100, 100, 200));

		this.botaoVerde = new JToggleButton(verde);
		this.botaoAzul = new JToggleButton(azul);
		this.botaoLaranja = new JToggleButton(laranja);
		this.botaoVermelho = new JToggleButton(vermelho);
		this.botaoPiscar = new JToggleButton("Iniciar");

		JPanel painelBotoes = new JPanel();
		painelBotoes.add(this.botaoPiscar);
		painelBotoes.add(this.botaoVerde);
		painelBotoes.add(this.botaoAzul);
		painelBotoes.add(this.botaoLaranja);
		painelBotoes.add(this.botaoVermelho);

		score = new JLabel("Score: 0");
		score.setBounds(250, 150, 300, 50);
		pontos = new JLabel(" ");
		pontos.setBounds(250, 150, 300, 50);
		
		painelBotoes.add(score);
		painelBotoes.add(pontos);

		JFrame tela = new JFrame("Genius");
		tela.add(painelBotoes);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.pack(); // faz a aplicação ficar com a melhor dimensão possivel
		tela.setVisible(true); // faz a aplicação ficar visivel
		tela.setLocationRelativeTo(null); // Faz a aplicação abrir no meio da

		// tela
		this.botaoVerde.addActionListener(new VerdeOuvinte(this.botaoVerde));
		this.botaoAzul.addActionListener(new AzulOuvinte(this.botaoAzul));
		this.botaoLaranja.addActionListener(new LaranjaOuvinte(this.botaoLaranja));
		this.botaoVermelho.addActionListener(new VermelhoOuvinte(this.botaoVermelho));

		this.vetorBotao[0] = this.botaoVerde;
		this.vetorBotao[1] = this.botaoAzul;
		this.vetorBotao[2] = this.botaoLaranja;
		this.vetorBotao[3] = this.botaoVermelho;

		this.botaoPiscar.addActionListener(new BotaoIniciarContinuarOuvinte(this.vetorBotao));

	}

	protected void validarJogada() {

		if (vetorJogador.size() == vetorComputador.size()) {
			for (int i = 0; i < vetorJogador.size(); i++) {
				if (vetorJogador.get(i) != vetorComputador.get(i)) {
					// JOptionPane.showInternalMessageDialog(new JPanel().getTopLevelAncestor(),
					// "Errou a sequencia. jogo será encerrado");
					System.exit(0);
				} else {
					score.setText("Score:");
					pontos.setText(String.valueOf(i+1));
					System.out.println("Computador [" + i + "]:" + vetorComputador.get(i));
				}
			}

			JOptionPane.showMessageDialog(null,
					"Parabéns você acertou, proximo nivel : " + vetorComputador.size() + " nível.");

			System.out.println("Acertou todas até o momento.");
		}
	}
}
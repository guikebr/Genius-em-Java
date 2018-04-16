package trabalho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class BotaoIniciarContinuarOuvinte extends PrincipalGeniusModelo implements ActionListener {
	JToggleButton[] vetorBotao = null;

	public BotaoIniciarContinuarOuvinte(JToggleButton[] botao) {
		this.vetorBotao = botao;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no botao PISCAR");

		if (vetorJogador.size() < vetorComputador.size()) {

			JOptionPane.showMessageDialog(null, "Aperte um botao para continuar.");

		} else {

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {

						Random rand = new Random();
						switch (rand.nextInt(4)) {

						case 0:
							vetorComputador.add(0);
							break;

						case 1:
							vetorComputador.add(1);
							break;

						case 2:
							vetorComputador.add(2);
							break;

						case 3:
							vetorComputador.add(3);
							break;

						}

						vetorJogador = new ArrayList<>();
						for (int j = 0; j < vetorComputador.size(); j++) {
							System.out.println("Computador [" + j + "]:" + vetorComputador.get(j));

							if (vetorComputador.get(j) == 0) {
								piscar(vetorBotao[0]);

							} else if (vetorComputador.get(j) == 1) {
								piscar(vetorBotao[1]);

							} else if (vetorComputador.get(j) == 2) {
								piscar(vetorBotao[2]);

							} else if (vetorComputador.get(j) == 3) {
								piscar(vetorBotao[3]);

							}
						}

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();

		}
	}

	private void piscar(JToggleButton botao) throws InterruptedException {
		botao.setSelected(false);
		Thread.sleep(200);
		botao.setSelected(true);
		Thread.sleep(200);
		botao.setSelected(false);
	}
}

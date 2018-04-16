package trabalho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

public class VerdeOuvinte extends PrincipalGeniusModelo implements ActionListener {
	public VerdeOuvinte(JToggleButton botao) {
		this.botaoVerde = botao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no botao VERDE");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// botao2Amarelo.setSelected(true);
				try {
					piscar(botaoVerde);
					vetorJogador.add(0);
					validarJogada();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void piscar(JToggleButton botao) throws InterruptedException {
		for (int i = 0; i < 1; i++) {
			botao.setSelected(false);
			Thread.sleep(200);
			botao.setSelected(true);
			botao.setSelected(false);
		}
	}
}

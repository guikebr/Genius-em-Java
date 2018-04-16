package trabalho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class AzulOuvinte extends PrincipalGeniusModelo implements ActionListener {
	public AzulOuvinte(JToggleButton botao) {
		this.botaoAzul = botao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no botao AZUL");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// botao2Amarelo.setSelected(true);
				try {
					piscar(botaoAzul);
					vetorJogador.add(1);
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
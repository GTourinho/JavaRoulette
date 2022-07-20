package br.ufba.mata55.projeto;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main extends JFrame {
	private Painel painel;

	public Main() {
		painel = new Painel();
		painel.setPreferredSize(new Dimension(Painel.LARGURA, Painel.ALTURA));
		add(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(painel);
		
		
		
	}

	private void executa() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Timer timer = new Timer(1000 / 144, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						painel.repaint();
						Toolkit.getDefaultToolkit().sync();
					}
				});
				timer.start();
			}
		});
	}

	public static void main(String[] args) {
		new Main().executa();
	}
}

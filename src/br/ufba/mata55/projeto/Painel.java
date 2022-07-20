package br.ufba.mata55.projeto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import br.ufba.mata55.projeto.Controle;

public class Painel extends JPanel implements KeyListener, MouseInputListener {
	private static final long serialVersionUID = 1L;

	public static final int LARGURA = 300;
	public static final int ALTURA = 300;
	Tela t = new Tela();
	
	

	public Painel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        t.desenha(g);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();

		if (keyChar == 27) { // Esc
			System.exit(0);
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		char keyChar = e.getKeyChar();
		
		if (keyChar == 10) {
			t.game = 1;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		char keyChar = e.getKeyChar();
		
		if (keyChar == 10) {
			t.game = 0;
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		t.mouse = 1;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		t.mouse = 0;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Controle.mouseX = e.getX();
		Controle.mouseY = e.getY();
	}
}


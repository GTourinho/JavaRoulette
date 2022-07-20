package br.ufba.mata55.projeto;

import java.awt.Color;
import java.awt.Graphics;

public class Verde extends Numero{

	public Verde(int numero, int pos) {
		super(numero, pos);
		
	}

	void desenha(Graphics g) {
		
		
		
	g.setColor(Color.GREEN);
	g.fillRect(super.getPos(), 10, 20, 20);
	g.setColor(Color.BLACK);
	g.drawString(Integer.toString(super.getNumero()), super.getPos()+5, 24);
		

	}
	
}

package br.ufba.mata55.projeto;

import java.awt.Color;
import java.awt.Graphics;

public class Preto extends Numero{

	public Preto(int numero, int pos) {
		super(numero, pos);
		// TODO Auto-generated constructor stub
	}

	void desenha(Graphics g) {
		
		
		g.setColor(Color.BLACK);
		g.fillRect(super.getPos(), 10, 20, 20);
		g.setColor(Color.RED);
		g.drawString(Integer.toString(super.getNumero()), super.getPos()+5, 24);
			

		}
	
}

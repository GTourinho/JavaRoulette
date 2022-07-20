package br.ufba.mata55.projeto;

import java.awt.Color;
import java.awt.Graphics;

public class Vermelho extends Numero{

	public Vermelho(int numero, int pos) {
		super(numero, pos);
		// TODO Auto-generated constructor stub
	}
	
	void desenha(Graphics g) {
		
		
		g.setColor(Color.RED);
		g.fillRect(super.getPos(), 10, 20, 20);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(super.getNumero()), super.getPos()+5, 24);
			

		}

}

package br.ufba.mata55.projeto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tela {

	
	
	Random r = new Random();
	
	Numero[] numeros = new Numero[15];
	
	int game, gamex, valor, mouse, mousei, apostapreto, apostavermelho, apostaverde, saldo = 500;
	
	double velocidade = r.nextInt(50)+50;
	
    int pos = 0, count = 0, vencedor;
	
	void desenha(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 300, 300);
		
		if(game == 1) {
			gamex = 1;
			velocidade = r.nextInt(50)+50;
		}
		
		if(gamex == 1) {
		
		pos += velocidade;
		
		
		count++;
		
		if(count == 100) {
		velocidade -= velocidade/4;
		count = 0;
		}
		
		
		if(velocidade <= 1) {
			
			for(int i=0; i<15; i++) {
				
				if(numeros[i].getPos() > 130 && numeros[i].getPos() <= 150) {
					vencedor = i;
					break;
				}
				
			}
			
			if(numeros[vencedor] instanceof Verde) {
				saldo += apostaverde * 14;
			}
			else if(numeros[vencedor] instanceof Vermelho) {
				saldo += apostavermelho * 2;
			}
			else {
				saldo += apostapreto * 2;
			}
			
			apostapreto = 0;
			apostavermelho = 0;
			apostaverde = 0;
			
			gamex = 0;
			count = 0;
		}
		
		pos = pos%300;
		
		}
		
		numeros[0] = new Verde(0, pos);
		Verde n = (Verde) numeros[0];
		n.desenha(g);
		
		if(pos >= 270) {
			int posj = pos - 300;
			Verde n3 = new Verde(0, posj);
			n3.desenha(g);
		}
		
		for(int i=1; i<15; i++) {
			int posi = pos+(i*20);
			
			posi = posi%300;
			
			
			
			if(i%2 == 0) {
				numeros[i] = new Vermelho(i, posi);
				Vermelho n1 = (Vermelho) numeros[i];
				n1.desenha(g);
				
				// Caso o numero ultrapasse a borda, desenhar sua continuidade no outro canto
				
				if(posi >= 270) {
					int posj = posi - 300;
					Vermelho n3 = new Vermelho(i, posj);
					n3.desenha(g);
				}
			}
			
			else {
				numeros[i] = new Preto(i, posi);
				Preto n2 = (Preto) numeros[i];
				n2.desenha(g);
				
				if(posi >= 270) {
					int posj = posi - 300;
					Preto n3 = new Preto(i, posj);
					n3.desenha(g);
				}
			}
          
		}
		
		g.setColor(Color.DARK_GRAY);
		
		g.fillRect(149, 9, 2, 22);
		g.fillRect(100, 40, 25, 20);
		g.fillRect(130, 40, 25, 20);
		g.fillRect(160, 40, 32, 20);
		g.fillRect(197, 40, 32, 20);
		g.fillRect(234, 40, 43, 20);
		
		g.setColor(Color.BLACK);
		
		g.drawString("+10", 102, 55);
		g.drawString("+50", 132, 55);
		g.drawString("+100", 162, 55);
		g.drawString("+500", 199, 55);
		g.drawString("Limpar", 236, 55);
		
		
		g.drawString("Valor:", 15, 55);
		g.drawString(Integer.toString(valor), 50, 55);
		
		
		g.setColor(Color.RED);
		
		g.fillOval(75, 90, 30, 30);
		
		g.setColor(Color.GREEN);
		
		g.fillOval(135, 90, 30, 30);
		
		g.setColor(Color.BLACK);
		
		g.fillOval(195, 90, 30, 30);
		
		g.setColor(Color.WHITE);
		
		g.drawString("(2x)", 80, 110);
		g.drawString("(14x)", 137, 110);
		g.drawString("(2x)", 200, 110);
		
		g.setColor(Color.RED);
		
		g.drawString(Integer.toString(apostavermelho), 85, 135);
		g.drawString(Integer.toString(apostaverde), 142, 135);
		g.drawString(Integer.toString(apostapreto), 205, 135);
		
		g.setColor(Color.BLACK);
		g.drawString("Saldo: ", 120, 230);
		
		g.setColor(Color.GREEN);
		g.drawString(Integer.toString(saldo), 160, 230);
		
		
		
		
		if(mouse == 1) {
			
			mousei++;
			
		}
		
		else if(mouse == 0) {
			
			mousei = 0;
			
		}
		
		
		
		if(mousei == 1 && gamex == 0) {
			
			// Valor das apostas
			
			if(Controle.mouseX >= 100 && Controle.mouseX <= 125 && Controle.mouseY >= 40 && Controle.mouseY <= 60) {
				valor += 10;
				
			}
			else if(Controle.mouseX >= 130 && Controle.mouseX <= 155 && Controle.mouseY >= 40 && Controle.mouseY <= 60) {
				valor += 50;
				
			}
			else if(Controle.mouseX >= 160 && Controle.mouseX <= 192 && Controle.mouseY >= 40 && Controle.mouseY <= 60) {
				valor += 100;
				
			}
			else if(Controle.mouseX >= 197 && Controle.mouseX <= 229 && Controle.mouseY >= 40 && Controle.mouseY <= 60) {
				valor += 500;
				
			}
			else if(Controle.mouseX >= 234 && Controle.mouseX <= 277 && Controle.mouseY >= 40 && Controle.mouseY <= 60) {
				valor = 0;
				
			}
			
			
			// Cor das apostas
			
			else if(Controle.mouseX >= 75 && Controle.mouseX <= 105 && Controle.mouseY >= 90 && Controle.mouseY <= 120) {
				
				apostavermelho += valor;
				saldo -= valor;
				valor = 0;
				
			}
			else if(Controle.mouseX >= 135 && Controle.mouseX <= 165 && Controle.mouseY >= 90 && Controle.mouseY <= 120) {
				
				apostaverde += valor;
				saldo -= valor;
				valor = 0;
				
			}
			else if(Controle.mouseX >= 195 && Controle.mouseX <= 225 && Controle.mouseY >= 90 && Controle.mouseY <= 120) {
				
				apostapreto += valor;
				saldo -= valor;
				valor = 0;
				
			}
			
			
			
		
			
			if(valor > saldo) {
				valor = saldo;
			}
			
			mousei = 2;
			
		}
		

	}
	
}

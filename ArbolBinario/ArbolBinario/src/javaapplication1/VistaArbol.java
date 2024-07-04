//Realizado por: Francisco Jaramillo - Gabriel Cevallos - 2do "A".
package javaapplication1;

import java.awt.Graphics;
import javax.swing.JPanel;

public class VistaArbol extends JPanel {

    private ArbolBinario arbol;
    private NodoArbol aux;
    private int radio = 20;
    private int verticalSeparation = 50;

    public VistaArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (arbol.getNodoRaiz() != null) {
            dibujarNodo(g, arbol.getNodoRaiz(), getWidth() / 2, 30, getWidth() / 4, aux);
        }
    }

    private void dibujarNodo(Graphics g, NodoArbol nodo, int x, int y, int hSeparation, NodoArbol aux) {
        if (nodo == null) {
            return;
        }
        
        if(nodo.equals(aux)){
            g.setColor(java.awt.Color.GREEN);
        }else{
            g.setColor(java.awt.Color.ORANGE);
        }
        
        g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
        g.setColor(java.awt.Color.BLUE);
        g.drawString(Integer.toString(nodo.valor), x - 6, y + 4);

        if (nodo.getNodoIzquierdo() != null) {
            g.drawLine(x - radio, y + radio, x - hSeparation + radio, y + verticalSeparation - radio);
            dibujarNodo(g, nodo.getNodoIzquierdo(), x - hSeparation, y + verticalSeparation, hSeparation / 2, aux);
        }

        if (nodo.getNodoDerecho() != null) {
            g.drawLine(x + radio, y + radio, x + hSeparation - radio, y + verticalSeparation - radio);
            dibujarNodo(g, nodo.getNodoDerecho(), x + hSeparation, y + verticalSeparation, hSeparation / 2, aux);
        }
    }
    
    public void updateView(NodoArbol nodo){
        this.aux = nodo;        
        repaint();
    }
}

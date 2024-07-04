//Realizado por: Francisco Jaramillo - Gabriel Cevallos - 2do "A".
package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejemplo {
    
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregarNodo(9);
        arbol.agregarNodo(4);
        arbol.agregarNodo(28);
        arbol.agregarNodo(16);
        arbol.agregarNodo(13);
        arbol.agregarNodo(21);
        arbol.agregarNodo(76);
        arbol.agregarNodo(113);
        arbol.agregarNodo(2);
        arbol.agregarNodo(1);
        arbol.agregarNodo(3);
        arbol.agregarNodo(7);
        arbol.agregarNodo(6);
        arbol.agregarNodo(8);
        arbol.agregarNodo(45);

        JFrame frame = new JFrame("Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        
        VistaArbol panel = new VistaArbol(arbol);
        frame.add(panel, BorderLayout.CENTER);
        
        JPanel controlPanel = new JPanel();
        JTextField valorField = new JTextField(5);
        JTextField valorEliminarField = new JTextField(5);
        JButton addButton = new JButton("Añadir Nodo");
        JButton deleteButton = new JButton("Eliminar Nodo");
        
        JButton preButton = new JButton("PreOrden");
        JButton preButton2 = new JButton("Mostrar PreOrden");
        
        JButton inButton = new JButton("Inorden");
        JButton inButton2 = new JButton("Mostrar InOrden");
        
        JButton postButton2 = new JButton("Mostrar PostOrden");
        JButton postButton = new JButton("postOrden");
        
        JTextArea txtArea =  new JTextArea("");
        txtArea.setPreferredSize(new Dimension(300, 100));
        arbol.setViewTree(panel);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int valor = Integer.parseInt(valorField.getText());
                    arbol.agregarNodo(valor);
                    valorField.setText("");
                    panel.repaint();
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int valor = Integer.parseInt(valorEliminarField.getText());
                arbol.borrarNodo(valor);
                valorEliminarField.setText("");
                panel.repaint();
            }
        });
        
        inButton.addActionListener(e -> new Thread(() -> arbol.recorrerInOrden()).start());
        postButton.addActionListener(e -> new Thread(() -> arbol.recorrerPostOrden()).start());
        preButton.addActionListener(e -> new Thread(() -> arbol.recorrerPreOrden()).start());
        
        inButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               txtArea.setText(arbol.getAux());
            }
        });
        
        preButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                txtArea.setText(arbol.getAux());
            }
        });
        
        postButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                txtArea.setText(arbol.getAux());
            }
        });
                
        // Colocar los botones dentro de panel
        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(valorField);
        controlPanel.add(addButton);
        
        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(valorEliminarField);
        controlPanel.add(deleteButton);
        
        controlPanel.add(preButton);
        controlPanel.add(preButton2);
        
        controlPanel.add(inButton);
        controlPanel.add(inButton2);
        
        controlPanel.add(postButton);
        controlPanel.add(postButton2);
        
        controlPanel.add(txtArea);
        
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

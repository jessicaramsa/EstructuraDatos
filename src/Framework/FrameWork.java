package FrameWork;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrameWork implements IFrameWork {
    private JFrame ventana;
    private JPanel panel;
    private JLabel msg;

    public void design() {
        panel = new JPanel();
        panel.setBounds(0, 0, 500, 300);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        ventana = new JFrame();
        ventana.setSize(500, 300);
        ventana.setTitle("Framework");
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(panel);
    }

    @Override
    public void meta(String m) {
        design();
        msg = new JLabel(m);
        msg.setVisible(true);
        msg.setBounds(0, 0, 500, 15);
        panel.add(msg);
    }

    @Override
    public void datos() {}

    @Override
    public void calculosT(long i, long f) {
        long t;
        String m;

        t = f - i;
        m = "Tiempo transcurrido: " + t + " milisegundos.";
        JOptionPane.showMessageDialog(ventana, m, "El tiempo", 2);
    }

    @Override
    public void resultados(Object resul, String titleR) {
        JOptionPane.showMessageDialog(ventana, resul, titleR, 3);
    }

    @Override
    public void navegabilidad() {}
}

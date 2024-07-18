package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_casa;

public class view_casa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CirclePanel circlePanel;
    private logic_view_casa logic;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    view_casa frame = new view_casa();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public view_casa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        
        // Lógica para manejar los focos
        logic = new logic_view_casa();

        // Panel para la imagen
        ImageIcon originalIcon = new ImageIcon("src/recursos/casa.jpg"); // Reemplaza con la ruta de tu imagen
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lblImage = new JLabel(scaledIcon);
        lblImage.setBounds(0, 0, getWidth(), getHeight());

        contentPane.add(lblImage);
        setContentPane(contentPane);

        // Panel para los círculos
        circlePanel = new CirclePanel();
        circlePanel.setOpaque(false); // Hacer el panel transparente
        circlePanel.setBounds(0, 0, getWidth(), getHeight());
        contentPane.add(circlePanel);

        lblImage.add(circlePanel);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        if (contentPane != null) {
            ImageIcon originalIcon = new ImageIcon("src/recursos/casa.jpg"); // Reemplaza con la ruta de tu imagen
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel lblImage = new JLabel(scaledIcon);
            lblImage.setBounds(0, 0, width, height);
            
            contentPane.removeAll();
            contentPane.add(lblImage);
            contentPane.add(circlePanel);
            contentPane.revalidate();
            contentPane.repaint();
        }
    }

    class CirclePanel extends JPanel {
        private static final long serialVersionUID = 1L;

        public CirclePanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    logic.toggleCircleColor(e.getX(), e.getY());
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            logic.drawCircles(g);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BattleshipGame extends JFrame {
    private JPanel player1Panel, player2Panel, shootingPanel;
    private JLabel[][] player1GridLabels, player2GridLabels, shootingGridLabels;
    private final int GRID_SIZE = 10;
    private final int CELL_SIZE = 50;

    public BattleshipGame() {
        setTitle("Battleship Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));

        player1Panel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        player2Panel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        shootingPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        
        player1GridLabels = new JLabel[GRID_SIZE][GRID_SIZE];
        player2GridLabels = new JLabel[GRID_SIZE][GRID_SIZE];
        shootingGridLabels = new JLabel[GRID_SIZE][GRID_SIZE];
        
        initializeGrid(player1Panel, player1GridLabels);
        initializeGrid(player2Panel, player2GridLabels);
        initializeGrid(shootingPanel, shootingGridLabels);
        
        add(player1Panel);
        add(player2Panel);
        add(shootingPanel);

        setSize(3 * GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        setVisible(true);
    }

    private void initializeGrid(JPanel panel, JLabel[][] labels) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setBackground(Color.WHITE);

                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        label.setBackground(Color.BLUE); // Change color for ship placement
                    }
                });

                labels[row][col] = label;
                panel.add(label);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BattleshipGame::new);
    }
}

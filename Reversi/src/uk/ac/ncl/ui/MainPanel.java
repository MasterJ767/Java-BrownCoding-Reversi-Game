/**
 * @author Kostiantyn Potomkin
 * @version 1.1.3
 * @since 05-03-2020
 */
package uk.ac.ncl.ui;

import uk.ac.ncl.Constants;
import uk.ac.ncl.entity.Cell;
import uk.ac.ncl.entity.CellStatus;
import uk.ac.ncl.game.MoveChecker;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static uk.ac.ncl.Constants.*;

public class MainPanel extends JFrame {

    private ArrayList<Cell> grayCells;
    public static int missedMoves = 0;
    private MoveChecker moveChecker;


    public MainPanel() {
        setTitle("Reversi");
        setSize(400, 400);
        setLocationRelativeTo(null);
        addComponentsToPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        moveChecker.removeMoves(grayCells);
        grayCells = moveChecker.findPotentialMoves(PLAYERS_CELL_STATUS);
        moveChecker.colourPieces(grayCells, CellStatus.GRAY);
    }

    /**
     * Sets up the board.
     */
    private void addComponentsToPane() {
        GridLayout gridLayout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
        this.setLayout(gridLayout);
        Cell[][] cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        moveChecker = new MoveChecker(cells);
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                CellStatus cellStatus = CellStatus.EMPTY;
                JButton button = setUpElementDesign();
                Cell tempEl = new Cell(cellStatus, button, i, j);
                if ((i == 3 && j == 4) || (i == 4 && j == 3)) {
                    tempEl.setValue( CellStatus.LIGHT);
                } else if ((i == 4 && j == 4) || (i == 3 && j == 3)) {
                    tempEl.setValue( CellStatus.DARK);
                }
                cells[i][j] = tempEl;
                button.addActionListener(e -> onClick(tempEl));
            }
        }
    }

    /**
     * Applies default design for cells on the board
     *
     * @return JButton with applied design
     */
    private JButton setUpElementDesign(){
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setBorder(new LineBorder(Color.BLACK));

        JButton button = new JButton(EMPTY_STRING);
        button.setPreferredSize(new Dimension(60,60));
        button.setBackground(BOARD_COLOUR);
        panel.setBackground(BOARD_COLOUR);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setOpaque(true);
        panel.add(button);

        return button;
    }

    /**
     * Checks whether the game has finished
     *
     * @param moveChecker the object which contains the boards current arrangement and
     *                    determines which moves can be made and when for each player
     */
    private void CheckNextMove(MoveChecker moveChecker){
        if (missedMoves > 1) {
            JOptionPane.showMessageDialog(this, moveChecker.getFinalScore());
            System.exit(0);
        }
        else
            moveChecker.colourPieces(grayCells, CellStatus.GRAY);
    }

    /**
     * Makes a move for the opponent
     *
     * @param opponent the object which represents an opposing player for the player of the
     *                 game, operated by the computer
     */
    private void MoveOpponent(Cell opponent){
        moveChecker.flipPieces(opponent, OPPONENTS_CELL_STATUS);
        missedMoves += 1;
        moveChecker.removeMoves(grayCells);
        grayCells = moveChecker.findPotentialMoves(PLAYERS_CELL_STATUS);
        if (grayCells.size() == 0)
            missedMoves += moveChecker.findPotentialMoves(OPPONENTS_CELL_STATUS).size() > 0 ? 1 : 2;
        CheckNextMove(moveChecker);
    }

    /**
     * Makes a move for the user with the selected piece
     *
     * @param tempEl selected piece used to calculate which pieces get flipped on the player's turn
     */
    private void MovePlayer(Cell tempEl){
        missedMoves = 0;
        if (tempEl.getMove()!=null) {
            moveChecker.flipPieces(tempEl, PLAYERS_CELL_STATUS);
            Cell opponent = moveChecker.generateOpponent(OPPONENTS_CELL_STATUS);
            if (opponent!=null) {
                opponent.colourTemp(OPPONENTS_COLOUR, true);
                ActionListener taskPerformer = ae -> MoveOpponent(opponent);
                setUpTimer(taskPerformer);
            }
        }
        else{
            CheckNextMove(moveChecker);
        }
    }

    /**
     *
     * Applies the move, if the clicked cell is corresponds to a potential move
     *
     * @param tempEl selected piece used to calculate which pieces get flipped on the player's turn
     */
    private void onClick(Cell tempEl){
        System.out.println("11");
        if (tempEl.getValue() == CellStatus.GRAY) {
            System.out.println("12");
            moveChecker.colourPieces(grayCells, CellStatus.EMPTY);
            System.out.println("13");
            tempEl.colourTemp(PLAYERS_COLOUR, true);
            System.out.println("14");
            ActionListener taskPerformer = ae -> MovePlayer(tempEl);
            System.out.println("15");
            setUpTimer(taskPerformer);
            System.out.println("16");
        }
    }

    /**
     * Creates a delay to make user's and opponent's moves visible
     *
     * @param taskPerformer
     */
    private void setUpTimer(ActionListener taskPerformer){
        Timer timer = new Timer(Constants.DELAY_TIME, taskPerformer);
        System.out.println("17");
        timer.setRepeats(false);
        System.out.println("18");
        timer.start();
        System.out.println("19");
    }
}

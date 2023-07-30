import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class TicTacToe extends JFrame implements ActionListener {
    JButton b[] = new JButton[10];
    int arr[] = new int[10];
    JLabel l1 = new JLabel();
    ImageIcon o = new ImageIcon("src\\images\\oimage.png");
    ImageIcon x = new ImageIcon("src\\images\\ximage.png");
    Timer time = new Timer();

    // constructor---------------------------------------------
    TicTacToe() {
        setTitle("TicTacToe");
        ImageIcon icon = new ImageIcon("src\\images\\xNEON.jpg");
        setIconImage(icon.getImage());
        setSize(500, 500);
        setLayout(new GridLayout(3, 3, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 1; i < 10; i++) {
            b[i] = new JButton();
            add(b[i]);
            b[i].setFocusable(false);
            b[i].addActionListener(this);
            b[i].setBackground(Color.RED);
        }

        setResizable(false);
        setVisible(true);
    }

    // ---------------------------------------------
    int bcount = 0;

    public void actionPerformed(ActionEvent e) {
        // ----button action performed-------------------------------
        for (int i = 1; i <= 9; i++)
            if (e.getSource() == b[i]) {
                bcount++;
                if (bcount % 2 == 0) {
                    b[i].setIcon(o);
                    arr[i] = 1;
                } else {
                    b[i].setIcon(x);
                    arr[i] = 2;
                }

                System.out.println(arr[i]);
                // checking condition ----------------------
                if (bcount > 2 && condition()) {
                    if (arr[i] == 2) {
                        for (int j = 1; j < 10; j++) {
                            b[j].setIcon(new ImageIcon("src\\images\\xwin.png"));
                        }
                        TimerTask task = new TimerTask() {
                            public void run() {
                                reset();
                            }
                        };
                        // if win -----reset game after 3 seconds ----------
                        time.schedule(task, 3000);

                    } else {
                        for (int j = 1; j < 10; j++) {
                            b[j].setIcon(new ImageIcon("src\\images\\owin.png"));
                        }
                        TimerTask task = new TimerTask() {
                            public void run() {
                                reset();
                            }
                        };
                        // if win -----reset game after 3 seconds ----------
                        time.schedule(task, 3000);
                    }
                }
                // ------------------reset if no win occured--------------
                if (bcount == 9 && !condition()) {
                    reset();
                }
            }
    }

    // ---condition-- for x or o win-----------------------------------------------
    boolean condition() {
        if ((arr[1] == 1 && arr[2] == 1 && arr[3] == 1) || ((arr[1] == 2 && arr[2] == 2 && arr[3] == 2))) {
            return true;
        } else if ((arr[4] == 1 && arr[5] == 1 && arr[6] == 1) || (arr[4] == 2 && arr[5] == 2 && arr[6] == 2)) {
            return true;
        } else if ((arr[7] == 1 && arr[8] == 1 && arr[9] == 1) || (arr[7] == 2 && arr[8] == 2 && arr[9] == 2)) {
            return true;
        } else if ((arr[1] == 1 && arr[4] == 1 && arr[7] == 1) || (arr[1] == 2 && arr[4] == 2 && arr[7] == 2)) {
            return true;
        } else if ((arr[2] == 1 && arr[5] == 1 && arr[8] == 1) || (arr[2] == 2 && arr[5] == 2 && arr[8] == 2)) {
            return true;
        } else if ((arr[3] == 1 && arr[6] == 1 && arr[9] == 1) || (arr[3] == 2 && arr[6] == 2 && arr[9] == 2)) {
            return true;
        } else if ((arr[3] == 1 && arr[5] == 1 && arr[7] == 1) || (arr[3] == 2 && arr[5] == 2 && arr[7] == 2)) {
            return true;
        } else if ((arr[1] == 1 && arr[5] == 1 && arr[9] == 1) || (arr[1] == 2 && arr[5] == 2 && arr[9] == 2)) {
            return true;
        } else {
            return false;
        }

    }

    // rest condition ------------------------------------
    void reset() {
        for (int i = 1; i < 10; i++) {
            arr[i] = 0;
            b[i].setIcon(null);
        }
        bcount = 0;
    }

}

// Main---------------------------------------------------------
public class Main {
    public static void main(String[] args) throws Exception {
        new TicTacToe();
    }
}

/*
 * Copyright (C) 2016 18balanagav
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Display;

import java.util.ArrayList;
import elochessrater.EloChessRater;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 18balanagav
 */
public class recordGame extends javax.swing.JFrame {

    private String player2name, player1name;
    private double player1Result, player2Result;

    /**
     * Creates new form recordGame
     */
    public recordGame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        player1Name = new javax.swing.JTextField();
        player2Name = new javax.swing.JTextField();
        player1Win = new javax.swing.JRadioButton();
        player2Win = new javax.swing.JRadioButton();
        draw = new javax.swing.JRadioButton();
        recordButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        player1Name.setText("Player 1's Name");

        player2Name.setText("Player 2's Name");

        player1Win.setText("Player 1 Win");
        player1Win.setVerifyInputWhenFocusTarget(false);

        player2Win.setText("Player 2 Win");

        draw.setText("Draw");

        recordButton.setText("Record");
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(player1Name, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(player2Name)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(player2Win)
                            .addComponent(player1Win)
                            .addComponent(draw, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(recordButton)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(player1Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(recordButton)
                .addGap(9, 9, 9)
                .addComponent(player2Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(player1Win)
                .addGap(18, 18, 18)
                .addComponent(player2Win)
                .addGap(18, 18, 18)
                .addComponent(draw)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        // TODO add your handling code here:
        player1name = player1Name.getText();
        player2name = player2Name.getText();
        player1Result = (player1Win.isSelected()) ? 1 : ((draw.isSelected()) ? 0.5 : 0);
        player2Result = (player2Win.isSelected()) ? 1 : ((draw.isSelected()) ? 0.5 : 0);
        try {
            EloChessRater name = new EloChessRater(player1name, player2name, player1Result, player2Result);
            name.run();
        } catch (IOException ex) {
            Logger.getLogger(recordGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            viewPlayers view = new viewPlayers();
            this.setVisible(false);
            view.run();
        } catch (IOException ex) {
            Logger.getLogger(recordGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_recordButtonActionPerformed

    public void run() {
        new recordGame().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JRadioButton draw;
    private javax.swing.JTextField player1Name;
    private javax.swing.JRadioButton player1Win;
    private javax.swing.JTextField player2Name;
    private javax.swing.JRadioButton player2Win;
    private javax.swing.JButton recordButton;
    // End of variables declaration//GEN-END:variables
}

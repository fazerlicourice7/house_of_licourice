/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramMaker;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author fazer
 */
public class Interface2 extends javax.swing.JPanel {

    static String input;
    
    public Interface2(){
        initComponents();
    }

    public final void initComponents() {

        daFrame = new javax.swing.JInternalFrame();
        inputPane = new javax.swing.JTextField();
        subPermutationButton = new javax.swing.JToggleButton();
        anagramButton = new javax.swing.JToggleButton();
        permutationButton = new javax.swing.JToggleButton();
        Generate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputText = new javax.swing.JTextArea();

        daFrame.setVisible(true);

        inputPane.setText("Enter word(s)");

        subPermutationButton.setText("sub-Permutations");

        anagramButton.setText("Anagrams");

        permutationButton.setText("Permutations");

        Generate.setText("Generate");

        outputText.setColumns(20);
        outputText.setRows(5);
        jScrollPane2.setViewportView(outputText);

        javax.swing.GroupLayout daFrameLayout = new javax.swing.GroupLayout(daFrame.getContentPane());
        daFrame.getContentPane().setLayout(daFrameLayout);
        daFrameLayout.setHorizontalGroup(
                daFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(daFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(daFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputPane)
                                .addComponent(subPermutationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addComponent(anagramButton, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addComponent(permutationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addComponent(Generate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addContainerGap(24, Short.MAX_VALUE))
        );
        daFrameLayout.setVerticalGroup(
                daFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(daFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inputPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subPermutationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anagramButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(permutationButton)
                        .addGap(18, 18, 18)
                        .addComponent(Generate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(daFrame)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(daFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }

    public static String getInput() {
        Generate.addActionListener((ActionEvent e) -> {
            input = inputPane.getText();
        });
        return input;
    }

    public static void setOutput(ArrayList WORDS, ArrayList permutations) {
        if (WORDS.size() < 1) {
            outputText.setText("There are no anagrams of your input. Here are the permutations instead.");
            for (int loop = 0; loop < permutations.size(); loop++) {
                outputText.append((String) permutations.get(loop));
            }
        } else {
            for (int loop = 0; loop < WORDS.size(); loop++) {
                outputText.append((String) WORDS.get(loop));
            }
        }
    }

    private static javax.swing.JButton Generate;
    public static javax.swing.JToggleButton anagramButton;
    public static javax.swing.JInternalFrame daFrame;
    private static javax.swing.JTextField inputPane;
    private static javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea outputText;
    public static javax.swing.JToggleButton permutationButton;
    public static javax.swing.JToggleButton subPermutationButton;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramMaker;

import java.util.ArrayList;

/**
 * @author fazer
 */
public class Interface extends javax.swing.JPanel {

    /**
     * Creates new form Interface
     */
    public Interface() {
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

        inputPane = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputText = new javax.swing.JTextArea();
        Generate = new javax.swing.JToggleButton();

        inputPane.setText("Enter word(s) to find anagram of");

        outputText.setColumns(20);
        outputText.setRows(5);
        jScrollPane2.setViewportView(outputText);

        Generate.setText("Generate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputPane)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(Generate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Generate)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public static String getInput() {
        String input;
        while (!Generate.getModel().isSelected()) {
        }
        input = inputPane.getText();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JToggleButton Generate;
    private static javax.swing.JTextField inputPane;
    private static javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea outputText;
    // End of variables declaration//GEN-END:variables
}
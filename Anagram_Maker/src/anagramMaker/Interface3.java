/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramMaker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fazer
 */
public class Interface3 extends javax.swing.JFrame {

    boolean words = false, perms = false, subPerms = false, subWords = false;
    ArrayList<String> permutations = new ArrayList();
    static String input;

    /**
     * Creates new form Interface3
     */
    public Interface3() {
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

        inputText = new javax.swing.JTextField();
        permutationTButton = new javax.swing.JToggleButton();
        subPermutationTButton = new javax.swing.JToggleButton();
        anagramTButton = new javax.swing.JToggleButton();
        Generate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        subAnagramsTButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputText.setText("Enter Word(s)");

        permutationTButton.setText("Permutations");
        permutationTButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                permutationTButtonStateChanged(evt);
            }
        });

        subPermutationTButton.setText("sub-Permutations");
        subPermutationTButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                subPermutationTButtonStateChanged(evt);
            }
        });

        anagramTButton.setText("Anagrams");
        anagramTButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                anagramTButtonStateChanged(evt);
            }
        });

        Generate.setText("Generate");
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });

        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane1.setViewportView(outputArea);

        subAnagramsTButton.setText("sub Anagrams");
        subAnagramsTButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                subAnagramsTButtonStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subAnagramsTButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anagramTButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subPermutationTButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(inputText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(permutationTButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Generate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permutationTButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subPermutationTButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anagramTButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subAnagramsTButton)
                .addGap(18, 18, 18)
                .addComponent(Generate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
        getPermutations getPermutations2 = new getPermutations();
        checksDictionary checkDictionary = new checksDictionary();
        ArrayListArrayList stringFromArrayList = new ArrayListArrayList();
        input = inputText.getText();
        int length = input.length();
        //in the case of subPermutations
        if (subPerms) {
            ArrayList totalSPerms = new ArrayList();
            for (int loop = 0; loop < length - 1; loop++) {
                input += " ";
                //System.out.println(input + "*");
                totalSPerms.add(getPermutations2.permutations(input));
            }
            //System.out.println("Subperms");
            permutations = stringFromArrayList.getAllContents(totalSPerms);
        } //in the case of Permutations  
        else if (perms) {
            permutations = getPermutations2.permutations(input);
        } //words
        else if (words) {
            permutations = getPermutations2.permutations(input);
            try {
                permutations = checkDictionary.findWords(permutations);
            } catch (IOException ex) {
                Logger.getLogger(Interface3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //split words 
        else if (subWords) {
            ArrayList totalSPerms = new ArrayList();
            for (int loop = 0; loop < length - 1; loop++) {
                input += " ";
                //System.out.println(input + "*");
                totalSPerms.add(getPermutations2.permutations(input));
            }
            //System.out.println("Subperms");
            permutations = stringFromArrayList.getAllContents(totalSPerms);
            try {
                permutations = checkDictionary.findWords(permutations);
            } catch (IOException ex) {
                Logger.getLogger(Interface3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //default is Anagrams (aLL false)
        else if (!(perms && subPerms && words)) {
            permutations = getPermutations2.permutations(input);
            try {
                permutations = checkDictionary.findWords(permutations);
            } catch (IOException ex) {
                Logger.getLogger(Interface3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setOutput(permutations);
    }//GEN-LAST:event_GenerateActionPerformed

    private void permutationTButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_permutationTButtonStateChanged
        perms = permutationTButton.isSelected();
    }//GEN-LAST:event_permutationTButtonStateChanged

    private void subPermutationTButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_subPermutationTButtonStateChanged
        subPerms = subPermutationTButton.isSelected();
    }//GEN-LAST:event_subPermutationTButtonStateChanged

    private void anagramTButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_anagramTButtonStateChanged
        words = anagramTButton.isSelected();
    }//GEN-LAST:event_anagramTButtonStateChanged

    private void subAnagramsTButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_subAnagramsTButtonStateChanged
        subWords = subAnagramsTButton.isSelected();
    }//GEN-LAST:event_subAnagramsTButtonStateChanged

    public void setOutput(ArrayList WORDS) {
        outputArea.setText(null);
        for (int loop = 0; loop < WORDS.size(); loop++) {
            String word = (String) WORDS.get(loop);
            if (word.charAt(0) != ' ' && word.charAt(word.length() - 1) != ' ') {
                outputArea.append((String) WORDS.get(loop));
                outputArea.append("\n");
            }
        }
    }

    public void initialize() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generate;
    private javax.swing.JToggleButton anagramTButton;
    private javax.swing.JTextField inputText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JToggleButton permutationTButton;
    private javax.swing.JToggleButton subAnagramsTButton;
    private javax.swing.JToggleButton subPermutationTButton;
    // End of variables declaration//GEN-END:variables
}
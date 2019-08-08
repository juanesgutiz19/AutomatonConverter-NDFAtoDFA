/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaunoteoria;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Gutierrez
 */
public class AutomatonView extends javax.swing.JFrame {

    /**
     * Creates new form AutomatonView
     */
    
   private String[] transitions;
   private AutomatonController automatonController;
   private String[] inputSymbols;
   private String[] states;
   private FA automaton;
   
    public AutomatonView() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
    
    public AutomatonView(String[] states, String[] inputSymbols){
        initComponents();
        automaton = new FA();
        automatonController = new AutomatonController();
        this.states = states;
        this.inputSymbols = inputSymbols;
        showAutomaton(this.states, this.inputSymbols);
        this.setLocationRelativeTo(null);
    }

    public void showAutomaton(String[] states, String[] inputSymbols){
        addRowsToTable(states.length, inputSymbols.length);
        automatonController.setStates(states);
        automatonController.setSymbols(inputSymbols);
        addSymbolsToTable(automatonController.getMyAutomaton().getInputSymbols());
        addStatesToTable(automatonController.getMyAutomaton().getStates());
    }
    
    public void addRowsToTable(int rows, int columns){
        String i = new String();
        String j = "";
        for (int k = 0; k < columns; k++) 
            i = i.concat(j);
        DefaultTableModel m = (DefaultTableModel) tableAutomaton.getModel();
        for (int k = 0; k < rows; k++) {
            m.addRow(new Object[]{i});
        }
    }
    
    public void addSymbolsToTable(ArrayList<String> symbols) {
        DefaultTableModel m = (DefaultTableModel) tableAutomaton.getModel();
        m.addColumn("States");
        for (int j = 0; j < symbols.size(); j++)
            m.addColumn(symbols.get(j));
    }
    
    public void addStatesToTable(ArrayList<State> states) {
        DefaultTableModel m = (DefaultTableModel) tableAutomaton.getModel();
        m.addColumn("A ó R");
        for (int j = 0; j < states.size(); j++) {
            m.setValueAt(states.get(j).getNameState(), j, 0);
            if (states.get(j).isAcceptingState()) {
                m.setValueAt("A", j, tableAutomaton.getColumnCount() - 1);
            } else {
                m.setValueAt("R", j, tableAutomaton.getColumnCount() - 1);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAutomaton = new javax.swing.JTable();
        buttonAddTransition = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableAutomaton.setBackground(new java.awt.Color(255, 255, 255));
        tableAutomaton.setForeground(new java.awt.Color(0, 0, 0));
        tableAutomaton.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableAutomaton.setGridColor(new java.awt.Color(254, 254, 254));
        tableAutomaton.setSelectionBackground(new java.awt.Color(0, 120, 215));
        tableAutomaton.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tableAutomaton);

        buttonAddTransition.setLabel("Add transition");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddTransition, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddTransition, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public class MyModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int i, int i1) {
            if (i1 < 1) {
                return false;
            } else {
                return true;
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutomatonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutomatonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutomatonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutomatonView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutomatonView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buttonAddTransition;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAutomaton;
    // End of variables declaration//GEN-END:variables
}

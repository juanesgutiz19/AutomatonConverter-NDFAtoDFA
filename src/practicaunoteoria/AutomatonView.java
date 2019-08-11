package practicaunoteoria;

import practicaunoteoria.resources.QueueFA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Gutierrez
 */
public class AutomatonView extends javax.swing.JFrame {

    /**
     * Creates new form AutomatonView
     */
    private AutomatonController automatonController;
    private String[] inputSymbols;
    private String[] states;
    private FA automaton;
    
    public AutomatonView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public AutomatonView(String[] states, String[] inputSymbols) {
        initComponents();
        automaton = new FA();
        automatonController = new AutomatonController();
        this.states = states;
        this.inputSymbols = inputSymbols;
        showAutomaton(this.states, this.inputSymbols);
        this.setLocationRelativeTo(null);
    }
    
    public void showAutomaton(String[] states, String[] inputSymbols) {
        addRowsToTable(states.length, inputSymbols.length);
        automatonController.setStates(states);
        automatonController.setSymbols(inputSymbols);
        addSymbolsToTable(automatonController.getMyAutomaton().getInputSymbols());
        addStatesToTable(automatonController.getMyAutomaton().getStates());
    }
    
    public void addRowsToTable(int rows, int columns) {
        String i = new String();
        String j = "";
        for (int k = 0; k < columns; k++) {
            i = i.concat(j);
        }
        DefaultTableModel m = (DefaultTableModel) tableAutomaton.getModel();
        for (int k = 0; k < rows; k++) {
            m.addRow(new Object[]{i});
        }
    }
    
    private boolean check() {
        int c = 0;
        String[] a;
        for (int i = 0; i < tableAutomaton.getRowCount(); i++) {
            for (int j = 1; j < tableAutomaton.getColumnCount() - 1; j++) {
                String e = (String) tableAutomaton.getValueAt(i, j);
                if (e != null) {
                    if (e.contains(",")) {
                        a = e.split(",");
                        for (int k = 0; k < a.length; k++) {
                            if (getSymbolRow(a[i]) == -10) {
                                return false;
                            }
                        }
                    } else if (getSymbolRow(e) == -10) {
                        return false;
                    }
                } else {
                    if (c == 0) {
                        DefaultTableModel model = (DefaultTableModel) tableAutomaton.getModel();
                        Vector vector = new Vector();
                        vector.add("E");
                        automatonController.getMyAutomaton().getInputSymbols().stream().forEach((_item) -> {
                            vector.add("E");
                        });
                        vector.add("R");
                        model.addRow(vector);
                        c++;
                        automatonController.getMyAutomaton().getStates().add(new State("Err", false, false));
                    }
                    tableAutomaton.setValueAt("E", i, j);
                }
            }
        }
        return true;
    }
    
    public int getSymbolRow(String symbol) {
        int row = -10;
        for (int j = 0; j < tableAutomaton.getRowCount(); j++) {
            if (tableAutomaton.getValueAt(j, 0).toString().equals(symbol)) {
                row = j;
            }
        }
        return row;
    }
    
    public void addStatesToTable(ArrayList<State> states) {
        DefaultTableModel m = (DefaultTableModel) tableAutomaton.getModel();
        m.addColumn("A/R");
        for (int j = 0; j < states.size(); j++) {
            m.setValueAt(states.get(j).getNameState(), j, 0);
            if (states.get(j).isAcceptingState()) {
                m.setValueAt("A", j, tableAutomaton.getColumnCount() - 1);
            } else {
                m.setValueAt("R", j, tableAutomaton.getColumnCount() - 1);
            }
        }
    }
    
    public boolean ItWasProcessed(ArrayList<String> processed, String state) {
        for (int j = 0; j < processed.size(); j++) {
            if (processed.get(j).contains(state)) {
                return true;
            }
        }
        return false;
    }
    
    public void emptyTable() {
        for (int i = 0; i < tableAutomaton.getRowCount(); i++) {
            for (int j = 1; j < tableAutomaton.getColumnCount() - 1; j++) {
                tableAutomaton.setValueAt("", i, j);
            }
        }        
    }
    
    public boolean ItAlreadyExists(ArrayList<String[]> locators, String[] locator) {
        String[] a;
        boolean b = true;
        for (int i = 0; i < locators.size(); i++) {
            a = locators.get(i);
            if (!(a.length == locator.length)) {
                b = false;
            } else {
                b = true;
                for (int j = 0; j < locator.length; j++) {
                    if (!locator[j].equals(a[j])) {
                        b = false;
                    }
                }
                if (b) {
                    return b;
                }
            }
        }
        return b;
    }
    
    public State joinStates(ArrayList<State> states) {
        boolean initialState = false;
        boolean aceptingState = false;
        String r = "";
        for (int j = 0; j < states.size(); j++) {
            r = r + states.get(j).getNameState();
            if (states.get(j).isInitialState()) {
                initialState = true;
            }
            
            if (states.get(j).isAcceptingState()) {
                aceptingState = true;
            }
        }
        State state = new State(r, aceptingState, initialState);
        return state;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAutomaton = new javax.swing.JTable();
        buttonAddTransition = new java.awt.Button();
        buttonCheckAutomaton = new java.awt.Button();
        buttonDeterminism = new java.awt.Button();
        buttonConvert = new java.awt.Button();
        buttonSimplify = new java.awt.Button();
        textFieldString = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableAutomaton.setForeground(new java.awt.Color(0, 0, 0));
        tableAutomaton.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableAutomaton.setGridColor(new java.awt.Color(254, 254, 254));
        tableAutomaton.setSelectionBackground(new java.awt.Color(0, 120, 215));
        jScrollPane1.setViewportView(tableAutomaton);

        buttonAddTransition.setLabel("Add transition");
        buttonAddTransition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddTransitionActionPerformed(evt);
            }
        });

        buttonCheckAutomaton.setLabel("Check the automaton");
        buttonCheckAutomaton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCheckAutomatonActionPerformed(evt);
            }
        });

        buttonDeterminism.setLabel("Determinism or non-determinism");
        buttonDeterminism.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeterminismActionPerformed(evt);
            }
        });

        buttonConvert.setLabel("Convert to deterministic automaton");
        buttonConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConvertActionPerformed(evt);
            }
        });

        buttonSimplify.setLabel("Simplify automaton");
        buttonSimplify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimplifyActionPerformed(evt);
            }
        });

        textFieldString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldStringActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAddTransition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonDeterminism, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(buttonConvert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(buttonSimplify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCheckAutomaton, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldString)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAddTransition, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(buttonDeterminism, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSimplify, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCheckAutomaton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldString, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldStringActionPerformed

    }//GEN-LAST:event_textFieldStringActionPerformed

    private void buttonAddTransitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddTransitionActionPerformed
        int rowIndex = tableAutomaton.getSelectedRow();
        int colIndex = tableAutomaton.getSelectedColumn();
        if (rowIndex >= 0 && colIndex >= 0) {
            String transitionString = JOptionPane.showInputDialog("Write the transition, If you have more than one transition, separate by commas ','");
            tableAutomaton.setValueAt(transitionString, rowIndex, colIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Select the box to add new transitions");
        }
    }//GEN-LAST:event_buttonAddTransitionActionPerformed

    private void buttonDeterminismActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeterminismActionPerformed
        try {
            boolean nonDeterministic = false;
            for (int i = 0; i < tableAutomaton.getRowCount(); i++) {
                for (int j = 1; j < tableAutomaton.getColumnCount() - 1; j++) {
                    if (tableAutomaton.getValueAt(i, j).toString().contains(",")) {
                        nonDeterministic = true;
                    }
                }
            }
            if (nonDeterministic) {
                javax.swing.JOptionPane.showMessageDialog(this, "¡The automaton entered is non-deterministic!");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "¡The automaton entered is deterministic!");
            }
        } catch (NullPointerException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fill the transitions correctly");
        }
    }//GEN-LAST:event_buttonDeterminismActionPerformed
    
    public void addSymbolsToTable(ArrayList<String> symbols) {
        DefaultTableModel m = (DefaultTableModel) tableAutomaton.getModel();
        m.addColumn("States");
        for (int j = 0; j < symbols.size(); j++) {
            m.addColumn(symbols.get(j));
        }
    }
    
    private void addTransitionsToTable(ArrayList<ArrayList<String>> transitions) {
        for (int i = 0; i < transitions.size(); i++) {
            ArrayList<String> transitions1 = transitions.get(i);
            for (int j = 0; j < transitions1.size(); j++) {
                tableAutomaton.setValueAt(transitions1.get(j), i, j + 1);
            }
        }
    }
    
    private ArrayList<State> arentStrangers() {
        ArrayList<State> visited = new ArrayList<>();
        automatonPath(visited, automatonController.getMyAutomaton().getState((String) tableAutomaton.getValueAt(0, 0)));
        return visited;
    }
    
    private void automatonPath(ArrayList<State> visited, State vertex) {
        State auxiliaryState;
        visited.add(vertex);
        for (int i = 1; i < tableAutomaton.getColumnCount() - 1; i++) {
            auxiliaryState = automatonController.getMyAutomaton().getState((String) tableAutomaton.getValueAt(getSymbolRow(vertex.getNameState()), i));
            if (!visited.contains(auxiliaryState)) {
                automatonPath(visited, auxiliaryState);
            }
        }
    }
    

    private void buttonConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConvertActionPerformed
        try {
            ArrayList<String[]> indicators = new ArrayList<>();
            ArrayList<String> processed = new ArrayList<>();
            ArrayList<State> states1 = new ArrayList<>();
            ArrayList<ArrayList<String>> transitions1 = new ArrayList<>();
            ArrayList<String> transitions2 = new ArrayList<>();
            FA auxiliaryAutomaton = new FA(new ArrayList<>());
            QueueFA queue = new QueueFA();
            boolean b = false;
            String state, stateFinite;
            String[] stateI;
            char[] sortS;
            State aux1, aux2;
            aux1 = automatonController.getMyAutomaton().getState(tableAutomaton.getValueAt(0, 0).toString());
            auxiliaryAutomaton.addState(aux1);
            states1.add(aux1);
            processed.add(aux1.getNameState());
            for (int i = 1; i < tableAutomaton.getColumnCount() - 1; i++) {
                state = tableAutomaton.getValueAt(0, i).toString();
                if (state.contains(",")) {
                    stateI = state.split(",");
                    Arrays.sort(stateI);
                    indicators.add(stateI);
                    stateFinite = "";
                    for (String stateI1 : stateI) {
                        stateFinite = stateFinite + stateI1;
                        if (automatonController.getMyAutomaton().getState(stateI1).isAcceptingState()) {
                            b = true;
                        }
                    }
                    sortS = stateFinite.toCharArray();
                    Arrays.sort(sortS);
                    stateFinite = new String(sortS);
                    aux1 = new State(stateFinite, b, false);
                    if (!auxiliaryAutomaton.containsState(aux1.getNameState())) {
                        states1.add(aux1);
                        queue.enqueue(aux1);
                        auxiliaryAutomaton.addState(aux1);
                    }
                    transitions2.add(aux1.getNameState());
                } else {
                    aux1 = automatonController.getMyAutomaton().getState(state);
                    if (!auxiliaryAutomaton.containsState(aux1.getNameState())) {
                        states1.add(aux1);
                        queue.enqueue(aux1);
                        auxiliaryAutomaton.addState(aux1);
                    }
                    transitions2.add(aux1.getNameState());
                }
            }
            transitions1.add((ArrayList<String>) transitions2.clone());
            transitions2.clear();
            String symbolFA = "", symbolAux = "";
            String[] auxI;
            while (!queue.isEmpty()) {
                aux1 = (State) queue.dequeue();
                if (getSymbolRow(aux1.getNameState()) == -10) {
                    for (int i = 0; i < indicators.size(); i++) {
                        auxI = indicators.get(i);
                        b = false;
                        for (int j = 1; j < tableAutomaton.getColumnCount() - 1; j++) {
                            for (String auxI1 : auxI) {
                                String estado = UtilMethods.concatString((String) tableAutomaton.getValueAt(getSymbolRow(auxI1), j), ",");
                                if (!symbolFA.contains(estado)) {
                                    symbolAux = symbolAux + "," + (String) tableAutomaton.getValueAt(getSymbolRow(auxI1), j);
                                    symbolFA = symbolFA + estado;
                                    if (automatonController.getMyAutomaton().getState((String) tableAutomaton.getValueAt(getSymbolRow(auxI1), j)).isAcceptingState() && automatonController.getMyAutomaton().getState((String) tableAutomaton.getValueAt(getSymbolRow(auxI1), j)) != null) {
                                        b = true;
                                    }
                                }
                            }
                            symbolAux = symbolAux.substring(1, symbolAux.length());
                            sortS = symbolFA.toCharArray();
                            Arrays.sort(sortS);
                            symbolFA = new String(sortS);
                            stateI = symbolAux.split(",");
                            Arrays.sort(stateI);
                            if (!ItAlreadyExists(indicators, stateI)) {
                                indicators.add(stateI);
                            }
                            aux2 = new State(symbolFA, b, false);
                            transitions2.add(symbolFA);
                            if (!auxiliaryAutomaton.containsState(aux2.getNameState())) {
                                states1.add(aux2);
                                queue.enqueue(aux2);
                                auxiliaryAutomaton.addState(aux2);
                            }
                            symbolFA = "";
                            symbolAux = "";
                        }
                        if (!ItWasProcessed(processed, UtilMethods.toString(auxI))) {
                            transitions1.add((ArrayList<String>) transitions2.clone());
                            processed.add(UtilMethods.toString(auxI));
                        }
                        transitions2.clear();
                    }
                    indicators.clear();
                } else {
                    for (int i = 1; i < tableAutomaton.getColumnCount() - 1; i++) {
                        state = tableAutomaton.getValueAt(getSymbolRow(aux1.getNameState()), i).toString();
                        if (state.contains(",")) {
                            stateI = state.split(",");
                            Arrays.sort(stateI);
                            indicators.add(stateI);
                            stateFinite = "";
                            for (String stateI1 : stateI) {
                                stateFinite = stateFinite + stateI1;
                                if (automatonController.getMyAutomaton().getState(stateI1).isAcceptingState()) {
                                    b = true;
                                }
                            }
                            sortS = stateFinite.toCharArray();
                            Arrays.sort(sortS);
                            stateFinite = new String(sortS);
                            aux2 = new State(stateFinite, b, false);
                            if (!auxiliaryAutomaton.containsState(aux2.getNameState())) {
                                queue.enqueue(aux2);
                                states1.add(aux2);
                                auxiliaryAutomaton.addState(aux2);
                            }
                            transitions2.add(aux2.getNameState());
                        } else {
                            aux2 = automatonController.getMyAutomaton().getState(state);
                            if (!auxiliaryAutomaton.containsState(aux2.getNameState())) {
                                queue.enqueue(aux2);
                                states1.add(aux2);
                                auxiliaryAutomaton.addState(aux2);
                            }
                            transitions2.add(aux2.getNameState());
                        }
                    }
                    if (!ItWasProcessed(processed, aux1.getNameState())) {
                        transitions1.add((ArrayList<String>) transitions2.clone());
                        processed.add(aux1.getNameState());
                    }
                    transitions2.clear();
                }
            }
            automaton = new FA(transitions1, states1, automatonController.getMyAutomaton().getInputSymbols());
            automatonController.setMyAutomaton(automaton);
            DefaultTableModel m = new DefaultTableModel();
            tableAutomaton.setModel(m);
            System.out.println(tableAutomaton.getColumnName(tableAutomaton.getColumnCount() - 1));
            addSymbolsToTable(automatonController.getMyAutomaton().getInputSymbols());
            addRowsToTable(automatonController.getMyAutomaton().getStates().size(), inputSymbols.length);
            addStatesToTable(automatonController.getMyAutomaton().getStates());
            addTransitionsToTable(automatonController.getMyAutomaton().getTransitions());
        } catch (NullPointerException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "¡Fill the transitions correctly!");
        }
    }//GEN-LAST:event_buttonConvertActionPerformed
    
    public boolean stateBelongsToSet(ArrayList<State> set, String state) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).getNameState().contentEquals(state)) {
                return true;
            }
        }
        return false;
    }
    
    private String getCompositeState(String state, ArrayList<State> states) {
        for (int i = 0; i < states.size(); i++) {
            if (states.get(i).getNameState().contains(state)) {
                return states.get(i).getNameState();
            }
        }
        return "";
    }
    
    public boolean statesBelong(ArrayList<ArrayList<State>> sets, ArrayList<String> states) {
        String test;
        ArrayList<State> set;
        int c;
        for (int i = 0; i < sets.size(); i++) {
            set = sets.get(i);
            test = "";
            for (int j = 0; j < set.size(); j++) {
                test = test + set.get(j).getNameState();
            }
            c = 0;
            for (int j = 0; j < states.size(); j++) {
                if (test.contains(states.get(j))) {
                    c++;
                }
            }
            if (c == states.size()) {
                return true;
            }
        }
        return false;
    }
    
    public void addTransitions(JTable table) {
        try {
            ArrayList<ArrayList<String>> transitions1 = new ArrayList<>();
            ArrayList<String> transitions2;
            int c = 0;
            for (int i = 0; i < table.getRowCount(); i++) {
                transitions2 = new ArrayList<>();
                for (int j = 1; j < table.getColumnCount() - 1; j++) {
                    if (!automatonController.belongsToStates(automatonController.getMyAutomaton().getStates(), table.getValueAt(i, j).toString())) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Las transiciones ingresadas no son correctas. ");
                        emptyTable();
                        c++;
                        break;
                    } else {
                        transitions2.add(table.getValueAt(i, j).toString());
                    }
                }
                if (c != 0) {
                    break;
                } else {
                    transitions1.add(transitions2);
                }
            }
            automatonController.setTransitions(transitions1);
            
        } catch (NullPointerException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor de click en otra parte de la ventana\n"
                    + " (Preferiblemente la primera fila). ");
        }
    }
    private void buttonSimplifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimplifyActionPerformed
        if (check()) {
            try {
                boolean d = true;
                boolean allStatesBelong;
                ArrayList<String> evaluatedTransitions;
                ArrayList<State> auxiliaryStates;
                ArrayList<State> newStates;
                ArrayList<State> set;
                ArrayList<String> inputSymbols1 = automatonController.getMyAutomaton().getInputSymbols();
                ArrayList<ArrayList<State>> setStates = new ArrayList<>();
                automatonController.getMyAutomaton().setStates(arentStrangers());
                automatonController.separateStates(setStates);
                while (d) {
                    for (int i = 0; i < setStates.size(); i++) {
                        auxiliaryStates = setStates.get(i);
                        for (int j = 0; j < inputSymbols1.size(); j++) {
                            evaluatedTransitions = new ArrayList<>();
                            for (int k = 0; k < auxiliaryStates.size(); k++) {
                                evaluatedTransitions.add((String) tableAutomaton.getValueAt(getSymbolRow(
                                        auxiliaryStates.get(k).getNameState()), j + 1));
                            }
                            allStatesBelong = true;
                            if (!statesBelong(setStates, evaluatedTransitions)) {
                                allStatesBelong = false;
                            }
                            if (!allStatesBelong) {
                                for (int k = 0; k < setStates.size(); k++) {
                                    newStates = new ArrayList<>();
                                    for (int l = 0; l < evaluatedTransitions.size(); l++) {
                                        if (stateBelongsToSet(setStates.get(k), evaluatedTransitions.get(l))) {
                                            newStates.add(auxiliaryStates.get(l));
                                        }
                                    }
                                    if (!newStates.isEmpty()) {
                                        set = (ArrayList<State>) newStates.clone();
                                        setStates.add(set);
                                        for (int h = 0; h < newStates.size(); h++) {
                                            evaluatedTransitions.remove(auxiliaryStates.indexOf(newStates.get(h)));
                                            auxiliaryStates.remove(newStates.get(h));
                                        }
                                    }
                                }
                                for (int k = 0; k < setStates.size(); k++) {
                                    if (setStates.get(k).isEmpty()) {
                                        setStates.remove(k);
                                        k = 0;
                                    }
                                }
                            } else {
                                d = false;
                            }
                            if (d) {
                                break;
                            }
                        }
                        
                        if (d) {
                            break;
                        }
                    }
                }
                auxiliaryStates = new ArrayList<>();
                automatonController.setInitialBeginning(setStates);
                for (int i = 0; i < setStates.size(); i++) {
                    auxiliaryStates.add(joinStates(setStates.get(i)));
                }
                
                ArrayList<ArrayList<String>> transicionesAux = new ArrayList<>();
                ArrayList<String> transicionesFE;
                State constTransiciones;
                int index;
                for (int i = 0; i < setStates.size(); i++) {
                    constTransiciones = setStates.get(i).get(0);
                    index = getSymbolRow(constTransiciones.getNameState());
                    transicionesFE = new ArrayList<>();
                    for (int j = 1; j < tableAutomaton.getColumnCount() - 1; j++) {
                        transicionesFE.add(getCompositeState((String) tableAutomaton.getValueAt(index, j), auxiliaryStates));
                    }
                    transicionesAux.add((ArrayList<String>) transicionesFE.clone());
                    
                }
                automaton = new FA(transicionesAux, auxiliaryStates, automatonController.getMyAutomaton().getInputSymbols());
                automatonController.setMyAutomaton(automaton);
                DefaultTableModel model = new DefaultTableModel();
                tableAutomaton.setModel(model);
                System.out.println(tableAutomaton.getColumnName(tableAutomaton.getColumnCount() - 1));
                addSymbolsToTable(automatonController.getMyAutomaton().getInputSymbols());
                addRowsToTable(automatonController.getMyAutomaton().getStates().size(), inputSymbols.length);
                addStatesToTable(automatonController.getMyAutomaton().getStates());
                addTransitionsToTable(automatonController.getMyAutomaton().getTransitions());
            } catch (NullPointerException e) {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Click on another part of the screen");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Fill the transitions correctly");
        }
    }//GEN-LAST:event_buttonSimplifyActionPerformed

    private void buttonCheckAutomatonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCheckAutomatonActionPerformed
        try {
            String string = textFieldString.getText();
            if (string.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Enter s string");
            } else if (automatonController.belongsToSymbols(automatonController.getMyAutomaton().getInputSymbols(), string)) {
                addTransitions(tableAutomaton);
                boolean accepted = automatonController.checkString(string, automatonController.getMyAutomaton().getInputSymbols(), automatonController.getMyAutomaton().getStates(), automatonController.getMyAutomaton().getTransitions());
                if (accepted) {
                    javax.swing.JOptionPane.showMessageDialog(this, "The text entered is accepted");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "The text entered is rejected");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Enter another string");
                textFieldString.setText("");
            }
        } catch (NullPointerException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Click on another part of the screen");
        }
    }//GEN-LAST:event_buttonCheckAutomatonActionPerformed
    
    public class MyModel extends DefaultTableModel {
        
        @Override
        public boolean isCellEditable(int i, int i1) {
            return i1 >= 1;
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
    private java.awt.Button buttonCheckAutomaton;
    private java.awt.Button buttonConvert;
    private java.awt.Button buttonDeterminism;
    private java.awt.Button buttonSimplify;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAutomaton;
    private javax.swing.JTextField textFieldString;
    // End of variables declaration//GEN-END:variables
}

package practicaunoteoria;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que contiene la instancia del autómata finito con el que se trabaja en la aplicación, además contiene 
 * algunos métodos útiles para aportar a la conversión, simplificación y prueba del autómata.
 * 
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class AutomatonController {

    
    private FA myAutomaton = new FA();

    /*
     * Verifica si el estado que se ingresa de primero sí es efectivamente el inicial.
     */
    public boolean isFirstStateInitial(String[] states) {
        return states[0].contains("!");
    }

    /**
     * Método para obtener el autómata finito instanciado.
     * 
     * @return 
     */
    public FA getMyAutomaton() {
        return myAutomaton;
    }

    /*
     * Asigna los estados al autómata con base en la hilera que ingresó el usuario
     * Esta hilera anteriormente se convirtió en un arreglo de string.
     * Si el estado tiene un "." al inicio es de aceptación, si no lo tiene, es de rechazo
     * Si el estado tiene un "!" es el estado inicial, estrictamente tiene que ser el primer 
     * símbolo que se ingrese.
     */
    public void setStates(String[] states) {
        boolean accepting;
        ArrayList<State> automatonStates = new ArrayList<>();
        String symbol;
        boolean initial;
        for (int j = 0; j < states.length; j++) {
            accepting = false;
            initial = false;
            if (states[j].contains(".")) {
                accepting = true;
                if (states[j].contains("!")) {
                    symbol = states[j].substring(states[j].indexOf(".") + 1, states[j].length() - 1);
                    if (j == 0) {
                        initial = true;
                    }
                } else {
                    symbol = states[j].substring(states[j].indexOf(".") + 1, states[j].length());
                }
            } else if ((states[j].contains("!") && initial == false)) {
                symbol = states[j].substring(0, states[j].length() - 1);
                if (j == 0) {
                    initial = true;
                }
            } else {
                symbol = states[j].substring(0, states[j].length());
            }
            State state = new State(symbol, accepting, initial);
            automatonStates.add(state);
        }
        myAutomaton.setStates(automatonStates);
    }

    /**
     * Método que retorna la posición de una transición de un autómata finito, para ello 
     * se manda un conjunto de estados que vendrian siendo transiciones.
     * 
     * @param states
     * @param state
     * @return 
     */
    public int searchState(ArrayList<State> states, String state) {
        int position = 0;
        for (int i = 0; i < states.size(); i++) 
            if (states.get(i).getNameState().equals(state)) 
                position = i;
        return position;
    }
    
    /**
     * Cuando un conjunto tenga estado de aceptación se pone al inicio mediante este método.
     * 
     * @param setStates 
     */
    public void setInitialBeginning(ArrayList<ArrayList<State>> setStates) {
        State aux3;
        ArrayList<State> aux1;
        ArrayList<State> aux2;
        for (int i = 0; i < setStates.size(); i++) {
            aux1 = setStates.get(i);
            for (int j = 0; j < aux1.size(); j++) {
                aux3 = aux1.get(j);
                if (aux3.isInitialState()) {
                    aux2 = setStates.get(0);
                    setStates.set(0, aux1);
                    setStates.set(i, aux2);
                    return;
                }
            }
        }
    }

    /**
     * Método que establece los símbolos del autómata que fueron digitados por el usuario.
     * 
     * @param symbols 
     */
    public void setSymbols(String[] symbols) {
        ArrayList<String> automatonSymbols = new ArrayList<>();
        automatonSymbols.addAll(Arrays.asList(symbols));
        myAutomaton.setInputSymbols(automatonSymbols);
    }

    /**
     * Método que ayuda a separar los estados de aceptación con los estados de rechazo.
     * 
     * @param setStates 
     */
    public void separateStates(ArrayList<ArrayList<State>> setStates) {
        ArrayList<State> Astates = new ArrayList<>();
        ArrayList<State> Rstates = new ArrayList<>();
        for (int i = 0; i < myAutomaton.getStates().size(); i++) 
            if (myAutomaton.getStates().get(i).isAcceptingState()) {
                Rstates.add(myAutomaton.getStates().get(i));
            } else {
                Astates.add(myAutomaton.getStates().get(i));
            }
        setStates.add(Astates);
        setStates.add(Rstates);
    }

    /**
     * Método que establece las transiciones del autómata que fueron ingresadas por el usuario.
     * 
     * @param transitions 
     */
    public void setTransitions(ArrayList<ArrayList<String>> transitions) {
        myAutomaton.setTransitions(transitions);
    }

    /**
     * Método que nos retorna verdadero si una transición digitada por el usuario
     * pertenece a cierto conjunto de estados.
     * 
     * @param states
     * @param transition
     * @return 
     */
    public boolean belongsToStates(ArrayList<State> states, String transition) {
        boolean j = true;
        for (int i = 0; i < states.size(); i++) 
            if (!transition.equals(states.get(i).getNameState())) {
                j = false;
            } else {
                j = true;
                break;
            }
        return j;

    }

    /**
     * Método que retorna las transiciones del autómata finito instanciado.
     * 
     * @return 
     */
    public ArrayList<ArrayList<String>> getTransitions() {
        return myAutomaton.getTransitions();
    }

    /**
     * Método que retorna verdadero si la hilera digitada por el usuario contiene los símbolos de entrada 
     * del autómata finito.
     * 
     * @param inputSymbols
     * @param string
     * @return 
     */
    public boolean belongsToSymbols(ArrayList<String> inputSymbols, String string) {
        boolean b = true;
        int c;
        String charOfString;
        for (int i = 0; i < string.length(); i++) {
            charOfString = Character.toString(string.charAt(i));
            c = 0;
            for (int j = 0; j < inputSymbols.size(); j++) {
                if (!charOfString.equals(inputSymbols.get(j))) {
                    c++;
                }
                if (c == inputSymbols.size()) {
                    b = false;
                    break;
                }
            }
            if (b == false) {
                break;
            }
        }
        return b;
    }

    /**
     * Método que establece el autómata finito.
     * 
     * @param myAutomaton 
     */
    public void setMyAutomaton(FA myAutomaton) {
        this.myAutomaton = myAutomaton;
    }
    
    /**
     * El método verifica si la hilera que fue digitada por el usuario es válida para el autómata, retorna verdadero si lo es.
     * 
     * @param string
     * @param symbols
     * @param states
     * @param transitions
     * @return 
     */
    public boolean checkString(String string, ArrayList<String> symbols, ArrayList<State> states, ArrayList<ArrayList<String>> transitions) {
        boolean accepted;
        String transition1;
        String charString;
        int row = 0;
        int column = 0;
        int countString = 0;
        while (countString < string.length()) {
            if (column < symbols.size()) {
                charString = Character.toString(string.charAt(countString));
                if (charString.equals(symbols.get(column))) {
                    transition1 = transitions.get(row).get(column);
                    row = searchState(states, transition1);
                    column = 0;
                    countString++;
                } else {
                    column++;
                }
            } else {
                column = 0;
            }
        }
        accepted = states.get(row).isAcceptingState();
        return accepted;
    }
}

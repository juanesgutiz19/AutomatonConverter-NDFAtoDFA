
package practicaunoteoria;

import java.util.ArrayList;

/**
 * Class Finite Automaton: Es válida tanto para determinísticos como para no determinísticos, por lo 
 * que tiene un arraylist de arraylist de Strings de transiciones, lo que conlleva a poder tener una sola 
 * transición o más.
 * 
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class FA {
    
    private boolean containsNullSecuence;
    private ArrayList<ArrayList<String>> transitions;
    private ArrayList<State> states;
    private ArrayList<String> inputSymbols;

    /**
     * Contructor vacío del autómata finito
     */
    public FA(){
        
    }
    
    /**
     * Contructor con parámetros del autómata finito, en él hay un atributo booleano que nos determina si el autómata 
     * acepta la secuencia nula o no. Además un arreglo de estados, de transiciones y un arreglo de arreglos de string 
     * para almacenar las transiciones, puesto que el autómata puede ser determinístico o no determinístico.
     * 
     * @param containsNullSecuence
     * @param transitions
     * @param states
     * @param inputSymbols 
     */
    public FA(boolean containsNullSecuence, ArrayList<ArrayList<String>> transitions, ArrayList<State> states, ArrayList<String> inputSymbols) {
        this.containsNullSecuence = containsNullSecuence;
        this.transitions = transitions;
        this.states = states;
        this.inputSymbols = inputSymbols;
    }
    
    /**
     * Método para obtener todos los valores de los atributos de un estado con determinado nombre.
     * 
     * @param state
     * @return 
     */
    public State getState(String state){
        for (int j = 0; j < states.size(); j++) 
            if (states.get(j).getNameState().equals(state)) return states.get(j);                    
        State a;
        a = new State();
        return a;
    }
         
    /**
     * Constructor con parámetros de un autómata finito, en este caso no le entra como parámetro el booleano para 
     * saber si el autómata acepta secuencia nula o no.
     * 
     * @param transitions
     * @param states
     * @param inputSymbols 
     */
    public FA(ArrayList<ArrayList<String>> transitions, ArrayList<State> states, ArrayList<String> inputSymbols) {
        this.transitions = transitions;
        this.states = states;
        this.inputSymbols = inputSymbols;
    }

    /**
     * Constructor con parámetros, en este caso solo recibe como parámetros el conjunto de estados y símbolos de 
     * entrada del autómata.
     * 
     * @param states
     * @param inputSymbols 
     */
    public FA(ArrayList<State> states, ArrayList<String> inputSymbols) {
        this.states = states;
        this.inputSymbols = inputSymbols;
    }

    /**
     * Constructor que solo recibe como parámetro el conjunto de estados del autómata.
     * 
     * @param states 
     */
    public FA(ArrayList<State> states) {
        this.states = states;
    }

    /**
     * Método que retorna verdadero si un autómata contiene cierto estado.
     * 
     * @param state
     * @return 
     */
    public boolean containsState(String state){
        for (int j = 0; j < states.size(); j++)
            if (states.get(j).getNameState().equals(state)) return true;
        return false;
    }
    
    /**
     * Método que nos retorna verdadero si un autómata contiene la secuencia nula.
     * 
     * @return 
     */
    public boolean isContainsNullSecuence() {
        return containsNullSecuence;
    }
    
    /**
     * Método para agregar un estado al conjunto de estados del autómata.
     * 
     * @param state 
     */
    public void addState(State state){
        this.states.add(state);
    }

    /**
     * Método que sirve para establecer si un autómata acepta la secuencia nula.
     * 
     * @param containsNullSecuence 
     */
    public void setContainsNullSecuence(boolean containsNullSecuence) {
        this.containsNullSecuence = containsNullSecuence;
    }

    /**
     * Método que retorna el arreglo de transiciones que tiene un autómata
     * 
     * @return 
     */
    public ArrayList<ArrayList<String>> getTransitions() {
        return transitions;
    }
    
    /**
     * Método que establece las transiciones de un autómata.
     * 
     * @param transitions 
     */
    public void setTransitions(ArrayList<ArrayList<String>> transitions) {
        this.transitions = transitions;
    }

    /**
     * Método que nos devuelve los estados correspondientes a un autómata.
     * 
     * @return 
     */
    public ArrayList<State> getStates() {
        return states;
    }

    /**
     * Métpdp que establece los estados de un autómata.
     * 
     * @param states 
     */
    public void setStates(ArrayList<State> states) {
        this.states = states;
    }
    
    /**
     * Método que retorna los símbolos de entrada de un autómata.
     * 
     * @return 
     */
    public ArrayList<String> getInputSymbols() {
        return inputSymbols;
    }

    /**
     * Método que establece los símbolos de entrada de un autómata.
     * 
     * @param inputSymbols 
     */
    public void setInputSymbols(ArrayList<String> inputSymbols) {
        this.inputSymbols = inputSymbols;
    } 
}

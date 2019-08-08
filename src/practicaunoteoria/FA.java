/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaunoteoria;

import java.util.ArrayList;

/**
 * Class Finite Automaton: Es válida tanto para determinísticos como para no determinísticos, por lo 
 * que tiene un arraylist de arraylist de Strings de transiciones, lo que conlleva a poder tener una sola 
 * transición o más.
 * @author Juan Gutierrez
 */
public class FA {
    
    private boolean containsNullSecuence;
    private ArrayList<ArrayList<String>> transitions;
    private ArrayList<State> states;
    private ArrayList<String> inputSymbols;

    public FA(){
        
    }
       
    /*
    public boolean containsState(String state){
        states.forEach((s) -> {
            if (s.getNameState().equals(state)){
                return true;
            }
        });
        return false;
    }
    */
      
    public FA(boolean containsNullSecuence, ArrayList<ArrayList<String>> transitions, ArrayList<State> states, ArrayList<String> inputSymbols) {
        this.containsNullSecuence = containsNullSecuence;
        this.transitions = transitions;
        this.states = states;
        this.inputSymbols = inputSymbols;
    }
    
    public State getState(String state){
        for (int j = 0; j < states.size(); j++) 
            if (states.get(j).getNameState().equals(state)) return states.get(j);                    
        State a;
        a = new State();
        return a;
    }
            
    public FA(ArrayList<ArrayList<String>> transitions, ArrayList<State> states, ArrayList<String> inputSymbols) {
        this.transitions = transitions;
        this.states = states;
        this.inputSymbols = inputSymbols;
    }

    public FA(ArrayList<State> states, ArrayList<String> inputSymbols) {
        this.states = states;
        this.inputSymbols = inputSymbols;
    }

    public FA(ArrayList<State> states) {
        this.states = states;
    }

    public boolean containsState(String state){
        for (int j = 0; j < states.size(); j++)
            if (states.get(j).getNameState().equals(state)) return true;
        return false;
    }
    public boolean isContainsNullSecuence() {
        return containsNullSecuence;
    }

    public void setContainsNullSecuence(boolean containsNullSecuence) {
        this.containsNullSecuence = containsNullSecuence;
    }

    public ArrayList<ArrayList<String>> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<ArrayList<String>> transitions) {
        this.transitions = transitions;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public ArrayList<String> getInputSymbols() {
        return inputSymbols;
    }

    public void setInputSymbols(ArrayList<String> inputSymbols) {
        this.inputSymbols = inputSymbols;
    }
    
}

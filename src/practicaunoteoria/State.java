/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaunoteoria;

/**
 *
 * @author Juan Gutierrez
 */

public class State {
    
    private String nameState;
    private boolean  acceptingState;
    private boolean initialState;
    
    public State(String nameState, boolean acceptingState, boolean initialState) {
        this.nameState = nameState;
        this.acceptingState = acceptingState;
        this.initialState = initialState;
    }

    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    public boolean isAcceptingState() {
        return acceptingState;
    }

    public void setAcceptingState(boolean acceptingState) {
        this.acceptingState = acceptingState;
    }

    public boolean isInitialState() {
        return initialState;
    }

    public void setInitialState(boolean initialState) {
        this.initialState = initialState;
    }
    
    State(){
        
    }
}

package practicaunoteoria;

/**
 * Clase que contiene métodos y atributos relacionados a un estado.
 * 
 * @author Andrés Quintero
 * @author Juan Esteban Gutiérrez
 */
public class State {
    
    private String nameState;
    private boolean  acceptingState;
    private boolean initialState;
    
    /**
     * Contructor de la clase Estado, en este caso recibe el nombre de este, un booleano para determinar si este es un
     * estado de aceptación (true) o rechazo (false) y otro booleano para determinar si el estado ingresado por el usuario es 
     * estado inicial.
     * 
     * @param nameState
     * @param acceptingState
     * @param initialState 
     */
    public State(String nameState, boolean acceptingState, boolean initialState) {
        this.nameState = nameState;
        this.acceptingState = acceptingState;
        this.initialState = initialState;
    }

    /**
     * Método para obtener el nombre de un estado.
     * 
     * @return 
     */
    public String getNameState() {
        return nameState;
    }

    /**
     * Método para establecer o modificar el nombre de un estado.
     * 
     * @param nameState 
     */
    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    /**
     * Método para saber si un estado es de aceptación o rechazo.
     * 
     * @return 
     */
    public boolean isAcceptingState() {
        return acceptingState;
    }

    /**
     * Método para establecer si un estado es de aceptación o rechazo.
     * 
     * @param acceptingState 
     */
    public void setAcceptingState(boolean acceptingState) {
        this.acceptingState = acceptingState;
    }

    /**
     * Método que retorna verdadero si un estado es inicial.
     * 
     * @return 
     */
    public boolean isInitialState() {
        return initialState;
    }

    /**
     * Método que establece si un estado es inicial.
     * 
     * @param initialState 
     */
    public void setInitialState(boolean initialState) {
        this.initialState = initialState;
    }
    
    /**
     * Constructor vacío de la clase Estado.
     */
    State(){
        
    }
}

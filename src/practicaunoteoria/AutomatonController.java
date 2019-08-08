package practicaunoteoria;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Juan Gutierrez
 */
public class AutomatonController {

    private FA myAutomaton = new FA();

    
    public boolean isFirstStateInitial(String[] states) {
        return states[0].contains("!");
    }
    
    
    public FA getMyAutomaton() {
        return myAutomaton;
    }

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
    
    public void setSymbols(String[] symbols) {
        ArrayList<String> automatonSymbols = new ArrayList<>();
        automatonSymbols.addAll(Arrays.asList(symbols));
        myAutomaton.setInputSymbols(automatonSymbols);
    }


}

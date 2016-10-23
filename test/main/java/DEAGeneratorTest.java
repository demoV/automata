package main.java;

import main.java.dfa.DFA;
import main.java.dfa.Transitions;
import main.java.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DEAGeneratorTest {
    @Test
    public void shouldParseJsonAndCanRunAllTestCases() throws Exception {
        String jsonString = "{'name':'odd number of zeroes'," +
                "'type':'dfa'," +
                "'tuple':{'states':['q1','q2']," +
                "'alphabets':['1','0']," +
                "'delta':{'q1':{'0':'q2','1':'q1'},'q2':{'0':'q1','1':'q2'}},'" +
                "start_state':'q1'," +
                "'final_states':['q2']}," +
                "'pass_cases':['0','000','00000','10','101010','010101']," +
                "'fail_cases':['00','0000','1001','1010','001100']}";

        final Parser parser = new Parser();
        DFAManager dfaManager = parser.toDfARunner(jsonString);

        DFARunner runner = dfaManager.createRunner(new DFAGenerator() {
            @Override
            public DFA create(List<String> states, List<String> alphabets, HashMap<String, HashMap<String, String>> delta, String startState, List<String> finalStates) {
                HashSet<String> statesSet = new HashSet<>(states);
                HashSet<String> alphabetSet = new HashSet<>(alphabets);
                HashSet<String> finalSet = new HashSet<>(finalStates);
                Transitions transitions = new Transitions();
                transitions.addAll(delta);
                return new DFA(statesSet, alphabetSet, startState, finalSet, transitions);
            }
        });

        Assert.assertTrue(runner.runAll());
    }

    @Test
    public void canRunAllFromFile() throws Exception {

    }
}
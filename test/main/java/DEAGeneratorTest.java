package main.java;

import org.junit.Test;

public class DEAGeneratorTest {
    @Test
    public void shouldGiveDFAOfGivenJSON() throws Exception {
        String jsonString = "{'name':'odd number of zeroes'," +
                "'type':'dfa'," +
                "'tuple':{'states':['q1','q2']," +
                "'alphabets':['1','0']," +
                "'delta':{'q1':{'0':'q2','1':'q1'},'q2':{'0':'q1','1':'q2'}},'" +
                "startState':'q1'," +
                "'finalStates':['q2']}," +
                "'passCases':['0','000','00000','10','101010','010101']," +
                "'failCases':['00','0000','1001','1010','001100']}";

        final Parser parser = new Parser();
        DFAInput dfaInput = parser.toDFAInput(jsonString);

    }
}
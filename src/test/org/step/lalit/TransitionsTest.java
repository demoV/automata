package org.step.lalit;

import org.junit.Test;
import org.step.lalit.dfa.Transitions;

import static org.junit.Assert.assertEquals;

public class TransitionsTest {
    @Test
    public void shouldGiveNextState() throws Exception {
        Transitions transitions = new Transitions();
        transitions.add("q1", "1", "q1");
        transitions.add("q1", "0", "q2");

        assertEquals("q1", transitions.nextState("q1", "1"));
        assertEquals("q2", transitions.nextState("q1", "0"));

    }
}
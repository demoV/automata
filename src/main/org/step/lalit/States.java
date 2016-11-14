package org.step.lalit;

import java.util.HashSet;

public class States extends HashSet<String> {

    public Boolean containsAny(States finalState) {
        for (String state : finalState) {
            if (this.contains(state))
                return true;
        }
        return false;
    }
}

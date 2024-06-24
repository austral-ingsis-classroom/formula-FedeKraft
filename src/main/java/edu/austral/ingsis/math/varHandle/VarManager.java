package edu.austral.ingsis.math.varHandle;

import edu.austral.ingsis.math.VarValue;

import java.util.*;
import edu.austral.ingsis.math.*;


public class VarManager {
    private final Map<String, VarValue> vars = new HashMap<>();

    public VarManager(Function func) {
        collectVars(func);
    }

    private void collectVars(Function func) {
        VariableProcessor processor = new VariableProcessor();
        func.accept(processor);
        Set<String> varNames = processor.getHashSet();
        for (String name : varNames) {
            vars.putIfAbsent(name, new VarValue(name));
        }
    }

    public List<String> getVarNames() {
        return new ArrayList<>(vars.keySet());
    }
}
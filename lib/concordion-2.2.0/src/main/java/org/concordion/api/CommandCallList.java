package org.concordion.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.unmodifiableList;


public class CommandCallList {

    private List<CommandCall> commandCalls = new ArrayList<CommandCall>();
    
    public boolean isEmpty() {
        return commandCalls.isEmpty();
    }

    public void setUp(Evaluator evaluator, ResultRecorder resultRecorder, Fixture fixture) {
        for(CommandCall call : commandCalls) call.setUp(evaluator, resultRecorder, fixture);
    }
    
    public void execute(Evaluator evaluator, ResultRecorder resultRecorder, Fixture fixture) {
        for(CommandCall call : commandCalls) call.execute(evaluator, resultRecorder, fixture);
    }

    public void verify(Evaluator evaluator, ResultRecorder resultRecorder, Fixture fixture) {
        for(CommandCall call : commandCalls) call.verify(evaluator, resultRecorder, fixture);
    }

    public void processSequentially(Evaluator evaluator, ResultRecorder resultRecorder, Fixture fixture) {
        for(CommandCall call : commandCalls) {
            call.setUp(evaluator, resultRecorder, fixture);
            call.execute(evaluator, resultRecorder, fixture);
            call.verify(evaluator, resultRecorder, fixture);
        }
    }

    public void append(CommandCall commandCall) {
        commandCalls.add(commandCall);
    }

    public int size() {
        return commandCalls.size();
    }
    
    public CommandCall get(int index) {
        return commandCalls.get(index);
    }

    public Collection<CommandCall> asCollection() {
        return unmodifiableList(commandCalls);
    }

    public void remove(CommandCall element) {
        commandCalls.remove(element);
    }
}

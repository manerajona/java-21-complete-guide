package com.manerajona.java.designpatterns.behavioral.state.example3;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;

enum States {
    OFF_HOOK,   // starting
    ON_HOOK,    // terminal
    CONNECTING,
    CONNECTED,
    ON_HOLD
}

enum Events {
    CALL_DIALED,
    HUNG_UP,
    CALL_CONNECTED,
    PLACED_ON_HOLD,
    TAKEN_OFF_HOLD,
    LEFT_MESSAGE,
    STOP_USING_PHONE
}

class SpringStateMachine {

    static StateMachine<States, Events> buildMachine() throws Exception {
        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

        // Configure states: initial and all states
        builder.configureStates()
                .withStates()
                .initial(States.OFF_HOOK)
                .states(EnumSet.allOf(States.class));

        // Configure transitions
        builder.configureTransitions()
                .withExternal()
                .source(States.OFF_HOOK)
                .event(Events.CALL_DIALED)
                .target(States.CONNECTING)
                .and()
                .withExternal()
                .source(States.OFF_HOOK)
                .event(Events.STOP_USING_PHONE)
                .target(States.ON_HOOK)
                .and()
                .withExternal()
                .source(States.CONNECTING)
                .event(Events.HUNG_UP)
                .target(States.OFF_HOOK)
                .and()
                .withExternal()
                .source(States.CONNECTING)
                .event(Events.CALL_CONNECTED)
                .target(States.CONNECTED)
                .and()
                .withExternal()
                .source(States.CONNECTED)
                .event(Events.LEFT_MESSAGE)
                .target(States.OFF_HOOK)
                .and()
                .withExternal()
                .source(States.CONNECTED)
                .event(Events.HUNG_UP)
                .target(States.OFF_HOOK)
                .and()
                .withExternal()
                .source(States.CONNECTED)
                .event(Events.PLACED_ON_HOLD)
                .target(States.ON_HOLD)
                .and()
                .withExternal()
                .source(States.ON_HOLD)
                .event(Events.TAKEN_OFF_HOLD)
                .target(States.CONNECTED)
                .and()
                .withExternal()
                .source(States.ON_HOLD)
                .event(Events.HUNG_UP)
                .target(States.OFF_HOOK);

        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        StateMachine<States, Events> machine = buildMachine();
        machine.start();

        final States exitState = States.ON_HOOK;

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (machine.getState().getId() != exitState) {
                State<States, Events> currentState = machine.getState();
                System.out.println("The phone is currently " + currentState.getId());
                System.out.println("Select a trigger:");

                // Get possible transitions from the current state
                List<Transition<States, Events>> transitions = machine.getTransitions()
                        .stream()
                        .filter(t -> t.getSource() == currentState)
                        .toList();

                IntStream.range(0, transitions.size())
                        .mapToObj(i -> String.format("(%d) %s", i, transitions.get(i).getTrigger().getEvent()))
                        .forEach(System.out::println);

                // Retrieve a valid user choice
                int choice = getUserChoice(console, transitions.size());

                // Send the chosen event to perform the transition
                machine.sendEvent(transitions.get(choice).getTrigger().getEvent());
            }
        }
        System.out.println("And we are done!");
    }

    /**
     * Reads and validates the user's choice.
     *
     * @param console    The BufferedReader for input.
     * @param maxOptions The number of available options.
     * @return A valid choice index.
     */
    private static int getUserChoice(BufferedReader console, int maxOptions) {
        while (true) {
            try {
                System.out.print("Please enter your choice: ");
                int choice = Integer.parseInt(console.readLine());
                if (choice >= 0 && choice < maxOptions) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please choose a number between 0 and " + (maxOptions - 1) + ".");
                }
            } catch (NumberFormatException | IOException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}

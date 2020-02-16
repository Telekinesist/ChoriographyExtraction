package networks;

public interface Behavior {
    enum Action {
        Condition,
        Offering,
        ProcedureInvocation,
        Receive,
        Selection,
        Send,
        Termination
    }

    Action getAction();

    Behavior copy();

    int hashCode();

    boolean equals(Behavior other);


}

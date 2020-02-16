package networks;

import java.util.HashMap;

public class ProcessTerm {
    private HashMap<String, Behavior> procedures;   //Map from procedure names to their behaviours
    private Behavior main;                          //The main behaviour for the procedure

    /***
     * Constructor for ProcessTerm
     * @param procedures A HashMap from the procedure name as string, to the Behaviour of that procedure
     * @param main The main Behaviour for this procedure
     */
    public ProcessTerm(HashMap<String, Behavior> procedures, Behavior main){
        this.procedures = procedures;
        this.main = main;
    }

    /***
     * Converts the procedures into a human readable format
     * @return string representing this mapping
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        procedures.forEach((key, value) -> {
            builder.append(String.format("def %s{%s} ", key, value));
        });
        builder.append(String.format("main {%s}}", main));
        return builder.toString();
    }

    /***
     * Makes a deep copy of this object
     * @return copy of this object instance
     */
    public ProcessTerm copy(){
        HashMap<String, Behavior> proceduresCopy = new HashMap<>(procedures.size());
        procedures.forEach((key, value) -> {
            proceduresCopy.put(key, value.copy());
        });
        return new ProcessTerm(proceduresCopy, main.copy());
    }

    /***
     * Compares this object with another object for equality.
     * @param other the object to compare with
     * @return true if both objects are functionally identical
     */
    public boolean equals(ProcessTerm other){
        if (this == other)          //If it is the same object
            return true;
        if (main != other.main)     //The main Behaviours must be identical
            return false;
        return procedures.equals(other.procedures); //They are equal if the mapping is equal
    }

    /***
     * Calculates the hashcode for this ProcessTerm.
     * The hash is calculated from the mapping, as well as the main behaviour
     * @return the hashvalue considering all behaviours
     */
    public int hashCode(){
        int hash = procedures.hashCode();
        return 31 * hash + main.hashCode();
    }
}

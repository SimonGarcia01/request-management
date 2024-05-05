package model;

public interface EfficiencyCalculable {
    //Methods
    //Calculate Efficiency
    /**
     * <p><b>EfficiencyCalculable</b></p>
     * <b>Description:</b> This interface defines a contract for objects that can calculate efficiency.
     * 
     * <p><b>Method:</b></p>
     * <ul>
     *      <li>{@code calculateEfficiency}: Calculates the efficiency of the implementing class.</li>
     * </ul>
     * 
     * <p><b>Usage:</b></p>
     * <p>To implement this interface, a class must provide a concrete implementation for the {@code calculateEfficiency} method, which should return a double value representing the calculated efficiency.</p>
     * 
     * @return The efficiency value calculated by the implementing class.
     */
    public abstract double calculateEfficiency();
}

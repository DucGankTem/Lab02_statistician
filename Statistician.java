package Lab02;

public class Statistician implements Cloneable {

    private double sumOfValues;
    private int count;
    private double smallestValue;
    private double largestValue;

    public Statistician() {
        // Initialize all fields as specified in the class invariants.
        sumOfValues = 0.0;
        count = 0;
        smallestValue = Double.NaN; // Initialize as NaN since there are no values yet.
        largestValue = Double.NaN; // Initialize as NaN since there are no values yet.
    }

    public int getLength() {
        return count; // Return the count of values.
    }

    public double getSum() {
        return sumOfValues; // Return the sum of values.
    }

    public double getMean() {
        if (count == 0) {
            return Double.NaN; // Handle the case where no values have been entered.
        }
        return sumOfValues / count; // Calculate and return the mean.
    }

    public double getSmallest() {
        return smallestValue; // Return the smallest value.
    }

    public double getLargest() {
        return largestValue; // Return the largest value.
    }

    public void insert(double number) {
        // Update statistics with the new number.
        if (count == 0 || number < smallestValue) {
            smallestValue = number;
        }
        if (count == 0 || number > largestValue) {
            largestValue = number;
        }
        sumOfValues += number;
        count++;
    }

    public void reset() {
        // Reset all fields to initial values.
        sumOfValues = 0.0;
        count = 0;
        smallestValue = Double.NaN;
        largestValue = Double.NaN;
    }

    public void add(Statistician addend) {
        // Add the statistics of another Statistician to this Statistician.
        sumOfValues += addend.sumOfValues;
        count += addend.count;
        if (count == 0 || addend.smallestValue < smallestValue) {
            smallestValue = addend.smallestValue;
        }
        if (count == 0 || addend.largestValue > largestValue) {
            largestValue = addend.largestValue;
        }
    }

    public Statistician union(Statistician other) {
        // Create a new Statistician with combined statistics.
        Statistician result = new Statistician();
        result.sumOfValues = this.sumOfValues + other.sumOfValues;
        result.count = this.count + other.count;
        result.smallestValue = Math.min(this.smallestValue, other.smallestValue);
        result.largestValue = Math.max(this.largestValue, other.largestValue);
        return result;
    }

    @Override
    public Statistician clone() {
        // Create a deep copy of this Statistician.
        Statistician copy = new Statistician();
        copy.sumOfValues = this.sumOfValues;
        copy.count = this.count;
        copy.smallestValue = this.smallestValue;
        copy.largestValue = this.largestValue;
        return copy;
    }
}
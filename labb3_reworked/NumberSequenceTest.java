// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0};
        NumberSequence sequence = null;
        //sequence = new ArrayNumberSequence(realNumbers);
        sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here
        out.println("length: " + sequence.length());
        out.println("one upper bound: " + sequence.upperBound());
        out.println("one lower bound: " + sequence.lowerBound());
        out.println();

        int positionPlace = 4;
        double positionValue = 8;
        try {out.println("number at position " + positionPlace + ": " +  sequence.numberAt(positionPlace));
        } catch (IndexOutOfBoundsException newException) {
            out.println(newException.getMessage());
        }
        out.println("position of " + positionValue +": " + sequence.positionOf(positionValue));
        out.println();

        double containsValue = 21;
        out.println("is inceasing: " + sequence.isIncreasing());
        out.println("is deceasing: " + sequence.isDecreasing());
        out.println("contains " + containsValue + ": " + sequence.contains(containsValue));
        out.println();

        double addValue = 34;
        out.println("add: " + addValue + ":");
        sequence.add(addValue);
        out.println(sequence.toString());
        
        int inserPlace = 7;
        double insertValue = 0.0;
        try {out.println("insert " + insertValue + " at position " + inserPlace + ":");
        sequence.insert(inserPlace, insertValue);
        } catch (IndexOutOfBoundsException newException) {
            out.println(newException.getMessage());
        }
        out.println(sequence.toString());
        
        int removePlace = 7;
        try {out.println("remove at position " + removePlace + ":");
        sequence.removeAt(removePlace);
        } catch (IndexOutOfBoundsException newException) {
            out.println(newException.getMessage());
        } catch (IllegalStateException newException) {
            out.println(newException.getMessage());
        }
        out.println(sequence.toString());
        out.println();

        out.println("corresponding array: ");
        double[] sequenceArray = sequence.asArray();
        for (int i = 0; i < sequenceArray.length ; i++)
            out.print(sequenceArray[i] + " ");
    }
}
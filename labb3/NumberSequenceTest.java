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
        // sequence = new ArrayNumberSequence(realNumbers);
        sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here
        out.println("length: " + sequence.length());
        out.println("one upper bound: " + sequence.upperBound());
        out.println("one lower bound: " + sequence.lowerBound());
        out.println();

        int position = 4;
        int value = 8;
        out.println("number at position " + position + ": " +  sequence.numberAt(position));
        out.println("position of " + value +": " + sequence.positionOf(value));
        out.println();
        /*
        out.println("is inceasing: " + BOOL);
        out.println("is deceasing: " + BOOL);
        out.println("contains " + VALUE + ": " + BOOL);
        out.println();

        out.println("add: " + VALUE + ":");
        out.println(ARRAY);
        out.println("insert " + VALUE + " at position" + POSITION + ":");
        out.println(ARRAY);
        out.println("remove at position " + POSITION + ":");
        out.println(ARRAY);
        out.println();

        out.println("corresponding array: ");
        out.println(ARRAY);
        */
    }
}
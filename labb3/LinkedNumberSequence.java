// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    // add code here
	// length returns the node length of this sequence
	public int length ()
	{
		Node n = first;
		int l = 1;
		while (n.next != null)
		{
			l++;
			n = n.next;
		}
		return l;
	}

	// upperBound returns the highest number of this sequence
	public double upperBound ()
	{
		Node n = first;
		double upperHighest = n.number;
		while (n.next != null)
		{
			if (n.next.number > upperHighest)
			{
				upperHighest = n.next.number;
			}
			n = n.next;
		}
		return upperHighest;
	}

	// lowerBound returns the lowest number of this sequence
	public double lowerBound ()
	{
		Node n = first;
		double lowestNumber = n.number;
		while (n.next != null)
		{
			if (n.next.number < lowestNumber)
			{
				lowestNumber = n.next.number;
			}
			n = n.next;
		}
		return lowestNumber;
	}

	public double numberAt (int position)
	{
		Node n = first;
		for (int i = 0; i < position; i++)
		{
			n = n.next;
		}
		return n.number;
	}

	public int positionOf (double number)
	{
		Node n = first;
		int index = 0;
		while (n.next != null)
		{
			if (n.number == number)
			{
				break;
			}
			index++;
			n = n.next;
		}
		return index;
	}

	boolean isIncreasing ();
}
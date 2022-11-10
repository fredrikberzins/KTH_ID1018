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
	public int length () {	
		int length = 0;
		for(Node n = first; n == null; n = n.next)
			length++;     
		return length;
	}

	// upperBound returns the highest number of this sequence
	public double upperBound () {
		Node n = first;
		double upperBound = n.number;
		while (n.next != null) {
			if (n.next.number > upperBound)
				upperBound = n.next.number;
			n = n.next;
		}
		return upperBound;
	}

	// lowerBound returns the lowest number of this sequence
	public double lowerBound () {
		Node n = first;
		double lowerBound = n.number;
		while (n.next != null) {
			if (n.next.number < lowerBound)
				lowerBound = n.next.number;
			n = n.next;
		}
		return lowerBound;
	}

	public double numberAt (int position) {
		if (position > length())
			throw new IndexOutOfBoundsException("Position is out of bounds. Position: " + position + " Max position: " + length());
		Node n = first;
		for (int i = 0; i < position ; i++)
			n = n.next;
		return n.number;
	}

	public int positionOf (double number) {
		Node n = first;
		int positionOf = 0;
		while (n!= null) {
			if (n.number == number)
				break;
			positionOf++;
			n = n.next;
		}
		return positionOf;
	}

	public boolean isIncreasing () {
		Node n = first;
		boolean isIncreasing = true;
		while(n.next != null) {
			if (n.number >= n.next.number) {
				isIncreasing = false;
				return isIncreasing;
			}
			n = n.next;
		}
		return isIncreasing;
	}

	public boolean isDecreasing () {
		Node n = first;
		boolean isDecreasing = true;
		while(n.next != null) {
			if (n.number <= n.next.number) {
				isDecreasing = false;
				return isDecreasing;
			}
			n = n.next;
		}
		return isDecreasing;
	}
	
	public boolean contains (double number){
		Node n = first;
		boolean contains = false;
		while (n != null) {
			if (n.number == number) {
				
				contains = true;
				return contains;
			}
			n = n.next;
		}
		return contains;
	}

	public void add (double number) {
		Node n = first;
		while (n.next != null)
			n = n.next;
		n.next = new Node(number);
	}

	public void insert (int position, double number) {
		if (position > length())
			throw new IndexOutOfBoundsException("Position is out of bounds. Position: " + position + " Max position: " + length());
		Node n = first;
		for (int i = 1; i < position; i++)
			n = n.next;
		Node m = n.next;
		n.next = new Node (number);
		n.next.next = m;
	}

	public void removeAt (int position) {
		if (position  >  length())
			throw new IndexOutOfBoundsException("Position is out of bounds. Position: " + position + " Max position: " + length());
		if (length() == 2)
			throw new IllegalStateException("Sequence to short, removal will not make it a sequence any more");
		Node n = first;
		for (int i = 0; i <= position; i++)
			n = n.next;
		n = n.next;
	}

	public double[] asArray () {
		Node n = first;
		double[] Array =  new  double[length()];
		for(int i = 0; i < length(); i++) {
			Array[i] = n.number;
			n = n.next;
		} 
		return Array;
	}
}
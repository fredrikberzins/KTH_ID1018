// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

    // add code here
	// add code here
	// length returns the node length of this sequence
	public int length ()
	{
		return numbers.length;
	}

	// upperBound returns the highest number of this sequence
	public double upperBound ()
	{	
		double upperBound = numbers[0];
		for(int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] > upperBound) {
				upperBound = numbers[i];
			}
		}
		return upperBound;
	}

	// lowerBound returns the lowest number of this sequence
	public double lowerBound ()
	{
		double lowerBound = numbers[0];
		for(int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] < lowerBound) {
				lowerBound = numbers[i];
			}
		}
		return lowerBound;
	}

	public double numberAt (int position)
	{
		if (position > numbers.length)
			throw new IndexOutOfBoundsException("Position is out of bounds. Position: " + position + " Max position: " + numbers.length);
			
		return numbers[position];
	}

	public int positionOf (double number)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] == number)
			{
				return i;
			}
		}
		return -1;
	}

	public boolean isIncreasing ()
	{
		boolean isIncreasing = true;
		for(int i = 0; i < numbers.length-1; i++)
		{
			if (numbers[i] >= numbers[i+1])
			{
				isIncreasing = false;
				return isIncreasing;
			}
		}
		return isIncreasing;
	}

	public boolean isDecreasing ()
	{
		boolean isDecreasing = true;
		for(int i = 0; i < numbers.length-1; i++)
		{
			if (numbers[i] <= numbers[i+1])
			{
				isDecreasing = false;
				return isDecreasing;
			}
		}
		return isDecreasing;
	}
	
	public boolean contains (double number)
	{
		for(int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] == number)
			{
				return true;
			}
		}
		return false;
	}

	public void add (double number)
	{
		double[] temporary = new double[numbers.length + 1]; 
		for(int i = 0; i < numbers.length; i++)
		{
			temporary[i] =  numbers[i];
		}
		temporary[temporary.length-1] = number;
		numbers = temporary;

	}

	public void insert (int position, double number)
	{
		if (position > numbers.length)
			throw new IndexOutOfBoundsException("Position is out of bounds. Position: " + position + " Max position: " + numbers.length);
			
		double[] temporary = new double[numbers.length + 1]; 
		int added = 0;
		for(int i = 0; i <= temporary.length-1; i++)
		{
			if(i != position)
			{
				temporary[i] = numbers[i- added];
			}
			else{
				temporary[i] =  number;
				added = 1;
			}
		}
		numbers = temporary;

	}

	public void removeAt (int position)
	{	
		if (position > numbers.length)
			throw new IndexOutOfBoundsException("Position is out of bounds. Position: " + position + " Max position: " + numbers.length);

		if (numbers.length  == 2)
			throw new IllegalStateException("Sequence to short, removal will not make it a sequence any more");

		double[] temporary = new double[numbers.length - 1]; 
		int removed = 0;
		for(int i = 0; i <= temporary.length-1; i++)
		{
			if(i != position)
			{
				temporary[i] = numbers[i+removed];
			}
			else{
				removed = 1;
				temporary[i] = numbers[i+removed];
			}
		}
		numbers = temporary;
	}

	public double[] asArray ()
	{
		return numbers;
	}
}
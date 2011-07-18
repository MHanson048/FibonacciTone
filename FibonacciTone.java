import org.jfugue.*;

public class FibonacciTone 
{
	int[] fibonacci;

    public FibonacciTone() 
	{
		fibonacci = fibonacci(25);
		playTune(createFibTune());
	}

	public int[] fibonacci(int n)
	{
		int[] fibArr = new int[n];
		fibArr[0] = 0;
		fibArr[1] = 1;
		int prevFib = fibArr[0];
		int currFib = fibArr[1];
		for (int i = 2; i < n; i++)
		{
			int newFib = prevFib + currFib;
			fibArr[i] = newFib;
			prevFib = currFib;
			currFib = newFib;
		}
		return fibArr;
	}

	public void printFib()
	{
		for (int i = 0; i < fibonacci.length; i++)
		{
			System.out.println(fibonacci[i]);
		}
	}

	public String createFibTune()
	{
		StringBuffer fibTune = new StringBuffer();
		int[] toneArr = new int[fibonacci.length];
		for (int i = 0; i < fibonacci.length - 1; i++)
		{
			fibTune.append(getNote(fibonacci[i] % 7));
			fibTune.append(" ");
		}
		fibTune.append(getNote(fibonacci[fibonacci.length - 1] % 7));
		return fibTune.toString();
	}

	public String getNote(int notePos) 
	{
		StringBuffer noteBuffer = new StringBuffer();
		String notes = new String("CDEFGAB");
		char c = notes.charAt(notePos);
		noteBuffer.append("I[");
		noteBuffer.append(Integer.toString((int)(Math.random() * 127)));
		noteBuffer.append("] ");
		noteBuffer.append("&");
		noteBuffer.append(Integer.toString((int)(Math.random() * 16383)) + " ");
		noteBuffer.append(Character.toString(c));
		return noteBuffer.toString();
	}

	public void playTune(String strTune)
	{
		System.out.println(strTune);
		Player player = new Player();
		player.play("I[31] " + strTune);
	}
}

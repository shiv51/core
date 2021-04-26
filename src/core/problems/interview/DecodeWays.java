package core.problems.interview;

public class DecodeWays {

	static int countDecoding(char[] digits, int n) {
		// base cases (1,2)
		if (n == 0 || n == 1)
			return 1;

		// for base condition "01123" should return 0
		if (digits[0] == '0')
			return 0;

		// Initialize count
		int count = 0;

		// If the last digit is not 0, then
		// last digit must add to
		// the number of words
		if (digits[n - 1] > '0')
			count = countDecoding(digits, n - 1);

		// If the last two digits form a number
		// smaller than or equal to 26,
		// then consider last two digits and recursion
		if (digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7'))
			count += countDecoding(digits, n - 2);

		return count;
	}

	// Given a digit sequence of length n,
	// returns count of possible decodings by
	// replacing 1 with A, 2 woth B, ... 26 with Z
	static int countWays(char[] digits, int n) {
		if (n == 0 || (n == 1 && digits[0] == '0'))
			return 0;
		return countDecoding(digits, n);
	}

	// Driver code
	public static void main(String[] args) {
		char digits[] = { '1','2','3' };
		int n = digits.length;
		//System.out.printf("Count is %d", countWays(digits, n));
		
		//char digits[] = {'1','2','3','4'};
	    //int n = digits.length;
	    System.out.println("Count is " + 
	               countDecodingDP(digits, n));
	}

	public int numDecodings(String s) {

		int[] numberOfDecodings = new int[s.length()];
		int currentNum, nextNum;

		currentNum = Integer.parseInt(s.charAt(s.length() - 1) + "");
		if (currentNum != 0)
			numberOfDecodings[s.length() - 1] = 1;
		else
			numberOfDecodings[s.length() - 1] = 0;

		for (int i = s.length() - 2; i >= 0; i--) {
			nextNum = currentNum;
			currentNum = Integer.parseInt(s.charAt(i) + "");

			if (currentNum == 0)
				numberOfDecodings[i] = 0;
			else {
				if (currentNum >= 3 || (currentNum == 2 && nextNum >= 7))
					numberOfDecodings[i] = numberOfDecodings[i + 1];

				else if (i + 2 <= s.length() - 1 && ((currentNum == 1 || currentNum == 2) && nextNum == 0))
					numberOfDecodings[i] = numberOfDecodings[i + 2];

				else {
					if (i + 2 <= s.length() - 1)
						numberOfDecodings[i] = numberOfDecodings[i + 1] + numberOfDecodings[i + 2];
					else {
						if ((currentNum == 1 || currentNum == 2) && nextNum == 0)
							numberOfDecodings[i] = 1;
						else
							numberOfDecodings[i] = 2;
					}
				}
			}
		}

		return numberOfDecodings[0];
	}
	
	// A Dynamic Programming based 
	// function to count decodings
	static int countDecodingDP(char digits[], 
	                           int n)
	{
	    // A table to store results of subproblems
	    int count[] = new int[n + 1]; 
	    count[0] = 1;
	    count[1] = 1;
	    if(digits[0]=='0')   //for base condition "01123" should return 0 
	          return 0;
	    for (int i = 2; i <= n; i++)
	    {
	        count[i] = 0;
	 
	        // If the last digit is not 0, 
	        // then last digit must add to
	        // the number of words
	        if (digits[i - 1] > '0')
	            count[i] = count[i - 1];
	 
	        // If second last digit is smaller
	        // than 2 and last digit is smaller
	        // than 7, then last two digits 
	        // form a valid character
	        if (digits[i - 2] == '1' ||
	           (digits[i - 2] == '2' && 
	            digits[i - 1] < '7'))
	            count[i] += count[i - 2];
	    }
	    return count[n];
	}
	 
}

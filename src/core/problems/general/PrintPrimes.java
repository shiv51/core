package core.problems.general;

public class PrintPrimes {

	public static void main(String[] args) {
		
		int max_val = 10;
		Boolean[] prime = new Boolean[max_val + 1];
        for (int i = 0; i < max_val + 1; i++)
        {
            prime[i] = true;
        }
	
		for (int p = 2; p * p <= max_val; p++)
        {
 
            // If prime[p] is not changed, then
            // it is a prime
            if (prime[p] == true)
            {
 
                // Update all multiples of p
                for (int i = p * 2; i <= max_val; i += p)
                {
                    prime[i] = false;
                }
            }
	}
	}
}

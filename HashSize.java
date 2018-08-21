import java.util.Random;

public class HashSize {
	private long potentialHashSize;
	private int base;
	public int[] binaryArray;
	public Random rand;
	public int randomPrime;
	public int marker;
	public boolean isPrime;
	public long finalModulus;
	
	public HashSize(){
		binaryArray = new int[17];
		rand = new Random();
		isPrime = false;
		
		while(isPrime == false){
		makeRandomNum();
		fillBinaryArray();
		primeCalculation();
		}
	}
	public void makeRandomNum(){
		
		randomPrime = rand.nextInt(501)+95500;
		while(randomPrime%2 == 0){
			randomPrime = rand.nextInt(501)+95500;
		}
		//System.out.println(randomPrime);
	}
	
	public void fillBinaryArray(){
		int marker = randomPrime - 1;
		//System.out.println(marker);
		for(int i = 16; i >= 0; i--){
			binaryArray[i] = marker % 2;
			marker = marker/2;
		}
		for(int i = 0; i < binaryArray.length; i++){
		//	System.out.print(binaryArray[i] + " ");
		}
		//System.out.println();
	}
	
	
	public boolean isItPrime(long fM){
	
		if(fM == 1){
			isPrime = true;
			return true;
		}
		
		return false;
	}
	
	public void primeCalculation(){
		base = 3;
		finalModulus = 0;
		for(int i = 0; i < binaryArray.length - 1; i++){
			//System.out.println(finalModulus);
			if(i == 0){
				finalModulus = (base * base) % randomPrime;
			}
			else{
				if(binaryArray[i] == 1){
					finalModulus = (finalModulus * base) % randomPrime;
					finalModulus = (finalModulus * finalModulus) % randomPrime;
				}
				else{
					finalModulus = (finalModulus * finalModulus) % randomPrime;
					
				}
				
				
				
			}
			
			
			
		}
		isItPrime(finalModulus);
		
	}
	
	
	public int getHashSize(){
		
		
		return randomPrime;
	}


//May need to modify so that m - 2 is also prime

	
}

import java.util.Random;

public class HashTable{

	private HashObject[] hashTable;
	
	private int inputType;
	private int sizeOfTable;
	private long numOfProbes;
	private Random rand;
	private long frequency;
	private double loadFactor;
	private long totalNumberInserted;
	private int probesUsed;
	private int duplicatesTotal;
	
	public HashTable(int integers, int sz, double alpha){
		sizeOfTable = sz;
		
		hashTable = new HashObject[sizeOfTable];
		loadFactor = alpha;
		rand = new Random();
		inputType = 1;
		totalNumberInserted = 0;
		numOfProbes = 0;
		duplicatesTotal = 0;
	}
	
	public HashTable(long longs, int sz, double alpha){
		sizeOfTable = sz;
		hashTable = new HashObject[sizeOfTable];
		loadFactor = alpha;
		inputType = 2;
		totalNumberInserted = 0;
		numOfProbes = 0;
		duplicatesTotal = 0;

	}
	
	public HashTable(String strings, int sz, double alpha){
		sizeOfTable = sz;
		hashTable = new HashObject[sizeOfTable];
		loadFactor = alpha;
		inputType = 3;
		totalNumberInserted = 0;
		numOfProbes = 0;
		duplicatesTotal = 0;

	}
	public long getTotalNumberInserted(){
		return totalNumberInserted;
	}
	
	
	
	public void insertLinear(HashObject hObj, long key){
		probesUsed = 0;
		int index = (int) (key % sizeOfTable);
		while(hObj.getStatus() == false){
			
			//probe made
			probesUsed++;
			
			//when the key is occupado
			if(hashTable[index] != null){
				if(hashTable[index].equals(hObj)){
					hashTable[index].incrementFrequency();
					probesUsed = 0;
					hObj.setStatus(true);
				}
				else{
					index++;
					if(index == sizeOfTable){
						index = 0;
					}
				}
			}
			
			//when the key is empty
			else{
				
				hashTable[index] = hObj;
				hObj.setStatus(true);
				numOfProbes = numOfProbes + probesUsed;
				probesUsed = 0;
				totalNumberInserted++;
			}		
		}
	}
	public void insertDHash(HashObject hObj, long key ){
		probesUsed = 0;
		
		int index = (int) (key % sizeOfTable);
		while(hObj.getStatus() == false){
			
			//probe made
			probesUsed++;
			System.out.println("Index: " + index);
			System.out.println("total Duplicates: " + duplicatesTotal);

			//when the key is occupied
			if(hashTable[index] != null){
				
				if(hashTable[index].equals(hObj)){
					hashTable[index].incrementFrequency();
					probesUsed = 0;
					hObj.setStatus(true);
					duplicatesTotal++;
				}
				else{
					index = (int) ((key % sizeOfTable) + (probesUsed * (1 + (key % (sizeOfTable - 2)))));
					while(index >= sizeOfTable){
						index = (index - sizeOfTable);
					}
				}
			}
			
			//when the key is empty
			else{
				
				hashTable[index] = hObj;
				hObj.setStatus(true);
				numOfProbes = numOfProbes + probesUsed;
				System.out.println("inserted");
				probesUsed = 0;
				totalNumberInserted++;

			}		
		}
	}
	
	//This is meant for incrementing the amount of probes for INDIVIDUAL tables
	//Only incrementing for Linear Probing or Double Hash Table
	public void incrementProbes(){
		numOfProbes++;
	}
	
	public boolean isFilled(){
		if(totalNumberInserted >= loadFactor * sizeOfTable){
			return true;
		}
		return false;
	}
}

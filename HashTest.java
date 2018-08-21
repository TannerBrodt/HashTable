import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Tanner Brodt
 *
 */
public class HashTest {

	public static void main(String args[]){
		if(args.length != 3){
			System.out.println("Inappropriate amount of arguments");
			System.out.println("Number of arguments needed: 3");
			System.exit(1);
		}
		
		try{
			int inputType = Integer.parseInt(args[0]);
			double loadFactor = Double.parseDouble(args[1]);
			int debugInput = Integer.parseInt(args[2]);
			
			if(inputType > 3 || inputType < 1){
				System.out.println("Input Type must be between 1, 2, or 3");
				System.exit(1);
			}
			if(loadFactor >= 1 || loadFactor <= 0){
				System.out.println("Load Factor must be between 0 and 1");
				System.exit(1);
			}
			if(debugInput > 2 || debugInput < 0){
				System.out.println("Debug Type must be 0, 1, or 2");
			}
			
			//creates the size of the HashTables by calliing HashSize (which goes through the annoying isPrime())
			HashSize primeSize = new HashSize();
			int sizeOfTable = primeSize.getHashSize();
			System.out.println(sizeOfTable);
//			//creates some HashTables that use whatever the command line arguments were.
//			if(inputType == 1){
//				int integerProcess = 1;
//				HashTable linearProbed = new HashTable(integerProcess, sizeOfTable, loadFactor);
//				HashTable doubleHashedProbed = new HashTable(integerProcess, sizeOfTable, loadFactor);
//				//be careful with using twoTables. Data is everything
//				HashTable twoTables = new HashTable(integerProcess, sizeOfTable, loadFactor);
//				twoTables.probeTheseTwo(linearProbed, doubleHashedProbed);
//				
//				
//			}
			///////////////////////////////////////////////////////////////////////////
			
			
			HashTable linearProbed = new HashTable(inputType, sizeOfTable, loadFactor);
			HashTable doubleHashedProbed = new HashTable(inputType, sizeOfTable, loadFactor);
			
			
			//Works with the Random Integer maker!
			
			if(inputType == 1){
				Random rand = new Random();
				
		        //NOTE: these while loops are not able to be used until you actually "fill up"
				while(doubleHashedProbed.isFilled() == false){
					long newNumber = (long) Math.abs(rand.nextInt());
					HashObject hObj = new HashObject(newNumber);
				
					long key = hObj.getKey();
					
					linearProbed.insertLinear(hObj, key);
					hObj.setStatus(false);
					doubleHashedProbed.insertDHash(hObj, key);
					
				}
			}
			
			//Works with the currentTimeMillis longs
			
			if(inputType == 2){
				
		        //NOTE: these while loops are not able to be used until you actually "fill up"
				while(doubleHashedProbed.isFilled() == false){
					long newTime = System.currentTimeMillis();
					HashObject hObj = new HashObject(newTime);
					
					long key = hObj.getKey();
					
					linearProbed.insertLinear(hObj, key);
					hObj.setStatus(false);
					doubleHashedProbed.insertDHash(hObj, key);
				}
				
			}
			
			//Works with the words from word_list
			
			if(inputType == 3){
				//Make sure you change this mister Tanner to word-list (the required long file)
				File file = new File("MyWordList");

			    try {

			        Scanner scan = new Scanner(file);

			        //NOTE: these while loops are not able to be used until you actually "fill up"
			        while (doubleHashedProbed.isFilled() == false) {
			        	//while(scan.hasNextLine()){
			        	String newWord = scan.next();
			            //Just tested if it gets the words and it works!
			            //System.out.println(newWord);
			        	
			            HashObject hObj = new HashObject(newWord);
			            long key = hObj.getKey();
			            linearProbed.insertLinear(hObj, key);
						doubleHashedProbed.insertDHash(hObj, key);
						
			        }
			        scan.close();
			    } 
			    catch (FileNotFoundException e) {
			        System.out.println("This text file cannot be read!!!");
			    }
				
			}
			System.out.println("Beep");
			///////////////////////////////////////////////////////////////////////////
		}
		catch(NumberFormatException e){
			System.out.println("Your first argument needs to be an integer, your second as a double,"
					+ " and third as an integer.");
		}
		catch(Exception e){
			System.out.println("Something just went wrong... Really unexpectedly");
		}
	}
	
}

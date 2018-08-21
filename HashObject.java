public class HashObject{

	private long frequency;
	private Object obj;
	private String word;
	private long key;
	private boolean status;
	private long num;
	
	
	
	//Objects are what get stored in the HashTable Array
	HashObject(String nWord){
		word = nWord;
		frequency = 1;
		key = word.hashCode();
		status = false;
		obj = nWord;
		num = -1;
	}
	HashObject(long number){
		word = "";
		frequency = 1;
		key = number;
		status = false;
		obj = number;
		num = key;
	}

	
	//The get key is pretty much the hashCode of the Object. It gets modulusted to find the index
	public long getKey(){
		
		return key;
	}

	public void setStatus(boolean st){
		status = st;
	}

	public boolean getStatus(){
		return status;
	}
	
	//How many of this specific Object has been created. Not how many were submitted (impossible)
	public void incrementFrequency(){
		frequency++;
		
	}
	
	//
	@Override
	public String toString() {
		return "HashObject []";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		HashObject other = (HashObject) obj;
		
		if(this.word == other.word){
			//System.out.println(this.key);
			//System.out.println(other.key);
			if(this.key == other.key){
				return true;
			}
			return false;
		}
		

		if(this.obj != other)
		if (key != other.key)
			return false;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
//		
		return true;
	}




//This was derived from the object class
	//It compares the HashObject in the array with the HashObject coming in. For Duplicates.
	


	
	
}

package serverside;

public class SentenceProcessor {
	
	private int size = 65535;
	
	private String sentence;
	
	
	public SentenceProcessor(byte[] byteData) {
		
		this.sentence = new String(byteData);
	}
	
	public String getSentence() {
		
		return sentence;
	}
	
	/**
	 * This method convert value into an array of byte
	 * @param length
	 * @return
	 */
	public byte[] convertToByteArray(int value) {
		
		byte[] outData = new byte[size];
		
		String stringValue = Integer.valueOf(value).toString();
		
        outData = stringValue.getBytes();
        
        return outData;
	}
	
	/**
	 * This method count the number of characters in a sentence
	 * @return
	 */
	public int countCharacters() {
		
        int index = 0;
        char currentChar = sentence.charAt(index);
        while (currentChar != '\0') {
        	
        	currentChar = sentence.charAt(index++);
        }
        

        return index - 1;
	}
	
	/**
	 * This method count the number of vowels in a sentence
	 * @return
	 */
	public int countVowels() {
		
		int count=0;
		
		for (int i=0 ; i<sentence.length(); i++){
	         char ch = sentence.charAt(i);
	         if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'){
	            count ++;
	         }
	      }
		return count;
	}
	/**
	 * This method count the number of vowels in a sentence
	 * @return
	 */
	public int countConsonants() {
		 int counter = 0;
		 String lowercase = sentence.toLowerCase();
		 for (int i=0 ; i<lowercase.length(); i++){
	         char ch = lowercase.charAt(i);
	         if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
	            System.out.print("");
	         }else if(ch >= 'a' && ch <= 'z'){
	            counter++;
	         }
	      }
		 return counter;
	}
	
	public int countPunctuation() {
		int countt =0;
		String lowercase = sentence.toLowerCase();
		for (int i=0 ; i<lowercase.length(); i++) {
			char ch = lowercase.charAt(i);
	         if(!Character.isWhitespace(ch)&& !Character.isISOControl(ch) && !Character.isLetter(ch) ){
	            countt++;
	         }	
		}
		return countt;
	}
	

}

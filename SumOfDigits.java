package week2.day2.assignments;

public class SumOfDigits {

	public static void main(String[] args) {


		String text = "Tes12Le79af65";
		
		int sum = 0;
		
		
		//Method 1
		String newTxt = text.replaceAll("\\D", "");
		System.out.println(newTxt);
		char[] arr1 = newTxt.toCharArray();
		int len = arr1.length;
		
		for(int i=0; i<len; i++) {
			int num = Character.getNumericValue(arr1[i]);
			sum+=num;
		}
		
		System.out.println(sum);
		
		
		//Method 2
		char arr2[] = text.toCharArray();
		int l = arr2.length;
		
		for(int i=0; i<l; i++) {
			
			char c = arr2[i];
			boolean res = Character.isDigit(c);
			if(res) {
				sum+=c;
			}
			
			else
				break;
		}
		
		System.out.println(sum);

	}

}

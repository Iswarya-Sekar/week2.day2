package week2.day2.assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String text = "We learn java basics as part of java sessions in java week1";

		int count = 0;
		String text1 = "";
		String[] txtArr = text.split(" ");
		int len = txtArr.length;
		for (int i = 0; i < len; i++) {    //txtArr[2] = java 

			for (int j = i + 1; j < len - 1; j++) {  //txtArr[7], [10] = java

				if (txtArr[i].equalsIgnoreCase(txtArr[j])) {
					count++;
				}

				if (count > 0) {
					
					txtArr[j]="";
					count--;
					
				}

			}
			
			System.out.print(txtArr[i] + " ");

		}

		System.out.println(text1);

	}

}

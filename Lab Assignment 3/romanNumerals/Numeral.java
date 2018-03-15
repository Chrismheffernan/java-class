package romanNumerals;

public class Numeral {

	private int numeralValue;
	private String romanNumeral;
	
	public Numeral(String romanNumeral)
	{
		this.romanNumeral = romanNumeral;
	}
	
	public Numeral(int numeralValue)
	{
		this.numeralValue = numeralValue;
	}
	
	public boolean testRoman(String romanNumeral)
	{
		String test1, test2, test3, test4;
		int highValue = 0;
		
		Stack test = new Stack();
		for (int i = 0; i < romanNumeral.length(); i++) {
            String st = Character.toString(romanNumeral.charAt(i));
            test.push(st);
        }
		
		for(int i = 0; i < test.size(); i++)
		{
			test1 = test.pop();
			if(test1 != "I" || test1 != "V" || test1 != "X" || test1 != "L" || test1 != "C" || test1 != "D" || test1 != "M")
			{
				return false;
			}
			
			if(test1 == "I")
			{
				
			}
		}
		
	}
	
	
	
	
	
}

package romanNumerals;

public class Numeral {

	private int iCount, vCount, xCount, lCount, cCount, dCount, mCount;
	private int iCountPlus, xCountPlus, cCountPlus, mCountPlus;
	private int numeralValue;
	private String romanNumeral;
	private boolean invalid = false;
	
	public Numeral(String romanNumeral)
	{
		this.romanNumeral = romanNumeral;
		convertRoman(romanNumeral);
		invalidCheck();
	}
	
	public Numeral(int numeralValue)
	{
		romanNumeral = "";
		this.numeralValue = numeralValue;
		convertArabic(numeralValue);
		invalidCheck();
	}
	
	public void convertArabic(int numeralValue)
	{
		String thou = "", hund = "", ten = "", sing = "";
		int thousands = numeralValue/1000;
		int hundreds = (numeralValue%1000)/100;
		int tens = (numeralValue%100)/10;
		int single = numeralValue%10;
		
		if(thousands > 0)
		{
			if( thousands == 3 )
			{
				thou = "MMM";
			}
			if( thousands == 2 )
			{
				thou = "MM";
			}
			if( thousands == 1)
			{
				thou = "M";
			}
			
			romanNumeral = romanNumeral + thou;
		}
		
		if( hundreds > 0);
		{
			if( hundreds == 9)
			{
				hund = "CM";
			}
			if( hundreds == 8)
			{
				hund = "DCCC";
			}
			if( hundreds == 7)
			{
				hund = "DCC";
			}
			if( hundreds == 6)
			{
				hund = "DC";
			}
			if( hundreds == 5)
			{
				hund = "D";
			}
			if( hundreds == 4)
			{
				hund = "CD";
			}
			if( hundreds == 3)
			{
				hund = "CCC";
			}
			if( hundreds == 2)
			{
				hund = "CC";
			}
			if( hundreds == 1)
			{
				hund = "C";
			}
			
			romanNumeral = romanNumeral + hund;
		}
		
		if( tens > 0)
		{
			if( tens == 9)
			{
				ten = "XC";
			}
			if( tens == 8)
			{
				ten = "LXXX";
			}
			if( tens == 7)
			{
				ten = "LXX";
			}
			if( tens == 6)
			{
				ten = "LX";
			}
			if( tens == 5)
			{
				ten = "L";
			}
			if( tens == 4)
			{
				ten = "XL";
			}
			if( tens == 3)
			{
				ten = "XXX";
			}
			if( tens == 2)
			{
				ten = "XX";
			}
			if( tens == 1)
			{
				ten = "X";
			}
			
			romanNumeral = romanNumeral + ten;
		}
		
		if( single > 0)
		{
			if( single == 9)
			{
				sing = "IX";
			}
			if( single == 8)
			{
				sing = "VIII";
			}
			if( single == 7)
			{
				sing = "VII";
			}
			if( single == 6)
			{
				sing = "VI";
			}
			if( single == 5)
			{
				sing = "V";
			}
			if( single == 4)
			{
				sing = "IV";
			}
			if( single == 3)
			{
				sing = "III";
			}
			if( single == 2)
			{
				sing = "II";
			}
			if( single == 1)
			{
				sing = "I";
			}
			
			romanNumeral = romanNumeral + sing;
		}
	}
	
	public void convertRoman(String romanNumeral)
	{
		Stack test = new Stack();
		for (int i = 0; i < romanNumeral.length(); i++) {
            String st = Character.toString(romanNumeral.charAt(i));
            test.push(st);
        }
		
		while(!test.isEmpty())
		{
			
			String temp = test.pop();
		
			if( !temp.equals("I") && !temp.equals("V") && !temp.equals("X") && !temp.equals("L") && !temp.equals("C") && !temp.equals("D") && !temp.equals("M"))
			{
				invalid = true;
			}
			
			if( temp.equals("I"))
			{
				if( numeralValue < 5)
				{
					numeralValue += 1;
				}
				
				if( numeralValue >= 5)
				{
					numeralValue -= 1;
					iCountPlus++;
				}
				
				if( numeralValue > 10)
				{
					invalid = true;
				}
				
				iCount++;
			}
			
			if(temp.equals("V"))
			{
				numeralValue += 5;
				vCount++;
				
				if( numeralValue > 8)
				{
					invalid = true;
				}
			}
			
			if( temp.equals("X"))
			{
				if( numeralValue < 50)
				{
					numeralValue += 10;
				}
				
				if( numeralValue >= 50)
				{
					numeralValue -= 10;
					xCountPlus++;
				}
				
				if( numeralValue > 109)
				{
					invalid = true;
				}
				
				xCount++;
			}
			
			if( temp.equals("L"))
			{
				numeralValue += 50;
				lCount++;
				
				if( numeralValue > 80)
				{
					invalid = true;
				}
			}
			
			if( temp.equals("C") )
			{
				if( numeralValue < 500)
				{
					numeralValue += 100;
				}
				
				if( numeralValue >= 500)
				{
					numeralValue -= 100;
					cCountPlus++;
				}
				
				if( numeralValue > 1099)
				{
					invalid = true;
				}
				
				cCount++;
			}
			
			if( temp.equals("D"))
			{
				numeralValue += 500;
				dCount++;
				
				if( numeralValue > 800)
				{
					invalid = true;
				}
			}
			
			if( temp.equals("M"))
			{
				if( numeralValue < 5000)
				{
					numeralValue += 1000;
				}
				
				if( numeralValue >= 5000)
				{
					numeralValue -= 1000;
					mCountPlus++;
				}
						
				mCount++;
			}
		}
	}
	
	public void invalidCheck()
	{
		if( iCount > 3 || vCount >1 || xCount> 4 || lCount >1 || cCount > 4 || dCount > 1 || mCount >4)
		{
			invalid =true;
		}
		if( xCountPlus > 1 || cCountPlus > 1 || mCountPlus > 1 || iCountPlus > 1)
		{
			invalid = true;
		}
	}
	
	public int printArabic()
	{
		return numeralValue;
	}
	
	public String printRoman()
	{
		return romanNumeral;
	}
	
	public boolean isValid()
	{
		return invalid;
	}
	
	
	
	
	
}

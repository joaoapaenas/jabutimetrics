package br.jabuti.metrics.test.testInput;

public class CyclomaticComplexityAverage {

	/**
	 * @param args
	 */
	public void CC1 (String[] args) {
	}

	public void CC2_If(boolean a){
		if (a)
			System.out.print(a);
	}
	
	public void CC2_IfElse(boolean a){
		if (a)
			System.out.print(a);
		else
			System.out.print(!a);
	}	
	
	public void CC3_and(boolean a, boolean b){
		if (a && b)
			System.out.print(a);
		else
			System.out.print(!a);
	}
	
	public void CC3_or(boolean a, boolean b){
		if (a || b)
			System.out.print(a);
		else
			System.out.print(!a);
	}

	public void CC2_xor(boolean a, boolean b){
		if (a ^ b)
			System.out.print(a);
		else
			System.out.print(!a);
	}
	
	public void CC2_while(boolean a){
		while (a)
			System.out.print(a);
	}
	
	public void CC2_for(boolean a){
		for(int i=0;a;i++)
			System.out.print(a);
	}

	public void CC2_switch(int a){
		switch(a){
			case 1: System.out.print(a);
		}
	}
	
	public void CC3_switch2CaseDefault(int a){
		switch(a){
			case 1: System.out.print(a);
			case 2: System.out.print(a);
			default: System.out.print(a);
		}
	}

	public void CC2_switch1CaseDefault(int a){
		switch(a){
			case 1: System.out.print(a);
			default: System.out.print(a);
		}
	}
	
	
}

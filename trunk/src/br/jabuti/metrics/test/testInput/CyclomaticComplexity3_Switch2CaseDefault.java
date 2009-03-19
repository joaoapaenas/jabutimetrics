package br.jabuti.metrics.test.testInput;

public class CyclomaticComplexity3_Switch2CaseDefault {

	public void CC2_switch(int a){
		switch(a){
			case 1: System.out.print(a);
			case 2: System.out.print(a);
			default: System.out.print(a);
		}
	}
}

package br.jabuti.metrics.test;


import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.jabuti.lookup.Program;
import br.jabuti.metrics.Metrics;

public class TestCyclomaticComplexity {

	String nomeDeClasseInput;
	
	Program programaTest;
	Metrics metricas;

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCCMax1() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity1";
		instanceProgram(nomeDeClasseInput);
		testValue(1,nomeDeClasseInput);
	}

	@Test
	public void testCCMax2() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity2_If";
		instanceProgram(nomeDeClasseInput);
		testValue(2,nomeDeClasseInput);
	}
	
	@Test
	public void testCCMax2_IfElse() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity2_IfElse";
		instanceProgram(nomeDeClasseInput);
		testValue(2,nomeDeClasseInput);
	}
	
	@Test
	public void testCCMax3_And() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity3_And";
		instanceProgram(nomeDeClasseInput);
		testValue(3,nomeDeClasseInput);
	}

	
	@Test
	public void testCCMax3_Or() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity3_Or";
		instanceProgram(nomeDeClasseInput);
		testValue(3,nomeDeClasseInput);
	}
	
	@Test
	public void testCCMax2_Xor() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity2_Xor";
		instanceProgram(nomeDeClasseInput);
		testValue(2,nomeDeClasseInput);
	}	

	@Test
	public void testCCMax2_While() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity2_While";
		instanceProgram(nomeDeClasseInput);
		testValue(2,nomeDeClasseInput);
	}	
	
	@Test
	public void testCCMax2_For() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity2_For";
		instanceProgram(nomeDeClasseInput);
		testValue(2,nomeDeClasseInput);
	}	
	
	@Test
	public void testCCMax2_Switch1Case() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity2_Switch";
		instanceProgram(nomeDeClasseInput);
		testValue(2,nomeDeClasseInput);
	}	

	@Test
	public void testCCMax2_Switch1CaseDefault() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity2_Switch1CaseDefault";
		instanceProgram(nomeDeClasseInput);
		testValue(2,nomeDeClasseInput);
	}	
	
	@Test
	public void testCCMax3_Switch2CaseDefault() {
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.CyclomaticComplexity3_Switch2CaseDefault";
		instanceProgram(nomeDeClasseInput);
		testValue(3,nomeDeClasseInput);
	}	
	
	private void instanceProgram(String className){
		try {
			programaTest = new Program(className);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void testValue(int value, String className){
		metricas = new Metrics(programaTest);
		double maxComplexity = metricas.cc_max(className);
		assertEquals(value,maxComplexity,0);
		
	}
	
	
}

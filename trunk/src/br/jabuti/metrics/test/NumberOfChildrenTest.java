/**
 * 
 */
package br.jabuti.metrics.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.jabuti.lookup.Program;
import br.jabuti.metrics.Metrics;

/**
 * @author paulo and raphael
 *
 */
public class NumberOfChildrenTest {

	String inputClassName;
	
	Program programTest;
	Metrics metrics;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void tryToLoadNonExistingClass(){
		inputClassName = "ClasseQueNaoExiste"; 
		try {
			programTest = new Program(inputClassName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		metrics = new Metrics(programTest);
		double numeroDeFilhos = metrics.noc(inputClassName);
		assertEquals(-1,numeroDeFilhos,0);
	}
	
	@Test
	public void numberOfChildrenEqualsZeroTest(){
		inputClassName = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual0"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		try {
			programTest = new Program(inputClassName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		metrics = new Metrics(programTest);
		double numeroDeFilhos = metrics.noc(inputClassName);
		assertEquals(0,numeroDeFilhos,0);
		
	}
	
	@Test
	public void loadChildrenTest(){
		inputClassName = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual1"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		try {
			programTest = new Program(inputClassName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numberOfLoadedClasses = programTest.getClasses().length;
		assertEquals(2, numberOfLoadedClasses);
		assertEquals(inputClassName, programTest.getClasses()[1]);
		
	}
	
	
	@Test
	public void numberOfChildrenEqualsOneTest(){

		inputClassName = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual1Filho"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		String inputSuperClassName = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual1"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		try {
			programTest = new Program(inputClassName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		metrics = new Metrics(programTest);
		double numeroDeFilhos = metrics.noc(inputSuperClassName);
		assertEquals(1,numeroDeFilhos,0);
	}
	
	@Test
	public void numberOfChildrenEqualsTwoTest(){

		inputClassName = "br.jabuti.metrics.test.testInput.InputTestChildrenTwo"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		String inputClassNameFilho1 =  "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual1Filho"; 
		String inputSuperClassName = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual1"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		try {
			programTest = new Program(inputClassNameFilho1);
			programTest.addClass(inputClassName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		metrics = new Metrics(programTest);
		
		double numeroDeFilhos = metrics.noc(inputSuperClassName);
		assertEquals(2,numeroDeFilhos,0);
	}
}
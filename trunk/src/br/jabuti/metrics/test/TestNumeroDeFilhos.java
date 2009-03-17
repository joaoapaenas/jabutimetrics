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
 * @author paulo
 *
 */
public class TestNumeroDeFilhos {

	String nomeDeClasseInput;
	
	Program programaTest;
	Metrics metricas;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void tentaCarregarClasseQueNaoExiste(){
		nomeDeClasseInput = "ClasseQueNaoExiste"; 
		try {
			programaTest = new Program(nomeDeClasseInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		metricas = new Metrics(programaTest);
		double numeroDeFilhos = metricas.noc(nomeDeClasseInput);
		assertEquals(-1,numeroDeFilhos,0);
	}
	
	@Test
	public void testNumeroDeFilhosIgual0(){
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual0"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		try {
			programaTest = new Program(nomeDeClasseInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		metricas = new Metrics(programaTest);
		double numeroDeFilhos = metricas.noc(nomeDeClasseInput);
		assertEquals(0,numeroDeFilhos,0);
		
	}
	
	@Test
	public void testSeFilhosSaoCarregados(){
		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual1"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		try {
			programaTest = new Program(nomeDeClasseInput);
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
		
		int numeroDeClassesCarregadas = programaTest.getClasses().length;
		assertEquals(2, numeroDeClassesCarregadas);
		
	}
	
	
	@Test
	public void testNumeroDeFilhosIgual1(){

		nomeDeClasseInput = "br.jabuti.metrics.test.testInput.InputTesteNumeroDeFilhosIgual1"; // Eh necessario que seja passado o nome inteiro da classe (classe + pacotes);
		try {
			programaTest = new Program(nomeDeClasseInput);
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
		metricas = new Metrics(programaTest);
		double numeroDeFilhos = metricas.noc(nomeDeClasseInput);
		assertEquals(1,numeroDeFilhos,0);
	}
	
	
	

}


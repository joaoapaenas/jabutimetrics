package br.jabuti.metrics.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.jabuti.lookup.Program;
import br.jabuti.metrics.Metrics;


public class TestNumberOfInstanceVariables {
	String nameOfInputClass;
	
	Program testProgram;
	Metrics metrics;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void tryLoadNotExistenClass(){
		nameOfInputClass = "NotExistenClass"; 
		try {
			testProgram = new Program(nameOfInputClass);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		metrics = new Metrics(testProgram);
		double numberOfInstanceVariables = metrics.niv(nameOfInputClass);
		assertEquals(-1,numberOfInstanceVariables,0);
	}
	
	@Test
	public void testNumberOfInstanceVariables0(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfInstanceVariables0";
		try {
			testProgram = new Program(nameOfInputClass);
		} catch (Exception e) {
			e.printStackTrace();
			fail("didn´t load input class");
		}
		metrics = new Metrics(testProgram);
		double numberOfInstanceVariables=metrics.niv(nameOfInputClass);
		assertEquals(0,numberOfInstanceVariables,0);
	}
	
	@Test
	public void testNumberOfInstanceVariables1(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfInstanceVariables1";
		try {
			testProgram = new Program(nameOfInputClass);
		} catch (Exception e) {
			e.printStackTrace();
			fail("didn´t load input class");
		}
		metrics = new Metrics(testProgram);
		double numberOfInstanceVariables=metrics.niv(nameOfInputClass);
		assertEquals(1,numberOfInstanceVariables,0);
	}
	
	@Test
	public void testNumberOfInstanceVariables2(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfInstanceVariables2";
		try {
			testProgram = new Program(nameOfInputClass);
		} catch (Exception e) {
			e.printStackTrace();
			fail("didn´t load input class");
		}
		metrics = new Metrics(testProgram);
		double numberOfInstanceVariables=metrics.niv(nameOfInputClass);
		assertEquals(2,numberOfInstanceVariables,0);
	}
	
	@Test
	public void testNumberOfInstanceVariables3(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfInstanceVariables3";
		try {
			testProgram = new Program(nameOfInputClass);
		} catch (Exception e) {
			e.printStackTrace();
			fail("didn´t load input class");
		}
		metrics = new Metrics(testProgram);
		double numberOfInstanceVariables=metrics.niv(nameOfInputClass);
		assertEquals(3,numberOfInstanceVariables,0);
	}
}

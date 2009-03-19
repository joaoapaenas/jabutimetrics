package br.jabuti.metrics.test;


import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.jabuti.lookup.Program;
import br.jabuti.metrics.Metrics;

public class TestNumberOfParametersByMethod {
	String nameOfInputClass;
	String nameOfInputClassParent;
	
	Program testProgram;
	Metrics metrics;
	
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
		double numberOfInstanceVariables = metrics.mnpm(nameOfInputClass);
		assertEquals(-1,numberOfInstanceVariables,0);
	}
	
	@Test
	public void testNumberOfParameterByMethod0(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfParametersByMethod0";
		try {
			testProgram = new Program(nameOfInputClass);
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
		metrics = new Metrics(testProgram);
		double numberOfParametersByMethod = metrics.mnpm(nameOfInputClass);
		assertEquals(0,numberOfParametersByMethod,0);
	}

	@Test
	public void testNumberOfParameterByMethod1(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfParametersByMethod1";
		try {
			testProgram = new Program(nameOfInputClass);
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
		metrics = new Metrics(testProgram);
		double numberOfParametersByMethod = metrics.mnpm(nameOfInputClass);
		assertEquals(1,numberOfParametersByMethod,0);
	}
	
	@Test
	public void testNumberOfParameterByMethod2(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfParametersByMethod2";
		try {
			testProgram = new Program(nameOfInputClass);
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
		metrics = new Metrics(testProgram);
		double numberOfParametersByMethod = metrics.mnpm(nameOfInputClass);
		assertEquals(2,numberOfParametersByMethod,0);
	}
	
	@Test
	public void testNumberOfParameterByMethod3(){
		nameOfInputClass = "br.jabuti.metrics.test.testInput.InputTestNumberOfParametersByMethod3";
		nameOfInputClassParent = "br.jabuti.metrics.test.testInput.InputTestNumberOfParametersByMethod3Parent";
		try {
			testProgram = new Program(nameOfInputClass);
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
		metrics = new Metrics(testProgram);
		double numberOfParametersByMethod; 
		numberOfParametersByMethod = metrics.mnpm(nameOfInputClass);
		assertEquals(1,numberOfParametersByMethod,0);
		
		numberOfParametersByMethod = metrics.mnpm(nameOfInputClassParent);
		assertEquals(3,numberOfParametersByMethod,0);
	}
}

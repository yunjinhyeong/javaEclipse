package com.exam.vo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

@DisplayName("테스트케이스 클래스")
public class MyTests {
	
	private Person person;
	
	@BeforeEach
	void init() {
		person = new Person("홍길동", 27, false);
	}
	
	@Test
	void testPerson() {
		assertFalse(person.isMarried());
	}
	
	@Test
	void testHello() {
		assertEquals(Hello.helloWorld(), "Hello world!");
		
		assertThrows(Exception.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				Hello.receivePositiveNumber(-1);
			}
		});
	}
	
	@Test
	void testGetNumArr() {
		int[] arr = { 10, 20, 30 };
		assertArrayEquals(Hello.getNumArr(), arr);
	}
	
	@Test
	void testCalc() {
		assertEquals(Calc.add(1, 2), 3);
		assertEquals(Calc.sub(7, 2), 5);
	}
}

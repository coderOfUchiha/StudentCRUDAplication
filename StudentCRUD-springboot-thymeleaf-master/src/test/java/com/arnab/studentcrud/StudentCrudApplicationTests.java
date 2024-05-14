package com.arnab.studentcrud;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class StudentCrudApplicationTests {
	Calculator underTest = new Calculator();
	@Test
	public void addTest(){
		int numberOne = 20;
		int numberTwo = 20;
		int result= underTest.add(numberTwo,numberOne);
        int expectedResult = 40;
        assertThat(result).isEqualTo(expectedResult);

	}

	class Calculator{
		int add(int a, int b){
			return a+b;
		}
	}

}



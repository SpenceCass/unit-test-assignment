import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

class TestDemoTest {
	
	private TestDemo TestDemo;

	@BeforeEach
	void setUp() throws Exception {
		TestDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest #argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
				
		if(expectException == false) {
			assertThat(TestDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> 
		    TestDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);

		}
		
		
	}
	static Stream<Arguments> argumentsForAddPositive(){
		// @formatter:off
		
		return Stream.of(
		arguments(2, 4, 6, false),
		arguments(3, -12, -9, true),
		arguments(1, -1, 0, true)
		);
		// @formatter:on
		}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(TestDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
	
	
	
}

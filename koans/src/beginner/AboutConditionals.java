package beginner;


import com.sandwich.koan.Koan;
import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;


public class AboutConditionals {

	@Koan
	public void basicIfWithoutCurly(){
		// Ifs without curly braces are ugly and not recommended but still valid:
		int x = 1;
		if (true) 
			x++;
		assertEquals(x, 2);
	}
	
	@Koan
	public void basicIfElseWithoutCurly(){
		// Ifs without curly braces are ugly and not recommended but still valid:
		int x = 1;
		boolean secretBoolean = false;
		if (secretBoolean) 
			x++;
		else
			x--;
		assertEquals(x, 0);
	}
	
	@Koan
	public void basicIfElseIfElseWithoutCurly(){
		int x = 1;
		boolean secretBoolean = false;
		boolean otherBooleanCondition = true;
		// Ifs without curly braces are ugly and not recommended but still valid:
		if (secretBoolean) 
			x++;
		else if (otherBooleanCondition)
			x = 10;
		else
			x--;
		assertEquals(x, 10);
	}
	
	@Koan
	public void nestedIfsWithoutCurlysAreReallyMisleading() {
		// Why are these ugly you ask? Well, try for yourself
		int x = 1;
		boolean secretBoolean = false;
		boolean otherBooleanCondition = true;
		// Ifs without curly braces are ugly and not recommended but still valid:
		if (secretBoolean)  x++;
			if (otherBooleanCondition) x = 10;
		else x--;
		// Where does this else belong to!?
		assertEquals(x, 10);
	}
	
	@Koan
	public void ifAsIntended() {
		boolean secretBoolean = true;
		int x = 1;
		if (secretBoolean) {
			x++;
		} else {
			x = 0;
		}
		// There are different opinions on where the curly braces go...
		// But as long as you put them here. You avoid problems as seen above.
		assertEquals(x, 2);
	} 
	
	@Koan 
	public void basicSwitchStatement() {
		int i = 1;
		String result = "Basic ";
		switch(i) {
			case 1:
				result += "One";
				break;
			case 2:
				result += "Two";
				break;
			default:
				result += "Nothing";
		}
		assertEquals(result, "Basic One");
	}
	
	@Koan 
	public void switchStatementFallThrough() {
		int i = 1;
		String result = "Basic ";
		switch(i) {
			case 1:
				result += "One";
			case 2:
				result += "Two";
			default:
				result += "Nothing";
		}
		assertEquals(result, "Basic OneTwoNothing");
	}
	
	@Koan 
	public void switchStatementCrazyFallThrough() {
		int i = 5;
		String result = "Basic ";
		switch(i) {
			case 1:
				result += "One";
			default:
				result += "Nothing";
			case 2:
				result += "Two";
		}
		assertEquals(result, "Basic NothingTwo");
	}
	
	@Koan 
	public void switchStatementConstants() {
		int i = 5;
		// What happens if you remove the 'final' modifier?
		// ANSWER: Compile error stating that case expression must be constant 
		// What does this mean for case values?
		// ANSWER: That would mean that case values must be constant values
		final int caseOne = 1;
		String result = "Basic ";
		switch(i) {
			case caseOne:
				result += "One";
				break;
			default:
				result += "Nothing";
		}
		assertEquals(result, "Basic Nothing");
	}
	
	@Koan 
	public void switchStatementSwitchValues() {
		// Try different (primitive) types for 'c'
		// Which types do compile?
		// ANSWER: Compiles on byte, int, short, char, won't compile on long, float, double
		// Does boxing work?
		// ANSWER: Yes, it does but only on the valid primitives listed above.
		byte c = 'a';
		String result = "Basic ";
		switch(c) {
			case 'a':
				result += "One";
				break;
			default:
				result += "Nothing";
		}
		assertEquals(result, "Basic One");
	}
}

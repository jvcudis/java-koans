package beginner;

import com.sandwich.koan.Koan;
import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

public class AboutMethodPreference {

	class A {
		public String doStuff(int i) { return "int"; }
		public String doStuff(Double i) { return "Double"; }
		public String doStuff(Object i) { return "Object"; }
		public String doStuff(int...i) { return "int vararg"; }
	}
	
	@Koan
	public void methodPreferenceInt() {
		assertEquals(new A().doStuff(1), "int");
	}

	@Koan
	public void methodPreferenceInteger() {
		assertEquals(new A().doStuff(Integer.valueOf(1)), "Object");
	}
	
	@Koan
	public void methodPreferenceLong() {
		long l = 1;
		assertEquals(new A().doStuff(l), "Object");
	}
	
	@Koan
	public void methodPreferenceBoxedLong() {
		Long l = Long.valueOf(1);
		assertEquals(new A().doStuff(l), "Object");
	}
	
	@Koan
	public void methodPreferenceDouble() {
		Double l = Double.valueOf(1);
		assertEquals(new A().doStuff(l), "Double");
	}

	@Koan
	public void methodPreferenceMore() {
		// What happens if you change 'Integer' to 'Double'
		// ANSWER: The returned string for methodPreferenceInteger is "Object" while
		//		   the returned string for methodPreferenceDouble is "Double"
		// Does this explain 'methodPreferenceDouble'?
		// ANSWER: Yes, that means that if the passed variable does not match any method arguments
		//		   then by default, it would use the Object arguments, root class drama 
		// Think about why this happens?
		// ANSWER: Given the example below, that a primitive and a wrapper is being passed,
		//		   I think that the number of arguments is considered first before the data type
		//		   of the passed arguments.
		assertEquals(new A().doStuff(1, Integer.valueOf(2)), "int vararg");
	}
}

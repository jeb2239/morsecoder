package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MorseCoderTest {
	
	MorseCoder morseCoder = new MorseCoder(MorseCodeUtilities.RESOURCE_PATH + "morsecode_general.xml");

	@Test
	public void testIfEncodeWorksAsExpected() {
		assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + MorseCodeUtilities.ERROR_STRING + "//", morseCoder.encode("Hello, world!"));
	}
	
	@Test
	public void testIfEncodeWorksAsExpectedWithOneSpecialCasesNotSeparated() {
		assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + MorseCodeUtilities.ERROR_STRING + "//...---...//", morseCoder.encode("Hello, world! [SOS]"));
	}
	
	@Test
	public void testIfEncodeWorksAsExpectedWithGivingAnInvalidWord() {
		assertEquals("[undefined]/.../---/...//", morseCoder.encode("[SOS"));
	}
	
	@Test
	public void testIfEncodeWorksAsExpectedWithThreeSpecialCasesNotSeparated() {
		assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + MorseCodeUtilities.ERROR_STRING + "//...---...//...---...//...---...//", morseCoder.encode("Hello, world! [SOS][SOS][SOS]"));
	}
	
	@Test
	public void testIfDecodeWorksAsExpected() {
		assertEquals("HELLO, WORLD", morseCoder.decode("...././.-../.-../---/--..--/   /.--/---/.-./.-../-../"));
	}
}
package jcmc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class t1 {
	private t ts;
	@Before
	public void stup() {
		ts=new t();
	}
	@Test
	public void tp() {
		assertEquals(2, ts.pls(1, 1));
	}
	@Test
	public void tm() {
		assertEquals(0, ts.min(1, 1));
	}
	@Test
	public void tqdh() {
		assertTrue(ts.qdh(3, 2));
	}

}

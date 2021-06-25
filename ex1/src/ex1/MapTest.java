package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
	Map maptest = new Map();
	
	@Before
	public void setUp() throws Exception {
		maptest.setMaxRowNum(4);
		maptest.setMaxColNum(4);
	}

	@Test
	public void testSetMaxColNum() {
		maptest.setMaxColNum(9);
		assertEquals(9,maptest.getMaxColNum());
	}

	@Test
	public void testSetMaxRowNum() {
		maptest.setMaxRowNum(12);
		assertEquals(12,maptest.getMaxRowNum());
	}

	@Test
	public void testSetIsDead() {
		maptest.setIsDead(false);
		assertEquals(false,maptest.getIsDead());
	}

	@Test
	public void testSetIsRunning() {
		maptest.setIsRunning(false);
		assertEquals(false,maptest.getIsRunning());
	}

	@Test
	public void testSetIsSelected() {
		maptest.setIsSelected(2, 1);
		assertEquals(true,maptest.getIsSelected(2, 1));
	}
}

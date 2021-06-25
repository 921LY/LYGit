package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogicTest {

	Map map = new Map();
	private Logic logic;
	
	@Before
	public void setUp() throws Exception {
		map.setMaxRowNum(4);
		map.setMaxColNum(4);
		logic= new Logic(4,4);
	}

	@Test
	public void testgetNeighborCount() {
		int grid[][] = {{0,0,0,0,0,0},
				        {0,1,1,0,1,0},
				        {0,1,1,0,0,0},
				        {0,0,1,1,0,0},
				        {0,0,1,1,1,0},
				        {0,0,0,0,0,0}};
		logic.setGrid(grid);
		int result = logic.getNeighborCount(2, 2);//(0,0)
		assertEquals(5,result);
	}
	
	@Test
	public void testUpdate() {
		int grid[][] = {{0,0,0,0,0,0},{0,1,1,0,1,0},{0,1,1,0,0,0},
		                {0,0,1,1,0,0},{0,0,1,1,1,0},{0,0,0,0,0,0}};
        logic.setGrid(grid);
		logic.update();
		int[][] Grid1 = new int[6][6];
		Grid1 = logic.getGrid();
		int R1[] = new int[36];
		int n = 0;
		for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
            	R1[n] = Grid1[i][j];
            	n++;
            }
        }
		int R2[] = {0,0,0,0,0,0, 0,1,1,1,0,0, 0,0,0,0,0,0, 
				    0,0,0,0,1,0, 0,0,1,0,1,0, 0,0,0,0,0,0};
		for(int m = 0; m < 36; m++)
		{
			assertEquals(R2[m],R1[m]);  //array
		}
	}
}

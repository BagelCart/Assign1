package assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleListTest {

	@Test
	public void addInsertsInFrontOfList() {
		SimpleList tester = new SimpleList();
		
		tester.add(3);
		int value = tester.list[0];
		
		assertEquals(3 , value);
	}
	
	@Test
	public void addMovesEntries() {
		SimpleList tester = new SimpleList();
		
		tester.add(5);
		tester.add(1);
		
		assertFalse(5 == tester.list[0]);
	}
	
	@Test
	public void removeDeletesInstances() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 3;
		tester.list[2] = 1;
		tester.list[3] = 5;
		tester.count = 4;
		
		tester.remove(1);
		
		assertTrue(tester.list[0] == 3);
	}
	
	@Test
	public void nothingToRemove() {
		SimpleList tester = new SimpleList();
		
		tester.list[0] = 7;
		tester.list[1] = 9;
		
		tester.remove(900);
		
		assertTrue(tester.list[1] == 9);
	}
	
	@Test
	public void countReturnsInteger() {
		SimpleList tester = new SimpleList();
		
		assertEquals(0 , tester.count());
	}
	
	@Test
	public void countChangeWithAdd() {
		SimpleList tester = new SimpleList();
		
		tester.add(4);
		
		assertFalse(tester.count() == 0);
	}
	
	@Test
	public void toStringReturnsContents() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 2;
		tester.list[2] = 3;
		tester.list[3] = 4;
		tester.count = 4;
		
		assertEquals("1 2 3 4" , tester.toString());
	}
	
	@Test
	public void toStringReturnsEmptyStringOnEmptyList() {
		SimpleList tester = new SimpleList();
		
		assertEquals("" , tester.toString());
	}
	
	@Test
	public void searchFindsFirstLocation() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 5;
		tester.list[2] = 3;
		tester.list[3] = 5;
		tester.count = 4;
		
		assertEquals(1 , tester.search(5));
	}
	
	@Test
	public void searchReturnsNegativeOneIfNotInList() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 5;
		tester.list[2] = 3;
		tester.list[3] = 5;
		tester.count = 4;
		
		assertEquals(-1 , tester.search(532));
	}

	@Test
	public void addExpandsListByFiftyPercent() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 5;
		tester.list[2] = 3;
		tester.list[3] = 5;
		tester.list[4] = 2;
		tester.list[5] = 2;
		tester.list[6] = 2;
		tester.list[7] = 2;
		tester.list[8] = 2;
		tester.list[9] = 2;
		tester.count = 10;
		tester.add(12);
		
		assertEquals(15 , tester.size());
	}
	
	@Test
	public void removeShrinksList() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 3;
		tester.list[2] = 1;
		tester.list[3] = 5;
		tester.count = 4;
		
		tester.remove(1);
		
		assertEquals(7 , tester.size());
	}
	
	@Test
	public void appendAddsToEndOfList() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 5;
		tester.list[2] = 3;
		tester.count = 3;
		tester.append(17);
		
		assertTrue(tester.list[3] == 17);
	}
	
	@Test
	public void appendExpandsList() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 1;
		tester.list[1] = 5;
		tester.list[2] = 3;
		tester.list[3] = 5;
		tester.list[4] = 2;
		tester.list[5] = 2;
		tester.list[6] = 2;
		tester.list[7] = 2;
		tester.list[8] = 2;
		tester.list[9] = 2;
		tester.count = 10;
		tester.append(12);
		
		assertEquals(15 , tester.size());
	}
	
	@Test
	public void firstReturnsFirstElement() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 4;
		tester.list[1] = 9;
		tester.list[2] = 52;
		tester.count = 3;
		
		assertEquals(4 , tester.first());
	}
	
	@Test
	public void firstReturnsNegativeOneOnEmptyList() {
		SimpleList tester = new SimpleList();
		
		assertEquals(-1 , tester.first());
	}
	
	@Test
	public void lastReturnsLastElement() {
		SimpleList tester = new SimpleList();
		tester.list[0] = 4;
		tester.list[1] = 9;
		tester.list[2] = 52;
		tester.count = 3;
		
		assertEquals(52 , tester.last());
	}
	
	@Test
	public void lastReturnsNegativeOneOnEmptyList() {
		SimpleList tester = new SimpleList();
		
		assertEquals(-1 , tester.last());
	}
}

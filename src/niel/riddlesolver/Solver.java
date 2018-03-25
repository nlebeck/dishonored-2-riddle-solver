package niel.riddlesolver;

import java.util.ArrayList;
import java.util.List;

public class Solver {
	
	// Colors
	public static int GREEN = 0;
	public static int WHITE = 1;
	public static int RED = 2;
	public static int BLUE = 3;
	public static int PURPLE = 4;
	public static String[] COLOR_TEXT = { "Green", "White", "Red", "Blue", "Purple" };
	
	// Hometowns
	public static int BALETON = 0;
	public static int KARNACA = 1;
	public static int DUNWALL = 2;
	public static int DABOKVA = 3;
	public static int FRAEPORT = 4;
	public static String[] HOMETOWN_TEXT = { "Baleton", "Karnaca", "Dunwall", "Dabokva", "Fraeport" };
	
	// Alcohols
	public static int BEER = 0;
	public static int WINE = 1;
	public static int WHISKEY = 2;
	public static int RUM = 3;
	public static int ABSINTHE = 4;
	public static String[] ALCOHOL_TEXT = { "Beer", "Wine", "Whiskey", "Rum", "Absinthe" };
	
	// Names
	public static int MARCOLLA = 0;
	public static int CONTEE = 1;
	public static int NATSIOU = 2;
	public static int FINCH = 3;
	public static int WINSLOW = 4;
	public static String[] NAME_TEXT = { "Marcolla", "Contee", "Natsiou", "Finch", "Winslow" };
	
	// Items
	public static int SNUFF_TIN = 0;
	public static int WAR_MEDAL = 1;
	public static int BIRD_PENDANT = 2;
	public static int RING = 3;
	public static int DIAMOND = 4;
	public static String[] ITEM_TEXT = { "Snuff Tin", "War Medal", "Bird Pendant", "Ring", "Diamond" };
	
	/**
	 * Generates all permutations of an array holding the integers 0 through 4.
	 */
	private List<int[]> permuteFive() {
		List<int[]> result = new ArrayList<int[]>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					for (int m = 0; m < 5; m++) {
						for (int n = 0; n < 5; n++) {
							if (   i != j && i != k && i != m && i != n
								&& j != k && j != m && j != n
								&& k != m && k !=n
								&& m != n) {
								int[] array = new int[5];
								array[0] = i;
								array[1] = j;
								array[2] = k;
								array[3] = m;
								array[4] = n;
								result.add(array);
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * Returns the position of the person with the given value in the given
	 * category.
	 */
	private int findPerson(int[] category, int value) {
		for (int i = 0; i < 5; i++) {
			if (category[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Determines whether the given assignment of values to positions for each
	 * category fits the constraints in the riddle.
	 */
	private boolean check(int[] names, int[] colors, int[] alcohols, int[] hometowns, int[] items) {
		int tmpA = findPerson(names, FINCH);
		int tmpB = findPerson(colors, WHITE);
		if (tmpA != tmpB) {
			return false;
		}
		
		tmpA = findPerson(names, MARCOLLA);
		if (tmpA != 0) {
			return false;
		}
		
		tmpA = findPerson(colors, GREEN);
		if (tmpA != 1) {
			return false;
		}
		
		// It's unclear from the text whether the person in blue is immediately
		// to the left of the person in red, but allowing the person in blue to
		// be anywhere to the left of the person in red seems to lead to
		// multiple valid solutions
		tmpA = findPerson(colors, BLUE);
		tmpB = findPerson(colors, RED);
		if (tmpB - tmpA != 1) {
			return false;
		}
		
		tmpA = findPerson(colors, BLUE);
		tmpB = findPerson(alcohols, RUM);
		if (tmpA != tmpB) {
			return false;
		}
		
		tmpA = findPerson(colors, PURPLE);
		tmpB = findPerson(hometowns, BALETON);
		if (tmpA != tmpB) {
			return false;
		}
		
		tmpA = findPerson(items, WAR_MEDAL);
		tmpB = findPerson(hometowns, BALETON);
		if (Math.abs(tmpA - tmpB) != 1) {
			return false;
		}
		
		tmpA = findPerson(names, NATSIOU);
		tmpB = findPerson(items, SNUFF_TIN);
		if (tmpA != tmpB) {
			return false;
		}
		
		tmpA = findPerson(hometowns, DABOKVA);
		tmpB = findPerson(items, RING);
		if (tmpA != tmpB) {
			return false;
		}

		tmpA = findPerson(items, DIAMOND);
		tmpB = findPerson(hometowns, DUNWALL);
		int tmpC = findPerson(alcohols, BEER);
		if (Math.abs(tmpA - tmpB) != 1 || Math.abs(tmpB - tmpC) != 1) {
			return false;
		}
		
		tmpA = findPerson(names, WINSLOW);
		tmpB = findPerson(alcohols, ABSINTHE);
		if (tmpA != tmpB) {
			return false;
		}
		
		tmpA = findPerson(hometowns, KARNACA);
		tmpB = findPerson(alcohols, WHISKEY);
		if (tmpA != tmpB) {
			return false;
		}
		
		tmpA = findPerson(alcohols, WINE);
		if (tmpA != 2) {
			return false;
		}
		
		tmpA = findPerson(names, CONTEE);
		tmpB = findPerson(hometowns, FRAEPORT);
		if (tmpA != tmpB) {
			return false;
		}
		
		return true;
	}
	
	private String arrayToString(int[] array, String[] text) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			result.append(text[array[i]]);
			if (i < array.length - 1) {
				result.append("\t");
			}
		}
		return result.toString();
	}
	
	public void solve() {
		List<int[]> permutations = permuteFive();
		for (int[] names : permutations) {
			for (int[] colors : permutations) {
				for (int[] alcohols : permutations) {
					for (int[] hometowns : permutations) {
						for (int[] items : permutations) {
							boolean valid = check(names, colors, alcohols, hometowns, items);
							if (valid) {
								System.out.println(arrayToString(names, NAME_TEXT));
								System.out.println(arrayToString(colors, COLOR_TEXT));
								System.out.println(arrayToString(alcohols, ALCOHOL_TEXT));
								System.out.println(arrayToString(hometowns, HOMETOWN_TEXT));
								System.out.println(arrayToString(items, ITEM_TEXT));
								System.out.println("");
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Solver solver = new Solver();
		solver.solve();
	}
}

package Print;

import java.util.Map;

public abstract class MapTable<K, V> extends MapUtils<K, V> {
	protected String[] header;
	
	MapTable(Map<K, V> map) {
		super(map);
	}
	
	abstract void printTable();
	abstract void printAnalysis();
	
	public void setHeader(String... labels) {
		this.header = labels;
	}
	
	protected String middleString(String str, int width) {
		// Align the the string to the middle
		int space = (width - str.length()) / 2;
		int fac = (width - str.length()) % 2; // factor
		return " ".repeat(space) + str + " ".repeat(space + fac);
	}
}

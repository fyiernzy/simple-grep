package Print;

import java.util.Map;

public abstract class MapPrinter<K, V> extends MapUtils<K, V> {
	MapPrinter(Map<K, V> map) {
		super(map);
	}
	
	abstract void printMap();
}

package Print;

import java.util.*;

public abstract class MapUtils<K, V> {
	protected final Map<K, V> MAP;
	
	MapUtils(Map<K, V> map){
		this.MAP = map;
	}
}

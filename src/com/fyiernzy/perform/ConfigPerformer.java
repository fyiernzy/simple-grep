package com.fyiernzy.perform;

import com.fyiernzy.system.Configuration;

public class ConfigPerformer {
	public static void perform(StringBuilder command) {
		String[] tmp = command.toString().split(" ");
		
		String key = tmp[2];
		String value = tmp[3];
		
		switch(key) {
			case "--user.name"    -> Configuration.setName(value);
			case "--user.email"   -> Configuration.setEmail(value);
			case "--system.decor" -> Configuration.setCommandDecor(value);
			case "--system.head"  -> Configuration.setCommandHead(value);
			case "default" 		  -> Configuration.setDefault();
			
		}
	}
}

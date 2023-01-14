package com.fyiernzy.perform;

import com.fyiernzy.system.Configuration;

public class ConfigPerformer {
	public static void perform(StringBuilder command) {
		String[] tmp = command.toString().split(" ");
		
		switch(tmp[2]) {
			case "--user.name":
				Configuration.setName(tmp[3]);
				break;
			case "--user.email":
				Configuration.setEmail(tmp[3]);
				break;
			case "--system.decor":
				Configuration.setCommandDecor(tmp[3]);
				break;
			case "--system.head":
				Configuration.setCommandHead(tmp[3]);
				break;
			case "default":
				Configuration.setName("localHost");
				Configuration.setEmail("localHost@root.com");
				Configuration.setCommandDecor(">>>");
				Configuration.setCommandHead("fop");
				break;
			
		}
	}
}

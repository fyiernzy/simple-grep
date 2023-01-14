package com.fyiernzy.perform;

import java.util.ArrayList;
import com.fyiernzy.constant.RegexConst;

public abstract class SearchPerformer extends Performer {
	protected StringBuilder command;
	
	SearchPerformer(StringBuilder command) {
		this.command = command;
	}
	
	public String[] getCommandList() {
		return getCommandList(2);
	}
	
	public String[] getCommandList(int startIndex) {
		String[] tmp = this.command.toString().split(RegexConst.SPLIT_REGEX);
		
		ArrayList<String> commands = new ArrayList<String>();
		
		for(int i = startIndex; i < tmp.length; i++) {
			if (tmp[i].matches(RegexConst.TIME_REGEX))
				commands.add(tmp[i].substring(1));
			else if (tmp[i].matches(RegexConst.ARGUMENT_REGEX))
				commands.add(tmp[i]);
		}
		
		return commands.toArray(new String[commands.size()]);
	}
	
	abstract StringBuilder perform();
}

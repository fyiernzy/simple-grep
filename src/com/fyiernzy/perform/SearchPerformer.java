package com.fyiernzy.perform;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.fyiernzy.constant.RegexConst;

public abstract class SearchPerformer {
	protected final StringBuilder COMMAND;
	protected final String SOURCE;
	
	SearchPerformer(String file, StringBuilder command) {
		this.SOURCE = file;
		this.COMMAND = command;
	}
	
	public String[] getCommandList() {
		return this.getCommandList(2);
	}
	
	public String[] getCommandList(int startIndex) {
		String[] tmp = RegexConst.SPLIT.split(this.COMMAND);
		
		ArrayList<String> commands = new ArrayList<String>();
		
		for(int i = startIndex; i < tmp.length; i++) {
			if (Pattern.matches(RegexConst.TIME.pattern(), tmp[i]))
				commands.add(tmp[i].substring(1));
			else if (Pattern.matches(RegexConst.ARGUMENT.pattern(), tmp[i]))
				commands.add(tmp[i]);
		}
		
		return commands.toArray(new String[commands.size()]);
	}
	
	abstract StringBuilder perform();
}

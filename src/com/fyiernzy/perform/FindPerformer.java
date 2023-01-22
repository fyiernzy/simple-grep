package com.fyiernzy.perform;

import com.fyiernzy.search.*;

public class FindPerformer extends SearchPerformer {
	public FindPerformer(String file, StringBuilder command) {
		super(file, command);
	}
	
	@Override
	public StringBuilder perform() {
		String[] keywords = this.getCommandList();
		return new FindStream(this.SOURCE).readContent().filterArgument(keywords).toResult();
	}
}

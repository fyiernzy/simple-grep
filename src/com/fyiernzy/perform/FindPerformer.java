package com.fyiernzy.perform;

import com.fyiernzy.search.*;

public class FindPerformer extends SearchPerformer {
	public FindPerformer(StringBuilder command) {
		super(command);
	}
	
	@Override
	public StringBuilder perform() {
		return new FindStream().readContent().filterArgument(getCommandList()).toResult();
	}
}

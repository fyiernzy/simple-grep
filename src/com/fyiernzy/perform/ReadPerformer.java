package com.fyiernzy.perform;

import com.fyiernzy.search.ReadStream;

public class ReadPerformer extends SearchPerformer {
	public ReadPerformer(StringBuilder command) {
		super(command);
	}
	
	@Override
	public StringBuilder perform() {
		return new ReadStream()
				.readContent()
				.filterArgument(getCommandList(3))
				.limitContent(Integer.parseInt(command.toString().split(" ")[2]))
				.toResult();
	}
}

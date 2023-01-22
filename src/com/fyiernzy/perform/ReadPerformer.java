package com.fyiernzy.perform;

import com.fyiernzy.search.ReadStream;

public class ReadPerformer extends SearchPerformer {
	public ReadPerformer(String file, StringBuilder command) {
		super(file, command);
	}
	
	@Override
	public StringBuilder perform() {
		String[] keywords = this.getCommandList(3);
		int numOfContents = Integer.parseInt(this.COMMAND.toString().split(" ")[2]);
		
		return new ReadStream(this.SOURCE).readContent()
										  .filterArgument(keywords)
										  .limitContent(numOfContents).toResult();
	}
}

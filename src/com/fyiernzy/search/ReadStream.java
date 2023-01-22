package com.fyiernzy.search;

public class ReadStream extends SearchStream {
	public ReadStream(String file) {
		super(file);
	}
	
	@Override
	public ReadStream filterArgument(String... keywordList) {
		return (ReadStream) super.filterArgument(keywordList);
	}
	
	@Override
	public ReadStream readContent() {
		return (ReadStream) super.readContent();
	}
	
	public ReadStream limitContent(int index) {
		String[] split = this.content.toString().split("\n");
		int max = Math.min(index, split.length);
		this.content.setLength(0);
		
		for(int i = 0; i < max; i++) 
			this.content.append(split[i]).append("\n");
		
		return this;
	}
}

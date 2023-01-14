package com.fyiernzy.search;

public class ReadStream extends SearchStream {
	@Override
	public ReadStream filterArgument(String[] keywordList) {
		return (ReadStream) super.filterArgument(keywordList);
	}
	
	@Override
	public ReadStream readContent() {
		return (ReadStream) super.readContent();
	}
	
	public ReadStream limitContent(int index) {
		StringBuilder tmp = new StringBuilder();
		String[] split = this.content.toString().split("\n");
		int num = (index < split.length) ? index : split.length;
		
		for(int i = 0; i < num; i++) {
			tmp.append(split[i] + "\n");
		}
		
		this.content = tmp;
		return this;
	}
}

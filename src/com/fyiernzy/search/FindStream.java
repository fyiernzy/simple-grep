package com.fyiernzy.search;



public class FindStream extends SearchStream {
	@Override
	public FindStream filterArgument(String[] keywordList) {
		return (FindStream) super.filterArgument(keywordList);
	}
	
	@Override
	public FindStream readContent() {
		return (FindStream) super.readContent();
	}
	
}

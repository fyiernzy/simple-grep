package com.fyiernzy.perform;

import java.util.*;
import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.search.*;

import java.time.LocalDate;

public class ListPerformer extends SearchPerformer {
	public ListPerformer(String file, StringBuilder command) {
		super(file, command);
	}
	
	@Override
	public StringBuilder perform() {
		String[] commands = this.getCommandList();
		String[] keywordList = Arrays.copyOfRange(commands, 2, commands.length);
		
		LocalDate start = LocalDate.parse(commands[0], RegexConst.DATE_FORMATTER);
		LocalDate end = LocalDate.parse(commands[1], RegexConst.DATE_FORMATTER);
		
		return new ListStream(this.SOURCE).readContent().filterTime(start, end).filterArgument(keywordList).toResult();

	}
}

package com.fyiernzy.perform;

import java.util.regex.*;

import com.fyiernzy.constant.ConfigConst;
import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.search.*;

public class RegexPerformer extends SearchPerformer {
	private final StringBuilder RECORD;
	
	public RegexPerformer(StringBuilder command, StringBuilder record) {
		super(command);
		this.RECORD = record;
	}
	
	public StringBuilder perform() {
		Pattern pattern = Pattern.compile(RegexConst.REGEX_REGEX);
		Matcher matcher = pattern.matcher(this.command);
		matcher.matches();
		
		StringBuilder sb = new StringBuilder();
		
		switch(matcher.group(1)) {
		case ConfigConst.CONFIG_REGEX_MATCH   -> sb = new RegexStream().readContent().filterRegex(matcher.group(2)).toResult();
		case ConfigConst.CONFIG_REGEX_EXTRACT -> sb = new RegexStream().extractRegex(matcher.group(2), this.RECORD).toResult();
		}
		
		return sb;
	}
}

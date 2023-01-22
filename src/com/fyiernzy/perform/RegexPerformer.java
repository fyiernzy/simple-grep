package com.fyiernzy.perform;

import java.util.regex.*;
import com.fyiernzy.constant.ConfigConst;
import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.search.*;

public class RegexPerformer extends SearchPerformer {
	private final StringBuilder RECORD;
	
	public RegexPerformer(String file, StringBuilder command, StringBuilder record) {
		super(file, command);
		this.RECORD = record;
	}
	
	public StringBuilder perform() {
		Matcher matcher = RegexConst.REGEX.matcher(this.COMMAND);		
		matcher.matches();
		
		RegexStream stream = new RegexStream(this.SOURCE, matcher.group(2));
		
		switch(matcher.group(1)) {
			case ConfigConst.CONFIG_MATCH   -> stream.readContent().filterRegex();
			case ConfigConst.CONFIG_EXTRACT -> stream.extractRegex(this.RECORD);
		}
		
		return stream.toResult();
	}
}

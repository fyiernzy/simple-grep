package com.fyiernzy.perform;

public class Tester {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello world");
		// System.out.println(sb);
		sb.setLength(0);
		System.out.println(sb);
		sb.append("Hello world");
		System.out.println(sb);
	}
}

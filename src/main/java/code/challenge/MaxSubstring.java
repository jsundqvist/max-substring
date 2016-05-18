package code.challenge;

import java.util.HashSet;
import java.util.Set;

public class MaxSubstring {

	private static final String INPUT = "abbcda";
	private static final String EXPECTED = "bcda";

	public static int getMaxSubstringLength(String input) {
		return getMaxSubstring11(input).length();
	}

	public static String getMaxSubstring10(String input) {
		String[] candidates = new String[input.length()];
		for(int i = 0; i < input.length(); i++) {
			Set<Character> visited = new HashSet<>();
			StringBuilder builder = new StringBuilder();
			for(int j = i; j < input.length(); j++) {
				char c = input.charAt(j);
				if(!visited.contains(c)) { // constant time
					builder.append(c);
					visited.add(c);
				} else {
					candidates[i] = builder.toString();
					break;
				}
			}
			candidates[i] = builder.toString();
		}
		String maxSubstring = null;
		for(String candidate : candidates) {
			if(maxSubstring == null || candidate.length() > maxSubstring.length())
				maxSubstring = candidate;
		}
		return maxSubstring;
	}

	public static String getMaxSubstring11(String input) {
		String maxSubstring = null;
		for(int i = 0; i < input.length(); i++) {
			StringBuilder builder = new StringBuilder();
			Set<Character> visited = new HashSet<>();
			for(int j = i; j < input.length(); j++) {
				char c = input.charAt(j);
				if(!visited.contains(c)) {
					builder.append(c);
					visited.add(c);
				} else
					break;
			}
			String candidate = builder.toString();
			if(maxSubstring == null || candidate.length() > maxSubstring.length())
				maxSubstring = candidate;
		}
		return maxSubstring;
	}

	public static String getMaxSubstring20(String input) {
		String maxSubstring = null;
		StringBuilder substring = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int indexOf = substring.indexOf(Character.toString(c)); // linear time
			if(indexOf < 0)
				substring.append(c);
			else {
				if(maxSubstring == null || substring.length() > maxSubstring.length())
					maxSubstring = substring.toString();
				substring = new StringBuilder(substring.substring(indexOf + 1, substring.length()) + c);
			}
		}
		if(maxSubstring == null || substring.length() > maxSubstring.length())
			maxSubstring = substring.toString();
		return maxSubstring;
	}

}

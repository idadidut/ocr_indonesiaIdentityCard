package ktp.processing;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Postprocessing {
	private String regex;
	private String replacement;
	private String output;
	private Matcher matcher;
	private Pattern pattern;
	
	public String postprocess(String input) {
		regex = "[\\.\\,\\:\\=]+";
		replacement="";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = " +";
		replacement=" ";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "\n +";
		replacement="\n";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "\n. (. )*";
		replacement="\n";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "^ +";
		replacement="";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "^. (. )*";
		replacement="^";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "\n\n+";
		replacement="\n";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "([A-z])5";
		replacement="$1S";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);

		regex = "5([A-z])";
		replacement="S$1";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "([A-z])8([A-z])";
		replacement="$1S$2";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = "([^\\WAIUEO])LI";
		replacement="$1U";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
//		regex = "([a-z])I";
//		replacement="$1l";
//		pattern = Pattern.compile(regex);
//		matcher = pattern.matcher(input);
//		input = matcher.replaceAll(replacement);
//		
//		regex = "([^\\Waiueo])l([^\\Waiueo])";
//		replacement="$1i$2";
//		pattern = Pattern.compile(regex);
//		matcher = pattern.matcher(input);
//		input = matcher.replaceAll(replacement);
		
		regex = " 3 ";
		replacement=" ";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = " F ";
		replacement=" ";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = " 1 ";
		replacement=" ";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = " - ";
		replacement=" ";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		input = matcher.replaceAll(replacement);
		
		regex = " I ";
		replacement=" ";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(input);
		output = matcher.replaceAll(replacement);
		
		return output;
	}
}

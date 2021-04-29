package core;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static String getDomainName(String url) throws URISyntaxException {
	    URI uri = new URI(url);
	    String domain = uri.getHost();
	    return domain.startsWith("www.") ? domain.substring(4) : domain;
	}
	
	public static void main(String[] args) throws URISyntaxException {
		String domainRegexFromURL = "^(?:(?i)https?:\\/\\/)?(?:(?i)www[0-9]*.)?([^:\\/?\\n]+)";
		//String url = "yahoo.com/anypath";
		//String url = "www.yahoo.com/anypath";
		//String url = "http://yahoo.com/anypath";
		//String url = "http://www.yahoo.com/anypath";
		//String url = "yahoo.com";
		String url = "https://yahoo.com";
		//String url = "yahoo.com/anypath";
		Pattern pattern = Pattern.compile(domainRegexFromURL);
	        Matcher matcher = pattern.matcher(url);
	       if (matcher.find()) {
	    	   System.out.println("-----");
	    	   System.out.println(matcher.group(1));
	       }
	}
}

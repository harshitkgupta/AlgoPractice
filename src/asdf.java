import org.apache.commons.lang.StringEscapeUtils;
public class asdf {
	

	    public static void main(String[] args) {
	        String strHTMLInput = "<p>MyName & Your Name<p>";
	        String strEscapeHTML = StringEscapeUtils.escapeHtml(strHTMLInput);
	        String strUnEscapeHTML = StringEscapeUtils.unescapeHtml(strEscapeHTML);
	        System.out.println("Escaped HTML >>> " + strEscapeHTML);
	        System.out.println("UnEscaped HTML >>> " + strUnEscapeHTML);
	        
	        
	        String escpaeUnicode = "\u5bfc\u5165\u6e05\u5355";
	        String strEscapeHTML1 = StringEscapeUtils.escapeHtml(escpaeUnicode);
	        String strUnEscapeHTML1 = StringEscapeUtils.unescapeHtml(escpaeUnicode);
	        System.out.println("Escaped HTML >>> " + strEscapeHTML1);
	        System.out.println("\u5bfc\u5165\u6e05\u5355");
	        System.out.println("UnEscaped HTML >>> " + strUnEscapeHTML1);
	    }
	
}

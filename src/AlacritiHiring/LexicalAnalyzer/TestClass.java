package AlacritiHiring.LexicalAnalyzer;

import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        String str;
        Set<String> variables = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            str = s.nextLine();
            for(String st: str.split(";"))
            {
            	if(st.split("=").length >=2)
            		variables.add(st.split("=")[0].trim());
            }
        }
        s.close();
        System.out.println(variables.size());
    }
}
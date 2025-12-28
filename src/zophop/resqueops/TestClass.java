package zophop.resqueops;


import java.util.*;


class TestClass {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
           int N= s.nextInt();s.nextLine();
           String string = s.nextLine();
           int dist[] = new int[2];
           int id = 1, c=1;
           char prev='R';
           for(int i=0; i< string.length(); i++){
        	   switch(string.charAt(i)){
        	   case 'M' : dist[id]+=c;
        	   			break;
        	   case 'L' : c*= ((prev=='L')? 1: -1); id=0;
        	   			break;
        	   case 'R' : c*= ((prev=='R')? 1: -1); id=1;
	   			break;		
        	   }
           }
        }
        */

        System.out.println("Hello World!");
    }
}

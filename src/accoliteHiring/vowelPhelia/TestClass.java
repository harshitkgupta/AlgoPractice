package accoliteHiring.vowelPhelia;


import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        List<Integer> pos = new ArrayList<Integer>();
        while(T>0)
        {
            T--;
            int N= s.nextInt();
            s.nextLine();
            String word = s.nextLine();
            pos.clear();
            pos.add(-1);
            for(int i=0;i<word.length(); i++)
            {
                if(vowels.contains(word.charAt(i)))
                    pos.add(i);
            }
            pos.add(N);
            if(pos.size()<=4)
                System.out.println("0");
            else
            {
                long  ans=0;
                for(int i=1;i<pos.size()-3;i=i+1)
                {
                    ans+=((long)(pos.get(i)-pos.get(i-1)))*((long)(pos.get(i+3)-pos.get(i+3-1)));
                }
                System.out.println(ans);
            }
            
        }
        s.close();
    }
}

@FunctionalInterface
interface MyStringFace{
	String giveDemo(String a);
}
public class MethodReferenceDemo {
	public static void main(String args[]){
		MyStringFace f = MyStringClass::giveDemo;
		System.out.println(f.giveDemo("Ram"));
		
		MyStringClass2 c2 = new MyStringClass2();
		MyStringFace f2 = c2::giveDemo;
		f2.giveDemo("Mohan ");
	}
	
}
class MyStringClass {

static 	public String giveDemo(String a) {
		return "Hello World "+a;
	}
	
}

class MyStringClass2 {

 	public String giveDemo(String a) {
		return "Hello World "+a;
	}
	
}

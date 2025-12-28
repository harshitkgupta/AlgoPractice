@FunctionalInterface
interface PrintInterface<T,R>{
	R fun(T t);
}

@FunctionalInterface
interface ConsInterface{
	Person getObject(String name);
}
public class MethodReferenceDemo2 {
	public static void main(String args[]){
		ConsInterface c=Person::new;
		PrintInterface<Person,String> it=Person::getName;
		Person p= c.getObject("RAMMMMMMM");
		print(it,p);
	}
	public static void print(PrintInterface<Person,String> i, Person pr){
		System.out.println(i.fun(pr));
	}	
}

class Person{
	String name;
	Person(String name){
		this.name=name;
	}
	String getName(){
		return name;
	}
}

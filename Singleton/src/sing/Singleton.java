package sing;

public class Singleton {

private static Singleton theonlyref; //the only one reference to only one object is static

private Singleton(){  //notice the private constructor invoked only through static method
	
}

public static Singleton getInstance(){
	if(theonlyref==null){
		theonlyref=new Singleton();
	}
		return theonlyref;
}

}

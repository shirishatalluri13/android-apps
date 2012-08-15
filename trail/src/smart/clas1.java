package smart;

import java.util.*;
public class clas1 {

	public int j = 98;
	/**
	 * @param args
	 */
	public static void editlist(Collection<String> l1,Collection<String> l2){
		Iterator<String> it = l1.iterator();
		Iterator<String> it2 = l2.iterator();
		
		while(it.hasNext()){
			if(l2.contains(it.next()))
					it.remove();
		}
	}	
	//printMe method
	public static void printMe(Collection<String> l1){
		LinkedList<String> l01 = (LinkedList<String>)l1;
		for(int i=0;i<l1.size();i++)
			System.out.printf("%s ",l01.get(i));
		System.out.println();
	}
	//reverseMe method
	public static void reverseMe(List<String> l){
		ListIterator bobby = l.listIterator(l.size());
		while(bobby.hasPrevious()){
			System.out.printf("%s ",bobby.previous());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//collections holds references to other subjects and it is dynamic eg. list,set etc.
		String[] things = {"eggs","lasers","hats","pie"};
		List<String> lis1 = new ArrayList<String>();
		
		String[] llthings = {"apples","newbie","pwnge","bacon","goats"};
		List<String> ll1 = new LinkedList<String>();
		
		for(String x : llthings) //populates ll1 wiht llthings
			ll1.add(x);
		
		String[] llmorethings = {"sausage","bacon","goats","harrypotter"};
		List<String> ll2 = new LinkedList<String>();
		
		for(String x : llmorethings)
			ll2. add(x);
		
		ll1.addAll(ll2);
		ll2 = null;
		
		printMe(ll1);
		//removeStuff(ll1,2,5);
		
		reverseMe(ll1);
	//	printMe(ll1);
		//add array items to list
		for( String x : things){
			System.out.println(x);
			lis1.add(x);
		}
		
		String[] morethings = {"lasers","hats"};
		List<String> lis2 = new ArrayList<String>();
		
		for( String x : morethings){
			System.out.println(x);
			lis2.add(x);
		}
		
		
		editlist(lis1,lis2);//edit lis1 to take out items - items in lis2
		System.out.println();
	
		System.out.println("printing out list 1");
		for(int i=0;i<lis1.size();i++)
			System.out.printf("%s ", lis1.get(i));
	
		String[] stuff = {"babies","watermelong","melons","fudge"};
		//converting an array to a list
		LinkedList<String> thelist = new LinkedList<String>(Arrays.asList(stuff));

		thelist.addFirst("firstthing");
		
		//convert back to array
		stuff = thelist.toArray(new String[thelist.size()]);//notice the method parameter !!
		System.out.println();

		System.out.println();
		for(String x : stuff)
			System.out.println(x);
	
		String[] crap ={"apples","bacon","car","starwars"};
	//	Clas2.printmsg();
	}
}

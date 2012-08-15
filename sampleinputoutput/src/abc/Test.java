package abc;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bicycle b;
		b=new MountainBike(1, 2, 3, 4);
		b.speaker();//calls the overriden one. coz it knows what object it is holding but only methods which are commont to both are callable
		/*
		 * You can make a logical test as to the type of a particular object using the instanceof operator.
		 *  This can save you from a runtime error owing to an improper cast. For example:
			if (obj instanceof MountainBike) {
    			MountainBike myBike = (MountainBike)obj;
			}
			Here the instanceof operator verifies that obj 
			refers to a MountainBike so that we can make the 
			cast with knowledge that there will be no runtime exception thrown.
		 */
	}

}

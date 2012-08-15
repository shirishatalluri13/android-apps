package abc;
public class Testanimals {

	public static int[] arr = {5,3,4,8,6,7};
	public static int[] pre=new int[6];
    public static int[] old = new int[6];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int x=0;x<6;x++)
			pre[x]=1;
		for(int x:pre)
			System.out.print(x);
		for(int i =0;i<6;i++){
			for(int j=0;j<i;j++){
				if(pre[j]+1>pre[i]&&arr[i]>arr[j])
				{	pre[i]=pre[j]+1;
					old[i]=j;
				}   
			}
				
		}
		System.out.println();
		for(int x:old)
			System.out.print(x);
		printrec(5);
	}
	
	public static void printrec(int i){
		if(i==0){
			System.out.println(arr[0]);
			return;
		} else {
			printrec(old[i]);
			System.out.println(arr[i]);
		}	
	}

}

//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    static class Pump{
        int petrol;
        int distance;
        
        Pump(int petrol,int distance){
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	int n = petrol.length;
	Pump[] p =new Pump[n];
	for(int i = 0; i < n ;i++){
	    p[i]=new Pump(petrol[i],distance[i]);
	}
	int petrol_ki_kami = 0;
       int balance = 0;
       int start = 0;
       
       for (int i=0; i<n; i++){
           balance += p[i].petrol - p[i].distance;
           if (balance < 0){
               petrol_ki_kami += balance;
               start = i+1;
               balance = 0;
           }
       }
       
       if (petrol_ki_kami + balance >= 0){
           return start;
       }
       else{
           return -1;
       }
    }
}
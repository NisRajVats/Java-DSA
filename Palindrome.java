import java.util.Scanner;



class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }

        int n = x;
        int revnum = 0 ;

        while(n>0)
        {
            int d = n%10;
            revnum = revnum *10 + d;
            n=n/10;
        }
        if(revnum == x)
        {
            return true;
        }
        else{
            return false;
        }
    }
}



public class Palindrome {

    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any number:");
        int x = sc.nextInt();

        Solution sol = new Solution ();

        if (sol.isPalindrome(x)) {
            System.out.println(x + " is a palindrome.");
        } else {
            System.out.println(x + " is not a palindrome.");
        }
        
        sc.close(); // Close the Scanner
        
    }
}
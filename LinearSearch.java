// Ques: Take an array from the user and search for a given number and print the index at which it occurs..

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array...:");
        int size = sc.nextInt();
        int arr[] = new int[size];

        for(int i=0;i<size;i++)
        {
            System.out.print("Enter the elements of array:");
            arr[i]=sc.nextInt();
        }
        // System.out.print("The array is :");
        // for(int i=0;i<size;i++)
        // {
        //     System.out.print(arr[i]+" ");
            
        // }

        System.out.print("Which number you want to search:");
        int query = sc.nextInt();
        int flag = 0;
        for(int i=0;i<size;i++)
        {
            if(query == arr[i])
            {
                System.out.print("Your number is at index :" + i);
                flag = 1;
                break;
            }
            
        }
        if(flag == 0){
            System.out.println("Cannot find .. ");
        }



        sc.close();
    }
}
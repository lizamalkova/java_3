package homework6;

import java.util.Arrays;

public class ArrayMain {

    public static void main(String[] args) {
    }

    public static int[] transformArray(int arr[]) throws RuntimeException{
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                index = i;
            }
        }
        if (index == -1){
            throw new RuntimeException("Invalid array");
        } else {
            int[] newArr = new int[arr.length-(index+1)];
            for(int i=index+1;i<arr.length;i++){
                newArr[i-(index+1)]=arr[i];
            }
            return newArr;
        }

    }

    public static boolean checkArray(int[] arr){
        for (int number:arr){
            if (number != 1 && number != 4){
                return false;
            }
        }
        return true;
    }

}

package homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class homework1 {

    public static void main(String[] args) {

        Integer arr1[] = {1,2,3,4,5};
        String arr2[] = {"I","W","X","T"};
        changeElementsArray(1,4,arr1);
        changeElementsArray(2,4,arr2);

        }

    public static <T> void changeElementsArray(int i, int j, T[] arr){
        T array = arr[i];
        arr[i] = arr[j];
        arr[j] = array;
    }

    public static <T> ArrayList<T> changeToArrayList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}

package homework6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TransformTest2 {

    private int arr[];

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,5}},
                {new int[]{5,88,2,67,0}},
                {new int[]{56,5,5}}
        });
    }

    public TransformTest2(int[] arr) {
        this.arr = arr;
    }

    @Test (expected = RuntimeException.class)
    public void transformETest(){
        new ArrayMain().transformArray(arr);
    }
}
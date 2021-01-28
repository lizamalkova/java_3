package homework6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TransformTest {

    private int arr[];
    private int newArr[];

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,4,4,2,3,4,1,7}, new int[]{1,7}},
                {new int[]{1,2,3,4}, new int[]{}},
                {new int[]{4,7,66,32,90}, new int[]{7,66,32,90}},
        });
    }

    public TransformTest(int[] arr, int[] newArr) {
        this.arr = arr;
        this.newArr = newArr;
    }

    @Test
    public void transformTest(){
        Assert.assertArrayEquals(newArr, new ArrayMain().transformArray(arr));
    }
}


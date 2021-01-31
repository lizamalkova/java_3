package homework6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckTest {

    private int arr[];
    private boolean result;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,1,1}, true},
                {new int[]{4,4}, true},
                {new int[]{2,5,7}, false},
                {new int[]{1,1,4}, true},
                {new int[]{4,1,4,1}, true},
        });
    }

    public CheckTest(int[] arr, boolean result) {
        this.arr = arr;
        this.result = result;
    }

    @Test
    public void checkTest(){
        Assert.assertEquals(result, new ArrayMain().checkArray(arr));
    }
}
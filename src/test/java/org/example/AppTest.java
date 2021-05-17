package org.example;



import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Unit test for simple App.
 */

public class AppTest {

    @Test
    public static void one(){
        int arr[] = {1,2,1,2,4,5};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry entry:entries){
            if(entry.getValue().equals(1)){
                System.out.println(entry.getKey());
            }
        }
    }
}

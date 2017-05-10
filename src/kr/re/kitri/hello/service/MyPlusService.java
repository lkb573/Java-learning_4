package kr.re.kitri.hello.service;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class MyPlusService {

    public static int plusFunction(int fstNum, int secNum){
        return fstNum + secNum;

    }

    public static int sumList(List<Integer> intList) {
        /*int sum = 0;
        for(int e : intList){
            sum += e;
        }
        return sum;*/


        return intList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double averList(List<Integer> intList) throws Exception {

        /*return (double) sumList(intList) / intList.size();*/

        OptionalDouble result = intList.stream()
                .mapToInt(Integer::intValue)
                .average();

        if(result.isPresent()){
            return result.getAsDouble();
        }
        else {
            throw new Exception("No Data!");
        }

    }
}

package kr.re.kitri.hello;

import kr.re.kitri.hello.service.MyPlusService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HelloJdbc {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        MyPlusService service = new MyPlusService();
        int result = service.sumList(intList);
        double average = 0;
        try {
            average = service.averList(intList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(result);
        System.out.println(average);

    }


}
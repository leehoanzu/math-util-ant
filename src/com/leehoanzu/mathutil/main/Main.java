/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leehoanzu.mathutil.main;

import com.leehoanzu.mathutil.core.MathUtil;

/**
 *
 * @author lehoa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("This message comes form the main() method");
        System.out.println("This jar file built based ANT in co-operating with JUnit");
        System.out.println("More over, this message come from a US-BUILD'S JAR FILE");
        tryTDDFirst();
        //testFactorialGivenWrongArgumentThrowsException();
        
    }
    
    public static void testFactorialGivenWrongArgumentThrowsException() {
        //Test case #3: đưa data cà chớn, n âm, hoặc n quá lớn
        //              hàm đước thiết kế ném về ngoại lệ!!!
        //Thấy ngoại lệ mừng rơi nước mắt khi đưa vào -5
        //thấy ngoại lệ xuất hiện như kì vọng -> pased cái test -> màu xanh
        System.out.println("Hope to see the Exception! Iliegal Argument Exception");
        MathUtil.getFactorial(-5);
    }
    
    //hàm này được viết ra để dung thử kĩ thuật viết code kiểu TDD
    //họi thử/dùng thử hàm chính bên cỏe/bên MathUtil
    //xem nó đúng sai ra sao, ở nhgay mức khởi động viết hàm
    public static void tryTDDFirst() {
        //test case #1 (tình hống kiểm thử hàm số 1/xài thử hàm):
        //- Input: n = 1;
        //- Gọi hàm getFactorial(1)
        //- Hy vọng hàm trả về 1, vì 1! = 1
        
        long expected = 1;
        long actual = MathUtil.getFactorial(1);
        //so sánh expected vs. actual coi chừng nó giống nhau hem?
        //giống -> hàm đúng vói case đang test
        //sai -> bug rồi!!! với case đang test
        System.out.println("Test 1! status: " +
                            "Expected: " + expected +
                            " | Actual: " + actual);
        
        //test case #2 (tình hống kiểm thử hàm số 1/xài thử hàm):
        //- Input: n = 2;
        //- Gọi hàm getFactorial(2)
        //- Hy vọng hàm trả về 2, vì 2! = 2        
        //so sánh expected vs. actual coi chừng nó giống nhau hem?
        //giống -> hàm đúng vói case đang test
        //sai -> bug rồi!!! với case đang test
        System.out.println("Test 2! status: " +
                            "Expected: 2"  +
                            " | Actual: " + MathUtil.getFactorial(2));
    }
}


//TEST CASE LÀ GÌ?
//Là 1 tình huống xài app/kiểm thử app/ kiểm thử tính năng/màn hình
//chức năng/xử lí của app
//Test case là tình huống kiểm thử app/chức năng mà khi đó
//ta phải
//- đưa vào data giả/mẫu/test,
//-đưa ra giá trị kì vọng ta mong chờ app trả ra
//sau đó chờ hàm/tính năng xử lí xòn trae ra kết quả!!!
//và ta nhìn kết quả ổn/ tính năng ổn, TEST CASE PASSED
//                                      TEST CASE FAILED
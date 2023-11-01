/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leehoanzu.mathutil.core;

//import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.leehoanzu.mathutil.core.MathUtil.*;

/**
 *
 * @author lehoa
 */

@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    //Chuẩn bị data mảng 2 chiều vì nó có data có n đưa vào
    //và expected [2] và có nhiều cặp như thế [7]
    //mảng 2 chiều [7][2]
    
    @Parameterized.Parameters
    public static Object[][] initData() {
        int a[] = {5, 10, 15, 20, 25};
        int b[][] = {{1, 0},{1, 1},{2, 2},{6, 3},{24, 4},{120, 5},{720, 6}};
        int c[][] = {   {1, 0},
                        {1, 1},
                        {2, 2},
                        {6, 3},
                        {24, 4},
                        {120, 5},
                        {720, 6}
                    };
        return new Integer[][]  {   {1, 0},
                                {1, 1},
                                {2, 2},
                                {6, 3},
                                {24, 4},
                                {120, 5},
                                {720, 6}
                            }; 
    } //xài Wrapper class nếu chơi với số, ví dụ Integer (int) LOng (long)
    
    //sau khi có bộ data qua mảng 2 chiều, JUnit sẽ tự lặp for
    //để lôi ra từng cặp data (1, 0) (1, 1), (2, 2), (6, 3)...
    //nhồi cặp này vào trong hàm so sánh...
    //nhưng nhồi  - cách nào, gắn value này vào biến nào đó
    //gắn vào biến - THAM SỐ HÓA PARAMETERIZED
    //TA SẼ MAP/ ÁNH XẠ 2 CỘT ỨNG VỚI 2 BIẾN: CỘT 0 - EXPECTED
    //                                          CỘT 1 - N ĐƯA VÀO HÀM GETF()
    
    @Parameterized.Parameter(value = 0)
    public long expected;
    
    @Parameterized.Parameter(value = 1)
    public int n;
    
    //test hoy vì đã có các test case và data
    @Test
    public void testfactorialGivenRightArgrumentReturnWell() {
        
        assertEquals(expected, getFactorial(n));
    }
    
}

//CLASS NÀY SẼ CHỨA CODE DÙNG ĐỂ TEST CODE CHÍNH Ở BÊN CLASS MATHUTIL
//CLASS NÀY SẼ CHỨA CODE DÙNG ĐỂ TEST HÀM getF() coi hàm chạy đúng hok
//Code viết ra dùng để test code khác (hàm khác/code khác)
//thì đoạn code này, class này đc gọi tên là : TEST SCRIPT
//Trong test script sẽ có những tình huống xài app, đưa data cụ thể vào
//chờ xem hàm xử lí kết quả có nhiều như kì vọng hay k?
//Một Test Script sẽ chứa nhiều TEST CASES
//                              mỗi test case ứng với 1 tình huống xài hàm

//Phân tích Test Script cũ - hôm qua kia
//Trong test script cũ xuất hiện bad smell, sự trùng lặp câu lệnh
//dưới đây
//Assert.assertEquals(120, MathUtil.getFactorial(5));
//lệnh so sánh giá trị, lệnh gọi hàm đc lặp đi lặp lại với mỗi test case
//Cũng hàm nay, cũng lệnh này, nhưng nó phải viết lại cho các bộ
//data sau:

//Expected          n
//1                 0
//1                 1
//2                 2
//6                 3
//24                4
//120               5
//720               6

//[7][2]

//Có cách nào kiểu thay 2 con số trong lệnh so sánh = 2 ??? nào đó
//Assert.assertEquals(???, Mathutil.getFactorial(???));

//Assert.assertEquals(expected, MathUtil.getFactorial(n));
//Kĩ thuật tách câu lệnh + Data ra hai phần riêng biệt sau đó
//nhồi data trở lại phần hỏi chấm => Viết kiểm thử hướng về việc phân tách data

//Nếu ta tách được toàn bộ dât trong các lệnh câu so sánh ở trên 
//ra 1 chỗ tiêng biệt như hàng cột ở trên, sáu đố
//ta chhir việc pick/lấy/tỉa data này nạp dần vào vái lệnh
//gọi gàm, thì ta sẽ đạt đc:
//- Code gọn gàng hơn k bị trùng lặp
//-Nhìn tổng quan biết có bao nhiêu test case và liệu rằng chúng ta
//đủ hay chưa

//Kĩ thuật viết test script (câu lênh test) mà tách biệt data ra khỏi lệnh so sánh
//đc gọi bằng những tên sau:
//- PARAMETERIZED - THAM SỐ HÓA, BIEN DATA RA 1 CHỔ, ĐẶT CHO NHỮNG CÁI
//TÊN BIẾN, LÁT HỒI NHỒI CHÚNG TRỞ LẠI LỆNH SO SÁNH

//-DDT - DATA DRIVEN TESTING VIẾT CODE KIỂM THỬ THEO STYLE TÁCH DATA
//JUNIT FW HỖ TRỢ SẴN TA VỤ TÁCH DATA, DUYET VÒNG FOR TRÊN DATA
//NHỒI VÀO HÀM TƯƠNG ỨNG

//ĐỂ CHƠI VỚI DDT, TA CẦN:
//-Tách data ra 1 chỗ - MẢNG
//- Map cái data này vào các biến tương ứng
//-Nhồi các biến tuuowng ứng này vào câu lệnh so sánh/gọi hàm

package com.leehoanzu.mathutil.core;

//import junit.framework.Assert; //phiên bản cũ
import org.junit.Assert;
import org.junit.Test;
public class MathUtilTest {
    
    //Ta đi test ngoại lệ, tức là so sánh đo lường xem ngoại lệ
    //có xuất hiện hay không khi ta đua data cà chớn, n < 0 || n > 20
    //thay vì so sánh expected value vs. actual value
    //LÚC NÀY TA SẼ ĐI SO SÁNH/ƯỚC LƯỢNG XEM NGOẠI LỆ CÓ XUẤT HIỆN NHƯ KÌ VỌNG
    //HAY KO, NẾU CÓ XH NHƯ KÌ VỌNG, SURE, HÀM THIẾT KẾ NGON
    //NẾU NGOẠI LỆ XH NHƯ KÌ VỌNG, THÌ MÀU XANH - THẤY MÀU ĐỎ NGOẠI LỆ MỪNG RƠI NC MẮT
    
    //@Test(expected = IllegalArgumentException.class)
    //@Test(expected = NumberFormatException.class) //khi dua vào chu thay vi so
    @Test(expected = Exception.class)
    //class là đo lường 1 object thuộc nhóm nào
    public void testFactorialGivenWrongArgumentThrowsException() {
        //Test case #3: đưa data cà chớn, n âm, hoặc n quá lớn
        //              hàm đước thiết kế ném về ngoại lệ!!!
        //Thấy ngoại lệ mừng rơi nước mắt khi đưa vào -5
        //thấy ngoại lệ xuất hiện như kì vọng -> pased cái test -> màu xanh
        System.out.println("Hope to see the Exception! Iliegal Argument Exception");
        MathUtil.getFactorial(-5);      
    }
    
    
    @Test
    public void testFactoriaGivenRightArgumentReturnsWell2() {
               
        //Test case #4: n = 3, hy vọng hàm trả về 6, thực tế ???
        Assert.assertEquals(6, MathUtil.getFactorial(3));
        
        //Test case #5: n = 4, hy vọng hàm trả về 24, thực tế ???
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        
        //Test case #6: n = 5, hy vọng hàm trả về 120, thực tế ???
        Assert.assertEquals(120, MathUtil.getFactorial(5));
        
    }
    
    
    
    @Test //coding convention - quy tắc viết code
            //tên hàm kiểm thử/tên hàm của test script
            //phải nói lên ý nghĩa của việc kiểm thử
            //tình huống này, ta mún test hàm getF() tham số tử tế
            //n = 0..20!!!
    public void testFactoriaGivenRightArgumentReturnsWell() {
        
        //Test case số #1: n = 1, hy vọng trả về 1
        //                          thưc tế hàm trả về mAY, đoán xem!!!
        long expected = 1;
        long actual = MathUtil.getFactorial(0);//hàm chạy đi thì mới biết
        //so sánh giữa expected vs. actual, máy tự so, k cần
        //sout() khổ cực
        Assert.assertEquals(expected, actual);
        
        //Test case #2: n = 1, hy vọng hàm trả về 1, thực tế ???
        Assert.assertEquals(1, MathUtil.getFactorial(1));
        
        //Test case #3: n = 2, hy vọng hàm trả về 1, thực tế ???
        Assert.assertEquals(2, MathUtil.getFactorial(2));
        
    }
    
    
    //@Test ra lệnh cho JUnit mình đã add/import
    //Từ động generate ra cái hàm public static void main()
    //biesn hàm tryJUnitComarrison() thành hàm main()
    //Và gửi main() này cho JVM chạy - java vitual Machine
    //@Test ~~~ main(), 
    //ko @Test thì class k có main(), lấy gì mà chạy cho runabel method
    
    
    @Test
    public void tryJUnitComparison() {
        //hàm này thử nghiệm việc so sánh expected vs actual
        //coi sai đúng ra màu thế nào!!
        //ta đàng xài hàm của thư viện JUnit nhưng k xài bừa
        //bãi mà phải viết theo quy định trước
        //quy tắc định trước nằm ở @ ~ annotation
        Assert.assertEquals(69, 69);
    }
    
}

//CLASS NÀY DEV SẼ VIẾT NHỮNG CÂU LỆNH DÙNG ĐỂ TEST HÀM
//CỦA CODE CHÍNH, TEST CÁC HÀM CUA CLASS MATHUTIL
//Trong class này sẽ có những lời gọi hàm getFactorial()
//có những lệnh so sánh giữa EXPECTED và ACTUAL
//giống giống mình đã làm test ở bên main()
//nhưng khác ở chổ, SAI -> MÀU ĐỔ, ĐÚNG -> MÀU XANH
//mắt ta không cần nhìn các dòng output từ hàm System.out cho mất sức
//mắt giờ chỉ nhìn 2 màu XANH ĐỎ
//Muốn có đc điều này ta sẽ đùng thêm các UNIT TESTING FRAMWORK
//VÍ dụ: JUnit, testNG (Java)
//      xUnit, MSTest, NUit (C#)
//      phpUnit (PHP)

//VIỆC VIẾT CODE ĐỂ TEST CODE GỌI LÀ UNIT TESTING
//ĐOẠN CODE TRONG CLASS NÀY DÙNG JUNIT/UNIT TESTING FRAMEWORK
//ĐỂ KIỂM THỬ HÀM CỦA CODE CHÍNH
//ĐOẠN CODE KIỂM THỬ NÀY ĐƯỢC GỌI LÀ: TEST SCRIPT
//Code dùng để test code (chính) gọi là test script
//Test Script là các đoạn code đc viết ra để test code chính (DAO
//DTO, Controller, API...)
//Muốn test thì phải phác thảo các TEST CASE
//Test Script sẽ sử dụng các Test Case
//Ví dụ: Viết code để test hàm getFactorial() với các case
//n = -5, 0 , 1, ...

//QUY TẮC XANH ĐỎ:
//* MÀU XANH: KHI TẤT CẢ CÁC TEST CASE PHẢI LÀ XANH, 
//tức là expected == actual
//cho tất cả các tình huống test

//* MÀU ĐỎ: CHỈ CẦN 1 TRONG NHỮNG TEST CASE, 
//CHỈ CẦN 1 CÁI EXPECTED != ACTUAL, KẾT LUẬN MẠNH TAY/GẮT: HÀM SAI QUÁ SAI

//Ý nghĩa của quy tắc: nếu đã liệt kê, nếu đã liệt kê các test case, thì chúng 
//phải đúng hết, chỉ cần 1 thằng sai, hàm k ổn định về việc return -> hàm sai
//ĐÚNG ĐÚNG HẾT, SAI CHỈ CẦN 1 THẰNG

//EXPECTED == ACTUAL -> CASE ĐÚNG, TEST CASE PASSED
//EXPECTED != ACTUAL -> CASE FAILED
    //NẾU EXPECTED LÀ CHÍNH XÁC, HÀM ĐÃ XỬ LÍ SAI, BUG
    //CŨNG CÓ KHI EXPECTED, CÁI TA KÌ VỌNG BỊ SAI!!! LỖI DÂN QC TÍNH TOÁN
    //BẰNG TAY BỊ SAU!!!
    

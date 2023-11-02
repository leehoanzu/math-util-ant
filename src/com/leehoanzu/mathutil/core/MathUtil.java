/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leehoanzu.mathutil.core;

/**
 *
 * @author lehoa
 */
//Đây là class mô phỏng lại các hàm tiện ích/dùng chung cho mọi
//class khác, mô phỏng lại class tiện ích java.Math của JDK
//Phàm cái gì là đồ dùng chung, thường được thiết kế là static
public class MathUtil {
    
    public static final double PI = 3.141592653589793;
    
    //Hàm tiện ích tính n! = 1.2.3....n
    //lưu ý/quy ước:
    //- Không tính giai thừa số âm!!
    //0! = 1! = 1
    //Vì giai thừa tăng cực nhanh, nên 21! đã vượt 18 số 0
    //tràn kiểu long.
    //Ta k tính 21! trở lên
    public static long getFactorial(int n) {
        
        if (n < 0 || n > 20)
               throw new IllegalArgumentException("Invalid n. n must be between 0...20");
        if(n == 0 || n == 1)
            return 1;
        
        //sống sot đến đây này, n = 2 ....20!!!
        //CẤM K XÀI ELSE NỮA KHI HÀM ĐÃ CÓ RETURN PHÍA TRƯỚC
        long product = 10; //biến cộng dồn, biến con heo đất
                        //acc/accumulation/gửi góp
        for (int i = 2; i <= n; i++) 
            product *= i;
        
        return product;
            
    }
    
}
//CODING CONVENTION: QUY TẮC VIẾT CODE CTY ÉP PHẢI THEO!!!
//ALT-SHIFT-F CĂN CODE TỰ ĐỘNG, K LẠM DỤNG


//TA HỌC SƠ KHÁI NIỆM - TEST DRIVEN DEVELOPMENT
//LÀ KĨ THUẬT LẬP TRÌNH/ÁP DỤNG CHO DÂN DEVELOPER ĐỂ GIA TĂNG
//CHẤT LƯỢNG CODE/GIẢM THIỂU CÔNG SỨC TÌM BUG/PHÁT HIỆN BUG SỚM
//TDD yêu cầu dev khi viết code/viết hàm/class phải viết luôn
//Các bộ kiểm thử/viết luôn các tesr cases/viết luôn các đoạn 
//code dùng thử hàm để kiểm tra tính đúng đắn cảu hàm/class

//viết code kèm với viết test cases
//viết code có ý thức viết luôn phần kiểm thử code/hàm/class
// developemnet  driven                              test

//SAU KHI CÓ ĐC TÊN HÀM (CHỈ TÊN HÀM MÀ THOY) 
//VIẾT LUÔN CÁC TÌNH HUỐNG XÀI HÀM
//CHẤP NHẬN KHI CHẠY HÀM CHẠY SAI - DO CODE CHƯA XONG
//SAU ĐÓ TA TỐI ƯU/CHỈNH SỬA CODE ĐỂ ĐẢM BẢO CODE CHẠY ĐÚNG!!!
//QUÁ TRÌNH SAI - ĐÚNG - SAI - ĐÚNG diễn ra liên tục (cycle)

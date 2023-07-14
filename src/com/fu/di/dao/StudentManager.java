/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fu.di.dao;

import com.fu.di.dto.Student;
import com.fu.di.util.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WBPC.VN
 */
public class StudentManager {
    private List<Student> studList = new ArrayList();
    
    //giả bộ có danh sách SV từ DB, làm constructor,set(đưa vào)
    //floating block of code
    {
        studList.add(new Student("SE999999", "Chin Nguyen", 1999, 9.0, "SE"));
        studList.add(new Student("SE888888", "Tam Le", 1998, 8.0, "SE"));
        studList.add(new Student("SE444444", "Bon Pham", 2004, 4.0, "SE"));
        studList.add(new Student("IA555555", "Nam Ly", 2005, 5.0, "IA"));
        studList.add(new Student("IA333333", "Ba Mai", 2003, 3.0, "IA"));
        studList.add(new Student("GD777777", "Bay Vo", 1997, 7.0, "GD"));
        studList.add(new Student("GD666666", "Luc Tran", 2006,6.0, "GD"));
        studList.add(new Student("SS222222", "Hai Vu ", 2002, 2.0, "IB"));
    }
    
    //Hàm query data , filter data theo tiêu chuẩn ràng.condition nào đó
    //1. Show tất cả data
    
    public List<Student> getAll() {
        return studList;
    }
    
    //2. in ra/Trả về danh sách sinh viên ngành SE  === SQL : where major = 'SE'
    public List<Student> getSEStudents() {
        List<Student> result = new ArrayList();
        
        for (int i = 0; i < studList.size(); i++) {
            if(studList.get(i).getMajor().equalsIgnoreCase("SE")){
                result.add(studList.get(i));
            }
        }
        return result;
    }
    
    
    //3.In ra/trả về danh sách sinh viên ngành SE,điểm trung bình lớn hơn bằng 5
      public List<Student> getSEStudentsGt5() {
        List<Student> result = new ArrayList();
        
        for (int i = 0; i < studList.size(); i++) {
           Student x = studList.get(i);
           if(x.getMajor().equalsIgnoreCase("SE") && x.getGpa() >= 5){
               result.add(x);
           }
        }
        return result;
    }
    
  


//Bình luận khi viết các hàm ứng với các câu query
//1.Dễ viết, cần query thế nào thì thêm các hàm tương ứng, với filter/đẹp
//tương ứng gài trong hàm
//2.Nhược điểm : nhiều hàm , quá nhiều hàm, và tương lai còn thêm nữa
//theo nhu cầu thông kê

//2.1: Thiết kê tốt hơn chút, ít hàm hơn đc ko?? mà vẫn nhiều filter 
//     gộp nhiều filter trong 1 hàm  

//========  Ưu : dễ viết như cách 1,gom toàn bộ các hàm vào 1 hàm
//          Nhược : vẫn ko dự đoán hết đc các cases, các trường hợp muốn 
//          filter là vô chừng, theo cách người xài hàm này người ta muốn
//          
//3. Lật ngược vấn đề : TẠI SAO MÌNH/HÀM NÀY PHẢI DỰ ĐOÁN HẾT NHU CẦU FILTER CỦA NGƯỜI TA???
//NHU CẦU FILTER CỦA NGƯỜI TA??? - VÔ CHỪNG FILTER
// TAO - MANAGER CÓ DATA, NHƯNG KO CÓ FILTER
//MÀY- NGƯỜI XÀI HÀM , MÀY CÓ FILER - VÔ CHỪNG
//MÀY MUỐN J, CỤ THỂ LÀ J, MÀY CỨ CHUẨN BỊ LUÔN, ĐƯA VÀO CHO
//TAO, TAO CĂN THEO CÁI MÀY MUỐN, LẤY RA STUDENT TƯƠNG ỨNG THEO
//TIÊU CHÍ CỦA MÀY...
//MÀY MUỐN IF THẾ NÀO,MÀY LÀM LUÔN ĐI, TAO KO DỰ ĐOÁN NỮA
//BẠN ĐƯA CÁI BẠN MUỐN VÀO TRONG MANAGER CỦA TỚ, TỚ LÔI TỪNG 
//SV XÉT THEO TIÊU CHÍ CỦA BẠN, TỚ RETURN 
      
      
 //HIỆN NAY: TỚ DỰ ĐOÁN LUÔN TIÊU CHÍ CỦA BẠN, TỰ KIỂM TRA IF CÓ THỎA 
 //KO, TỚ BỊ RƯỢT, LÂU LÂU BỔ SUNG THÊM HÀM THEO NHIỀU NHU CẦU KHÁC NHAU
      
 //IF PHẢI NẰM Ở ĐẦU VÀO CỦA HÀM
 // TUI CHỈ GỌI IF ĐỂ BIẾT RẰNG SV CỦA TA THỎA IF ĐƯA VÀO KO, THỎA TRẢ
 //KO ĐI TIẾP SV KHÁC
 //CHỐT HẠ: IF ĐƯA TỪ BÊN NGOÀI VÀO, KO PHẢI LÀ INT ĐƯA VÀO ĐỂ TA TỰ LO
 //IF ĐƯA BÊN NGOÀI VÀO,CODE ĐƯA BÊN NGOÀI VÀO
 //BÊN NGOÀI ĐƯA TIÊU CHÍ XÉT DUYỆT VÀO BÊN TRONG, TA , HÀM TA THEO
 //TIÊU CHÍ BÊN NGOÀI ĐƯA VÀO???
      
      
 //HÀM EM CHUẨN BỊ DATA VÀ XÉT DUYỆT THEO BÊN NGOÀI
 //ĐƯA IF BÊN NGOÀI VÀO?? LÀM SAO???, ĐƯA OBJECT, ĐƯA ĐỐI TƯỢNG VÀO
 //SỜ IF QUA CHẤM CỦA ĐỐI TƯỢNG

 //quy ước:
 //1.Lấy tất cả sinh viên ; 2: Lấy sinh viên nghành SE 
 //3. Lấy sinh viên SE >= 5; 4: Lấy sinh viên SE cao nhất.....
 
 //FilterType chính là cái flag để hàm biết phải làm gì
 //trong code sure switch-case với các tình huống filter
 // 1, 2, 3,4 ,5,.... ko đẹp, thay bằng ENUM (DROP - DOWN LIST, COMBO-BOX)
 
    public List<Student> getStudents(int filterType) {
        List<Student> result = new ArrayList();
        
        switch(filterType){
            case 1:
                result = studList;// Lấy hết sinh viên 
                break;
            case 2:
                for (Student x : studList) {
                    if(x.getMajor().equalsIgnoreCase("SE")){
                        result.add(x);
                    }
                }
                break;
            case 3:
                for (Student x : studList) {
                    if(x.getMajor().equalsIgnoreCase("IA")){
                        result.add(x);
                    }
                }
                break;
            default:
                System.out.println("Please choose the filter type from");
        }
        return result;
  }

//Chính thức vào DI
//public List<Student> getStudents() {
    //object chính nó phải có lệnh if, đẩy if hàm mình thành if bên ngoài đưa vào
    //đấy gọi gọi dependency đã đc chích vào/inject
    //mày đưa cái cách mày nhìn dữ liệu vào cho tao,tao xử lí theo cách 
    //của mày, gọi if của mày, hàm cảu mày, hàm trong obj đưa vào
    //if viết chỗ khác, viết ở object khác, class khác
    //tức là chơi với DI, mình phải tạo ít nhất 1 class khác chứa  
    //if chứa dependency, ràng buộc, filter,bộ lọc,cách bạk
    //muốn xử lí infor
    //class ??? này viết như thế nào? if để trong hàm nào, nhiều if thì sao
    //if trong bao nhiêu hàm thì đủ ???????
    //ko thể mỗi if một hàm, nếu thế thì hàm getStudents() lại phải
    //tùy từng query type, mà phải chọn if tương ứng -> lặp lại
    //đúng vấn đề
    //CHỐT HẠ: OBJECT ĐƯA VÀO CHỈ MỘT HÀM IF

    //for(với mỗi sv x tìm thấy trong danh sách đang có)
      //  if obj.check(x) là đúng tiêu chuẩn thì
        //    add x vào WishList
        //ko đúng tiêu chuẩn, move next

    //check() là hàm có if, đúng, nhưng bao nhiêu if trong check()
    //hóa ra bao nhiêu if ta lại viết trong check(), vớ vẩn tập 2
    //check() ko có code , ai muốn viết thế nào thì viết như thế theo
    //nhu cầu riêng, check() ko viết if luôn
    //lúc nào ai đó thực sự muốn filter, viết if cho check() ko muốn 
    //lúc đó viết code cho check() implement một abstract method 
    //mùi của Interface/Abstract class xuất hiện
    //hóa ra thay vì em phụ thuộc vào 1 cái j cụ thể - có code
    //ta phụ thuộc vào 1 cái chung chung, ko chi tiết, abstract , interface 
    //LOOSE COUPLING hay HIGH COHENSION LOW COUPLING   SOLID 
    

//  }
//tui cần lắm bạn đưa cho tui hàm if qua cái object tên là condition
//cond.check() sẽ trả về đúng sai, if() trong check sẽ trả về đúng sai
//tui đưa từng sv cho bạn check()
//lúc nào xài hàm của tui, độ ra cái check() có if bên trong đi
//lỏng lẻo , tao để mày làm if loose coupling - low coupling
//vẫn cần mày, vì tao có data, giúp mày theo cách mày muốn 
//dependency , đưa vào hàm qua tham số Injection
public List<Student> getStudents(Filter<Student> cond ) {
       List<Student> result = new ArrayList();
       for (Student x : studList) {
           if(cond.check(x) == true){      //đúng là sv mày cần theo
                  result.add(x);                         //cái check, cái if của mày hay ko
                                           //đúng thì báo tao
           }
               
           }
       return result; //đúng cho n loại if chấp, ko cần dự đoán
                      //select * from Student WHERE ??? check() tự viết
    }
       

}

 //4.In ra/trả về danh sách sinh viên ngành SE,điểm trung bình bé hơn bằng 5
    //5.In ra/trả về danh sách sinh viên ngành SE,có điểm cao nhất
    //6.In ra/trả về danh sách sinh viên ngành SE, có điểm trung bình lớn hơn bằng 8
    //7.In ra/trả về danh sách sinh viên  điểm trung bình cao nhất (Thủ khoa của trường)
    //8.In ra/trả về danh sách sinh viên ngành SE,điểm trung bình lớn hơn bằng 5
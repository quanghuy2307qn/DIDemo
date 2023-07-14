/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package didemo;

import com.fu.di.dao.FilterBySE;
import com.fu.di.dao.StudentManager;
import com.fu.di.dto.Student;
import com.fu.di.util.Filter;
import java.util.List;

/**
 *
 * @author WBPC.VN
 */
public class DIDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //saveAStudent();
        testStudentManager();
        testStudentManagerUsingSimpleFilter();
        testGetStudentsBySE();
        testGetStudentBySEGt5UsingAnonymous();
    }
    //cách tạo class FilterSE rời rạc, làm riêng đủ hay, nhưng hơi tốn kém
    //tạo class dùng ko nhiều lần, vậy lược bớt thao tác tạo class
    //mục đích cuối cùng: cần code if của hàm check()
    //vì chỉ cần object.check() là đủ
    //2 giải pháp : Anonymous class,class ngầm hiểu, ko cần tên j cả
    //              mượn gió bẻ măng, mượn Interface new luôn
    //              bung rộng gõ code @Override
    
    public static void testGetStudentBySELt5UsingAnonymous() {
        StudentManager sm = new StudentManager();
        //Lambda xuất hiện, rút gọn tên hàm, tên class
        //                      anonymous method name
        //          `           hàm vô danh của class vô danh thuộc về Interface
                                        
        //Filter<Student> se = new .....  //có code cho hàm check()
        //Filter<Student> se = x -> {return x.getMajor().equalsIgnoreCase("SE")  &&  
        //                   x.getGpa() < 5;};
        
        //Filter<Student> se = x -> {if (return x.getMajor().equalsIgnoreCase("SE")  &&  
        //                   x.getGpa() < 5)
        //                          return true;
        //                              return false;};
        
        //Filter<Student> se = x ->  x.getMajor().equalsIgnoreCase("SE")  &&  
        //                  x.getGpa() < 5;
        
                                                 
        //Hàm trong hàm 
        //Đây là biểu thức Lambda chuẩn
        List<Student> list = sm.getStudents(x ->  x.getMajor().equalsIgnoreCase("SE")  &&  
                                             x.getGpa() < 5);
        for (Student x : list) {
            x.showProfile();
        }
    }
    //FUNCTIIONAL PROGRAMMING - HÀM LÀ THAM SỐ
    //lược bỏ luôn tên class, tên hàm, chỉ cần focus vào 
    //code trong hàm là đủ, câu if là đủ
    //hàm getStudents(chỉ cần đưa vào hàm là đủ)
    //                Filter<Student> cond
    //                                ko cần tạo object, có tạo xong
    //                                tao chỉ .check();
    //                                               tao cần if
    //                  rút gọn tối đa phần dư, focus hàm xử lí
    //                  giống biểu thức,công thức, LAMBDA Expression
    //Collections.sort(list, việc so sánh 2 object)
    //                      DI,hàm compare(obj1,obj2) hoy
    //                          Comparator Functional Interface
   
    
    public static void testGetStudentBySEGt5UsingAnonymous() {
           StudentManager sm = new StudentManager();
           Filter<Student> seFilter = new Filter<Student>() {
               @Override
               public boolean check(Student x) {
                   if(x.getGpa() >= 5 && x.getMajor().equalsIgnoreCase("SE")){
                       return true;
                   }
                            return false;
               }
           };
        System.out.println("The list of SE students with GPA >=5 ");
        List<Student> list = sm.getStudents(seFilter);
        for (Student x : list) {
            x.showProfile();
        }
    }
    public static void testGetStudentsBySE() {
        StudentManager sm = new StudentManager();
        FilterBySE seFilter = new FilterBySE();
       // seFilter.check(x); //Có code rồi đó
        //Chích sự phụ thuộc vào nè
        //sm.getStudents(seFilter);
        
        System.out.println("The list of SE students");
        List<Student> list = sm.getStudents(seFilter);
        for (Student x : list) {
            x.showProfile();
        }
    }
    public static void testStudentManager() {
        StudentManager sm = new StudentManager();
        System.out.println("The list of available students");
        for(Student x : sm.getAll()){
            x.showProfile();
        }
        
        System.out.println("The list of SE students (3)");
        for (Student x : sm.getSEStudents()) {
            x.showProfile();
            
        }
        
        System.out.println("The list of SE students gpa >=5 (2)");
        for (Student x : sm.getSEStudentsGt5()) {
            x.showProfile();
        }
    }
    
    public static void testStudentManagerUsingSimpleFilter() {
        StudentManager sm = new StudentManager();
        System.out.println("The list of available students");
        for(Student x : sm.getStudents(1)){
            x.showProfile();
        }
        System.out.println("The list of available students (3)");
        for(Student x : sm.getStudents(2)){
            x.showProfile();
        }
        System.out.println("The list of available students (2)");
        for(Student x : sm.getStudents(3)){
            x.showProfile();
        }
        
    }
    public static void saveAStudent() {
        Student x = new Student("SE123456", "Loc Phat", 2000, 6.8, "SE");
        x.showProfile();
    }
}

//SELECT *  FROM STUDENT WHERE ???
//                            RÀNG BUỘC TRÊN DỮ LIỄU 
//                            PHỤ THUỘC TRÊN TẬP DỮ LIỄU
//                            dependency/filter/condition/
//                            tui muốn đưa cho câu lệnh select 1 ràng buộc
//                            chỉ lấy ra sv nghành SE
//                            bạn đưa ràng buộc tớ trả về kết quả
//                              inject một cái dependency/loại filter
//CHỈ 1 LỆNH , TƯƠNG THÍCH N THỨ AI ĐÓ MUỐN
//LỎNG LẺO, MỞ VỚI TẤT CẢ , NHƯNG CẦN HỌ, PHỤ THUỘC MÀ LỎNG
//LOOSE COUPLING  
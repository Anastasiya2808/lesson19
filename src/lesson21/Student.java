package lesson21;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Exam> examList = new ArrayList<>();

    public void addExam (Exam exam){
        examList.add(exam);
    }

    public Student (String name){
        this.name = name;
    }

    public void printExamInfo (){
        examList.forEach(System.out::println);
    }
    //...

    // вложенный класс (static)
    // 1. внешний класс не может быть static
    // 2. область видимости - согласно модификатору
    // 3. можно создать экземпляр без экземпляра
    // внешнего класса
    // 4. нет доступа к нестатическим свойствам и методам
    // внешнего класса
    public static class Exam{
        private String title;

        public Exam(String title) {
            this.title = title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}

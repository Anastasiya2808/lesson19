package lesson21;

public class Application {

    public static void main(String[] args) {
        User user = new User(User.Level.LOW, "qwe");
        // екземпляр внутреннего класса
        User.Account account = user.new Account(20);
        System.out.println(account.getUser());

        User.Account account2 = new User(User.Level.HIGH, "asd")
                .new Account(200);
        System.out.println(account2.getUser());

        // создание экземпляра вложенного класса
        Student.Exam math = new Student.Exam("math");

        Student student1 = new Student("Tom");
        student1.addExam(math);


        // анонимные классы
        SomeInterface object = new SomeInterface() {
            @Override
            public void void1() { System.out.println("void1");}
            @Override
            public void void2() { System.out.println("void2");}
            @Override
            public void void3() { System.out.println("void3");}
        };
        System.out.println(object);
        object.void1();
        object.void2();
        object.void3();
    }
}

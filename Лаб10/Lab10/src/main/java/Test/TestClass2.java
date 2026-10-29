package Test;

public class TestClass2 extends TestClass {
    public TestClass2() {}


    @Override
    public void test4() { System.out.println("Тест текст класса 2.1"); }

    public void test5(double a) { System.out.println("Тест текст класса 2.2"); }
    public void test5(double a, double b) { System.out.println("Тест текст класса 2.3"); }
}
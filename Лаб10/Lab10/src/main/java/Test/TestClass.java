package Test;

public class TestClass implements TestInterface {
    public TestClass() {}


    @Override
    public void test1() { System.out.println("123"); }

    @Override
    public void test4() { System.out.println("Тест текст класса 1."); }
}
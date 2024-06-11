public class MySimpleArrayListDemo {
    public static void main(String[] args) {
        MySimpleArrayList<String> m = new MySimpleArrayList<>();
        m.add("Anton");
        m.add("Anton1");
        m.add("Anton2");
        m.add("Anton3");
        System.out.println(m);

        MySimpleArrayList<Long> m2 = new MySimpleArrayList<>();
        m2.add(123L);
        m2.add(4444L);
        m2.add(34523423L);
        m2.add(3452345L);
        System.out.println(m2);
    }
}

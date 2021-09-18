public class jopa {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Test string");
        str.setCharAt(1, 'X');
        str.toString();
        System.out.println(str);
    }
}

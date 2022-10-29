package Connection;

public class main {
    public static void main(String[] args) {
        api_nyt api = new api_nyt();
        System.out.println(api.get());
    }
}

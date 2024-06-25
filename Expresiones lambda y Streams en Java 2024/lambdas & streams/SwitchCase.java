public class SwitchCase {
    public static void main(String[] args) {
        var result = switch ("UNO") {
            case "UNO" -> 1;
            case "DOS" -> 2;
            case "TRES" -> 3;
            default -> 0;
        };
        System.out.println(result);
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // region Strings
        List<String> people = Arrays.asList("Tudor", "Ana", "Petra", "Larisa", "Liviu", "Alexandra", "Ionut");

        // 1. print list
        printList(people);

        // 2. print length of each word
        printList(getLengths(people));

        // 3. create a list of each name together with its length (Tudor 5, Ana 3 etc.)
        printList(getNamesAndLengths(people));

        // 4. replace all occurences of letter 'a' with '*'
        printList(getListAfterReplace(people));

        // 5. modify the names so that all the letters are uppercase
        printList(getUppercaseNames(people));

        // 6. names whose lengths are less than 6
        printList(getNamesLessThan5(people));

        // 7. print first 2 names that have odd length & end with 'a'
        printFirst2(people);

        // endregion

        // region Integers
        List<Integer> numbers = Arrays.asList(1, 123, 111, 43, 121, 1, 456, 1233, 76, 43, 32);

        // 8. sort the list in descending order and remove duplicates
        printList(getDescendingOrder(numbers));

        // 9. maximum number
        System.out.println((getMax(numbers)));

        // 10. get the sum of the numbers
        System.out.println(getSum(numbers));

        // 11. count the even numbers
        System.out.println(getNoOfEvenNumbers(numbers));

        // endregion

        // region Messages

        try (Stream<String> content = Files.lines(Paths.get("/Users/alexandramaci/Desktop/streams/LearnJavaStreams/src/messages.txt"))) {
            // 12. generate list of messages
            List<Message> messages = content
                    .map(
                        (String message) -> {
                            String[] m = message.split(":");
                            return new Message(m[0], m[1], m[2]);
                        })
                    .collect(Collectors.toList());

            System.out.println("Messages : ");
            printList(messages);
            System.out.println();
            System.out.println();

            // 13. petra sends messages to...

            // 14. questions

            // 15. questions sent by ana to petra

        } catch (IOException e) {
            e.printStackTrace();
        }

        // endregion
    }

    public static void printList(List<?> list) {

    }

    // region Strings
    public static List<Integer> getLengths(List<String> list) {
        return new ArrayList<>();
    }

    public static List<String> getNamesAndLengths(List<String> list) {
        return list;
    }

    private static List<String> getListAfterReplace(List<String> people) {
        return people;
    }

    private static List<String> getUppercaseNames(List<String> people) {
        return people;
    }

    private static List<String> getNamesLessThan5(List<String> people) {
        return people;
    }

    private static void printFirst2(List<String> people) {

    }


    // endregion

    // region Integers
    private static List<?> getDescendingOrder(List<Integer> numbers) {
        return numbers;
    }

    private static int getMax(List<Integer> numbers) {
        return 0;
    }

    private static int getSum(List<Integer> numbers) {
        return 0;
    }

    private static long getNoOfEvenNumbers(List<Integer> numbers) {
        return 0;
    }

    // endregion

}

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
        //printList(people);

        // 2. print length of each word
        //printList(getLengths(people));

        // 3. create a list of each name together with its length (Tudor 5, Ana 3 etc.)
        //printList(getNamesAndLengths(people));

        // 4. replace all occurrences of letter 'a' with '*'
        //printList(getListAfterReplace(people));

        // 5. modify the names so that all the letters are uppercase
        //printList(getUppercaseNames(people));

        // 6. names whose lengths are less than 6
        //printList(getNamesLessThan5(people));

        // 7. print first 2 names that have odd length & end with 'a'
        //printFirst2(people);

        // endregion

        // region Integers
        List<Integer> numbers = Arrays.asList(1, 123, 111, 43, 121, 1, 456, 1233, 76, 43, 32);

        // 8. sort the list in descending order and remove duplicates
        //printList(getDescendingOrder(numbers));

        // 9. maximum number
        //System.out.println((getMax(numbers)));

        // 10. get the sum of the numbers
        //System.out.println(getSum(numbers));

        // 11. count the even numbers
        //System.out.println(getNoOfEvenNumbers(numbers));

        // endregion

        // region Messages

        try (Stream<String> content = Files.lines(Paths.get("/Users/alexandramaci/Desktop/streams/LearnJavaStreams/src/messages.txt"))) {
            // 12. generate list of messages
            List<Message> messages = content
                    .map(
                        (String line) -> {
                            String[] m = line.split(":");
                            return new Message(m[0], m[1], m[2]);
                        })
                    .collect(Collectors.toList());

            //System.out.println("Messages : ");
            //printList(messages);
            System.out.println();
            System.out.println();

            // 13. petra sends messages to...
            messages.stream()
                    .filter(m -> m.getSender().equals("petra"))
                    .map(Message::getReceiver)
                    .distinct()
                    .count();

            // 14. questions
//            messages.stream()
//                    .filter(m -> m.getMessage().contains("?"))
//                    .forEach(System.out::println);

            // 15. questions sent by ana to petra
//            messages.stream()
//                    .filter(m -> m.getMessage().contains("?") && m.getSender().equals("ana") && m.getReceiver().equals("petra"))
//                    .forEach(System.out::println);

            // 16. messages received by liviu that are not questions
//            messages.stream()
//                    .filter(m -> m.getReceiver().equals("liviu") && !m.getMessage().contains("?"))
//                    .forEach(System.out::println);

            // 17. number of messages sent by each person
            messages.stream()
                    .map(m -> m.getSender() + " " + m.messageCount(messages,m.getSender()))
                    .distinct()
                    .forEach(System.out::println);
//            System.out.println(messageCount(messages, "petra"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // endregion
    }

    public static void printList(List<?> list) {
        list.stream().forEach(System.out::println);
    }

    // region Strings
    public static List<Integer> getLengths(List<String> list) {
        return list.stream().map(x -> x.length()).sorted().collect(Collectors.toList());
    }

    public static List<String> getNamesAndLengths(List<String> list) {
        return list.stream().map(x->x + " " + x.length()).collect(Collectors.toList());
    }

    private static List<String> getListAfterReplace(List<String> people) {
        return people.stream()
                .map(x -> x.replace("a","*"))
                .collect(Collectors.toList());
    }

    private static List<String> getUppercaseNames(List<String> people) {
        return people.stream()
                .map(x-> x.toUpperCase())
                .collect(Collectors.toList());
    }

    private static List<String> getNamesLessThan5(List<String> people) {
        return people.stream()
                .filter(x -> x.length() <6 )
                .collect(Collectors.toList());
    }

    private static void printFirst2(List<String> people) {
        people.stream().filter(x -> x.endsWith("a") && x.length() % 2 !=0 )
                .limit(2)
                .forEach(System.out::println);
    }


    // endregion

    // region Integers
    private static List<?> getDescendingOrder(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();
    }

    private static int getSum(List<Integer> numbers) {
        return numbers.stream().reduce((x,y)->x+y).get();
    }

    private static long getNoOfEvenNumbers(List<Integer> numbers) {
        return 0;//return numbers.stream().reduce(x -> x % 2).get();
    }


//    public static long messageCount (List<Message> msg , String user) {
//        return msg.stream()
//                .filter(m -> m.getSender().equals(user))
//                .count();
//    }

    // endregion

}

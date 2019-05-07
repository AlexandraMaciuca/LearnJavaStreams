import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> people = Arrays.asList("Tudor", "Ana", "Petra", "Larisa", "Liviu");

        // print list
        //printList(people);

        // print length of each word
        //printList(getLengths(people));

        // create a list of each name together with its length (Tudor 5, Ana 3 etc.)
        //printList(getNamesAndLengths(people));

        // replace all occurences of letter 'a' with '*'
        //printList(getListAfterReplace(people));

        // modify the names so that all the letters are uppercase
        printList(getUppercaseNames(people));
    }

    public static void printList(List<?> list){
        list.stream()
                .forEach(System.out::println);
    }

    public static List<Integer> getLengths(List<String> list){
        return list.stream()
                .map((String x) -> x.length())
                .collect(Collectors.toList());
        //return list.stream().map(String::length).collect(Collectors.toList());
    }

    public static List<String> getNamesAndLengths(List<String> list){
        return list.stream().map((String x)-> x + " " + x.length()).collect(Collectors.toList());
    }

    private static List<String> getListAfterReplace(List<String> people) {
        return people.stream().map(s->s.replace('a','*')).collect(Collectors.toList());
    }

    private static List<String> getUppercaseNames(List<String> people){
        return people.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}

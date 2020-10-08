package hackerrank.bgumguminterview;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result3 {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY operations
     *  2. INTEGER_ARRAY x
     */

    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        Stack<Long> stack = new Stack();
        int i = 0;

        if (operations == null || x == null || operations.isEmpty() || x.isEmpty() || x.size()>100000 || operations.size()>100000) {
            return new LinkedList<>(stack);
        }
        long max = x.get(0);
        long min = x.get(0);
        for (Integer current : x) {
            String operation;
            try {
                operation = operations.get(i);
            } catch (Exception e) {
                break;
            }
            if (current < min) {
                min = current;
            }
            if (current >= max) {
                max = current;
            }
            if ("push".equalsIgnoreCase(operation))
                stack.push(max * min);
            else if ("pop".equalsIgnoreCase(operation))
                stack.pop();
            i++;
        }
        return new LinkedList<>(stack);
    }

}

public class GumGum3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int operationsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> operations = IntStream.range(0, operationsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int xCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> x = IntStream.range(0, xCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Long> result = Result3.maxMin(operations, x);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

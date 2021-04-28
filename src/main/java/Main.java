import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /* 1. Создать пустой поток с двумя любыми промежуточными операциями
         и одной терминальной-которая напечатает результат коллекции; */
        Stream firstStream = Stream.empty();
        firstStream.distinct()
                .limit(0)
                .forEach(val -> System.out.println(val));

        /* 2. Создать поток с Листом данных(на Ваше усмотрения),
         который будет иметь две промежуточные операции и результатом выполнения получить Набор данных;*/
        List<Integer> nums = Arrays.asList(1, 2, 3);
        Stream<Integer> secondStream = (Stream<Integer>) nums.stream();
        List secondStreamResult = secondStream.distinct()
                .map(val -> val + 1)
                .collect(Collectors.toList());

        /* 3. Создать поток Набора данных(на Ваше усмотрение), который не будет иметь промежуточных данных
          и результатом будет Лист данных; */
        Stream<Integer> thirdStream = Stream.of(1, 2, 3);
        List thirdStreamResult = thirdStream.collect(Collectors.toList());

        /* 4. Создать Коллекцию в виде “ключ-значение”, наполнить,
         получив значение ключей пройтись по всем, напечатать их значение и результатом сохранить в виде коллекции;*/
        Map<Integer, String> myHashMap = new HashMap<Integer, String>();
        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        myHashMap.put(3, "Three");
        List<String> mapValues = myHashMap.values().stream()
                .map(val -> {
                    System.out.println(val);
                    return val;
                }).collect(Collectors.toList());

        /* 5. Cоздать коллекцию из 10 строчных значений в виде чисел. Используя стрим пропустить первое значение,
         указать лимит 8 значений, преобразовать все значения в int, отфильтровать значения только четных значения
         и собрать результат в коллекцию ТОЛЬКО уникальных значений; */
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Stream<String> fifthStream = (Stream<String>) numbers.stream();
        List<Integer> integers = fifthStream.skip(1)
                .limit(8)
                .map(val -> Integer.parseInt(val))
                .filter(val -> (val % 2 == 0))
                .distinct()
                .collect(Collectors.toList());

        /* 6. Создать поток, сразу наполнив его данными(не из коллекции), преобразовать в многопоточный поток, отсортировать,
         задать фильтр(на свое усмотрение) и найти первый элемент, который попадется(как результат выполнения); */
        Stream<Integer> sixthStream = Stream.of(1, 2, 3);
        Optional<Integer> number = sixthStream.parallel()
                .sorted()
                .filter(var -> (var > 1))
                .findFirst();

        /* 7. Создать поток, в котором показать применения всех 4х возможных вызовов Ссылочных методов. На свое усмотрение, но
         должны быть примеры вызовов всех методов в одном потоке. Можно создавать свои классы и методы для примера вызова,
         можно использовать представленные уже в Java; */
        String[] array = new String[]{"1", "2", "3"};
        Arrays.stream(array)
                .filter(val -> (!val.isEmpty()))
                .map(String::toLowerCase)
                .map(String::new)
                .map(Integer::parseInt)
                .distinct()
                .forEach(System.out::println);
    }
}


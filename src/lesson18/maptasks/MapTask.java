package lesson18.maptasks;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(getLoginsByCity(firstTaskMap, city));


        // TODO:: дан список слов (words).
        //  Написать метод, который будет возвращать количество
        //  одинаковых слов с списке
        //  в виде Map<String, Integer>,
        //  где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(getMonthsCount(words));


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели,
        //  возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(filterByAge(customerMap, 18, 35));

        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  4. написать метод, который выводит в консоль топ 10 самых частых слов

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(wordCount(text, "uncover"));

        System.out.println(getGroupsByLettersCount(text));

        printTopTen(text);

    }

    private static List<String> getLoginsByCity(HashMap<String, String> map, String city) {
        List<String> strings = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city)) {
                strings.add(entry.getKey());
            }
        }
        return strings;
    }

    private static Map<String, Integer> getMonthsCount(List<String> monthsList){
        HashMap<String, Integer> monthsCount = new HashMap<>();
        monthsList.forEach(month -> {
            int count = monthsCount.getOrDefault(month, 0);
            monthsCount.put(month, count + 1);

            /*if (monthsCount.containsKey(month)) {
                monthsCount.replace(month, monthsCount.get(month) + 1);
            } else {
                monthsCount.put(month, 1);
            }*/
        });
        return monthsCount;
    }


    private static HashMap<String, Customer> filterByAge(HashMap<String, Customer> map, int from, int to) {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry : map.entrySet()) {
            if (entry.getValue().getAge() >= from && entry.getValue().getAge() < to) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }


    private static int wordCount(String text, String wordToFind) {
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.equalsIgnoreCase(wordToFind)) count++;
        }
        return count;
    }

    private static Map<Integer, Set<String>> getGroupsByLettersCount(String text) {

        Map<Integer, Set<String>> map = new TreeMap<>();

        String[] words = text.trim().toLowerCase().split(" ");
        for (String word : words) {
//            int wordLen = word.length();
//            if (map.containsKey(wordLen)) {
//                map.get(wordLen).add(word);
//            } else {
//                HashSet<String> set = new HashSet<>();
//                set.add(word);
//                map.put(wordLen, set);
//            }

            Set<String> strings = map.getOrDefault(word.length(), new HashSet<>());
            strings.add(word);
            map.put(word.length(), strings);
        }
        return map;
    }
    private static void printTopTen(String text) {
        String[] words = text.trim().toLowerCase().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(hashMap.entrySet());
        entries.sort(new ValueComparator());
        for (int i = 0; i < 10; i++) {
            System.out.println(entries.get(i).getKey());
        }
    }
}

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}

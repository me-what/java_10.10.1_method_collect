// method collect

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> phones = new ArrayList<String>();
        Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        List<String> filteredPhones = phones.stream()
                .filter(s->s.length()<10)
                .collect(Collectors.toList());

        for(String s : filteredPhones){
            System.out.println(s);
        }
        System.out.println();


        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));


        Map<String, Integer> phones2 = phoneStream
                .collect(Collectors.toMap(p->p.getName(), t->t.getPrice()));

        phones2.forEach((k,v)->System.out.println(k + " " + v));
        System.out.println();


        Stream<String> phones3 = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        HashSet<String> filteredPhones3 = phones3.filter(s->s.length()<12).
                collect(Collectors.toCollection(HashSet::new));

        filteredPhones3.forEach(s->System.out.println(s));
        System.out.println();


        Stream<String> phones4 = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        ArrayList<String> filteredPhones4 = phones4.filter(s->s.length()<12)
                .collect(
                        ()->new ArrayList<String>(), // создаем ArrayList
                        (list, item)->list.add(item), // добавляем в список элемент
                        (list1, list2)-> list1.addAll(list2)); // добавляем в список другой список

        filteredPhones4.forEach(s->System.out.println(s));
    }
}
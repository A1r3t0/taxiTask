import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class taxi {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nOR = new ArrayList<>();
        ArrayList<Integer> taxiPrice = new ArrayList<>();
        ArrayList<Integer> taxiPrice2 = new ArrayList<>();
        ArrayList<Integer> nOR2 = new ArrayList<>();
        ArrayList<Boolean> boolResults = new ArrayList<>();
        System.out.print("Введите количество сотрудников: ");
        String nOS1 = reader.readLine();
        System.out.println();
        int nOS = Integer.parseInt(nOS1);
        if (nOS < 1 || nOS > 1000) {
            System.out.println("Количество сотрудников должно быть от 1 до 1000!");
            System.exit(0);
        }
        for (int i = 0; i < nOS; i++) {
            System.out.print("Введите расстояние от работы до дома (в километрах) для " + (i+1) + " сотрудника: ");
            String nOR1 = reader.readLine();
            int nOR0 = Integer.parseInt(nOR1);
            System.out.println();
            if (nOR0 < 0 || nOR0 > 1000) {
                System.out.println("Расстояние - положительное число от 0 до 1000!");
                System.exit(0);
            }
            nOR.add(nOR0);
            nOR2.add(nOR0);
        }
        for (int i = 0; i < nOS; i++) {
            System.out.print("Введите тариф (в рублях) за проезд 1 км такси в " + (i + 1) + " машине: ");
            String nOTax1 = reader.readLine();
            int nOTax = Integer.parseInt(nOTax1);
            System.out.println();
            if (nOTax < 0 || nOTax > 10000) {
                System.out.println("Тариф за километр не может превышать 10000, либо быть меньше 0!");
                System.exit(0);
            }
            taxiPrice.add(nOTax);
            taxiPrice2.add(nOTax);
        }

        Collections.sort(taxiPrice2); // сортировка цены на такси от меньшего к большему
        nOR2.sort(Comparator.reverseOrder()); // сортируем расстояние от большего к меньшему

        for (int i = 0; i < nOR.size() - 1; i++) {
            for (int j = 0; j < taxiPrice.size(); j++) {
                if ((nOR.get(i) != nOR.get(i+1)) && (taxiPrice.get(i) != taxiPrice.get(i+1))) {
                    boolResults.add(true);
                }
                else {
                    boolResults.add(false);
                }
            }
        }
        Set<Boolean> Set = new HashSet<>(boolResults);
        boolResults.clear();
        boolResults.addAll(Set);
        if (Set.size() == 1) {
            for (int m = 0; m < nOS; m++) { // i == m
                for (int s = 0; s < nOR2.size(); s++) { // j == s
                    for (int c = 0; c < nOS; c++) { // k == c
                        if ((nOR.get(m)).equals(nOR2.get(s)) && (taxiPrice2.get(s)).equals(taxiPrice.get(c))) {
                            System.out.println("Сотрудник " + (m + 1) + " должен сесть в " + (c + 1) + " такси.");
                        }
                    }
                }
            }
        }

        int priceResult = 0;
        for (int i = 0; i < nOS;) {
            for (int j = 0; j < nOS; j++) {
                priceResult = priceResult + (nOR2.get(i)*taxiPrice2.get(i));
                i++;
            }
        }
        System.out.println("Итоговая сумма за просчитанный вариант с минимальными затратами: " + priceResult + " руб.");
        int number = priceResult;
        ArrayList<String> list = new ArrayList<>();
        if (number < 1 || number > 100000) {
            System.out.println("Число не входит в диапазон от 1 до 100_000");
            System.exit(0);
        }
        if (number == 100000) {
            System.out.println("Сто тысяч рублей");
            System.exit(0);
        }
        if ((number/10000)%10 == 1) {
            switch ((number/1000)%10) {
                case 0 -> list.add("десять тысяч");
                case 1 -> list.add("одиннадцать тысяч");
                case 2 -> list.add("двенадцать тысяч");
                case 3 -> list.add("тринадцать тысяч");
                case 4 -> list.add("четырнадцать тысяч");
                case 5 -> list.add("пятнадцать тысяч");
                case 6 -> list.add("шестнадцать тысяч");
                case 7 -> list.add("семнадцать тысяч");
                case 8 -> list.add("восемнадцать тысяч");
                case 9 -> list.add("девятнадцать тысяч");
            }
        }
        else {
            switch ((number / 10000) % 10) {
                case 2 -> list.add("двадцать");
                case 3 -> list.add("тридцать");
                case 4 -> list.add("сорок");
                case 5 -> list.add("пятьдесят");
                case 6 -> list.add("шестьдесят");
                case 7 -> list.add("семьдесят");
                case 8 -> list.add("восемьдесят");
                case 9 -> list.add("девяносто");
            }
        }
        if ((number/10000)%10 != 1) {
            switch ((number / 1000) % 10) {
                case 1 -> list.add("одна тысяча");
                case 2 -> list.add("две тысячи");
                case 3 -> list.add("три тысячи");
                case 4 -> list.add("четыре тысячи");
                case 5 -> list.add("пять тысяч");
                case 6 -> list.add("шесть тысяч");
                case 7 -> list.add("семь тысяч");
                case 8 -> list.add("восемь тысяч");
                case 9 -> list.add("девять тысяч");
            }
        }
        switch ((number / 100) % 10) {
            case 1 -> list.add("сто");
            case 2 -> list.add("двести");
            case 3 -> list.add("триста");
            case 4 -> list.add("четыреста");
            case 5 -> list.add("пятьсот");
            case 6 -> list.add("шестьсот");
            case 7 -> list.add("семьсот");
            case 8 -> list.add("восемьсот");
            case 9 -> list.add("девятьсот");
        }
        if ((number/10)%10 == 1) {
            switch (number%10) {
                case 0 -> list.add("десять рублей");
                case 1 -> list.add("одиннадцать рублей");
                case 2 -> list.add("двенадцать рублей");
                case 3 -> list.add("тринадцать рублей");
                case 4 -> list.add("четырнадцать рублей");
                case 5 -> list.add("пятнадцать рублей");
                case 6 -> list.add("шестнадцать рублей");
                case 7 -> list.add("семнадцать рублей");
                case 8 -> list.add("восемнадцать рублей");
                case 9 -> list.add("девятнадцать рублей");
            }
        }
        else {
            switch ((number / 10) % 10) {
                case 2 -> list.add("двадцать");
                case 3 -> list.add("тридцать");
                case 4 -> list.add("сорок");
                case 5 -> list.add("пятьдесят");
                case 6 -> list.add("шестьдесят");
                case 7 -> list.add("семьдесят");
                case 8 -> list.add("восемьдесят");
                case 9 -> list.add("девяносто");
            }
        }
        if ((number / 10) % 10 != 1) {
            switch (number%10) {
                case 0 -> list.add("рублей");
                case 1 -> list.add("один рубль");
                case 2 -> list.add("два рубля");
                case 3 -> list.add("три рубля");
                case 4 -> list.add("четыре рубля");
                case 5 -> list.add("пять рублей");
                case 6 -> list.add("шесть рублей");
                case 7 -> list.add("семь рублей");
                case 8 -> list.add("восемь рублей");
                case 9 -> list.add("девять рублей");
            }
        }
        String word = "";
        for (String s : list) {
            word = word + s + " ";
        }
        System.out.println("Итого к оплате: " + word);
    }
}


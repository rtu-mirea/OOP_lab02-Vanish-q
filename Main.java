package com.company;
import java.util.Scanner;
public class Main {
/*
Последовательность десятичных положительных чисел представлена в строковом формате.
Методы:
•	Определить, максимальную разрядность чисел последовательности.
•	Найти числа, в шестнадцатеричном коде которых присутствуют буквы, и сформировать
из них массив-слов, отобразить сформированный массив.
•	Первую цифру числа заменить последней, а последнюю первой.
•	Сформировать массив, значениями которого являются индексы чисел последовательности,
равных последнему числу.
*/
/**
 Так вышло, что саму лвбораторную я на 80% сделал еще до того, как узнал что ее  нужно будет загружать на
 гит, а доделал до того как прочитал сообщение о том, что лучше выгружать промежуточные версии.
 В следующий раз исправлюсь
 */
    public static void main(String[] args) {
		int test = 8;
		Scanner in = new Scanner(System.in);
		while(test != 0){
			System.out.print("[0] - Завершение работы" + '\n' +
					"[1] - Вариант на String" + '\n' +
					"[2] - Ванриант на StringBuilder" + '\n' +
					"[3] - Вариант на регулярные выражения" + '\n' +
					"Выберите вариант: ");
			test = in.nextInt();
			switch (test){
				case 0:
					System.out.print("End of working");
					break;
				case 1:
					testStringClass(in);
					break;
				case 2:
                    testBuilderClass(in);
					break;
				case 3:
                    testDomen(in);
					break;
			}
		}
	}
	static void testStringClass(Scanner in){
    	NumWork object = new NumWork();
    	int task = 8;
    	while (task != 0){
    		System.out.print("[0] - Предыдущее меню" + '\n' +
					"[1] - Ввод строки" + '\n' +
					"[2] - Вывод строки" + '\n' +
					"[3] - Задание 1" + '\n' +
					"[4] - Задание 2" + '\n' +
					"[5] - Задание 3" + '\n' +
					"[6] - Задание 4" + '\n' +
					"Выберете задание: ");
    		task = in.nextInt();
    		switch(task){
				case 0:
					System.out.println("Возвращение к предыдущему меню...");
					break;
    			case 1:
					System.out.println("Введите числовую последовательность заканчивающуюся пробелом: ");
					in.nextLine();
					String str = in.nextLine();
					object.inputLine(str);
					break;
				case 2:
					System.out.println(object.getLine());
					break;
				case 3:
					System.out.println("Максимальная разрядность числа из последовательности = " + object.findMaxDigit());
					break;
				case 4:
					System.out.println("Числа преобразованные в шестнадцатиричную сс и имеющие в своей  записи буквы: " + object.makeWords());
					break;
				case 5:
					object.changeAllNums();
					System.out.println("Замененая строка: " + object.getLine());
					break;
				case 6:
					System.out.println("Массив индексов: ");
					int arr[] = object.indArr();
					for(Integer num: arr){
						System.out.print(num.toString() + ' ');
					}
					System.out.println();
					break;
			}
		}
	}
	static void testBuilderClass(Scanner in){
        NumBuilderWork object = new NumBuilderWork();
        int task = 8;
        while (task != 0){
            System.out.print("[0] - Предыдущее меню" + '\n' +
                    "[1] - Ввод строки" + '\n' +
                    "[2] - Вывод строки" + '\n' +
                    "[3] - Задание 1" + '\n' +
                    "[4] - Задание 2" + '\n' +
                    "[5] - Задание 3" + '\n' +
                    "Выберете задание: ");
            task = in.nextInt();
            switch(task){
                case 0:
                    System.out.println("Возвращение к предыдущему меню...");
                    break;
                case 1:
                    System.out.println("Введите числовую последовательность: ");
                    in.nextLine();
                    String str = in.nextLine();
                    object.inputLine(str);
                    break;
                case 2:
                    System.out.println(object.getLine());
                    break;
                case 3:
                    object.allToSixteen();
                    System.out.println("Последовательность с пребразованными числами: " + object.getLine());
                    break;
                case 4:
                    object.addSum();
                    System.out.println("Последовательность с добавленой в конец суммой: " + object.getLine());
                    break;
                case 5:
                    object.changeAllNums();
                    System.out.println("Последовательность с измененными числами: " + object.getLine());
                    break;
            }
        }
    }
    static void testDomen(Scanner in){
        RegularExpressions object = new RegularExpressions();
        int task = 8;
        while (task != 0){
            System.out.print("[0] - Предыдущее меню" + '\n' +
                    "[1] - Ввод текста" + '\n' +
                    "[2] - Вывод текста" + '\n' +
                    "[3] - Замена доменов" + '\n' +
                    "Выберете задание: ");
            task = in.nextInt();
            switch(task){
                case 0:
                    System.out.println("Возвращение к предыдущему меню...");
                    break;
                case 1:
                    System.out.println("Введите текст: ");
                    in.nextLine();
                    String str = in.nextLine();
                    object.inputText(str);
                    break;
                case 2:
                    System.out.println(object.getText());
                    break;
                case 3:
                    object.changAllDomens();
                    System.out.println("Текст с измененными доменами:\n" + object.getText());
                    break;

            }
        }
    }
}

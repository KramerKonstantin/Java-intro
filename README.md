# Домашнии задания по Java, 1 курс, 1 семестр

## [Домашнее задание 1. Сумма чисел](https://github.com/KramerKonstantin/Java-intro/tree/master/HW1)
1. Разработайте класс `Sum`, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.

2. Примеры запуска программы:
   > java Sum 1 2 3  
   > Результат: 6  
   > java Sum 1 2 -3  
   > Результат: 0  
   > java Sum "1 2 3"  
   > Результат: 6  
   > java Sum "1 2" " 3"  
   > Результат: 6  
   > java Sum " "  
   > Результат: 0  

Аргументы могут содержать цифры и произвольные пробельные символы.

3. При выполнении задания можно считать, что для представления входных данных и промежуточных результатов достаточен тип int.

4. При выполнении задания полезно ознакомиться с документацией к классам String и Integer.

## [Домашнее задание 2. Реверс](https://github.com/KramerKonstantin/Java-intro/tree/master/HW2)
1. Разработайте класс `Reverse`, читающий числа из стандартного входа, и выводящий их на стандартный вывод в обратном порядке.

2. В каждой строке входа содержится некоторое количество целых чисел (может быть 0). Числа разделены пробелами. Каждое число помещается в тип int.

3. Порядок строк в выходе должен быть обратным по сравнению с порядком строк во входе. Порядок чисел в каждой строке так же должен быть обратным к порядку чисел во входе.

4. Вход содержит не более 10^6 чисел.

5. Для чтения чисел используйте класс Scanner

6. Примеры работы программы:
   > Вход:  
   > 1 2  
   > 3  
   > Выход:  
   > 3  
   > 2 1  
   > Вход:  
   > 1  
   >   
   > 2 -3  
   > Выход:  
   > -3 2  
   >   
   > 1  

## [Домашнее задание 3. Статистика слов](https://github.com/KramerKonstantin/Java-intro/tree/master/HW3)
1. Разработайте класс WordStat, который будет подсчитывать статистику встречаемости слов во входном файле.

2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики, слова приводятся к нижнему регистру.

3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово и число его вхождений во входной файл.

4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.

5. Пример работы программы:
   * Входной файл:
   > To be, or not to be, that is the question:  
   * Выходной файл:
   > to 2  
   > be 2  
   > or 1  
   > not 1  
   > that 1  
   > is 1  
   > the 1  
   > question 1  

## [Домашнее задание 4. Статистика слов++](https://github.com/KramerKonstantin/Java-intro/tree/master/HW4)
1. Разработайте класс WordStatIndex, который будет подсчитывать статистику встречаемости слов во входном файле.

2. Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики, слова приводятся к нижнему регистру.

3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово, число его вхождений во входной файл и номера вхождений этого слова среди всех слов во входном файле.

4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.

5. Программа должна работать за линейное от размера входного файла время.

6. Примеры работы программы:
   * Входной файл:
   > Monday's child is fair of face.  
   > Tuesday's child is full of grace.  
   * Выходной файл:
   > monday's 1 1  
   > child 2 2 8  
   > is 2 3 9  
   > fair 1 4  
   > of 2 5 11  
   > face 1 6  
   > tuesday's 1 7  
   > full 1 10  
   > grace 1 12  

## [Домашнее задание 5. Разметка](https://github.com/KramerKonstantin/Java-intro/tree/master/HW5)
1. Разработайте набор классов для текстовой разметки.

2. Класс Paragraph может содержать произвольное число других элементов разметки и текстовых элементов.

3. Класс Text – текстовый элемент.

4. Классы разметки Emphasis, Strong, Strikeout – выделение, сильное выделение и зачеркивание. Элементы разметки могут содержать произвольное число других элементов разметки и текстовых элементов.

5. Все классы должны реализовывать метод toMarkdown(StringBuilder), которой должен генерировать Markdown-разметку по следующим правилам:
   1. текстовые элементы выводятся как есть;
   2. выделенный текст окружается символами '*';
   3. сильно выделенный текст окружается символами '__';
   4. зачеркнутый текст окружается символами '~'.
6. Следующий код должен успешно компилироваться:
```java
   Paragraph paragraph = new Paragraph(List.of(  
   	new Strong(List.of(  
   		new Text("1"),  
   		new Strikeout(List.of(  
   			new Text("2"),  
   			new Emphasis(List.of(  
   				new Text("3"),  
   				new Text("4")  
   			)),  
   			new Text("5")  
   		)),  
   		new Text("6")  
   	))  
   ));  
```

Вызов paragraph.toMakdown(new StringBuilder()) должен заполнять переданный StringBuilder следующим содержимым: 
   > __1~2*34*5~6__  


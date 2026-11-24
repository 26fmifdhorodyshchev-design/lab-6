public class Part1 {

    // 1. The Spelling Bee — виправлений код:
    //    pubic -> public, String args -> String[] args, printline -> println
    // public static void main(String[] args) { System.out.println("Hello"); }

    // 2. The Missing Link
    static void task2() {
        try {
            String text = null;
            System.out.println(text.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("2) NullPointerException: " + e.getMessage());
        }
    }

    // 3. Fencepost Error
    static void task3() {
        int[] arr = new int[3];
        try {
            for (int i = 0; i <= arr.length; i++) { // <= замість < : помилка на 1 елемент
                arr[i] = i * 10;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("3) ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    // 4. The Zero Guard
    static void task4() {
        int divisor = 0;
        int number = 100;
        if (divisor == 0) {
            System.out.println("4) Cannot divide!");
        } else {
            System.out.println("4) Result: " + (number / divisor));
        }
    }

    // 5. Multi-Catch (два окремі catch-блоки)
    static void task5() {
        int[] arr = new int[3];
        // Перший запуск — ділення на нуль
        try {
            int x = 10 / 0;
            arr[5] = x;
        } catch (ArithmeticException e) {
            System.out.println("5) Ділення на нуль: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("5) Вихід за межі масиву: " + e.getMessage());
        }
        // Другий запуск — доступ до масиву (ділення проходить успішно)
        try {
            int x = 10 / 2;
            arr[5] = x;
        } catch (ArithmeticException e) {
            System.out.println("5) Ділення на нуль: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("5) Вихід за межі масиву: " + e.getMessage());
        }
    }

    // 6. The Automatic Closer (try-with-resources)
    static void task6() {
        try (java.util.Scanner scan = new java.util.Scanner(System.in)) {
            System.out.print("6) Введіть щось (Enter): ");
            String line = scan.nextLine();
            System.out.println("6) Ви ввели: " + line);
        } // scan.close() викликається автоматично
        // УВАГА: закриття Scanner(System.in) закриває System.in,
        // тому далі в цій програмі нового Scanner на System.in створити не вдасться.
    }

    // 7. Logic Flip — це ЛОГІЧНА (Logical) помилка: код компілюється і працює, але дає неправильний результат.
    public static int add(int a, int b) {
        return a + b; // було: a - b
    }

    // 8. The "Finally" Test — так, finally виконується завжди
    static void task8() {
        try {
            System.out.println("8) try: все успішно");
        } catch (Exception e) {
            System.out.println("8) catch: не виконається");
        } finally {
            System.out.println("8) finally: виконується ЗАВЖДИ, навіть без помилки");
        }
    }

    // 9. Duck the Responsibility
    static int riskyMethod(int a, int b) throws ArithmeticException {
        return a / b; // виняток передається викликачу
    }

    // 10. The Stack Buster
    static void infinite(int n) {
        infinite(n + 1); // немає умови зупинки
    }

    public static void main(String[] args) {
        System.out.println("Hello"); // 1

        task2();
        task3();
        task4();
        task5();
        System.out.println("7) add(5, 3) = " + add(5, 3));
        task8();

        try {                                  // 9
            riskyMethod(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("9) Спіймано у main: " + e.getMessage());
        }

        try {                                  // 10
            infinite(0);
        } catch (StackOverflowError e) {
            System.out.println("10) Помилка в консолі: " + e.getClass().getName());
        }

        task6(); // останнім, бо закриває System.in
    }
}

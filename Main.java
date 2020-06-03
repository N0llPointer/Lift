import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>(); // Очередь
        Scanner scanner = new Scanner(System.in); 
        int floor; // Введенный этаж

        System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
        floor = scanner.nextInt(); // Ввод пользователя

        while(floor != 0){
            if(floor > 0 && floor < 26) // Если этаж находится в доме, тогда этаж добавляется в очередь
                queue.add(floor);
            else
                System.out.println("Такого этажа нет в доме"); // Если нет, тогда выводится сообщение об ошибке
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            floor = scanner.nextInt(); // Ввод пользователя
        }

        final int waitDoorsInSeconds = 10;
        final int waitMoveInSeconds = 5;
        int totalSeconds = 0;

        int currentFloor;
        int previousFloor = -1;

        while(!queue.isEmpty()){ // В этом цикле происходит одновременно вывод этажей и подсчет секунд. Цикл работает до тех пор, пока очередь не опустеет
            currentFloor = queue.poll(); // Текущий этаж равен первому элементу очереди. Метод poll возвращает элемент из головы очереди и удаляет его.
            System.out.print("этаж " + currentFloor);
            totalSeconds += waitDoorsInSeconds; // На каждом этаже лифт тратит время, чтобы открыть и закрыть двери
            if(previousFloor != -1) // Если это не первая остановка, тогда считается время пути
                totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds;
            previousFloor = currentFloor; // Текущий этаж становится предыдущим
            if(!queue.isEmpty()) // Если в очереди еще есть элементы, тогда выводится знак "->". Если этажи кончились, тогда знак не будет выведен.
                System.out.print(" -> ");
        }

        System.out.println("\nВремя затраченное лифтом на маршрут = " + totalSeconds + " с.");
    }

}

import java.util.Scanner;

public class AssignmentApp {
    public static void main(String[] args) {

        assignment a = new assignment();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter memory size:");
        int size = sc.nextInt();
        char[] arr = new char[size];

        int i = 0;
        char newItem;

        do {

            System.out.print("Enter data(type 'e' for end):");
            newItem = sc.next().charAt(0);

            if (newItem == 'e' || newItem == 'E') {
                System.out.println("Good bye");
                return;
            }

            // check if array is already full
            if (i == size) {
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                i--;
            }

            // add the new character to the array
            arr[i] = newItem;
            i++;

            // check if array is filled now
            if (i == size) {
                a.displayFrequency(arr);
            }

        } while (true);
    }

    public static class assignment {
        public void displayFrequency(char[] arr) {
            for (int i = 0; i < arr.length; i++) {
                int ans = counted(arr, i);
                if (ans == 0) {
                    int frequency = countFrequency(arr, i);
                    System.out.print( arr[i] + "->" + frequency + " ");
                }
            }
            System.out.print("\n");
        }

        int counted(char arr[], int index) {
            for (int i = 0; i < index; i++) {
                if (arr[i] == arr[index]) {
                    return 1;
                }
            }
            return 0;
        }

        int countFrequency(char[] arr, int index) {
            int count = 0;
            for (int i = index; i < arr.length; i++) {
                if (arr[i] == arr[index])
                    count++;
            }
            return count;
        }

    }
}

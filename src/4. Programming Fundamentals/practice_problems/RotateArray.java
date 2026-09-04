import java.util.Scanner;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {

        int n = nums.length;

        // Reduce k if it is greater than the array length
        k = k % n;

        int[] newArray = new int[n];

        // Place each element in its new position
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        // Copy new array back into nums
        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.print("Rotated Array: ");

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
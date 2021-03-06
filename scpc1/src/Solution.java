/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static int Answer;

    public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        String str = "";

        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            int n = sc.nextInt();
            int[] array = new int[n];
            boolean[] check = new boolean[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            for (int i = 0; i < n; i++) {
                if (check[i] == false) {
                    check[i] = true;
                    nextFriend(array, check, i);
                    Answer++;
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////

            // Print the answer to standard output(screen).
            str = str + "Case #" + (test_case+1) + "\n" + Answer + "\n";
        }
        System.out.println(str);
    }

    public static void nextFriend(int[] array, boolean[] check, int i) {
        if (array[i] + i >= array.length) {
            return;
        } else if (check[array[i] + i] == true) {
            Answer--;
            return;
        } else {
            check[array[i] + i] = true;
            nextFriend(array, check,array[i] + i);
            return;
        }
    }
}
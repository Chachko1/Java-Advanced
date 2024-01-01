package RetakeExam;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sizeMatrix=Integer.parseInt(scanner.nextLine());

        String[][] matrix=new String[sizeMatrix][sizeMatrix];

        for (int i = 0; i <matrix.length ; i++) {
            matrix[i]=scanner.nextLine().split("");
        }

        int initialAmount=100;
        int gamblerRow=-1;
        int gamblerCol=-1;
        for (int row = 0; row <sizeMatrix ; row++) {
            for (int col = 0; col <sizeMatrix ; col++) {
                if (matrix[row][col].equals("G")){
                    gamblerRow=row;
                    gamblerCol=col;
                }
            }
        }


        String command=scanner.nextLine();

        while (!command.equals("end")){
            boolean outOfBound=isOutOfBound(matrix,gamblerRow,gamblerCol,command);
            if (outOfBound){
                System.out.println("Game over! You lost everything!");
                return;
            }

                String nextStep="";
            switch (command){
                case "up":
                    nextStep=matrix[gamblerRow-1][gamblerCol];
                    if (nextStep.equals("W")){
                        initialAmount+=100;

                    } else if (nextStep.equals("P")) {
                        initialAmount-=200;

                    } else if (nextStep.equals("J")) {
                        initialAmount+=100000;
                        System.out.println("You win the Jackpot!");
                        System.out.printf("End of the game. Total amount: %d",initialAmount);
                        matrix[gamblerRow][gamblerCol]="-";
                        matrix[--gamblerRow][gamblerCol]="G";
                        printMatrix(matrix);

                        return;
                    }

                    matrix[gamblerRow][gamblerCol]="-";
                    matrix[--gamblerRow][gamblerCol]="G";
                    break;
                case "down":
                    nextStep=matrix[gamblerRow+1][gamblerCol];
                    if (nextStep.equals("W")){
                        initialAmount+=100;

                    } else if (nextStep.equals("P")) {
                        initialAmount-=200;

                    } else if (nextStep.equals("J")) {
                        initialAmount+=100000;
                        System.out.println("You win the Jackpot!");
                        System.out.printf("End of the game. Total amount: %d",initialAmount);
                        matrix[gamblerRow][gamblerCol]="-";
                        matrix[++gamblerRow][gamblerCol]="G";
                        printMatrix(matrix);

                        return;
                    }

                    matrix[gamblerRow][gamblerCol]="-";
                    matrix[++gamblerRow][gamblerCol]="G";

                    break;
                case "left":
                    nextStep=matrix[gamblerRow][gamblerCol-1];
                    if (nextStep.equals("W")){
                        initialAmount+=100;

                    } else if (nextStep.equals("P")) {
                        initialAmount-=200;

                    } else if (nextStep.equals("J")) {
                        initialAmount+=100000;
                        System.out.println("You win the Jackpot!");
                        System.out.printf("End of the game. Total amount: %d",initialAmount);
                        matrix[gamblerRow][gamblerCol]="-";
                        matrix[gamblerRow][--gamblerCol]="G";
                        printMatrix(matrix);

                        return;
                    }

                    matrix[gamblerRow][gamblerCol]="-";
                    matrix[gamblerRow][--gamblerCol]="G";

                    break;
                case "right":
                    nextStep=matrix[gamblerRow][gamblerCol+1];
                    if (nextStep.equals("W")){
                        initialAmount+=100;

                    } else if (nextStep.equals("P")) {
                        initialAmount-=200;

                    } else if (nextStep.equals("J")) {
                        initialAmount+=100000;
                        System.out.println("You win the Jackpot!");
                        System.out.printf("End of the game. Total amount: %d",initialAmount);
                        matrix[gamblerRow][gamblerCol]="-";
                        matrix[gamblerRow][++gamblerCol]="G";
                        printMatrix(matrix);

                        return;
                    }

                    matrix[gamblerRow][gamblerCol]="-";
                    matrix[gamblerRow][++gamblerCol]="G";

                    break;

            }




            if (initialAmount<=0){
                System.out.println("Game over! You lost everything!");
                return;
            }
            command= scanner.nextLine();
        }
        System.out.printf("End of the game. Total amount: %d$%n",initialAmount);
        printMatrix(matrix);
    }
    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element);
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }
    public static boolean isOutOfBound(String[][]matrix,int gamblerRow,int gamblerCol,String command) {
        switch (command) {
            case "up":
                if (gamblerRow - 1 < 0) {
                    return true;
                } else {
                    return false;
                }

            case "down":
                if (gamblerRow + 1 >= matrix.length) {
                    return true;
                } else {
                    return false;
                }

            case "left":
                if (gamblerCol - 1 < 0) {
                    return true;
                } else {
                    return false;
                }


            case "right":
                if (gamblerCol + 1 >= matrix.length) {
                    return true;
                } else {
                    return false;
                }


            default:
                return false;

        }
    }
}

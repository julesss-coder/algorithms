import java.util.Random;

public class BingoCardV2 {
    public static void main(String[] args) {
        String string = " B  I  N  G  O";
        int lowerBound = 1;
        int upperBound = 5;
        int[][] bingoNums = new int[5][5];
        StringBuilder bingoCard = new StringBuilder();

        // Create the numbers to be printed on Bingo Card:
        for (int j = 0; j < bingoNums.length; j++) {
            int i = 0;
            while (i < 5) {
                Random random = new Random();
                int randomNum = getUniqueNumber(lowerBound, upperBound, bingoNums, j, i, random);

                bingoNums[j][i] = randomNum;
                i++;
            }

            lowerBound = upperBound + 1;
            upperBound = upperBound + 5;
        }

        // Generate Bingo Card:
        bingoCard.append(string).append("\n");

        int l = 0;
        while (l < 5) {
            for (int j = 0; j < bingoNums.length; j++) {

                if (j == 2 & l == 2) {
                    bingoCard.append("   ");
                } else {
                    bingoCard.append(String.format("%2d ", bingoNums[j][l]));
                }
            }
            bingoCard.append("\n");
            l++;
        }

        System.out.println(bingoCard);
    }

    private static int getUniqueNumber(int lowerBound, int upperBound, int[][] bingoNums, int j, int i, Random random) {
        int randomNum;
        randomNum = random.nextInt(lowerBound, upperBound + 1);
        // Does this generate the correct range?
        // Check if current array already has randomNum
        for (int k = 0; k < i; k++) {
            if (bingoNums[j][k] == randomNum) {
                return getUniqueNumber(lowerBound, upperBound, bingoNums, j, i, random);
            }
        }

        return randomNum;
    }
}

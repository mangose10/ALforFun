import java.util.Arrays;

public class DamageStatCalc{

    public static void main(String[] args){
        skillDistributionPhia();
    }

    //returns 10% 50% and 90%
    //gets 111, 112, 113, 121, ...
    //therefore 27 possibilities repeatd over and over
    public static void skillDistributionPhia(){

        final int N_SKILLS = 3;
        //[1st][2nd][3rd][min/avg/max]
        double[][][] turnValues = new double[N_SKILLS][N_SKILLS][N_SKILLS];
        double total = 0;
        double[] skills = {0, 450, 45};
        double[] burnChance = {.5, 0, 2.0};
        //for skill 1: 00 = 0, 01 = 1, 10 = 1, 11 = 2 therefore 1
        //chance of 1 going off is 7/8 so chance of each is 
        //00 = 0.015625, 01 = 0.109375, 10 = 0.109375, 11 = 0.765625‬
        //000000 000001 000010 000011 000100 000101 000110 000111 //01
        //001000 001001 001010 001011 001100 001101 001110 001111
        //010000 010001 010010 010011 010100 010101 010110 010111
        //011000 011001 011010 011011 011100 011101 011110 011111
        //100000 100001 100010 100011 100100 100101 100110 100111
        //101000 101001 101010 101011 101100 101101 101110 101111
        //110000 110001 110010 110011 110100 110101 110110 110111
        //111000 111001 111010 111011 111100 111101 111110 111111
        //01
        //0 + 0.21875‬ + 1.53125‬
        //chance for skill one to be on the same person:
        //1/9 if you want skill2 to count, 1/3 if not 16+4+1
        double[] avgBurnCount = {1.75 , 0, 6};
        double[] usableBurn = {.11111111 , 0, 2};

        for (int i = 0; i < N_SKILLS; i++){
            for (int j = 0; j < N_SKILLS; j++){
                System.out.print(i + ", " + j + ": ");
                for (int k = 0; k < N_SKILLS; k++){
                    if (k == 2 && i == 0){turnValues[i][j][k] += 80;}
                    if (k == 2 && j == 0){turnValues[i][j][k] += 80;}
                    if (j == 2 && i == 0){turnValues[i][j][k] += 80;}
                    turnValues[i][j][k] += skills[i] + skills[j] + skills[k];
                    turnValues[i][j][k] += (avgBurnCount[i] + avgBurnCount[j] + avgBurnCount[k]) * 150;
                    total += turnValues[i][j][k];
                    System.out.print(turnValues[i][j][k] + " ");
                }
                System.out.println();
            }
        }

        System.out.println(total/27.0);

        return;
    }

   
}
package _05_arrays;
//leetcode
//1854. Maximum Population Year
public class MaxPopulationYear {
    public static void main(String[] args) {
        int[][] logs = {
                {1993, 1999},
                {2000, 2010}
        };
        int result = maximumPopulation(logs);
        System.out.println(result);
    }

    public static int maximumPopulation(int[][] logs) {
        // Initialize a population change array for years 1950 to 2050
        int[] populationChange = new int[2050 - 1950 + 1];

        // Fill the population change array
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            populationChange[birth - 1950]++;  // Increase population at birth year
            if (death < 2051) {
                populationChange[death - 1950]--;  // Decrease population at death year
            }
        }

        // Calculate the prefix sum to get the actual population per year
        int maxPopulation = 0;
        int currentPopulation = 0;
        int earliestYear = 1950;

        for (int year = 1950; year <= 2050; year++) {
            currentPopulation += populationChange[year - 1950];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                earliestYear = year;
            }
        }

        return earliestYear;
    }
}

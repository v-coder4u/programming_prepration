package gs;

public class MinimumEnergyRequiredToCrossStreet {

	static int minInitialEnergy(int arr[], int n) {
		int initMinEnergy = 0;
		int currEnergy = 0;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			currEnergy += arr[i];
			if (currEnergy <= 0) {
				initMinEnergy += Math.abs(currEnergy) + 1;
				currEnergy = 1;
				flag = true;
			}
		}
		return (flag == false) ? 1 : initMinEnergy;
	}

}

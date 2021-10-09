package arrayQuestions;

// Question 2 from DSA Cracker sheet

class MinMax {
	int min;
	int max;
	MinMax() {
		
	}
	MinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}
	void setMin(int min) {
		this.min = min;
	}
	void setMax(int max) {
		this.max = max;
	}
	int getMin() {
		return this.min;
	}
	int getMax() {
		return this.max;
	}
}
public class MinAndMax {

	public static void main(String[] args) {
		
		int arr[] = {10,4,15,21,7,3};
//		MinMax obj = MinAndMax.findMinMax(arr);
		MinMax obj = MinAndMax.findMinMaxRecursive(arr, 0, arr.length - 1);
		System.out.println(obj.getMin());
		System.out.println(obj.getMax());
	}
	
	public static MinMax findMinMax(int arr[]) {
		MinMax minmax = new MinMax(arr[0], arr[0]);
		
		if(arr.length == 1) {
			return minmax;
		}
		for(int i = 1 ; i < arr.length ; i++) {
			if(arr[i] < minmax.getMin()) {
				minmax.setMin(arr[i]);
			}
			if(arr[i] > minmax.getMax()) {
				minmax.setMax(arr[i]);
			}
		}
		return minmax;
	}
	
	public static MinMax findMinMaxRecursive(int arr[], int low, int high) {
		MinMax minmax = new MinMax();
		MinMax mml = new MinMax();
		MinMax mmr = new MinMax();
		
		// Incase of single element
		if(low == high) {
			minmax.setMin(arr[low]);
			minmax.setMax(arr[low]);
			return minmax;
		}
		
		// Incase of 2 elements
		if(low == (high-1)) {
			if(arr[low] > arr[high]) {
				minmax.setMax(arr[low]);
				minmax.setMin(arr[high]);
			}
			else {
				minmax.setMax(arr[high]);
				minmax.setMin(arr[low]);
			}
			return minmax;
		}
		
		//Incase of more elements
		int mid = (int)Math.floor((low+high)/2);
		mml = findMinMaxRecursive(arr, low, mid);
		mmr = findMinMaxRecursive(arr, mid+1, high);
		
		if(mml.getMin() < mmr.getMin()) {
			minmax.setMin(mml.getMin());
		} else {
			minmax.setMin(mmr.getMin());
		}
		
		if(mml.getMax() > mmr.getMax()) {
			minmax.setMax(mml.getMax());
		} else {
			minmax.setMax(mmr.getMax());
		}
		
		return minmax;
	}

}

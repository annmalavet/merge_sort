import java.util.Arrays;

public class Main {
	static int [] arr = new int []{9,-800,-7,50,-69,98,2,0,-3,2,1};
	//change arr's numbers to see how they re-sort
	
	static int left = 0;
	static int [] tempArr = new int [arr.length];
	static int right = arr.length-1;

	public static void main(String[] args) {
		mergeSort(arr, left, right);
		System.out.println(Arrays.toString(arr));
	}
	
    private static void mergeSort(int[] array, int left, int right) {

        if (left < right) {
        	//System.out.println(arr[left]+  "  "+arr[right]);
            //split the array into 2, find middle/center
            int center = left + (right-left)/ 2;        
            //sort the left and right array
            mergeSort(array, left, center);
            //sort the right side 
            mergeSort(array, center + 1, right);
            //System.out.println(array);
            //merge the result - merge both sides - after recursion
            merge( left, center, right);
           // System.out.println(left+"--"+center+"--"+right);
        }
    }
    
    public static void merge ( int left, int center, int right){
    	int i = 0;
    	for (i = 0; i <= right; i++) {
    	tempArr[i] = arr[i];
    	//System.out.println(Arrays.toString(tempArr));
    	}
    	
	
        int y = left;
        int centerPlusOne = center+1;   
        int k = left;

        while (y <= center && centerPlusOne <= right) {
            if (tempArr[y] <= tempArr[centerPlusOne]) {
                arr[k] = tempArr[y];
                y++;
            } else {
                arr[k] = tempArr[centerPlusOne];
                centerPlusOne++;
            }
            k++;
        }
        while (y <= center) {
            arr[k] = tempArr[y];
            k++;
            y++;
        }

    }

}

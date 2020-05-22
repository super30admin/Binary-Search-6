// Time Complexity : O(logN) and worst case O(N) 
// Space Complexity : O(1)

class Solution {
	
	// Binary Search in an array with blanks
	static int binarySearch(String arr[], int low, int high, String x) {

		while(low < high) {
			int mid = low + (high - low)/2;

			if(arr[mid].equals("")) {
				int left = mid - 1;
				int right = mid + 1;

				while(true) {
					if(left < low && right > high)
						return -1;
					else if(left >= low && !arr[left].equals("")) {
						mid = left;
						break;
					} else if(right <= high && !arr[right].equals("")) {
						mid = right;
						break;
					}

					left--;
					right++;
				}
			}

			if(arr[mid].equals(x))
				return mid;
			else if(x.compareTo(arr[mid]) < 0) // move left
				high = mid - 1;
		    else
		    	low = mid + 1;
		}

		return -1
	}

	private static int sparseSearch(String arr[], String x, int n) {
		return binarySearch(arr, 0, n-1, x);
	}

	public static void main(String args[]) {
		String arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"};
		String x = "geeks";

		int x = x.length();
		int index = sparseSearch(arr, x, n);

		if (index != -1) 
			System.out.println(x + " found at index " + index);
		else
			System.out.println(x + " not found");
	}
}

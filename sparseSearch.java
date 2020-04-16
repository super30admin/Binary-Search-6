class sparseSearch {

	// move mid to the closest non empty string and apply binary search
	static int search_iterative(String[] arr, String word) {
		int low = 0, high = arr.length;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid].equals(word)) return mid;
			if (arr[mid].isEmpty()) {
				int left = mid-1;
				int right = mid+1;
				while (true) {
					if (left < low && right > high) return -1;
					else if (left >= low && !arr[left].isEmpty()) {
						mid = left;
						break;
					}
					else if (right <= high && !arr[right].isEmpty()) {
						mid = right;
						break;
					}
					left--;
					right++;
				}
			}
			if (arr[mid].equals(word)) return mid;
			if (arr[mid].compareTo(word) < 0) {
				low = mid+1;
			}
			else high = mid-1;
		}
		return -1;
	}

	static int search(String[] arr, String word) {
		if (arr == null || word == null || word == "")
			return -1;
		return search_recursive(arr, word, 0, arr.length - 1);	
	}

	// move mid to the closest non empty string and apply binary search
	static int search_recursive(String[] arr, String word, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (arr[mid].equals(word))
			return mid;
		if (arr[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < start && right > end)
					return -1;
				else if (right <= end && !arr[right].isEmpty()) {
					mid = right;
					break;
				}
				else if (left >= start && !arr[left].isEmpty()) {
					mid = left;
					break;
				}
				left--;
				right++;
			}
		}
		if (arr[mid].equals(word))
			return mid;
		else if (arr[mid].compareTo(word) < 0)
			return search_recursive(arr, word, mid + 1, end);
		else
			return search_recursive(arr, word, start, mid - 1);
	}

	public static void main(String[] args) {
		String[] arr = new String[] {"at", "", "", "", "ball", "", "", "", "car", "", "", "", "dad", "", ""};
		System.out.println(search(arr, "ball"));
		System.out.println(search_iterative(arr, "ball"));		
	}
}
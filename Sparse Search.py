'''
Time Complexity: O(n + logk) -> in worst case as there could be all empty and target string in the leftmost or right most index
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation:
Do normal binary search except if our mid is an an empty string we use 2 pointers to move either left or right to find
the first non empty string and set that to the new mid.
'''
class Solution:
    def sparceSearch(self, nums: List[str], target) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == "":
                # Use 2 pointers to find the earliest occurance of not empty string
                left = right = mid
                while True:
                    if left < low and right > high:
                        return -1
                    elif low <= left and nums[left] != "":
                        mid = left
                        break
                    elif right <= high and nums[right] != "":
                        mid = right
                        break
                    left -= 1
                    right += 1

            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1


s = Solution()
ans = s.sparceSearch(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], "practice")
print(ans)
'''
Not submitted to leetcode
Time - O(logN) and worst case O(N)
Space - O(1)

Approach:
1. First do the regular binary search as given array is sorted.
2. If you find an empty string take 2 pointer left and right(one position + and - of mid) to keep track of empty strings and iterate linearly
until u find some character.
3. If whole array is empty then just return -1
'''
class Solution:
    def sparseSearch(self, arr, findStr):
        low = 0
        high = len(arr) - 1

        while low <= high:
            mid = low + (high-low)//2

            if arr[mid] == '':
                left = mid-1
                right = mid+1

                # find the non-empty string on left or right
                while(True):
                    if left < low and right > high:
                        return -1
                    elif left >= low and arr[left] != '':
                        mid = left
                        break;
                    elif right <= high and arr[right] != '':
                        mid = right
                        break;
                    left -= 1
                    right += 1

            # regular binary search
            if arr[mid] == findStr:
                return mid
            elif arr[mid] < findStr:
                high = mid - 1
            else:
                low = mid + 1

        return -1

sol = Solution()
str = ['abc','bd','','','','','c','','','','','','cd']
print(sol.sparseSearch(str,'c'))

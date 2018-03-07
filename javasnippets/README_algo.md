**INSERT SORT**  

**class: InsertSort**

* In place sorting.
* Can get very slow.
* Algo - O(n2) n 

example - 8,6,5,7,3,8,1,9
* pick 6
* Compare with prev value, here 8
* If larger, put larger value in place of 6. Read prev to prev.
* if no value or larger value, put 6 in empty place.
* Transitions

        8,6,5,7,3,8,1,9
        _,8,5,7,3,8,1,9
        6,8,5,7,3,8,1,9
* pick 5
* apply above logic
* Transitions ( on top already done one iteration)

        6,8,5,7,3,8,1,9
        6,_,8,7,3,8,1,9
        _,6,8,7,3,8,1,9
        5,6,8,7,3,8,1,9
* next iteration. pick 7

        5,6,8,7,3,8,1,9
        5,6,_,8,3,8,1,9
        5,6,7,8,3,8,1,9
* repeat iterations till last element        

**MERGE SORT**

class: MergeSort 

*Description:*

Merge sort will keep splitting the array in 2 till end and then merge the split arrays.

Example:
* (45, 23, 11, 89, 77, 98, 4, 28, 65, 43) - break till you end up with 1 or 2 elements per list.
* (45, 23) (11, 89) (77, 98) (4, 28) (65, 43) - sort each one next
* (23, 45) (11, 89) (77, 98) (4, 28) (43, 65) - pick 2 and pick smaller element into another list 
* (11, 23, 45, 89) (4, 28, 77, 98) (43, 65) - smaller list merged into sorted large list
* (11, 23, 45, 89) (4, 28, 43, 65, 77, 98) - keep merging..
* (4, 11, 23, 28, 43, 45, 65, 77, 89, 98 ) - final sorted list

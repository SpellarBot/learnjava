**How to check if 2 words are anagrams**  

**class: AnagramCheck**

3 approaches:
1. Read one char at a time from a word. Check if exists in another word using _indexOf_. if yes, exclude it from the word.

        int index = anagram.indexOf(c);
        anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());

2. put one word in string builder. and keep deleting the char found.

        StringBuilder sbSecond = new StringBuilder(second);
        sbSecond.deleteCharAt(index);
    
    
3. Sort and compare the words array.
        
        char[] charFromWord = word.toCharArray();
        Arrays.equals(charFromWord, charFromAnagram);

_KEY FUNCTIONS_
* String.indexOf
* String.toCharArray
* StringBuilder.deleteChatAt

**How to check if linked list is cyclic**
* create 2 pointers. one will read next node, other will read next to next.
* at some point they will end up reading same element.
* if not cyclic, pointers will hit null.
* Example 1

```
12	13	14	15	16	17	18		    -- Array Even			
12	13	14	15	16	17	18	12*	13  -- pointer 1
12	14	16	18	13	15	17	12*	14  -- pointer 2
										
12	13	14	15	16	17                          -- Array Odd						
12	13	14	15	16	17	12	13	14	15	16*	17  -- pointer 1
12	14	16	12	12	14	16	12	12	14	16*	12  -- pointer 2
```

**How to find prime numbers**

Start dividing number, starting with 2. Keeping dividing, as long as number is divisible by given divisor.
Keep noting the divisors.

*Example:*
* Number - 8 | 8/2 4/2 2/2 | Answer 2
* Example: 24 | 24/2 12/2 6/2 3/2 3/3 | Answer 2, 3


**How to remove duplicates from array**

class: RemoveArrayDupes

1. Sorted Array:
* Without creating another large array
* Start 2 pointers
* Keep 1st stagnant till 2nd has a number different from 1st.
* If different number found, increment both pointers and save new number with 1st pointer.

_Example_

[*1,*2,2,3,4,4,5] - input array 
[1,*2,2,*3,4,4,5] 
[1,2,*3,3,*4,4,5] -- keep moving unique integers left
[1,2,3,*4,4,4,*5]
[1,2,3,4,5, , ] - finally, original array is destroyed, but sorting is done without creating new array.

2. Unsorted Array. 
* So you don't care about order, create list from array.
* Create Set from List - This will remove the dupes
* Create array back from Set

**How to remove char from String**
class: RemoveCharFromString
Mainly , convert String to char[]

    char[] letters = word.toCharArray();
    
or use indexOf method

    word.indexOf(ch)
    
    
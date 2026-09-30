Yes bro, I understand exactly. I’ve started with the classic Striver A2Z Arrays module: 40 problems (14 Easy + 14 Medium + 12 Hard), and organized each problem with GFG + LeetCode + TUF practice links where an appropriate equivalent exists. The classic 14/14/12 structure is corroborated by multiple A2Z mirrors, while TUF’s current curriculum has since evolved.

I made the README so you can put it directly inside:

03-Arrays/README.md

Download Arrays_README.md

One important detail: I didn't force fake LeetCode links for problems that don't have a suitable exact LeetCode equivalent. Those are marked — instead.

This gives you a clean “open → pick question → practice” hub inside your repo. 

Arrays_README.md
Document
bro thats great

Haha thanks bro 😎🔥

This is actually a really useful setup for your DSA repo. Instead of remembering where every problem is, your 03-Arrays/README.md becomes your practice dashboard.

And whenever you finish a question, we can later add something like:

✅ Solved
🔁 Needs Revision
⭐ Important

So over time, your README can become your personal DSA revision tracker rather than just a list of links. 🚀

Root is great, but listen, can you just in place of where you write heading like Leetcode, CFG, and stuff, and give the links. In place of links, can you add image, and when I click on image, the questions open? So the image links, I will give you the image link, which is in my... let me search for images first. First of all, driver, it was a DSA sheet, when I open this. Inside that, there is a folder. Inside that, there is an image, capital I-M-A-G-E-S, images, and inside that, there is CFG.png, there is Leetcode.png, and there is Take You Forward.jpg. All these files, where Take You Forward, all of these are in smalls, but in Take You Forward, the U is capital, otherwise all the things are small. Okay? All of these are in images file, so use this address, okay? And everything is good, looks good.

Yes bro 😎 exactly that.

I changed the README so the GFG / LeetCode / TUF text links are represented by clickable images from your repo's Images folder:

Images/gfg.png
Images/leetcode.png
Images/takeUforward.jpg

So when you put README.md inside 03-Arrays, the image paths are relative and clicking the image opens the corresponding problem.

Download the updated Arrays_README.md

Just rename it to README.md when you put it inside 03-Arrays. 

Arrays_README.md
Document

Arrays_README.md
Striver A2Z --- Arrays Practice List

Purpose: A practice index for the Arrays section of Striver's A2Z
DSA series.
Use this file as a quick revision hub: pick a problem, attempt it
yourself, then open the platform you prefer.

Source: Striver's A2Z DSA
Sheet

Total: 40 problems --- 14 Easy + 14 Medium + 12 Hard

Note: Platform availability differs by problem. A blank LeetCode
cell means there is no exact/appropriate LeetCode problem link for
that Striver problem. For some problems, GFG has equivalent wording
rather than identical wording.

📌 Arrays --- Easy
         \# Problem           Difficulty    GFG                                                                                                                          LeetCode                                                                         TUF
          1 **Largest            Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1/)                                           ---                                                                              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/largest-element-in-an-array)
            Element in an                                                                                                                                                                                                                                 
            Array**                                                                                                                                                                                                                                       

          2 **Second             Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/second-largest3735/1/)                                                     [![Platform](../Images/gfg.png)](https://leetcode.com/problems/second-largest-digit-in-a-string/)      [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/second-largest-element-in-an-array-without-sorting)
            Largest                                                                                                                                                                                                                                       
            Element in an                                                                                                                                                                                                                                 
            Array**                                                                                                                                                                                                                                       

          3 **Check if the       Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1/)                                        ---                                                                              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/check-if-the-array-is-sorted)
            Array is                                                                                                                                                                                                                                      
            Sorted**                                                                                                                                                                                                                                      

          4 **Remove             Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/remove-duplicates-in-place-from-sorted-array/1/)                           [![Platform](../Images/gfg.png)](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/remove-duplicates-from-sorted-array)
            Duplicates                                                                                                                                                                                                                                    
            from Sorted                                                                                                                                                                                                                                   
            Array**                                                                                                                                                                                                                                       

          5 **Left Rotate        Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/rotate-array-by-one/1/)                                                    ---                                                                              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/left-rotate-an-array-by-one-place)
            Array by One                                                                                                                                                                                                                                  
            Place**                                                                                                                                                                                                                                       

          6 **Left Rotate        Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1/)                                  [![Platform](../Images/gfg.png)](https://leetcode.com/problems/rotate-array/)                          [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/left-rotate-an-array-by-d-places)
            Array by D                                                                                                                                                                                                                                    
            Places**                                                                                                                                                                                                                                      

          7 **Move Zeros         Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1/)                                    [![Platform](../Images/gfg.png)](https://leetcode.com/problems/move-zeroes/)                           [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/move-zeros-to-end)
            to End**                                                                                                                                                                                                                                      

          8 **Linear             Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1/)                               ---                                                                              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/linear-search)
            Search**                                                                                                                                                                                                                                      

          9 **Find the           Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1/)                                  ---                                                                              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/find-the-union)
            Union of Two                                                                                                                                                                                                                                  
            Sorted                                                                                                                                                                                                                                        
            Arrays**                                                                                                                                                                                                                                      

         10 **Find Missing       Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1/)                                            [![Platform](../Images/gfg.png)](https://leetcode.com/problems/missing-number/)                        [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/find-missing-number-in-an-array)
            Number in an                                                                                                                                                                                                                                  
            Array**                                                                                                                                                                                                                                       

         11 **Maximum            Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/maximize-number-of-1s0905/1/)                                              [![Platform](../Images/gfg.png)](https://leetcode.com/problems/max-consecutive-ones/)                  [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/maximum-consecutive-ones)
            Consecutive                                                                                                                                                                                                                                   
            Ones**                                                                                                                                                                                                                                        

         12 **Find the           Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-every-element-is-present-twice/1/)   [![Platform](../Images/gfg.png)](https://leetcode.com/problems/single-number/)                         [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/find-the-number-that-appears-once-and-other-numbers-twice)
            Number That                                                                                                                                                                                                                                   
            Appears Once**                                                                                                                                                                                                                                

         13 **Longest            Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1/)                                       ---                                                                              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/longest-subarray-with-given-sum-k)
            Subarray with                                                                                                                                                                                                                                 
            Sum K                                                                                                                                                                                                                                         
            (Positive)**                                                                                                                                                                                                                                  

         14 **Longest            Easy       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1/)                                       ---                                                                              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/longest-subarray-with-given-sum-k)
            Subarray with                                                                                                                                                                                                                                 
            Sum K                                                                                                                                                                                                                                         
            (Positive +                                                                                                                                                                                                                                   
            Negative)**                                                                                                                                                                                                                                   
📌 Arrays --- Medium
         \# Problem            Difficulty    GFG                                                                                          LeetCode                                                                      TUF
         15 **2 Sum**            Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/key-pair5616/1/)                           [![Platform](../Images/gfg.png)](https://leetcode.com/problems/two-sum/)                            [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/2sum-problem)

         16 **Sort an Array      Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1/)      [![Platform](../Images/gfg.png)](https://leetcode.com/problems/sort-colors/)                        [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/sort-an-array-of-0s-1s-and-2s)
            of 0s, 1s and                                                                                                                                                                                               
            2s**                                                                                                                                                                                                        

         17 **Majority           Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/majority-element-1587115620/1/)            [![Platform](../Images/gfg.png)](https://leetcode.com/problems/majority-element/)                   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/majority-element)
            Element (\>                                                                                                                                                                                                 
            N/2)**                                                                                                                                                                                                      

         18 **Kadane's           Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1/)           [![Platform](../Images/gfg.png)](https://leetcode.com/problems/maximum-subarray/)                   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/kadanes-algorithm)
            Algorithm ---                                                                                                                                                                                               
            Maximum                                                                                                                                                                                                     
            Subarray Sum**                                                                                                                                                                                              

         19 **Print              Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1/)         ---                                                                           [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/print-subarray-with-maximum-sum)
            Subarray with                                                                                                                                                                                               
            Maximum Sum**                                                                                                                                                                                               

         20 **Stock Buy and      Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1/)          [![Platform](../Images/gfg.png)](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)    [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/stock-buy-and-sell)
            Sell**                                                                                                                                                                                                      

         21 **Rearrange          Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1/)   [![Platform](../Images/gfg.png)](https://leetcode.com/problems/rearrange-array-elements-by-sign/)   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/rearrange-array-elements-by-sign)
            Array Elements                                                                                                                                                                                              
            by Sign**                                                                                                                                                                                                   

         22 **Next               Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/next-permutation5226/1/)                   [![Platform](../Images/gfg.png)](https://leetcode.com/problems/next-permutation/)                   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/next-permutation)
            Permutation**                                                                                                                                                                                               

         23 **Leaders in an      Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/)         ---                                                                           [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/leaders-in-an-array)
            Array**                                                                                                                                                                                                     

         24 **Longest            Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1/)    [![Platform](../Images/gfg.png)](https://leetcode.com/problems/longest-consecutive-sequence/)       [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/longest-consecutive-sequence)
            Consecutive                                                                                                                                                                                                 
            Sequence**                                                                                                                                                                                                  

         25 **Set Matrix         Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/set-matrix-zeroes/1/)                      [![Platform](../Images/gfg.png)](https://leetcode.com/problems/set-matrix-zeroes/)                  [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/set-matrix-zeroes)
            Zeroes**                                                                                                                                                                                                    

         26 **Rotate Matrix      Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1/)         [![Platform](../Images/gfg.png)](https://leetcode.com/problems/rotate-image/)                       [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/rotate-matrix-by-90-degrees)
            by 90 Degrees**                                                                                                                                                                                             

         27 **Print Matrix       Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/spiral-matrix-1587115621/1/)               [![Platform](../Images/gfg.png)](https://leetcode.com/problems/spiral-matrix/)                      [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/spiral-matrix)
            in Spiral                                                                                                                                                                                                   
            Manner**                                                                                                                                                                                                    

         28 **Count              Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1/)                   [![Platform](../Images/gfg.png)](https://leetcode.com/problems/subarray-sum-equals-k/)              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/count-subarrays-with-given-sum)
            Subarrays with                                                                                                                                                                                              
            Sum K**                                                                                                                                                                                                     
📌 Arrays --- Hard
         \# Problem           Difficulty    GFG                                                                                            LeetCode                                                              TUF
         29 **Pascal's          Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/pascal-triangle0652/1/)                      [![Platform](../Images/gfg.png)](https://leetcode.com/problems/pascals-triangle/)           [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/pascals-triangle)
            Triangle**                                                                                                                                                                                           

         30 **Majority           Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/majority-vote/1/)                            [![Platform](../Images/gfg.png)](https://leetcode.com/problems/majority-element-ii/)        [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/majority-element-ii)
            Element II (\>                                                                                                                                                                                       
            N/3)**                                                                                                                                                                                               

         31 **3 Sum**           Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1/)              [![Platform](../Images/gfg.png)](https://leetcode.com/problems/3sum/)                       [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/3-sum)

         32 **4 Sum**           Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1/)            [![Platform](../Images/gfg.png)](https://leetcode.com/problems/4sum/)                       [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/4-sum)

         33 **Largest            Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1/)              ---                                                                   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/largest-subarray-with-0-sum)
            Subarray with                                                                                                                                                                                        
            Sum 0**                                                                                                                                                                                              

         34 **Count              Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/count-the-subarrays-having-a-given-xor/1/)   ---                                                                   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/count-subarrays-with-xor-k)
            Subarrays with                                                                                                                                                                                       
            XOR K**                                                                                                                                                                                              

         35 **Merge             Medium      [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/overlapping-intervals-1587115620/1/)         [![Platform](../Images/gfg.png)](https://leetcode.com/problems/merge-intervals/)            [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/merge-overlapping-subintervals)
            Overlapping                                                                                                                                                                                          
            Intervals**                                                                                                                                                                                          

         36 **Merge Two          Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1/)       [![Platform](../Images/gfg.png)](https://leetcode.com/problems/merge-sorted-array/)         [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/merge-two-sorted-arrays-without-extra-space)
            Sorted Arrays                                                                                                                                                                                        
            Without Extra                                                                                                                                                                                        
            Space**                                                                                                                                                                                              

         37 **Find               Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/)           [![Platform](../Images/gfg.png)](https://leetcode.com/problems/set-mismatch/)               [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/find-the-repeating-and-missing-number)
            Repeating and                                                                                                                                                                                        
            Missing                                                                                                                                                                                              
            Number**                                                                                                                                                                                             

         38 **Count              Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1/)            ---                                                                   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/count-inversions)
            Inversions**                                                                                                                                                                                         

         39 **Reverse            Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/number-of-reverse-pairs/1/)                  [![Platform](../Images/gfg.png)](https://leetcode.com/problems/reverse-pairs/)              [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/reverse-pairs)
            Pairs**                                                                                                                                                                                              

         40 **Maximum            Hard       [![Platform](../Images/gfg.png)](https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1/)             [![Platform](../Images/gfg.png)](https://leetcode.com/problems/maximum-product-subarray/)   [![TUF](../Images/takeUforward.jpg)](https://takeuforward.org/practice/dsa/maximum-product-subarray)
            Product                                                                                                                                                                                              
            Subarray**                                                                                                                                                                                           
🧠 Recommended Practice Flow
Read the problem only.
Try the brute-force approach first.
Identify the pattern.
Write the optimal solution yourself in VS Code.
Dry-run at least one example.
Only then check the editorial/video if needed.
Quick Revision Checklist

Arrays Easy --- 14

Arrays Medium --- 14

Arrays Hard --- 12

Total --- 40

Related Resources
Official Striver A2Z DSA
Sheet
Take U Forward
LeetCode
GeeksforGeeks

Important: This list follows the classic Striver A2Z Arrays module
(14 Easy + 14 Medium + 12 Hard). TUF has continued to evolve the A2Z
curriculum, so newer versions of the sheet may contain additional or
reorganized material.
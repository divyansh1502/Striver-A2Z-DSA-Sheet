<div align="center">

![banner](https://capsule-render.vercel.app/api?type=waving&color=0:f97316,100:6366f1&height=180&section=header&text=Array%20Patterns%20in%20Java&fontSize=42&fontColor=ffffff&animation=fadeIn&desc=Spot%20the%20pattern%20%E2%86%92%20Eliminate%20the%20rest%20%E2%86%92%20Code%20it&descSize=16&descAlignY=72)

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="48" alt="java"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="40" alt="intellij"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/vscode/vscode-original.svg" width="40" alt="vscode"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="40" alt="git"/>

![DSA](https://img.shields.io/badge/DSA-Arrays-6366f1?style=for-the-badge&logo=leetcode&logoColor=white)
![Java](https://img.shields.io/badge/Code-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Patterns](https://img.shields.io/badge/Patterns-15-22c55e?style=for-the-badge)
![Level](https://img.shields.io/badge/Level-Beginner%20→%20Advanced-06b6d4?style=for-the-badge)

</div>

---

## 📑 Table of Contents

1. [The 5-Step Approach](#1-the-5-step-approach)
2. [Master Keyword Cheat Sheet](#2-master-keyword-cheat-sheet)
3. [Decision Flow](#3-decision-flow)
4. [The Patterns (Java code)](#4-the-patterns)
5. [Elimination Matrix](#5-elimination-matrix)
6. [What NOT to Look At (Traps)](#6-what-not-to-look-at-traps)
7. [Complexity Targets from Constraints](#7-complexity-targets-from-constraints)
8. [Practice List](#8-practice-list)

> Imports used in snippets: `import java.util.*;`

---

## 1. The 5-Step Approach

<img src="https://img.shields.io/badge/STEP-1-6366f1?style=flat-square"/> **Read the constraints first.** `n` tells you the allowed complexity (see section 7).

<img src="https://img.shields.io/badge/STEP-2-6366f1?style=flat-square"/> **Classify the output.** Do you need a *value*, an *index/pair*, a *count*, a *subarray*, a *subsequence*, or a *modified array*?

<img src="https://img.shields.io/badge/STEP-3-6366f1?style=flat-square"/> **Ask 4 property questions:**
- Is the array **sorted** (or can I sort it without breaking the answer)?
- Is it **contiguous** (subarray) or **any elements** (subsequence/subset)?
- Are values **bounded** (`1..n`, small range, only 0/1/2)?
- Can there be **negatives**? (kills many sliding-window ideas)

<img src="https://img.shields.io/badge/STEP-4-6366f1?style=flat-square"/> **Write the brute force in one line of thought** (usually O(n²) or O(n³)). Find the *repeated work*. The pattern removes that repeated work.

<img src="https://img.shields.io/badge/STEP-5-6366f1?style=flat-square"/> **Dry-run on a tiny example + edge cases** (empty, single element, all same, all negative, duplicates).

> 💡 **Golden rule:** *Brute force → find repeated work → pick the pattern that caches/skips it.*

---

## 2. Master Keyword Cheat Sheet

| 🔎 Keyword / Phrase in problem | 🎯 Likely Pattern |
|---|---|
| "sorted array", "pair/triplet with sum" | Two Pointers |
| "reverse", "palindrome", "remove duplicates in-place", "move zeroes" | Two Pointers (same direction) |
| "contiguous subarray of size k", "max/min sum of k elements" | Fixed Sliding Window |
| "longest/shortest subarray with condition", "at most k distinct" | Variable Sliding Window |
| "subarray sum equals k", "range sum query", "sum between i and j" | Prefix Sum (+ HashMap) |
| "count of subarrays with sum / xor / divisible by k" | Prefix Sum + HashMap |
| "two sum", "duplicate", "frequency", "anagram", "first unique" | Hashing |
| "maximum subarray", "best contiguous sum" | Kadane's |
| "next greater / smaller element", "stock span", "histogram" | Monotonic Stack |
| "sliding window maximum" | Monotonic Deque |
| "numbers in range `1..n`", "missing / duplicate number", O(1) space | Cyclic Sort / Index as Hash |
| "sort 0s 1s 2s", "partition around pivot" | Dutch National Flag |
| "merge intervals", "overlapping", "meeting rooms" | Sort + Intervals |
| "minimum maximum", "capacity", "ship in D days", "split array" | Binary Search on Answer |
| "rotated sorted array", "find peak", "search in sorted" | Binary Search |
| "kth largest", "top K frequent", "k closest" | Heap (PriorityQueue) / Quickselect |
| "majority element (> n/2)" | Boyer-Moore Voting |
| "maximize / minimize with choices", "can't pick adjacent" | DP |
| "all subsets / permutations / combinations" | Backtracking |
| "product except self", "left & right info needed" | Prefix + Suffix arrays |
| "range update (add x to l..r)" | Difference Array |
| "rotate array by k" | Reverse trick (3 reversals) |
| "spiral", "rotate matrix", "search in matrix" | Matrix traversal / boundary |

---

## 3. Decision Flow

```
START
 │
 ├─ Need ALL combinations / subsets / permutations? ─────────► BACKTRACKING
 │
 ├─ Is it a SUBARRAY (contiguous)?
 │    ├─ All values positive / condition is monotonic? ──────► SLIDING WINDOW
 │    ├─ Negatives allowed + "sum == k" ─────────────────────► PREFIX SUM + HASHMAP
 │    ├─ "max sum subarray" ─────────────────────────────────► KADANE
 │    └─ Range queries repeated ─────────────────────────────► PREFIX SUM
 │
 ├─ Is array SORTED (or sortable w/o losing info)?
 │    ├─ Pair / triplet / closest sum ───────────────────────► TWO POINTERS
 │    ├─ Search a value / boundary ──────────────────────────► BINARY SEARCH
 │    ├─ "min of max" / "max of min" ────────────────────────► BINARY SEARCH ON ANSWER
 │    └─ Intervals ──────────────────────────────────────────► SORT + MERGE
 │
 ├─ Values in range 1..n and O(1) space? ────────────────────► CYCLIC SORT
 │
 ├─ Need "next greater/smaller"? ────────────────────────────► MONOTONIC STACK
 │
 ├─ Need lookup / count / existence fast? ───────────────────► HASHMAP / HASHSET
 │
 ├─ Top K / Kth? ────────────────────────────────────────────► HEAP
 │
 └─ Optimal value w/ overlapping choices? ───────────────────► DP
```

---

## 4. The Patterns

### 🟣 Pattern 1: Two Pointers

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Variants**
- **Opposite ends** (`l = 0`, `r = n-1`) → sorted array, pair sum, palindrome, container with most water.
- **Same direction** (slow/fast or read/write) → remove duplicates, move zeroes, partition.

**✅ See:** sorted input, "pair", "triplet", "in-place", "O(1) extra space".
**❌ Don't see:** unsorted + must keep original indices (use HashMap instead).

**Template**
```java
int l = 0, r = a.length - 1;
while (l < r) {
    int s = a[l] + a[r];
    if (s == target) { /* found */ }
    else if (s < target) l++;     // need bigger sum
    else r--;                     // need smaller sum
}
```

**Example: Two Sum II (sorted)**
```java
public int[] twoSumSorted(int[] a, int target) {
    int l = 0, r = a.length - 1;
    while (l < r) {
        int s = a[l] + a[r];
        if (s == target) return new int[]{l + 1, r + 1};
        if (s < target) l++;
        else r--;
    }
    return new int[]{};
}
```

**Example: Move Zeroes (same direction)**
```java
public void moveZeroes(int[] a) {
    int w = 0;                                   // write pointer
    for (int x : a) {
        if (x != 0) a[w++] = x;
    }
    while (w < a.length) a[w++] = 0;
}
```

**Example: 3Sum (sort + two pointers)**
```java
public List<List<Integer>> threeSum(int[] a) {
    Arrays.sort(a);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < a.length - 2; i++) {
        if (i > 0 && a[i] == a[i - 1]) continue;         // skip duplicate anchor
        int l = i + 1, r = a.length - 1;
        while (l < r) {
            int s = a[i] + a[l] + a[r];
            if (s == 0) {
                res.add(Arrays.asList(a[i], a[l], a[r]));
                l++;
                while (l < r && a[l] == a[l - 1]) l++;   // skip duplicate
                r--;
            } else if (s < 0) l++;
            else r--;
        }
    }
    return res;
}
```

---

### 🟢 Pattern 2: Sliding Window

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)%20or%20O(k)-22c55e?style=flat-square)

**Core idea:** Instead of recomputing a subarray, **add the new element, remove the old one.**

**✅ See:** "contiguous", "subarray/substring", "longest/shortest", "at most k", "window of size k".
**❌ Don't see:** negative numbers with a "sum ≥ target" goal (window not monotonic) → use Prefix Sum + HashMap.

**Fixed window**
```java
public int maxSumK(int[] a, int k) {
    int cur = 0;
    for (int i = 0; i < k; i++) cur += a[i];
    int best = cur;
    for (int i = k; i < a.length; i++) {
        cur += a[i] - a[i - k];                  // slide
        best = Math.max(best, cur);
    }
    return best;
}
```

**Variable window template**
```java
int l = 0;
for (int r = 0; r < a.length; r++) {
    // 1. add a[r] to window state
    while (/* window is invalid */) {
        // 2. remove a[l] from window state
        l++;
    }
    // 3. update answer using (r - l + 1)
}
```

**Example: Minimum Size Subarray Sum (positives only)**
```java
public int minSubArrayLen(int target, int[] a) {
    int l = 0, cur = 0, best = Integer.MAX_VALUE;
    for (int r = 0; r < a.length; r++) {
        cur += a[r];
        while (cur >= target) {
            best = Math.min(best, r - l + 1);
            cur -= a[l++];
        }
    }
    return best == Integer.MAX_VALUE ? 0 : best;
}
```

**Example: Longest Subarray with at most K distinct**
```java
public int longestKDistinct(int[] a, int k) {
    Map<Integer, Integer> cnt = new HashMap<>();
    int l = 0, best = 0;
    for (int r = 0; r < a.length; r++) {
        cnt.merge(a[r], 1, Integer::sum);
        while (cnt.size() > k) {
            int left = a[l++];
            if (cnt.merge(left, -1, Integer::sum) == 0) cnt.remove(left);
        }
        best = Math.max(best, r - l + 1);
    }
    return best;
}
```

---

### 🔵 Pattern 3: Prefix Sum (+ HashMap)

![](https://img.shields.io/badge/Build-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Query-O(1)-22c55e?style=flat-square)

**Core idea:** `sum(i..j) = prefix[j+1] - prefix[i]`.
If `prefix[j] - prefix[i] == k` → `prefix[i] = prefix[j] - k` → **look it up in a HashMap**.

**✅ See:** "subarray sum equals k", "range sum", "count subarrays", **negatives allowed**, xor/mod variants.
**❌ Don't see:** sliding window fails here when negatives exist.

```java
int[] prefix = new int[a.length + 1];
for (int i = 0; i < a.length; i++) prefix[i + 1] = prefix[i] + a[i];
int rangeSum = prefix[j + 1] - prefix[i];         // sum of a[i..j]
```

**Example: Subarray Sum Equals K**
```java
public int subarraySum(int[] a, int k) {
    Map<Integer, Integer> seen = new HashMap<>();
    seen.put(0, 1);                               // empty prefix
    int cur = 0, count = 0;
    for (int x : a) {
        cur += x;
        count += seen.getOrDefault(cur - k, 0);   // earlier prefix that completes k
        seen.merge(cur, 1, Integer::sum);
    }
    return count;
}
```

**Example: Product of Array Except Self (prefix × suffix)**
```java
public int[] productExceptSelf(int[] a) {
    int n = a.length;
    int[] res = new int[n];
    int left = 1;
    for (int i = 0; i < n; i++) {
        res[i] = left;
        left *= a[i];
    }
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        res[i] *= right;
        right *= a[i];
    }
    return res;
}
```

**Difference Array (range updates)**
```java
public int[] applyUpdates(int n, int[][] updates) {     // updates = {l, r, val}
    int[] diff = new int[n + 1];
    for (int[] u : updates) {
        diff[u[0]] += u[2];
        diff[u[1] + 1] -= u[2];
    }
    int[] res = new int[n];
    int cur = 0;
    for (int i = 0; i < n; i++) {
        cur += diff[i];
        res[i] = cur;
    }
    return res;
}
```

---

### 🟡 Pattern 4: Hashing (HashMap / HashSet)

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(n)-f59e0b?style=flat-square)

**Core idea:** Trade space for O(1) lookup. Store *what you've seen* or *what you need*.

**✅ See:** "two sum" (unsorted), "duplicates", "frequency", "exists", "longest consecutive".
**❌ Don't see:** strict O(1) space → try sorting, two pointers, cyclic sort.

**Example: Two Sum (unsorted)**
```java
public int[] twoSum(int[] a, int target) {
    Map<Integer, Integer> seen = new HashMap<>();       // value -> index
    for (int i = 0; i < a.length; i++) {
        int need = target - a[i];
        if (seen.containsKey(need)) return new int[]{seen.get(need), i};
        seen.put(a[i], i);
    }
    return new int[]{};
}
```

**Example: Longest Consecutive Sequence**
```java
public int longestConsecutive(int[] a) {
    Set<Integer> set = new HashSet<>();
    for (int x : a) set.add(x);
    int best = 0;
    for (int x : set) {
        if (!set.contains(x - 1)) {                      // start of a run only
            int y = x;
            while (set.contains(y + 1)) y++;
            best = Math.max(best, y - x + 1);
        }
    }
    return best;
}
```

---

### 🔴 Pattern 5: Kadane's Algorithm

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** At each index, either **extend** the previous subarray or **start fresh**.

**✅ See:** "maximum sum contiguous subarray", "best profit window".
**❌ Don't see:** "exactly k elements" (sliding window) or "non-contiguous" (DP).

```java
public int maxSubArray(int[] a) {
    int cur = a[0], best = a[0];
    for (int i = 1; i < a.length; i++) {
        cur = Math.max(a[i], cur + a[i]);
        best = Math.max(best, cur);
    }
    return best;
}
```

**Variant: Max Product Subarray** (track both max & min, negatives flip)
```java
public int maxProduct(int[] a) {
    int mx = a[0], mn = a[0], best = a[0];
    for (int i = 1; i < a.length; i++) {
        if (a[i] < 0) { int t = mx; mx = mn; mn = t; }
        mx = Math.max(a[i], mx * a[i]);
        mn = Math.min(a[i], mn * a[i]);
        best = Math.max(best, mx);
    }
    return best;
}
```

---

### 🟠 Pattern 6: Binary Search (index & answer space)

![](https://img.shields.io/badge/Time-O(log%20n)-22c55e?style=flat-square)

**Two flavours**
1. **On array:** sorted / rotated sorted / peak.
2. **On answer:** answer lies in `[lo, hi]` and a `feasible(mid)` check is monotonic.

**✅ See:** "sorted", "rotated", "minimize the maximum", "maximize the minimum", "smallest x such that...".

**Template (find first true)**
```java
int lo = LOW, hi = HIGH;
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;          // avoids overflow
    if (feasible(mid)) hi = mid;
    else lo = mid + 1;
}
return lo;
```

**Example: Search in Rotated Sorted Array**
```java
public int search(int[] a, int t) {
    int l = 0, r = a.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (a[m] == t) return m;
        if (a[l] <= a[m]) {                          // left half sorted
            if (a[l] <= t && t < a[m]) r = m - 1;
            else l = m + 1;
        } else {                                     // right half sorted
            if (a[m] < t && t <= a[r]) l = m + 1;
            else r = m - 1;
        }
    }
    return -1;
}
```

**Example: Capacity to Ship Packages in D Days (on answer)**
```java
public int shipWithinDays(int[] w, int D) {
    int lo = 0, hi = 0;
    for (int x : w) { lo = Math.max(lo, x); hi += x; }
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (canShip(w, D, mid)) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}

private boolean canShip(int[] w, int D, int cap) {
    int days = 1, load = 0;
    for (int x : w) {
        if (load + x > cap) { days++; load = 0; }
        load += x;
    }
    return days <= D;
}
```

---

### 🟤 Pattern 7: Monotonic Stack / Deque

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(n)-f59e0b?style=flat-square)

**Core idea:** Keep a stack in sorted order; each element is pushed/popped once.

**✅ See:** "next greater", "previous smaller", "days until warmer", "largest rectangle", "trapping water".

**Example: Next Greater Element**
```java
public int[] nextGreater(int[] a) {
    int n = a.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);
    Deque<Integer> st = new ArrayDeque<>();            // stores indices
    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && a[st.peek()] < a[i]) {
            res[st.pop()] = a[i];
        }
        st.push(i);
    }
    return res;
}
```

**Example: Sliding Window Maximum (deque)**
```java
public int[] maxSlidingWindow(int[] a, int k) {
    int n = a.length;
    int[] res = new int[n - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();            // indices, values decreasing
    for (int i = 0; i < n; i++) {
        while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) dq.pollLast();
        dq.offerLast(i);
        if (dq.peekFirst() <= i - k) dq.pollFirst();   // out of window
        if (i >= k - 1) res[i - k + 1] = a[dq.peekFirst()];
    }
    return res;
}
```

---

### ⚪ Pattern 8: Cyclic Sort / Index as Hash

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** If values are in `1..n`, value `x` belongs at index `x-1`. Swap until placed.

**✅ See:** "range 1 to n", "missing number", "duplicate number", "first missing positive", "no extra space".
**❌ Don't see:** arbitrary or huge value ranges.

```java
public void cyclicSort(int[] a) {
    int i = 0;
    while (i < a.length) {
        int j = a[i] - 1;
        if (a[i] != a[j]) swap(a, i, j);
        else i++;
    }
}

private void swap(int[] a, int i, int j) {
    int t = a[i]; a[i] = a[j]; a[j] = t;
}
```

**Example: Find All Duplicates (index marking)**
```java
public List<Integer> findDuplicates(int[] a) {
    List<Integer> res = new ArrayList<>();
    for (int x : a) {
        int idx = Math.abs(x) - 1;
        if (a[idx] < 0) res.add(Math.abs(x));
        else a[idx] = -a[idx];                           // mark visited
    }
    return res;
}
```

**Example: First Missing Positive**
```java
public int firstMissingPositive(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
        while (a[i] >= 1 && a[i] <= n && a[a[i] - 1] != a[i]) {
            swap(a, i, a[i] - 1);
        }
    }
    for (int i = 0; i < n; i++) {
        if (a[i] != i + 1) return i + 1;
    }
    return n + 1;
}
```

---

### 🟪 Pattern 9: Dutch National Flag / In-place Partition

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**✅ See:** "sort colors", "only 0,1,2", "partition by pivot".

```java
public void sortColors(int[] a) {
    int lo = 0, mid = 0, hi = a.length - 1;
    while (mid <= hi) {
        if (a[mid] == 0) swap(a, lo++, mid++);
        else if (a[mid] == 1) mid++;
        else swap(a, mid, hi--);          // don't move mid: swapped-in value unchecked
    }
}
```

---

### 🟩 Pattern 10: Sort + Intervals

![](https://img.shields.io/badge/Time-O(n%20log%20n)-f59e0b?style=flat-square)

**✅ See:** "merge", "overlap", "insert interval", "minimum rooms/platforms", "non-overlapping".

```java
public int[][] merge(int[][] iv) {
    Arrays.sort(iv, (x, y) -> Integer.compare(x[0], y[0]));
    List<int[]> res = new ArrayList<>();
    res.add(iv[0]);
    for (int i = 1; i < iv.length; i++) {
        int[] last = res.get(res.size() - 1);
        if (iv[i][0] <= last[1]) last[1] = Math.max(last[1], iv[i][1]);
        else res.add(iv[i]);
    }
    return res.toArray(new int[0][]);
}
```

---

### 🟧 Pattern 11: Boyer-Moore Voting

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**✅ See:** "element appears more than n/2 times" (n/3 → two candidates).

```java
public int majorityElement(int[] a) {
    int cand = 0, cnt = 0;
    for (int x : a) {
        if (cnt == 0) cand = x;
        cnt += (x == cand) ? 1 : -1;
    }
    return cand;          // verify with a second pass if majority isn't guaranteed
}
```

---

### 🟥 Pattern 12: Heap / Top-K

![](https://img.shields.io/badge/Time-O(n%20log%20k)-f59e0b?style=flat-square)

**✅ See:** "kth largest/smallest", "top K frequent", "k closest", "merge k sorted".

```java
public int findKthLargest(int[] a, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();   // size k
    for (int x : a) {
        minHeap.offer(x);
        if (minHeap.size() > k) minHeap.poll();
    }
    return minHeap.peek();
}
```

---

### 🟦 Pattern 13: Dynamic Programming on Arrays

**✅ See:** "maximum/minimum/count ways", "can't take adjacent", "choice at each index", overlapping subproblems.

**Example: House Robber**
```java
public int rob(int[] a) {
    int prev = 0, cur = 0;
    for (int x : a) {
        int next = Math.max(cur, prev + x);
        prev = cur;
        cur = next;
    }
    return cur;
}
```

**Example: Longest Increasing Subsequence (O(n log n))**
```java
public int lengthOfLIS(int[] a) {
    int[] tails = new int[a.length];
    int size = 0;
    for (int x : a) {
        int lo = 0, hi = size;
        while (lo < hi) {                       // first tail >= x
            int mid = (lo + hi) >>> 1;
            if (tails[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        tails[lo] = x;
        if (lo == size) size++;
    }
    return size;
}
```

---

### 🟫 Pattern 14: Backtracking (Subsets / Permutations)

**✅ See:** "all possible", "generate every", small `n` (≤ 15–20).

```java
public List<List<Integer>> subsets(int[] a) {
    List<List<Integer>> res = new ArrayList<>();
    go(a, 0, new ArrayList<>(), res);
    return res;
}

private void go(int[] a, int i, List<Integer> path, List<List<Integer>> res) {
    if (i == a.length) {
        res.add(new ArrayList<>(path));         // copy, not reference
        return;
    }
    go(a, i + 1, path, res);                    // skip
    path.add(a[i]);
    go(a, i + 1, path, res);                    // take
    path.remove(path.size() - 1);               // undo
}
```

---

### ⬛ Pattern 15: Array Tricks (Rotate / Matrix)

**Rotate array by k: 3 reversals**
```java
public void rotate(int[] a, int k) {
    int n = a.length;
    k %= n;
    reverse(a, 0, n - 1);
    reverse(a, 0, k - 1);
    reverse(a, k, n - 1);
}

private void reverse(int[] a, int l, int r) {
    while (l < r) swap(a, l++, r--);
}
```

**Rotate matrix 90° clockwise: transpose + reverse rows**
```java
public void rotateMatrix(int[][] m) {
    int n = m.length;
    for (int i = 0; i < n; i++)
        for (int j = i + 1; j < n; j++) {
            int t = m[i][j]; m[i][j] = m[j][i]; m[j][i] = t;
        }
    for (int[] row : m) reverse(row, 0, n - 1);
}
```

---

## 5. Elimination Matrix

> Use this to **kill wrong patterns in 10 seconds.**

| Question | If YES → | If NO → eliminate |
|---|---|---|
| Is it **contiguous**? | Window / Prefix / Kadane | ❌ Sliding Window, Kadane, Prefix. Think Hash / DP / Backtracking / Greedy |
| Is the array **sorted**? | Two Pointers / Binary Search | ❌ Two Pointers (opposite) & Binary Search, unless sorting is allowed |
| Can I **sort** without losing index info? | Sort + Greedy / Two Pointers | ❌ Sorting. Use Hash |
| Are there **negatives**? | Prefix + Hash, Kadane | ❌ Sliding Window for "sum ≥ / = target" |
| Values in **`1..n`**? | Cyclic Sort / Index Hash | ❌ Cyclic Sort |
| Need **O(1) space**? | Two Pointers, Cyclic, Kadane, Voting | ❌ Hash / extra array approaches |
| Need **all** answers listed? | Backtracking | ❌ DP / Greedy (they give one optimal value) |
| Need **one optimal value**? | DP / Greedy / Binary Search on Answer | ❌ Backtracking (too slow) |
| Is the answer **monotonic** in some parameter? | Binary Search on Answer | ❌ Binary Search |
| "**Next** greater / smaller" asked? | Monotonic Stack | ❌ Brute nested loops |
| "**Top K**" asked? | Heap | ❌ Full sort when `k << n` |

### Quick elimination by problem type

| If the problem says... | Eliminate | Keep |
|---|---|---|
| "subarray sum == k" **with negatives** | Sliding Window, Two Pointers | Prefix + HashMap |
| "subarray sum ≥ target" **positives only** | Prefix + Hash | Sliding Window |
| "pair with sum" **unsorted, need indices** | Two Pointers | HashMap |
| "pair with sum" **sorted** | HashMap (extra space) | Two Pointers |
| "max sum, **exactly k** elements" | Kadane | Fixed Sliding Window |
| "max sum, **any length**" | Sliding Window | Kadane |
| "kth largest" | Full sort (if n is large) | PriorityQueue / Quickselect |
| "**subsequence**" (not contiguous) | Sliding Window, Kadane | DP / Greedy / Backtracking |

---

## 6. What NOT to Look At (Traps)

| ⚠️ Trap | Why it misleads you |
|---|---|
| The **story / theme** of the problem (stocks, houses, ships) | It's decoration. Look at the **operation** (sum? count? max? contiguous?). |
| **Example input only** | Examples are often sorted/positive; constraints may allow negatives, duplicates, empties. |
| **Array size in the example** | Only the constraint `n ≤ 10^5` matters, not `n = 6` in the example. |
| Jumping to **sorting** instantly | Sorting destroys index/order → breaks subarray & index-return problems. |
| Using **sliding window with negatives** | Window sum is no longer monotonic → wrong answers. |
| Using **HashMap** when O(1) space is demanded | Violates constraint; look for Two Pointers / Cyclic / Voting. |
| **Overthinking DP** | If a greedy or single pass gives the answer, DP is unnecessary. |
| Ignoring **duplicates** | 3Sum, subsets, permutations need explicit duplicate skipping. |
| **`int` overflow** | Sums/products can exceed ~2.1×10⁹. Use `long`, and `lo + (hi - lo) / 2` for mid. |
| Off-by-one in **`while (l < r)` vs `l <= r`** | `<` for pairs; `<=` for single-element binary search checks. |
| **`Arrays.asList` / `int[]` in generics** | `List<int[]>` is fine; `List<int>` is not. Use `Integer`. |
| Comparing `Integer` with `==` | Use `.equals()` for boxed values outside −128..127. |

---

## 7. Complexity Targets from Constraints

| n (max) | Target | Think |
|---|---|---|
| ≤ 10 | O(n!) | Permutations, Backtracking |
| ≤ 20 | O(2ⁿ) | Subsets, Bitmask |
| ≤ 500 | O(n³) | Triple loop / Floyd-style DP |
| ≤ 5,000 | O(n²) | Nested loops, 2D DP |
| ≤ 10⁵ | O(n log n) | Sort, Heap, Binary Search, Segment Tree |
| ≤ 10⁶ | O(n) | Two Pointers, Window, Prefix, Hash, Stack |
| ≤ 10⁹ | O(log n) / O(1) | Binary Search, Math |

---

## 8. Practice List

| # | Problem | Pattern | Difficulty |
|---|---|---|---|
| 1 | Two Sum | Hashing | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 2 | Best Time to Buy & Sell Stock | Kadane-style / Greedy | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 3 | Move Zeroes | Two Pointers | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 4 | Majority Element | Boyer-Moore | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 5 | Maximum Subarray | Kadane | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 6 | Subarray Sum Equals K | Prefix + Hash | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 7 | 3Sum | Sort + Two Pointers | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 8 | Container With Most Water | Two Pointers | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 9 | Product of Array Except Self | Prefix/Suffix | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 10 | Sort Colors | Dutch Flag | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 11 | Merge Intervals | Sort + Intervals | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 12 | Search in Rotated Sorted Array | Binary Search | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 13 | Find All Duplicates in Array | Cyclic / Index Hash | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 14 | Longest Consecutive Sequence | HashSet | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 15 | Min Size Subarray Sum | Variable Window | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 16 | Capacity to Ship Packages | Binary Search on Answer | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 17 | Daily Temperatures | Monotonic Stack | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 18 | Kth Largest Element | PriorityQueue | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 19 | House Robber | DP | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 20 | First Missing Positive | Cyclic Sort | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 21 | Sliding Window Maximum | Monotonic Deque | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 22 | Trapping Rain Water | Two Pointers / Stack | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 23 | Largest Rectangle in Histogram | Monotonic Stack | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |

---

## 🧠 One-Line Memory Hooks

```
Sorted + pair            →  Two Pointers
Contiguous + positives   →  Sliding Window
Contiguous + negatives   →  Prefix Sum + HashMap
Max contiguous sum       →  Kadane
Lookup / count / seen    →  HashMap / HashSet
1..n + O(1) space        →  Cyclic Sort
Next greater / smaller   →  Monotonic Stack (ArrayDeque)
Min-of-max / max-of-min  →  Binary Search on Answer
Top K / Kth              →  PriorityQueue
All possibilities        →  Backtracking
Best with choices        →  DP
```

<div align="center">

![footer](https://capsule-render.vercel.app/api?type=waving&color=0:6366f1,100:f97316&height=100&section=footer)

**Happy coding in Java! ☕🚀**

</div>
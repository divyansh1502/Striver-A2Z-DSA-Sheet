<div align="center">

![banner](https://capsule-render.vercel.app/api?type=waving&color=0:6366f1,100:06b6d4&height=180&section=header&text=Array%20Patterns%20Playbook&fontSize=42&fontColor=ffffff&animation=fadeIn&desc=Spot%20the%20pattern%20%E2%86%92%20Eliminate%20the%20rest%20%E2%86%92%20Code%20it&descSize=16&descAlignY=72)

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/python/python-original.svg" width="40" alt="python"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/cplusplus/cplusplus-original.svg" width="40" alt="cpp"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" alt="java"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" width="40" alt="js"/>

![DSA](https://img.shields.io/badge/DSA-Arrays-6366f1?style=for-the-badge&logo=leetcode&logoColor=white)
![Level](https://img.shields.io/badge/Level-Beginner%20→%20Advanced-06b6d4?style=for-the-badge)
![Patterns](https://img.shields.io/badge/Patterns-15-22c55e?style=for-the-badge)
![Lang](https://img.shields.io/badge/Code-Python-3776AB?style=for-the-badge&logo=python&logoColor=white)

</div>

---

## 📑 Table of Contents

1. [The 5-Step Approach (for ANY array problem)](#1-the-5-step-approach)
2. [Master Keyword Cheat Sheet](#2-master-keyword-cheat-sheet)
3. [Decision Flow: Which Pattern?](#3-decision-flow)
4. [The Patterns (with examples)](#4-the-patterns)
5. [Elimination Matrix: Rule Patterns Out Fast](#5-elimination-matrix)
6. [What NOT to Look At (Traps)](#6-what-not-to-look-at-traps)
7. [Complexity Targets from Constraints](#7-complexity-targets-from-constraints)
8. [Practice List](#8-practice-list)

---

## 1. The 5-Step Approach

<img src="https://img.shields.io/badge/STEP-1-6366f1?style=flat-square"/> **Read the constraints first.** `n` tells you the allowed complexity (see section 7).

<img src="https://img.shields.io/badge/STEP-2-6366f1?style=flat-square"/> **Classify the output.** Do you need: a *value*, an *index/pair*, a *count*, a *subarray*, a *subsequence*, or a *modified array*?

<img src="https://img.shields.io/badge/STEP-3-6366f1?style=flat-square"/> **Ask 4 property questions:**
- Is the array **sorted** (or can I sort it without breaking the answer)?
- Is it **contiguous** (subarray) or **any elements** (subsequence/subset)?
- Are values **bounded** (`1..n`, small range, only 0/1/2)?
- Can there be **negatives**? (kills many sliding-window ideas)

<img src="https://img.shields.io/badge/STEP-4-6366f1?style=flat-square"/> **Write brute force in 1 line of thought** (usually O(n²) or O(n³)). Find the *repeated work*. The pattern removes that repeated work.

<img src="https://img.shields.io/badge/STEP-5-6366f1?style=flat-square"/> **Dry-run on a tiny example + an edge case** (empty, single element, all same, all negative, duplicates).

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
| "kth largest", "top K frequent", "k closest" | Heap / Quickselect |
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
 ├─ Need lookup / count / existence fast? ───────────────────► HASHMAP / SET
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
- **Same direction** (slow/fast) → remove duplicates, move zeroes, partition.

**✅ See:** sorted input, "pair", "triplet", "in-place", "O(1) extra space".
**❌ Don't see:** unsorted + must keep original indices (use hashmap instead).

**Template**
```python
l, r = 0, len(a) - 1
while l < r:
    s = a[l] + a[r]
    if s == target: ...          # found
    elif s < target: l += 1      # need bigger
    else: r -= 1                 # need smaller
```

**Example: Two Sum II (sorted)**
```python
def two_sum_sorted(a, target):
    l, r = 0, len(a) - 1
    while l < r:
        s = a[l] + a[r]
        if s == target:
            return [l + 1, r + 1]
        if s < target:
            l += 1
        else:
            r -= 1
    return []
```

**Example: Move Zeroes (same direction)**
```python
def move_zeroes(a):
    w = 0                        # write pointer
    for x in a:
        if x != 0:
            a[w] = x
            w += 1
    while w < len(a):
        a[w] = 0
        w += 1
```

**Example: 3Sum (sort + two pointers)**
```python
def three_sum(a):
    a.sort()
    res = []
    for i in range(len(a) - 2):
        if i > 0 and a[i] == a[i - 1]:
            continue                         # skip duplicate anchor
        l, r = i + 1, len(a) - 1
        while l < r:
            s = a[i] + a[l] + a[r]
            if s == 0:
                res.append([a[i], a[l], a[r]])
                l += 1
                while l < r and a[l] == a[l - 1]:
                    l += 1
                r -= 1
            elif s < 0:
                l += 1
            else:
                r -= 1
    return res
```

---

### 🟢 Pattern 2: Sliding Window

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)%20or%20O(k)-22c55e?style=flat-square)

**Core idea:** Instead of recomputing a subarray, **add the new element, remove the old one.**

**✅ See:** "contiguous", "subarray/substring", "longest/shortest", "at most k", "window of size k".
**❌ Don't see:** negative numbers with a "sum ≥ target" goal (window is not monotonic) → use Prefix Sum + HashMap.

**Fixed window**
```python
def max_sum_k(a, k):
    cur = sum(a[:k])
    best = cur
    for i in range(k, len(a)):
        cur += a[i] - a[i - k]       # slide
        best = max(best, cur)
    return best
```

**Variable window template**
```python
l = 0
for r in range(len(a)):
    # 1. add a[r] to window state
    while window_is_invalid():
        # 2. remove a[l] from window state
        l += 1
    # 3. update answer with (r - l + 1)
```

**Example: Minimum Size Subarray Sum (positives only)**
```python
def min_subarray_len(target, a):
    l = cur = 0
    best = float('inf')
    for r, x in enumerate(a):
        cur += x
        while cur >= target:
            best = min(best, r - l + 1)
            cur -= a[l]
            l += 1
    return 0 if best == float('inf') else best
```

**Example: Longest Subarray with at most K distinct**
```python
from collections import defaultdict

def longest_k_distinct(a, k):
    cnt = defaultdict(int)
    l = best = 0
    for r, x in enumerate(a):
        cnt[x] += 1
        while len(cnt) > k:
            cnt[a[l]] -= 1
            if cnt[a[l]] == 0:
                del cnt[a[l]]
            l += 1
        best = max(best, r - l + 1)
    return best
```

---

### 🔵 Pattern 3: Prefix Sum (+ HashMap)

![](https://img.shields.io/badge/Build-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Query-O(1)-22c55e?style=flat-square)

**Core idea:** `sum(i..j) = prefix[j+1] - prefix[i]`.
If `prefix[j] - prefix[i] == k` → `prefix[i] = prefix[j] - k` → **look it up in a HashMap**.

**✅ See:** "subarray sum equals k", "range sum", "count subarrays", **negatives allowed**, xor/mod variants.
**❌ Don't see:** sliding window won't work here when negatives exist.

```python
prefix = [0] * (len(a) + 1)
for i, x in enumerate(a):
    prefix[i + 1] = prefix[i] + x
range_sum = prefix[j + 1] - prefix[i]
```

**Example: Subarray Sum Equals K**
```python
from collections import defaultdict

def subarray_sum(a, k):
    seen = defaultdict(int)
    seen[0] = 1                      # empty prefix
    cur = count = 0
    for x in a:
        cur += x
        count += seen[cur - k]       # earlier prefix that completes k
        seen[cur] += 1
    return count
```

**Example: Product of Array Except Self (prefix × suffix)**
```python
def product_except_self(a):
    n = len(a)
    res = [1] * n
    left = 1
    for i in range(n):
        res[i] = left
        left *= a[i]
    right = 1
    for i in range(n - 1, -1, -1):
        res[i] *= right
        right *= a[i]
    return res
```

**Difference Array (range updates)**
```python
def apply_updates(n, updates):       # updates = [(l, r, val)]
    diff = [0] * (n + 1)
    for l, r, v in updates:
        diff[l] += v
        diff[r + 1] -= v
    res, cur = [], 0
    for i in range(n):
        cur += diff[i]
        res.append(cur)
    return res
```

---

### 🟡 Pattern 4: Hashing (Map / Set)

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(n)-f59e0b?style=flat-square)

**Core idea:** Trade space for O(1) lookup. Store *what you've seen* or *what you need*.

**✅ See:** "two sum" (unsorted), "duplicates", "frequency", "exists", "longest consecutive".
**❌ Don't see:** strict O(1) space requirement → try sorting, two pointers, or cyclic sort.

**Example: Two Sum (unsorted)**
```python
def two_sum(a, target):
    seen = {}
    for i, x in enumerate(a):
        if target - x in seen:
            return [seen[target - x], i]
        seen[x] = i
```

**Example: Longest Consecutive Sequence**
```python
def longest_consecutive(a):
    s = set(a)
    best = 0
    for x in s:
        if x - 1 not in s:           # start of a run only
            y = x
            while y + 1 in s:
                y += 1
            best = max(best, y - x + 1)
    return best
```

---

### 🔴 Pattern 5: Kadane's Algorithm

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** At each index, either **extend** the previous subarray or **start fresh**.

**✅ See:** "maximum sum contiguous subarray", "best profit window".
**❌ Don't see:** "exactly k elements" (sliding window) or "non-contiguous" (DP).

```python
def max_subarray(a):
    cur = best = a[0]
    for x in a[1:]:
        cur = max(x, cur + x)
        best = max(best, cur)
    return best
```

**Variant: Max Product Subarray** (track both max & min because negatives flip)
```python
def max_product(a):
    mx = mn = best = a[0]
    for x in a[1:]:
        if x < 0:
            mx, mn = mn, mx
        mx = max(x, mx * x)
        mn = min(x, mn * x)
        best = max(best, mx)
    return best
```

---

### 🟠 Pattern 6: Binary Search (index & answer space)

![](https://img.shields.io/badge/Time-O(log%20n)-22c55e?style=flat-square)

**Two flavours**
1. **On array:** sorted / rotated sorted / peak.
2. **On answer:** answer lies in range `[lo, hi]` and a `feasible(mid)` check is monotonic.

**✅ See:** "sorted", "rotated", "minimize the maximum", "maximize the minimum", "smallest x such that...".

**Template (find first True)**
```python
lo, hi = LOW, HIGH
while lo < hi:
    mid = (lo + hi) // 2
    if feasible(mid):
        hi = mid
    else:
        lo = mid + 1
return lo
```

**Example: Search in Rotated Sorted Array**
```python
def search(a, t):
    l, r = 0, len(a) - 1
    while l <= r:
        m = (l + r) // 2
        if a[m] == t:
            return m
        if a[l] <= a[m]:                     # left half sorted
            if a[l] <= t < a[m]:
                r = m - 1
            else:
                l = m + 1
        else:                                # right half sorted
            if a[m] < t <= a[r]:
                l = m + 1
            else:
                r = m - 1
    return -1
```

**Example: Capacity to Ship Packages in D Days (on answer)**
```python
def ship_within_days(w, D):
    def can(cap):
        days, load = 1, 0
        for x in w:
            if load + x > cap:
                days += 1
                load = 0
            load += x
        return days <= D

    lo, hi = max(w), sum(w)
    while lo < hi:
        mid = (lo + hi) // 2
        if can(mid):
            hi = mid
        else:
            lo = mid + 1
    return lo
```

---

### 🟤 Pattern 7: Monotonic Stack / Deque

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(n)-f59e0b?style=flat-square)

**Core idea:** Keep a stack in sorted order; each element is pushed/popped once.

**✅ See:** "next greater", "previous smaller", "days until warmer", "largest rectangle", "trapping water".

**Example: Next Greater Element**
```python
def next_greater(a):
    res = [-1] * len(a)
    st = []                                  # stores indices
    for i, x in enumerate(a):
        while st and a[st[-1]] < x:
            res[st.pop()] = x
        st.append(i)
    return res
```

**Example: Sliding Window Maximum (deque)**
```python
from collections import deque

def max_sliding_window(a, k):
    dq, res = deque(), []                    # dq holds indices, values decreasing
    for i, x in enumerate(a):
        while dq and a[dq[-1]] <= x:
            dq.pop()
        dq.append(i)
        if dq[0] <= i - k:
            dq.popleft()
        if i >= k - 1:
            res.append(a[dq[0]])
    return res
```

---

### ⚪ Pattern 8: Cyclic Sort / Index as Hash

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** If values are in `1..n`, value `x` belongs at index `x-1`. Swap until placed.

**✅ See:** "range 1 to n", "missing number", "duplicate number", "first missing positive", "no extra space".
**❌ Don't see:** values with arbitrary range / huge values.

```python
def cyclic_sort(a):
    i = 0
    while i < len(a):
        j = a[i] - 1
        if a[i] != a[j]:
            a[i], a[j] = a[j], a[i]
        else:
            i += 1
```

**Example: Find All Duplicates**
```python
def find_duplicates(a):
    res = []
    for x in a:
        idx = abs(x) - 1
        if a[idx] < 0:
            res.append(abs(x))
        else:
            a[idx] = -a[idx]                 # mark visited
    return res
```

**Example: First Missing Positive**
```python
def first_missing_positive(a):
    n = len(a)
    for i in range(n):
        while 1 <= a[i] <= n and a[a[i] - 1] != a[i]:
            j = a[i] - 1
            a[i], a[j] = a[j], a[i]
    for i in range(n):
        if a[i] != i + 1:
            return i + 1
    return n + 1
```

---

### 🟪 Pattern 9: Dutch National Flag / In-place Partition

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**✅ See:** "sort colors", "only 0,1,2", "partition by pivot".

```python
def sort_colors(a):
    lo, mid, hi = 0, 0, len(a) - 1
    while mid <= hi:
        if a[mid] == 0:
            a[lo], a[mid] = a[mid], a[lo]
            lo += 1; mid += 1
        elif a[mid] == 1:
            mid += 1
        else:
            a[mid], a[hi] = a[hi], a[mid]
            hi -= 1                          # don't move mid (unchecked swap-in)
```

---

### 🟩 Pattern 10: Sort + Intervals

![](https://img.shields.io/badge/Time-O(n%20log%20n)-f59e0b?style=flat-square)

**✅ See:** "merge", "overlap", "insert interval", "minimum rooms/platforms", "non-overlapping".

```python
def merge_intervals(iv):
    iv.sort(key=lambda x: x[0])
    res = [iv[0]]
    for s, e in iv[1:]:
        if s <= res[-1][1]:
            res[-1][1] = max(res[-1][1], e)
        else:
            res.append([s, e])
    return res
```

---

### 🟧 Pattern 11: Boyer-Moore Voting

![](https://img.shields.io/badge/Time-O(n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**✅ See:** "element appears more than n/2 times" (or n/3 with 2 candidates).

```python
def majority(a):
    cand = cnt = 0
    for x in a:
        if cnt == 0:
            cand = x
        cnt += 1 if x == cand else -1
    return cand                              # verify if majority isn't guaranteed
```

---

### 🟥 Pattern 12: Heap / Top-K / Quickselect

![](https://img.shields.io/badge/Time-O(n%20log%20k)-f59e0b?style=flat-square)

**✅ See:** "kth largest/smallest", "top K frequent", "k closest", "merge k sorted".

```python
import heapq

def kth_largest(a, k):
    h = a[:k]
    heapq.heapify(h)                         # min-heap of size k
    for x in a[k:]:
        if x > h[0]:
            heapq.heapreplace(h, x)
    return h[0]
```

---

### 🟦 Pattern 13: Dynamic Programming on Arrays

**✅ See:** "maximum/minimum/count ways", "can't take adjacent", "choices at each index", overlapping subproblems.

**Example: House Robber**
```python
def rob(a):
    prev = cur = 0
    for x in a:
        prev, cur = cur, max(cur, prev + x)
    return cur
```

**Example: Longest Increasing Subsequence (O(n log n))**
```python
from bisect import bisect_left

def lis(a):
    tails = []
    for x in a:
        i = bisect_left(tails, x)
        if i == len(tails):
            tails.append(x)
        else:
            tails[i] = x
    return len(tails)
```

---

### 🟫 Pattern 14: Backtracking (Subsets / Permutations)

**✅ See:** "all possible", "generate every", small `n` (≤ 15–20).

```python
def subsets(a):
    res = []
    def go(i, path):
        if i == len(a):
            res.append(path[:])
            return
        go(i + 1, path)                      # skip
        path.append(a[i])
        go(i + 1, path)                      # take
        path.pop()
    go(0, [])
    return res
```

---

### ⬛ Pattern 15: Array Tricks (Rotate / Matrix)

**Rotate array by k: 3 reversals**
```python
def rotate(a, k):
    n = len(a); k %= n
    def rev(l, r):
        while l < r:
            a[l], a[r] = a[r], a[l]
            l += 1; r -= 1
    rev(0, n - 1); rev(0, k - 1); rev(k, n - 1)
```

**Rotate matrix 90° clockwise: transpose + reverse rows**
```python
def rotate_matrix(m):
    n = len(m)
    for i in range(n):
        for j in range(i + 1, n):
            m[i][j], m[j][i] = m[j][i], m[i][j]
    for row in m:
        row.reverse()
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
| "kth largest" | Full sort (if n is large) | Heap / Quickselect |
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
| Using **Hash** when O(1) space is demanded | Violates constraint; look for Two Pointers / Cyclic / Voting. |
| **Overthinking DP** | If a greedy or single pass gives the answer, DP is unnecessary. |
| Ignoring **duplicates** | 3Sum, subsets, permutations need explicit duplicate skipping. |
| **Integer overflow / mod** | Large sums & products; use `long` / `mod` in C++/Java. |
| Off-by-one in **`while l < r` vs `l <= r`** | `<` for pairs; `<=` for binary-search single-element checks. |

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
| 4 | Maximum Subarray | Kadane | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 5 | Subarray Sum Equals K | Prefix + Hash | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 6 | 3Sum | Sort + Two Pointers | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 7 | Container With Most Water | Two Pointers | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 8 | Product of Array Except Self | Prefix/Suffix | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 9 | Sort Colors | Dutch Flag | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 10 | Merge Intervals | Sort + Intervals | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 11 | Search in Rotated Sorted Array | Binary Search | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 12 | Find All Duplicates in Array | Cyclic / Index Hash | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 13 | Longest Consecutive Sequence | Hash Set | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 14 | Min Size Subarray Sum | Variable Window | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 15 | Capacity to Ship Packages | Binary Search on Answer | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 16 | Daily Temperatures | Monotonic Stack | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 17 | Majority Element | Boyer-Moore | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 18 | Kth Largest Element | Heap | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
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
Lookup / count / seen    →  HashMap
1..n + O(1) space        →  Cyclic Sort
Next greater / smaller   →  Monotonic Stack
Min-of-max / max-of-min  →  Binary Search on Answer
Top K / Kth              →  Heap
All possibilities        →  Backtracking
Best with choices        →  DP
```

<div align="center">

![footer](https://capsule-render.vercel.app/api?type=waving&color=0:06b6d4,100:6366f1&height=100&section=footer)

**Happy solving! 🚀**

</div>
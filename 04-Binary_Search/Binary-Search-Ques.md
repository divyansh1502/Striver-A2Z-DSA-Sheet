<div align="center">

![banner](https://capsule-render.vercel.app/api?type=waving&color=0:06b6d4,100:6366f1&height=180&section=header&text=Binary%20Search%20Patterns%20in%20Java&fontSize=40&fontColor=ffffff&animation=fadeIn&desc=Not%20sorted%3F%20Find%20the%20monotonic%20check%20%E2%86%92%20Binary%20search%20the%20answer&descSize=16&descAlignY=72)

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="48" alt="java"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="40" alt="intellij"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/vscode/vscode-original.svg" width="40" alt="vscode"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="40" alt="git"/>

![DSA](https://img.shields.io/badge/DSA-Binary%20Search-6366f1?style=for-the-badge&logo=leetcode&logoColor=white)
![Java](https://img.shields.io/badge/Code-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Patterns](https://img.shields.io/badge/Patterns-10-22c55e?style=for-the-badge)
![Source](https://img.shields.io/badge/Inspired%20by-Striver%20A2Z-06b6d4?style=for-the-badge)

</div>

---

## 📑 Table of Contents

1. [The Big Idea: Binary Search ≠ Sorted Array](#1-the-big-idea)
2. [The 5-Step Approach (Binary Search on Answer)](#2-the-5-step-approach)
3. [Master Keyword Cheat Sheet](#3-master-keyword-cheat-sheet)
4. [Decision Flow](#4-decision-flow)
5. [The Two Templates](#5-the-two-templates)
6. [The Patterns (Java code)](#6-the-patterns)
7. [How to Choose `lo` and `hi`](#7-how-to-choose-lo-and-hi)
8. [Elimination Matrix](#8-elimination-matrix)
9. [What NOT to Look At (Traps)](#9-what-not-to-look-at-traps)
10. [Complexity Targets](#10-complexity-targets)
11. [Practice List (Striver order)](#11-practice-list)

> Imports used in snippets: `import java.util.*;`

---

## 1. The Big Idea

Binary search does **not** need a sorted array. It needs a **monotonic yes/no question**.

```
candidate answer:   1    2    3    4    5    6    7    8    9
feasible(x)?        NO   NO   NO   YES  YES  YES  YES  YES  YES
                                   ^
                          first YES = the answer (minimum feasible)
```

If the answer lies in a range `[lo, hi]` and you can check *"is x enough?"* in O(n), then:

> **Total time = O(n × log(range))**, no sorting of the input needed.

Two things must be true:
1. **Search space is a range of numbers** (speed, days, capacity, distance...).
2. **Monotonic:** if `x` works, then every bigger `x` also works (or the opposite for "maximize").

> 💡 **Golden rule:** *Don't search the array. Search the answer. Ask: "if I guess X, can I verify it quickly?"*

---

## 2. The 5-Step Approach

<img src="https://img.shields.io/badge/STEP-1-6366f1?style=flat-square"/> **Spot the optimisation words.** *minimum of maximum*, *maximum of minimum*, *smallest x such that*, *least time/days/capacity*.

<img src="https://img.shields.io/badge/STEP-2-6366f1?style=flat-square"/> **Name the answer variable.** Speed `k`? Days `d`? Capacity `c`? Distance `dist`? That variable is what you binary search.

<img src="https://img.shields.io/badge/STEP-3-6366f1?style=flat-square"/> **Write `feasible(x)`.** A greedy O(n) loop: *"with this x, can I satisfy the rules?"*

<img src="https://img.shields.io/badge/STEP-4-6366f1?style=flat-square"/> **Prove monotonic.** Bigger speed → fewer hours. Bigger capacity → fewer days. If feasibility can flip back and forth, binary search is wrong.

<img src="https://img.shields.io/badge/STEP-5-6366f1?style=flat-square"/> **Set `lo`/`hi` tightly and pick the template.** *Minimise* → "first true" template. *Maximise* → "last true" template (see section 5 and 7).

> 💡 Brute force is always: *try every x from lo to hi, return first that works.* Binary search just skips the useless tries.

---

## 3. Master Keyword Cheat Sheet

| 🔎 Keyword / Phrase in problem | 🎯 Likely Pattern |
|---|---|
| "sorted array", "find x", "first / last occurrence", "insert position" | Classic Binary Search / Lower-Upper Bound |
| "floor", "ceil", "how many times x occurs" | Lower / Upper Bound |
| "rotated sorted array", "minimum in rotated" | Binary Search on sorted half |
| "peak element", "mountain", "local maximum" | Binary Search on slope |
| "every element appears twice except one" (sorted) | Binary Search on index parity |
| "minimum **speed / rate**", "eat all within h hours" (Koko) | BS on Answer, minimise |
| "least **capacity**", "ship within D days" | BS on Answer, minimise the max |
| "minimum **days** to make m bouquets", "wait until" | BS on Answer, minimise |
| "smallest **divisor** given a threshold" | BS on Answer, minimise |
| "split array **largest sum minimised**", "painter's partition", "allocate books" | BS on Answer, minimise the max |
| "place k cows / balls / routers, **maximise minimum distance**" | BS on Answer, maximise the min |
| "kth missing positive number" | BS on index with derived formula |
| "square root", "nth root", "floor of cbrt" | BS on Answer (math) |
| "minimise the maximum distance between gas stations" | BS on Answer, **real numbers** |
| "median of two sorted arrays", "kth element of two sorted arrays" | BS on Partition |
| "search in sorted 2D matrix", "row with max 1s" | BS on flattened index / per row |
| "median of row-wise sorted matrix" | BS on Answer + count ≤ mid |

---

## 4. Decision Flow

```
START
 │
 ├─ Is the INPUT sorted / rotated / mountain-shaped?
 │    ├─ Plain sorted, find value / boundary ──────────────► LOWER / UPPER BOUND
 │    ├─ Rotated sorted ───────────────────────────────────► FIND THE SORTED HALF
 │    ├─ Mountain / peak ──────────────────────────────────► COMPARE a[mid] vs a[mid+1]
 │    └─ Paired elements, one single ──────────────────────► INDEX PARITY
 │
 ├─ Is the ANSWER a number in a range, with a checkable condition?
 │    ├─ "minimum X such that it is possible" ─────────────► BS ON ANSWER (first true)
 │    ├─ "minimise the largest ..." ───────────────────────► BS ON ANSWER (first true)
 │    ├─ "maximise the smallest ..." ──────────────────────► BS ON ANSWER (last true)
 │    ├─ Answer can be fractional ─────────────────────────► REAL-VALUED BS (fixed iterations)
 │    └─ Can't check in O(n) / not monotonic ──────────────► NOT binary search
 │
 ├─ Two sorted arrays, median / kth? ──────────────────────► PARTITION BINARY SEARCH
 │
 └─ 2D matrix?
      ├─ Fully sorted when flattened ──────────────────────► BS on index (mid / cols, mid % cols)
      ├─ Rows sorted, need median ─────────────────────────► BS on answer + count per row
      └─ Rows & columns sorted ────────────────────────────► Staircase walk (not BS)
```

---

## 5. The Two Templates

Almost every problem in this sheet is one of these two. **Memorise them.**

### Template A: Minimum feasible value ("first true")

```
NO NO NO YES YES YES     → want the first YES
```
```java
int lo = LOW, hi = HIGH;                  // answer is guaranteed in [lo, hi]
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;         // lower mid
    if (feasible(mid)) hi = mid;          // mid works, try smaller (keep mid)
    else lo = mid + 1;                    // mid fails, go bigger
}
return lo;
```

### Template B: Maximum feasible value ("last true")

```
YES YES YES NO NO NO     → want the last YES
```
```java
int lo = LOW, hi = HIGH;
while (lo < hi) {
    int mid = lo + (hi - lo + 1) / 2;     // UPPER mid, or you get an infinite loop
    if (feasible(mid)) lo = mid;          // mid works, try bigger (keep mid)
    else hi = mid - 1;                    // mid fails, go smaller
}
return lo;
```

> ⚠️ **Why upper mid in Template B?** If `lo = mid` with lower mid, then `lo = 3, hi = 4` gives `mid = 3` forever.

### Template C: Real-valued (decimal answers)

```java
double lo = 0, hi = MAX;
for (int it = 0; it < 100; it++) {        // fixed iterations beat "hi - lo > 1e-6"
    double mid = (lo + hi) / 2;
    if (feasible(mid)) hi = mid;
    else lo = mid;
}
return hi;
```

---

## 6. The Patterns

### 🟣 Pattern 1: Classic Binary Search on Sorted Array (Lower / Upper Bound)

![](https://img.shields.io/badge/Time-O(log%20n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** Almost every sorted-array problem is *"find the first index where a condition becomes true."*

| Concept | Definition |
|---|---|
| **Lower bound** | first index with `a[i] >= x` |
| **Upper bound** | first index with `a[i] > x` |
| **Floor** | largest value `<= x` → `a[upperBound - 1]` |
| **Ceil** | smallest value `>= x` → `a[lowerBound]` |
| **First occurrence** | `lowerBound(x)` if `a[idx] == x` |
| **Last occurrence** | `upperBound(x) - 1` |
| **Count of x** | `upperBound(x) - lowerBound(x)` |
| **Search insert position** | `lowerBound(x)` |

**✅ See:** sorted input, "insert position", "first/last", "count occurrences", "floor/ceil".

```java
// first index with a[i] >= x   (returns n if none)
public int lowerBound(int[] a, int x) {
    int lo = 0, hi = a.length;                // hi = n, answer may be "past the end"
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (a[mid] >= x) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}

// first index with a[i] > x    (returns n if none)
public int upperBound(int[] a, int x) {
    int lo = 0, hi = a.length;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (a[mid] > x) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}
```

**Example: First & Last Position / Count Occurrences**
```java
public int[] firstAndLast(int[] a, int x) {
    int first = lowerBound(a, x);
    if (first == a.length || a[first] != x) return new int[]{-1, -1};
    return new int[]{first, upperBound(a, x) - 1};
}

public int countOccurrences(int[] a, int x) {
    return upperBound(a, x) - lowerBound(a, x);
}
```

---

### 🟢 Pattern 2: Binary Search on "Hidden Order" (Rotated / Peak / Parity)

![](https://img.shields.io/badge/Time-O(log%20n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** The array isn't fully sorted, but at every `mid` **one side is guaranteed to have structure**. Compare `mid` with a neighbour or the boundary to decide which half to throw away.

**✅ See:** "rotated", "peak", "mountain", "single non-duplicate", "minimum in rotated".
**❌ Don't see:** a truly random array (no structure → no binary search).

**Example: Search in Rotated Sorted Array (distinct)**
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

**Example: Rotated with Duplicates** (when `a[l] == a[m] == a[r]` you can't tell, so shrink)
```java
public boolean searchWithDup(int[] a, int t) {
    int l = 0, r = a.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (a[m] == t) return true;
        if (a[l] == a[m] && a[m] == a[r]) { l++; r--; continue; }   // ambiguous
        if (a[l] <= a[m]) {
            if (a[l] <= t && t < a[m]) r = m - 1;
            else l = m + 1;
        } else {
            if (a[m] < t && t <= a[r]) l = m + 1;
            else r = m - 1;
        }
    }
    return false;
}
```

**Example: Minimum in Rotated Sorted Array** (also gives rotation count = index of min)
```java
public int findMinIndex(int[] a) {
    int lo = 0, hi = a.length - 1;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (a[mid] > a[hi]) lo = mid + 1;            // min is in the right half
        else hi = mid;                               // mid could be the min
    }
    return lo;                                       // a[lo] is the minimum
}
```

**Example: Peak Element** (compare with the right neighbour: climb uphill)
```java
public int findPeak(int[] a) {
    int lo = 0, hi = a.length - 1;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < a[mid + 1]) lo = mid + 1;       // slope going up → peak on the right
        else hi = mid;                               // slope going down → peak here or left
    }
    return lo;
}
```

**Example: Single Element in Sorted Array (others appear twice)**
```java
public int singleNonDuplicate(int[] a) {
    int lo = 0, hi = a.length - 1;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        mid -= mid % 2;                              // force mid to be an even index
        if (a[mid] == a[mid + 1]) lo = mid + 2;      // pairs intact on the left
        else hi = mid;                               // pairing broke at or before mid
    }
    return a[lo];
}
```

---

### 🔴 Pattern 3: BS on Answer — Minimise the Maximum (the "Koko family")

![](https://img.shields.io/badge/Time-O(n%20log%20range)-f59e0b?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** The answer `x` is a capacity / speed / limit. Bigger `x` makes the job *easier*. Find the **smallest x that still works** → **Template A**.

**✅ See:** "minimum speed", "least capacity", "smallest divisor", "minimise the largest sum".
**How to spot it:** *"Give me the minimum value of something so that all work finishes within a limit."*

**Example: Koko Eating Bananas**

- Answer variable: speed `k` (bananas/hour).
- `feasible(k)`: total hours `Σ ceil(pile / k) <= h`.
- `lo = 1` (can't eat 0/hour), `hi = max(piles)` (faster than the biggest pile is pointless).

```java
public int minEatingSpeed(int[] piles, int h) {
    int lo = 1, hi = 0;
    for (int p : piles) hi = Math.max(hi, p);
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (hoursNeeded(piles, mid) <= h) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}

private long hoursNeeded(int[] piles, int k) {
    long total = 0;                                  // long: sum of hours can overflow int
    for (int p : piles) total += (p - 1) / k + 1;    // ceil(p / k), overflow-safe
    return total;
}
```

**Example: Capacity to Ship Packages in D Days**

- Answer variable: ship capacity.
- `feasible(cap)`: greedily load in order; count days. `days <= D`.
- `lo = max(weights)` (must carry the heaviest), `hi = sum(weights)` (everything in one day).

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
        if (load + x > cap) { days++; load = 0; }    // start a new day
        load += x;
    }
    return days <= D;
}
```

**Example: Smallest Divisor Given a Threshold**

- `feasible(d)`: `Σ ceil(a[i] / d) <= threshold`.
- `lo = 1`, `hi = max(a)`.

```java
public int smallestDivisor(int[] a, int threshold) {
    int lo = 1, hi = 0;
    for (int x : a) hi = Math.max(hi, x);
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        long sum = 0;
        for (int x : a) sum += (x - 1) / mid + 1;
        if (sum <= threshold) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}
```

**Example: Split Array Largest Sum / Painter's Partition / Allocate Books**

Same problem in 3 costumes: *split an array into `m` contiguous parts so the **largest part sum is as small as possible**.*

- `feasible(maxSum)`: greedily fill each part up to `maxSum`; count parts. `parts <= m`.
- `lo = max(a)`, `hi = sum(a)`.

```java
public int splitArray(int[] a, int m) {
    // Books variant: if (m > a.length) return -1;  (each student needs at least one book)
    int lo = 0, hi = 0;
    for (int x : a) { lo = Math.max(lo, x); hi += x; }
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (partsNeeded(a, mid) <= m) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}

private int partsNeeded(int[] a, int maxSum) {
    int parts = 1, cur = 0;
    for (int x : a) {
        if (cur + x > maxSum) { parts++; cur = 0; }
        cur += x;
    }
    return parts;
}
```

> 🧠 **Ship ≡ Split Array ≡ Books ≡ Painter.** Capacity = max part sum, days = parts. If you can code one, you can code all four.

---

### 🟡 Pattern 4: BS on Answer — Minimum Time / Days (the "Bouquets family")

![](https://img.shields.io/badge/Time-O(n%20log%20range)-f59e0b?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** The answer is a **moment in time** (day number). Later day → more things are ready → easier. Find the **earliest day that works** → **Template A**.

**✅ See:** "minimum number of days", "earliest time", "wait until".

**Example: Minimum Days to Make M Bouquets** (each bouquet needs `k` **adjacent** flowers)

- `feasible(day)`: scan; a flower is usable if `bloomDay[i] <= day`; count groups of `k` consecutive usable flowers. `bouquets >= m`.
- **Early exit:** if `m * k > n` → impossible, return `-1`. (Use `long` for the product.)
- `lo = min(bloomDay)`, `hi = max(bloomDay)`.

```java
public int minDays(int[] bloom, int m, int k) {
    if ((long) m * k > bloom.length) return -1;
    int lo = Integer.MAX_VALUE, hi = 0;
    for (int d : bloom) { lo = Math.min(lo, d); hi = Math.max(hi, d); }
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (bouquetsOn(bloom, mid, k) >= m) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}

private int bouquetsOn(int[] bloom, int day, int k) {
    int count = 0, run = 0;
    for (int d : bloom) {
        if (d <= day) {
            run++;
            if (run == k) { count++; run = 0; }      // bouquet complete
        } else run = 0;                              // adjacency broken
    }
    return count;
}
```

---

### 🟠 Pattern 5: BS on Answer — Maximise the Minimum (the "Aggressive Cows family")

![](https://img.shields.io/badge/Time-O(n%20log%20range)-f59e0b?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** Opposite direction. A **bigger** answer is **harder**. You want the **largest value that is still feasible** → **Template B** (upper mid!).

**✅ See:** "maximise the minimum distance", "place k items as far apart as possible".

**Example: Aggressive Cows / Magnetic Force Between Balls**

- Sort positions first (sorting is fine here, positions have no index to preserve).
- `feasible(dist)`: place the first cow at `a[0]`, then greedily place the next cow at the first stall `>= last + dist`. `placed >= cows`.
- `lo = 1`, `hi = a[n-1] - a[0]`.

```java
public int aggressiveCows(int[] stalls, int cows) {
    Arrays.sort(stalls);
    int lo = 1, hi = stalls[stalls.length - 1] - stalls[0];
    while (lo < hi) {
        int mid = lo + (hi - lo + 1) / 2;            // UPPER mid (Template B)
        if (canPlace(stalls, cows, mid)) lo = mid;   // works, try a bigger gap
        else hi = mid - 1;
    }
    return lo;
}

private boolean canPlace(int[] a, int cows, int dist) {
    int placed = 1, last = a[0];
    for (int i = 1; i < a.length; i++) {
        if (a[i] - last >= dist) { placed++; last = a[i]; }
    }
    return placed >= cows;
}
```

> 🧠 **Minimise-the-max** → feasible gets *easier* as x grows → `hi = mid`.
> **Maximise-the-min** → feasible gets *harder* as x grows → `lo = mid`.

---

### 🟤 Pattern 6: BS on Answer — Math (Sqrt / Nth Root)

![](https://img.shields.io/badge/Time-O(log%20n)-22c55e?style=flat-square)

**Core idea:** The answer is an integer in `[0, n]`; check `mid * mid <= n` (monotonic: true then false).

**Example: Integer Square Root** (last `mid` where `mid² <= x`: Template B)
```java
public int mySqrt(int x) {
    int lo = 0, hi = x;
    while (lo < hi) {
        int mid = lo + (hi - lo + 1) / 2;
        if ((long) mid * mid <= x) lo = mid;         // long: mid*mid overflows int
        else hi = mid - 1;
    }
    return lo;
}
```

**Example: Nth Root of M (return -1 if not an exact integer)**
```java
public int nthRoot(int n, int m) {
    int lo = 1, hi = m;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int cmp = compare(mid, n, m);
        if (cmp == 0) return mid;
        if (cmp < 0) lo = mid + 1;                   // mid^n < m
        else hi = mid - 1;                           // mid^n > m
    }
    return -1;
}

// returns -1 if mid^n < m, 0 if equal, 1 if mid^n > m (bails out early, no overflow)
private int compare(int mid, int n, int m) {
    long r = 1;
    for (int i = 0; i < n; i++) {
        r *= mid;
        if (r > m) return 1;
    }
    return r == m ? 0 : -1;
}
```

---

### 🟦 Pattern 7: BS on Answer — Index with a Derived Formula (Kth Missing)

![](https://img.shields.io/badge/Time-O(log%20n)-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** The array **is** sorted, but the question isn't about values, it's about a **derived quantity** that is monotonic in the index. Here: *missing numbers before index `i`* = `a[i] - (i + 1)`, which never decreases.

**✅ See:** "kth missing", "count of something up to index i keeps growing".

**Example: Kth Missing Positive Number** (strictly increasing array)
```java
public int findKthPositive(int[] a, int k) {
    int lo = 0, hi = a.length;                       // answer index may be n (past the end)
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        int missing = a[mid] - (mid + 1);            // missing numbers before a[mid]
        if (missing < k) lo = mid + 1;               // not enough missing yet
        else hi = mid;
    }
    return lo + k;                                   // lo elements exist before the answer
}
```

> Why `lo + k`? Among `1 .. answer`, exactly `lo` numbers are present in the array, so `answer = k + lo`.

---

### 🟪 Pattern 8: Real-Valued Binary Search (Gas Stations)

![](https://img.shields.io/badge/Time-O(n%20×%20iterations)-f59e0b?style=flat-square)

**Core idea:** Answer is a **decimal** (precision like `1e-6`). You can't do `mid + 1`, so shrink by halving with Template C. Use a **fixed iteration count** to avoid float-comparison loops that never end.

**Example: Minimise Max Distance Between Gas Stations** (add `k` new stations)

- `feasible(d)`: for every gap, stations needed so no sub-gap exceeds `d` is `ceil(gap / d) - 1`. Sum `<= k`.
- `lo = 0`, `hi = largest existing gap`.

```java
public double minimiseMaxDistance(int[] st, int k) {
    double lo = 0, hi = 0;
    for (int i = 1; i < st.length; i++) hi = Math.max(hi, st[i] - st[i - 1]);
    for (int it = 0; it < 100; it++) {
        double mid = (lo + hi) / 2;
        if (stationsNeeded(st, mid) <= k) hi = mid;  // mid is enough, try smaller
        else lo = mid;
    }
    return hi;
}

private long stationsNeeded(int[] st, double d) {
    long cnt = 0;
    for (int i = 1; i < st.length; i++) {
        double gap = st[i] - st[i - 1];
        cnt += (long) Math.ceil(gap / d) - 1;
    }
    return cnt;
}
```

---

### ⚪ Pattern 9: Binary Search on Partition (Two Sorted Arrays)

![](https://img.shields.io/badge/Time-O(log%20min(n,m))-22c55e?style=flat-square) ![](https://img.shields.io/badge/Space-O(1)-22c55e?style=flat-square)

**Core idea:** Don't merge. **Binary search how many elements to take from the smaller array** for the left half. The rest is forced from the other array. A valid split satisfies `l1 <= r2 && l2 <= r1`.

```
A:  a0 a1 | a2 a3          l1 = a1, r1 = a2
B:  b0 b1 b2 | b3          l2 = b2, r2 = b3
          ↑ partition: left half has (n1 + n2 + 1) / 2 elements
```

**✅ See:** "median of two sorted arrays", "kth element of two sorted arrays", O(log) required.

**Example: Median of Two Sorted Arrays**
```java
public double findMedian(int[] a, int[] b) {
    if (a.length > b.length) return findMedian(b, a);   // always search the smaller array
    int n1 = a.length, n2 = b.length;
    int lo = 0, hi = n1;
    int leftSize = (n1 + n2 + 1) / 2;
    while (lo <= hi) {
        int i = lo + (hi - lo) / 2;                     // elements taken from a
        int j = leftSize - i;                           // elements taken from b
        int l1 = (i == 0)  ? Integer.MIN_VALUE : a[i - 1];
        int r1 = (i == n1) ? Integer.MAX_VALUE : a[i];
        int l2 = (j == 0)  ? Integer.MIN_VALUE : b[j - 1];
        int r2 = (j == n2) ? Integer.MAX_VALUE : b[j];
        if (l1 <= r2 && l2 <= r1) {                     // valid partition
            if ((n1 + n2) % 2 == 1) return Math.max(l1, l2);
            return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        } else if (l1 > r2) hi = i - 1;                 // took too many from a
        else lo = i + 1;                                // took too few from a
    }
    return 0;
}
```

**Variant: Kth Element of Two Sorted Arrays** (same idea, left half size = `k`)
```java
public int kthElement(int[] a, int[] b, int k) {
    if (a.length > b.length) return kthElement(b, a, k);
    int n1 = a.length, n2 = b.length;
    int lo = Math.max(0, k - n2), hi = Math.min(k, n1);  // j = k - i must stay in [0, n2]
    while (lo <= hi) {
        int i = lo + (hi - lo) / 2, j = k - i;
        int l1 = (i == 0)  ? Integer.MIN_VALUE : a[i - 1];
        int r1 = (i == n1) ? Integer.MAX_VALUE : a[i];
        int l2 = (j == 0)  ? Integer.MIN_VALUE : b[j - 1];
        int r2 = (j == n2) ? Integer.MAX_VALUE : b[j];
        if (l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
        else if (l1 > r2) hi = i - 1;
        else lo = i + 1;
    }
    return -1;
}
```

---

### ⬛ Pattern 10: Binary Search on 2D Matrix

![](https://img.shields.io/badge/Time-O(log(n×m))-22c55e?style=flat-square)

**Three shapes, three tricks:**

| Matrix shape | Technique |
|---|---|
| Each row sorted **and** first of row > last of previous row | Treat as 1D: `mid → [mid / cols][mid % cols]` |
| Rows sorted, need **row with max 1s** (rows of 0s then 1s) | `lowerBound` of first `1` in every row |
| Rows sorted, need **median** | BS on answer: count of elements `<= mid` per row |
| Rows **and** columns sorted (not globally) | Staircase from top-right: O(n + m), not BS |

**Example: Search in Fully Sorted Matrix (flatten trick)**
```java
public boolean searchMatrix(int[][] m, int target) {
    int rows = m.length, cols = m[0].length;
    int lo = 0, hi = rows * cols - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int val = m[mid / cols][mid % cols];             // 1D index → 2D cell
        if (val == target) return true;
        if (val < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return false;
}
```

**Example: Row with Maximum 1s** (each row sorted: 0s then 1s)
```java
public int rowWithMax1s(int[][] m) {
    int bestRow = -1, bestCount = 0, cols = m[0].length;
    for (int i = 0; i < m.length; i++) {
        int firstOne = lowerBound(m[i], 1);              // reuse Pattern 1
        int count = cols - firstOne;
        if (count > bestCount) { bestCount = count; bestRow = i; }
    }
    return bestRow;
}
```

**Example: Median of Row-wise Sorted Matrix** (BS on answer + counting)

- Answer is a **value** between the smallest and largest element.
- `feasible(x)`: count of elements `<= x` is **more than** `(rows * cols) / 2`. The first such `x` is the median.
```java
public int matrixMedian(int[][] m) {
    int rows = m.length, cols = m[0].length;
    int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
    for (int[] row : m) {
        lo = Math.min(lo, row[0]);
        hi = Math.max(hi, row[cols - 1]);
    }
    int need = (rows * cols) / 2;                        // median has > need elements <= it
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        int count = 0;
        for (int[] row : m) count += upperBound(row, mid);   // # elements <= mid in this row
        if (count > need) hi = mid;
        else lo = mid + 1;
    }
    return lo;
}
```

---

## 7. How to Choose `lo` and `hi`

> 🎯 **`lo` = smallest answer that could possibly be valid. `hi` = an answer that is *always* valid.**

| Problem | `lo` | `hi` | Why |
|---|---|---|---|
| Koko Eating Bananas | `1` | `max(piles)` | speed 0 is meaningless; faster than the biggest pile adds nothing |
| Smallest Divisor (threshold) | `1` | `max(a)` | divisor above max gives every term = 1 |
| Ship in D days | `max(w)` | `sum(w)` | must lift heaviest; one day takes everything |
| Split Array / Painter / Books | `max(a)` | `sum(a)` | one part must hold the biggest item; 1 part holds all |
| Min days for bouquets | `min(bloom)` | `max(bloom)` | nothing blooms earlier / everything has bloomed by then |
| Aggressive cows | `1` | `max - min` | min gap is 1; max possible gap is the full span |
| Sqrt / Nth root | `0` or `1` | `x` or `m` | answer never exceeds the number |
| Gas stations | `0` | largest gap | distance 0 impossible but is the lower limit; largest gap = no new stations |
| Median of matrix | smallest element | largest element | median is a value inside the matrix |
| Kth missing positive | `0` (index) | `n` (index) | answer position may be past the end |

**Quick rules**
- If each item must be handled **whole** (can't split one item): `lo = max(item)`.
- If **no constraint** forces a minimum: `lo = 1`.
- `hi` = the "do everything in one go / one batch" answer.
- When unsure, **use a looser range**. It only costs `+1` iteration; a wrong tight range costs a wrong answer.

---

## 8. Elimination Matrix

> Use this to **decide in 10 seconds** whether binary search on answer is right.

| Question | If YES → | If NO → eliminate |
|---|---|---|
| Is the **answer a number in a range**? | BS on Answer | ❌ BS on Answer. Think DP / Greedy / Hash |
| Can I write `feasible(x)` as a **greedy O(n) check**? | BS on Answer | ❌ BS on Answer (too slow, or use DP) |
| Is `feasible` **monotonic** (all NO then all YES)? | BS on Answer | ❌ Binary Search entirely |
| Asks **"minimum of maximum"**? | Template A (first true) | |
| Asks **"maximum of minimum"**? | Template B (last true) | |
| Does the answer allow **decimals**? | Template C (real) | ❌ Integer `+1 / -1` shrinking |
| Is the **input sorted** and question is about a value/position? | Lower / Upper Bound | |
| Is the input **rotated / mountain**? | Half-sorted logic / slope | ❌ Plain lower bound |
| Do I need the **median / kth of two sorted arrays**? | Partition BS | ❌ Merge approach if O(log) demanded |

### Quick elimination by problem type

| If the problem says... | Eliminate | Keep |
|---|---|---|
| "minimum capacity / speed / days" | Sorting, DP | BS on Answer (first true) |
| "maximise the minimum distance" | Brute force over pairs | BS on Answer (last true) |
| "count subarrays / subsets" | BS on Answer | Prefix / DP |
| "answer must be **exact** and feasibility isn't monotonic" | BS on Answer | DP / Backtracking |
| "sorted, find a value" | BS on Answer | Plain BS |
| "min **sum** of subarray of fixed size" | BS on Answer | Sliding Window |

---

## 9. What NOT to Look At (Traps)

| ⚠️ Trap | Why it misleads you |
|---|---|
| **"Array is not sorted so no binary search"** | You binary search the **answer range**, not the array. |
| Writing `feasible()` **before** proving monotonicity | If bigger x can fail where smaller x passed, binary search silently returns garbage. |
| Using **lower mid in Template B** | `lo = mid` with `mid = (lo + hi) / 2` loops forever at `lo + 1 == hi`. Use `lo + (hi - lo + 1) / 2`. |
| `hi = mid - 1` in Template A | You may skip the valid answer. Template A keeps `hi = mid`. |
| **`int` overflow** in `feasible` | Sum of hours, `mid * mid`, `m * k` can exceed 2.1×10⁹. Use `long`. |
| Using `(lo + hi) / 2` | Overflows for large values. Use `lo + (hi - lo) / 2`. |
| **Wrong `lo`** (e.g. `lo = 1` for ship capacity) | Capacity below the heaviest package is impossible, `feasible` logic breaks. Use `max(w)`. |
| Forgetting the **impossible case** | Bouquets: `m * k > n` → `-1`. Books: `students > books` → `-1`. |
| **Ceil division** with `(a + b - 1) / b` | Can overflow. Use `(a - 1) / b + 1` for positive `a`. |
| Looping real BS with `while (hi - lo > 1e-6)` | Float issues may never terminate. Use a fixed 50–100 iterations. |
| Returning **`hi` vs `lo`** inconsistently | In Template A/B both converge to the same value; in real BS return `hi` (feasible side). |
| Sorting when **order matters** | Fine for cows/stalls, **wrong** for ship weights / bouquets / split array (contiguous!). |
| Confusing **"adjacent"** in bouquets | A non-bloomed flower must **reset** the run counter. |
| Thinking story = pattern | Cows, ships, painters, books are just decoration. Look at the **operation** (min of max? max of min?). |

---

## 10. Complexity Targets

| Problem type | Time | Space |
|---|---|---|
| Classic BS / lower & upper bound | O(log n) | O(1) |
| Rotated / peak / parity | O(log n) | O(1) |
| BS on Answer (check is O(n)) | **O(n × log(hi − lo))** | O(1) |
| Real-valued BS | O(n × iterations) | O(1) |
| Median / kth of two arrays | O(log min(n, m)) | O(1) |
| 2D flat BS | O(log(rows × cols)) | O(1) |
| Matrix median | O(rows × log(cols) × log(range)) | O(1) |

> 📐 **Estimate the iterations:** `log₂(10⁹) ≈ 30`, so with `n = 10⁵` you do ~3×10⁶ operations. Easily fast.

| n (max) | Typical hint |
|---|---|
| `n ≤ 10⁵`, values up to `10⁹` | O(n log(10⁹)): BS on answer fits |
| `n ≤ 10⁹` and "find x" | O(log n): direct BS / math |
| Any `n`, "minimum possible maximum" | Almost always BS on Answer |

---

## 11. Practice List

> Order follows the Striver A2Z Binary Search section.

| # | Problem | Pattern | Difficulty |
|---|---|---|---|
| 1 | Binary Search | Classic | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 2 | Lower Bound / Upper Bound | Bound | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 3 | Search Insert Position | Bound | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 4 | Floor and Ceil in Sorted Array | Bound | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 5 | First & Last Occurrence | Bound | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 6 | Count Occurrences in Sorted Array | Bound | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 7 | Search in Rotated Sorted Array I | Half-sorted | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 8 | Search in Rotated Sorted Array II (duplicates) | Half-sorted | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 9 | Minimum in Rotated Sorted Array | Half-sorted | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 10 | How Many Times Array Is Rotated | Half-sorted | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 11 | Single Element in Sorted Array | Parity | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 12 | Find Peak Element | Slope | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 13 | Square Root of a Number | BS on Answer (math) | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 14 | Nth Root of an Integer | BS on Answer (math) | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 15 | Koko Eating Bananas | Min speed | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 16 | Minimum Days to Make M Bouquets | Min days | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 17 | Smallest Divisor Given a Threshold | Min divisor | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 18 | Capacity to Ship Packages in D Days | Min of max | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 19 | Kth Missing Positive Number | Index formula | ![](https://img.shields.io/badge/-Easy-22c55e?style=flat-square) |
| 20 | Aggressive Cows | Max of min | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 21 | Allocate Books / Book Allocation | Min of max | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 22 | Painter's Partition | Min of max | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 23 | Split Array Largest Sum | Min of max | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 24 | Minimise Max Distance to Gas Station | Real-valued BS | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 25 | Median of Two Sorted Arrays | Partition BS | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 26 | Kth Element of Two Sorted Arrays | Partition BS | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 27 | Row with Maximum 1s | 2D + Bound | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 28 | Search in a 2D Matrix (fully sorted) | 2D flatten | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 29 | Search in a 2D Matrix II (rows & cols sorted) | Staircase | ![](https://img.shields.io/badge/-Medium-f59e0b?style=flat-square) |
| 30 | Find Peak Element II (2D) | BS on column max | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |
| 31 | Median of Row-wise Sorted Matrix | BS on Answer + count | ![](https://img.shields.io/badge/-Hard-ef4444?style=flat-square) |

---

## 🧠 One-Line Memory Hooks

```
Sorted + find / boundary             →  Lower / Upper Bound
Rotated                              →  Which half is sorted?
Peak                                 →  Compare a[mid] with a[mid+1]
Min speed / min days / min capacity  →  BS on Answer, Template A (hi = mid)
Minimise the largest sum             →  BS on Answer, lo = max(a), hi = sum(a)
Maximise the smallest distance       →  BS on Answer, Template B (lo = mid, UPPER mid)
Decimal answer                       →  Fixed 100 iterations, hi = mid / lo = mid
Median of two arrays                 →  Binary search the partition on the smaller array
Matrix, globally sorted              →  Flatten: row = mid / cols, col = mid % cols
Not sure it works?                   →  Is feasible(x) monotonic? If not, it's not BS.
```

### 🔑 The 3-question test for ANY "not sorted" binary search problem

```
1. Is the answer a number in a range [lo, hi]?          (speed, days, capacity, distance)
2. Can I check one candidate in O(n) with a greedy loop? (feasible(x))
3. Does feasible flip only ONCE (NO...NO YES...YES)?     (monotonic)

3 × YES  →  Binary Search on Answer.
```

<div align="center">

![footer](https://capsule-render.vercel.app/api?type=waving&color=0:6366f1,100:06b6d4&height=100&section=footer)

**Happy coding in Java! ☕🚀**

</div>
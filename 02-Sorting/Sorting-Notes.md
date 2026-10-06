<div align="center">

![banner](https://capsule-render.vercel.app/api?type=waving&color=0:f97316,100:db2777&height=190&section=header&text=Sorting%20Playlist&fontSize=46&fontColor=ffffff&animation=fadeIn&desc=All%20Sorting%20Methods%20%E2%80%A2%20Important%20Questions%20%E2%80%A2%20Java&descSize=17&descAlignY=72)

*Learn each sort, know when to use it, then solve the questions built on top of it.*

![Sorts](https://img.shields.io/badge/Sorting_Methods-10-f97316?style=for-the-badge)
![Visuals](https://img.shields.io/badge/Visual_Diagrams-11-db2777?style=for-the-badge)
![Questions](https://img.shields.io/badge/Important_Questions-13-db2777?style=for-the-badge)
![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

> [!NOTE]
> All snippets assume `import java.util.*;` and a helper `swap(int[] a, int i, int j)`.

---

## 📑 Playlist Order

| # | Sort | Type |
|:-:|:--|:--|
| 1 | Bubble Sort | Comparison |
| 2 | Selection Sort | Comparison |
| 3 | Insertion Sort | Comparison |
| 4 | Merge Sort | Divide & Conquer |
| 5 | Quick Sort | Divide & Conquer |
| 6 | Heap Sort | Comparison (Heap) |
| 7 | Shell Sort | Comparison (Gap) |
| 8 | Counting Sort | Non-comparison |
| 9 | Radix Sort | Non-comparison |
| 10 | Bucket Sort | Non-comparison |

---

## ✨ Cheat Sheet

<div align="center">

| Sort | Best | Average | Worst | Space | Stable | In-place |
|:--|:-:|:-:|:-:|:-:|:-:|:-:|
| **Bubble** | `O(n)` | `O(n²)` | `O(n²)` | `O(1)` | ✅ | ✅ |
| **Selection** | `O(n²)` | `O(n²)` | `O(n²)` | `O(1)` | ❌ | ✅ |
| **Insertion** | `O(n)` | `O(n²)` | `O(n²)` | `O(1)` | ✅ | ✅ |
| **Merge** | `O(n log n)` | `O(n log n)` | `O(n log n)` | `O(n)` | ✅ | ❌ |
| **Quick** | `O(n log n)` | `O(n log n)` | `O(n²)` | `O(log n)` | ❌ | ✅ |
| **Heap** | `O(n log n)` | `O(n log n)` | `O(n log n)` | `O(1)` | ❌ | ✅ |
| **Shell** | `O(n log n)` | depends on gaps | `O(n²)` | `O(1)` | ❌ | ✅ |
| **Counting** | `O(n + k)` | `O(n + k)` | `O(n + k)` | `O(k)` | ✅* | ❌ |
| **Radix** | `O(d·(n + k))` | `O(d·(n + k))` | `O(d·(n + k))` | `O(n + k)` | ✅ | ❌ |
| **Bucket** | `O(n + k)` | `O(n + k)` | `O(n²)` | `O(n + k)` | ✅** | ❌ |

<sub>k = value range · d = number of digits · * with the prefix-sum version (the simple version below isn't stable) · ** if the inner sort is stable</sub>

</div>

> [!TIP]
> **Stable** = equal elements keep their original order. This matters when sorting objects by one key, and it's why Radix Sort needs a stable inner sort.

---

## 🧩 Which Sort for Which Situation

| Situation | Use |
|:--|:--|
| Almost sorted / tiny array | Insertion Sort |
| Need guaranteed `O(n log n)` + stable | Merge Sort |
| Need counting pairs while sorting | Merge Sort |
| Fast average, in-place, or Kth element | Quick Sort / Quickselect |
| Need `O(n log n)` with `O(1)` space | Heap Sort |
| Small integer range | Counting Sort |
| Many digits / fixed-width numbers | Radix Sort |
| Uniform floating-point values | Bucket Sort |

> [!IMPORTANT]
> **Java built-ins:** `Arrays.sort(int[])` uses Dual-Pivot Quicksort (not stable). `Arrays.sort(Object[])` and `Collections.sort` use TimSort (stable).

---

## 🧪 Sorting Methods — Code

<details>
<summary><b>1 · Bubble Sort</b> — swap adjacent pairs, largest bubbles to the end</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 278" width="720" role="img" aria-label="Bubble Sort"><defs><linearGradient id="g1" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="278" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g1)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Bubble Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Compare neighbours and swap if out of order — the largest value bubbles to the end each pass.</text><text x="24" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Start</text><rect x="170" y="76" width="52" height="40" rx="7" fill="#db2777"/><text x="196.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="228" y="76" width="52" height="40" rx="7" fill="#db2777"/><text x="254.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="286" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="312.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="344" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="402" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="428.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><text x="476" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">5 &gt; 1 → swap, keep going</text><text x="24" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">After pass 1</text><rect x="170" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="196.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="228" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="254.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="286" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="312.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="344" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="402" y="132" width="52" height="40" rx="7" fill="#16a34a"/><text x="428.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><text x="476" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">largest (8) is in place</text><text x="24" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">After pass 2</text><rect x="170" y="188" width="52" height="40" rx="7" fill="#3b3560"/><text x="196.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="228" y="188" width="52" height="40" rx="7" fill="#3b3560"/><text x="254.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="286" y="188" width="52" height="40" rx="7" fill="#3b3560"/><text x="312.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="344" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="370.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="402" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="428.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><text x="476" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">pass 3: no swaps → stop</text><rect x="24" y="254" width="11" height="11" rx="3" fill="#db2777"/><text x="41" y="264" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">comparing</text><rect x="119.69999999999999" y="254" width="11" height="11" rx="3" fill="#16a34a"/><text x="136.7" y="264" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void bubbleSort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - 1 - i; j++) {
            if (a[j] > a[j + 1]) {
                swap(a, j, j + 1);
                swapped = true;
            }
        }
        if (!swapped) break;           // already sorted → O(n) best case
    }
}
```
</details>

<details>
<summary><b>2 · Selection Sort</b> — pick the minimum, place it at the front</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 334" width="720" role="img" aria-label="Selection Sort"><defs><linearGradient id="g2" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="334" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g2)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Selection Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Find the minimum of the unsorted part and swap it to the front.</text><text x="24" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Start</text><rect x="170" y="76" width="52" height="40" rx="7" fill="#db2777"/><text x="196.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">29</text><rect x="228" y="76" width="52" height="40" rx="7" fill="#f97316"/><text x="254.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><rect x="286" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="312.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">14</text><rect x="344" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">37</text><rect x="402" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="428.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">13</text><text x="476" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">min = 10 → swap with 29</text><text x="24" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">After pass 1</text><rect x="170" y="132" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><rect x="228" y="132" width="52" height="40" rx="7" fill="#db2777"/><text x="254.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">29</text><rect x="286" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="312.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">14</text><rect x="344" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">37</text><rect x="402" y="132" width="52" height="40" rx="7" fill="#f97316"/><text x="428.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">13</text><text x="476" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">min = 13 → swap with 29</text><text x="24" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">After pass 2</text><rect x="170" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><rect x="228" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="254.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">13</text><rect x="286" y="188" width="52" height="40" rx="7" fill="#f97316"/><text x="312.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">14</text><rect x="344" y="188" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">37</text><rect x="402" y="188" width="52" height="40" rx="7" fill="#3b3560"/><text x="428.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">29</text><text x="476" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">14 is already the min</text><text x="24" y="269" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Sorted</text><rect x="170" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><rect x="228" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="254.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">13</text><rect x="286" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="312.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">14</text><rect x="344" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="370.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">29</text><rect x="402" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="428.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">37</text><text x="476" y="269" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">after pass 4</text><rect x="24" y="310" width="11" height="11" rx="3" fill="#f97316"/><text x="41" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">minimum</text><rect x="107.1" y="310" width="11" height="11" rx="3" fill="#db2777"/><text x="124.1" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">swap target</text><rect x="215.39999999999998" y="310" width="11" height="11" rx="3" fill="#16a34a"/><text x="232.39999999999998" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void selectionSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] < a[min]) min = j;
        }
        swap(a, i, min);
    }
}
```
</details>

<details>
<summary><b>3 · Insertion Sort</b> — insert each element into the sorted prefix</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 334" width="720" role="img" aria-label="Insertion Sort"><defs><linearGradient id="g3" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="334" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g3)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Insertion Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Take the next element (key) and insert it into the sorted prefix by shifting larger values right.</text><text x="24" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Start</text><rect x="170" y="76" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="228" y="76" width="52" height="40" rx="7" fill="#f97316"/><text x="254.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="286" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="312.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="344" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="402" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="428.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><text x="476" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">key = 2 → shift 5 right</text><text x="24" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Insert 2</text><rect x="170" y="132" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="228" y="132" width="52" height="40" rx="7" fill="#16a34a"/><text x="254.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="286" y="132" width="52" height="40" rx="7" fill="#f97316"/><text x="312.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="344" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="402" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="428.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><text x="476" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">key = 4 → shift 5 right</text><text x="24" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Insert 4</text><rect x="170" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="228" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="254.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="286" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="312.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="344" y="188" width="52" height="40" rx="7" fill="#f97316"/><text x="370.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="402" y="188" width="52" height="40" rx="7" fill="#3b3560"/><text x="428.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><text x="476" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">key = 6 → no shift</text><text x="24" y="269" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Insert 6, 1</text><rect x="170" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="228" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="254.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="286" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="312.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="344" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="370.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="402" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="428.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><text x="476" y="269" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">1 shifts left past 6, 5, 4, 2</text><rect x="24" y="310" width="11" height="11" rx="3" fill="#f97316"/><text x="41" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">key</text><rect x="81.9" y="310" width="11" height="11" rx="3" fill="#16a34a"/><text x="98.9" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted prefix</text></svg>
</div>

```java
public void insertionSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
        int key = a[i], j = i - 1;
        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = key;
    }
}
```
</details>

<details>
<summary><b>4 · Merge Sort</b> — split, sort halves, merge</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 356" width="720" role="img" aria-label="Merge Sort"><defs><linearGradient id="g4" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="356" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g4)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Merge Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Divide until single elements, then merge sorted halves back together.</text><line x1="380" y1="112" x2="260" y2="126" stroke="#6b6495" stroke-width="1.5"/><line x1="380" y1="112" x2="500" y2="126" stroke="#6b6495" stroke-width="1.5"/><line x1="260" y1="162" x2="225" y2="176" stroke="#6b6495" stroke-width="1.5"/><line x1="260" y1="162" x2="295" y2="176" stroke="#6b6495" stroke-width="1.5"/><line x1="500" y1="162" x2="465" y2="176" stroke="#6b6495" stroke-width="1.5"/><line x1="500" y1="162" x2="535" y2="176" stroke="#6b6495" stroke-width="1.5"/><line x1="225" y1="212" x2="260" y2="226" stroke="#6b6495" stroke-width="1.5"/><line x1="295" y1="212" x2="260" y2="226" stroke="#6b6495" stroke-width="1.5"/><line x1="465" y1="212" x2="500" y2="226" stroke="#6b6495" stroke-width="1.5"/><line x1="535" y1="212" x2="500" y2="226" stroke="#6b6495" stroke-width="1.5"/><line x1="260" y1="262" x2="380" y2="276" stroke="#6b6495" stroke-width="1.5"/><line x1="500" y1="262" x2="380" y2="276" stroke="#6b6495" stroke-width="1.5"/><text x="24" y="99" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Array</text><text x="24" y="149" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Split</text><text x="24" y="199" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Split</text><text x="24" y="249" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Merge</text><text x="24" y="299" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Merge</text><rect x="282.0" y="76" width="46" height="36" rx="7" fill="#3b3560"/><text x="305.0" y="99.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="332.0" y="76" width="46" height="36" rx="7" fill="#3b3560"/><text x="355.0" y="99.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="382.0" y="76" width="46" height="36" rx="7" fill="#3b3560"/><text x="405.0" y="99.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="432.0" y="76" width="46" height="36" rx="7" fill="#3b3560"/><text x="455.0" y="99.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="212.0" y="126" width="46" height="36" rx="7" fill="#3b3560"/><text x="235.0" y="149.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="262.0" y="126" width="46" height="36" rx="7" fill="#3b3560"/><text x="285.0" y="149.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="452.0" y="126" width="46" height="36" rx="7" fill="#3b3560"/><text x="475.0" y="149.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="502.0" y="126" width="46" height="36" rx="7" fill="#3b3560"/><text x="525.0" y="149.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="202.0" y="176" width="46" height="36" rx="7" fill="#3b3560"/><text x="225.0" y="199.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="272.0" y="176" width="46" height="36" rx="7" fill="#3b3560"/><text x="295.0" y="199.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="442.0" y="176" width="46" height="36" rx="7" fill="#3b3560"/><text x="465.0" y="199.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="512.0" y="176" width="46" height="36" rx="7" fill="#3b3560"/><text x="535.0" y="199.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="212.0" y="226" width="46" height="36" rx="7" fill="#f97316"/><text x="235.0" y="249.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="262.0" y="226" width="46" height="36" rx="7" fill="#f97316"/><text x="285.0" y="249.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="452.0" y="226" width="46" height="36" rx="7" fill="#f97316"/><text x="475.0" y="249.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="502.0" y="226" width="46" height="36" rx="7" fill="#f97316"/><text x="525.0" y="249.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="282.0" y="276" width="46" height="36" rx="7" fill="#16a34a"/><text x="305.0" y="299.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="332.0" y="276" width="46" height="36" rx="7" fill="#16a34a"/><text x="355.0" y="299.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="382.0" y="276" width="46" height="36" rx="7" fill="#16a34a"/><text x="405.0" y="299.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="432.0" y="276" width="46" height="36" rx="7" fill="#16a34a"/><text x="455.0" y="299.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="24" y="332" width="11" height="11" rx="3" fill="#3b3560"/><text x="41" y="342" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">split</text><rect x="94.5" y="332" width="11" height="11" rx="3" fill="#f97316"/><text x="111.5" y="342" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">merging</text><rect x="177.6" y="332" width="11" height="11" rx="3" fill="#16a34a"/><text x="194.6" y="342" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void mergeSort(int[] a, int l, int r) {
    if (l >= r) return;
    int m = l + (r - l) / 2;
    mergeSort(a, l, m);
    mergeSort(a, m + 1, r);
    merge(a, l, m, r);
}

private void merge(int[] a, int l, int m, int r) {
    int[] t = new int[r - l + 1];
    int i = l, j = m + 1, k = 0;
    while (i <= m && j <= r) t[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];   // <= keeps it stable
    while (i <= m) t[k++] = a[i++];
    while (j <= r) t[k++] = a[j++];
    System.arraycopy(t, 0, a, l, t.length);
}
```
</details>

<details>
<summary><b>5 · Quick Sort</b> — partition around a pivot (random pivot avoids the O(n²) trap)</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 278" width="720" role="img" aria-label="Quick Sort"><defs><linearGradient id="g5" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="278" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g5)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Quick Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Pick a pivot, partition smaller values left and larger right — the pivot lands in its final place.</text><text x="24" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Pick pivot</text><rect x="170" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="196.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><rect x="228" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="254.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="286" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="312.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">9</text><rect x="344" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="402" y="76" width="52" height="40" rx="7" fill="#db2777"/><text x="428.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><text x="476" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">pivot = last element (6)</text><text x="24" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Partition</text><rect x="170" y="132" width="52" height="40" rx="7" fill="#f97316"/><text x="196.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="228" y="132" width="52" height="40" rx="7" fill="#f97316"/><text x="254.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="286" y="132" width="52" height="40" rx="7" fill="#db2777"/><text x="312.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="344" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="370.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><rect x="402" y="132" width="52" height="40" rx="7" fill="#3b3560"/><text x="428.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">9</text><text x="476" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">smaller | pivot | larger</text><text x="24" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Recurse</text><rect x="170" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="196.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="228" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="254.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="286" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="312.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="344" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="370.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><rect x="402" y="188" width="52" height="40" rx="7" fill="#16a34a"/><text x="428.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">9</text><text x="476" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">repeat on left and right parts</text><rect x="24" y="254" width="11" height="11" rx="3" fill="#db2777"/><text x="41" y="264" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">pivot</text><rect x="94.5" y="254" width="11" height="11" rx="3" fill="#f97316"/><text x="111.5" y="264" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">smaller than pivot</text><rect x="246.89999999999998" y="254" width="11" height="11" rx="3" fill="#3b3560"/><text x="263.9" y="264" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">larger than pivot</text><rect x="393.0" y="254" width="11" height="11" rx="3" fill="#16a34a"/><text x="410.0" y="264" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
private static final Random RNG = new Random();

public void quickSort(int[] a, int lo, int hi) {
    if (lo >= hi) return;
    int p = partition(a, lo, hi);
    quickSort(a, lo, p - 1);
    quickSort(a, p + 1, hi);
}

private int partition(int[] a, int lo, int hi) {
    swap(a, lo + RNG.nextInt(hi - lo + 1), hi);     // random pivot to the end
    int pivot = a[hi], i = lo;
    for (int j = lo; j < hi; j++) {
        if (a[j] < pivot) swap(a, i++, j);
    }
    swap(a, i, hi);
    return i;                                       // pivot's final index
}
```
</details>

<details>
<summary><b>6 · Heap Sort</b> — build a max-heap, repeatedly move the max to the end</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 334" width="720" role="img" aria-label="Heap Sort"><defs><linearGradient id="g6" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="334" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g6)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Heap Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Build a max-heap, then repeatedly swap the root (maximum) to the end and heapify the rest.</text><line x1="120" y1="100" x2="70" y2="160" stroke="#6b6495" stroke-width="1.5"/><line x1="120" y1="100" x2="170" y2="160" stroke="#6b6495" stroke-width="1.5"/><line x1="70" y1="160" x2="45" y2="220" stroke="#6b6495" stroke-width="1.5"/><line x1="70" y1="160" x2="95" y2="220" stroke="#6b6495" stroke-width="1.5"/><circle cx="120" cy="100" r="19" fill="#f97316"/><text x="120" y="106" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><circle cx="70" cy="160" r="19" fill="#3b3560"/><text x="70" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><circle cx="170" cy="160" r="19" fill="#3b3560"/><text x="170" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><circle cx="45" cy="220" r="19" fill="#3b3560"/><text x="45" y="226" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><circle cx="95" cy="220" r="19" fill="#3b3560"/><text x="95" y="226" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><text x="24" y="262" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">Max-heap: parent ≥ children</text><text x="260" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="start" font-weight="bold">Max-heap</text><rect x="420" y="76" width="48" height="40" rx="7" fill="#f97316"/><text x="444.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><rect x="474" y="76" width="48" height="40" rx="7" fill="#3b3560"/><text x="498.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="528" y="76" width="48" height="40" rx="7" fill="#3b3560"/><text x="552.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="582" y="76" width="48" height="40" rx="7" fill="#3b3560"/><text x="606.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="636" y="76" width="48" height="40" rx="7" fill="#3b3560"/><text x="660.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><text x="260" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="start" font-weight="bold">Swap root ↔ last</text><rect x="420" y="132" width="48" height="40" rx="7" fill="#db2777"/><text x="444.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="474" y="132" width="48" height="40" rx="7" fill="#3b3560"/><text x="498.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="528" y="132" width="48" height="40" rx="7" fill="#3b3560"/><text x="552.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="582" y="132" width="48" height="40" rx="7" fill="#3b3560"/><text x="606.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="636" y="132" width="48" height="40" rx="7" fill="#16a34a"/><text x="660.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><text x="260" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="start" font-weight="bold">Heapify the rest</text><rect x="420" y="188" width="48" height="40" rx="7" fill="#3b3560"/><text x="444.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="474" y="188" width="48" height="40" rx="7" fill="#3b3560"/><text x="498.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="528" y="188" width="48" height="40" rx="7" fill="#3b3560"/><text x="552.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="582" y="188" width="48" height="40" rx="7" fill="#3b3560"/><text x="606.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="636" y="188" width="48" height="40" rx="7" fill="#16a34a"/><text x="660.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><text x="260" y="269" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="start" font-weight="bold">Repeat → sorted</text><rect x="420" y="244" width="48" height="40" rx="7" fill="#16a34a"/><text x="444.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="474" y="244" width="48" height="40" rx="7" fill="#16a34a"/><text x="498.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="528" y="244" width="48" height="40" rx="7" fill="#16a34a"/><text x="552.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="582" y="244" width="48" height="40" rx="7" fill="#16a34a"/><text x="606.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="636" y="244" width="48" height="40" rx="7" fill="#16a34a"/><text x="660.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">10</text><rect x="24" y="310" width="11" height="11" rx="3" fill="#f97316"/><text x="41" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">root / max</text><rect x="126.0" y="310" width="11" height="11" rx="3" fill="#db2777"/><text x="143.0" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">swapped in</text><rect x="228.0" y="310" width="11" height="11" rx="3" fill="#16a34a"/><text x="245.0" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void heapSort(int[] a) {
    int n = a.length;
    for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);   // build max-heap
    for (int end = n - 1; end > 0; end--) {
        swap(a, 0, end);
        heapify(a, end, 0);
    }
}

private void heapify(int[] a, int n, int i) {
    while (true) {
        int l = 2 * i + 1, r = l + 1, big = i;
        if (l < n && a[l] > a[big]) big = l;
        if (r < n && a[r] > a[big]) big = r;
        if (big == i) return;
        swap(a, i, big);
        i = big;
    }
}
```
</details>

<details>
<summary><b>7 · Shell Sort</b> — insertion sort with shrinking gaps</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 334" width="720" role="img" aria-label="Shell Sort"><defs><linearGradient id="g7" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="334" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g7)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Shell Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Insertion sort on elements that are one gap apart; shrink the gap until it is 1.</text><text x="24" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Start</text><rect x="190" y="76" width="52" height="40" rx="7" fill="#f97316"/><text x="216.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">9</text><rect x="248" y="76" width="52" height="40" rx="7" fill="#db2777"/><text x="274.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="306" y="76" width="52" height="40" rx="7" fill="#a855f7"/><text x="332.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="364" y="76" width="52" height="40" rx="7" fill="#0ea5e9"/><text x="390.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><rect x="422" y="76" width="52" height="40" rx="7" fill="#f97316"/><text x="448.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="480" y="76" width="52" height="40" rx="7" fill="#db2777"/><text x="506.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="538" y="76" width="52" height="40" rx="7" fill="#a855f7"/><text x="564.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="596" y="76" width="52" height="40" rx="7" fill="#0ea5e9"/><text x="622.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><text x="24" y="157" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">gap = 4</text><rect x="190" y="132" width="52" height="40" rx="7" fill="#f97316"/><text x="216.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="248" y="132" width="52" height="40" rx="7" fill="#db2777"/><text x="274.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="306" y="132" width="52" height="40" rx="7" fill="#a855f7"/><text x="332.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="364" y="132" width="52" height="40" rx="7" fill="#0ea5e9"/><text x="390.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="422" y="132" width="52" height="40" rx="7" fill="#f97316"/><text x="448.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">9</text><rect x="480" y="132" width="52" height="40" rx="7" fill="#db2777"/><text x="506.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="538" y="132" width="52" height="40" rx="7" fill="#a855f7"/><text x="564.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="596" y="132" width="52" height="40" rx="7" fill="#0ea5e9"/><text x="622.0" y="157.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><text x="24" y="213" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">gap = 2</text><rect x="190" y="188" width="52" height="40" rx="7" fill="#f97316"/><text x="216.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="248" y="188" width="52" height="40" rx="7" fill="#db2777"/><text x="274.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="306" y="188" width="52" height="40" rx="7" fill="#f97316"/><text x="332.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="364" y="188" width="52" height="40" rx="7" fill="#db2777"/><text x="390.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="422" y="188" width="52" height="40" rx="7" fill="#f97316"/><text x="448.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="480" y="188" width="52" height="40" rx="7" fill="#db2777"/><text x="506.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><rect x="538" y="188" width="52" height="40" rx="7" fill="#f97316"/><text x="564.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">9</text><rect x="596" y="188" width="52" height="40" rx="7" fill="#db2777"/><text x="622.0" y="213.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><text x="24" y="269" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">gap = 1</text><rect x="190" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="216.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><rect x="248" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="274.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="306" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="332.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">4</text><rect x="364" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="390.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="422" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="448.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="480" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="506.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><rect x="538" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="564.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">8</text><rect x="596" y="244" width="52" height="40" rx="7" fill="#16a34a"/><text x="622.0" y="269.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">9</text><rect x="24" y="310" width="11" height="11" rx="3" fill="#f97316"/><text x="41" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">same colour = same gap chain</text><rect x="239.4" y="310" width="11" height="11" rx="3" fill="#16a34a"/><text x="256.4" y="320" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void shellSort(int[] a) {
    for (int gap = a.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < a.length; i++) {
            int key = a[i], j = i;
            while (j >= gap && a[j - gap] > key) {
                a[j] = a[j - gap];
                j -= gap;
            }
            a[j] = key;
        }
    }
}
```
</details>

<details>
<summary><b>8 · Counting Sort</b> — count occurrences (non-negative ints, small range)</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 344" width="720" role="img" aria-label="Counting Sort"><defs><linearGradient id="g8" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="344" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g8)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Counting Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">For small integer ranges: count occurrences, then rebuild the array in order.</text><text x="24" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Input</text><rect x="150" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="176.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="208" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="234.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="266" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="292.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="324" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="350.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">0</text><rect x="382" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="408.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="440" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="466.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="498" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="524.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">0</text><rect x="556" y="76" width="52" height="40" rx="7" fill="#3b3560"/><text x="582.0" y="101.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><text x="24" y="191" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">count[ ]</text><text x="176" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">0</text><text x="234" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">1</text><text x="292" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">2</text><text x="350" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">3</text><text x="408" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">4</text><text x="466" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">5</text><rect x="150" y="172" width="52" height="40" rx="7" fill="#f97316"/><text x="176.0" y="197.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="208" y="172" width="52" height="40" rx="7" fill="#3b3560"/><text x="234.0" y="197.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">0</text><rect x="266" y="172" width="52" height="40" rx="7" fill="#f97316"/><text x="292.0" y="197.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="324" y="172" width="52" height="40" rx="7" fill="#f97316"/><text x="350.0" y="197.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="382" y="172" width="52" height="40" rx="7" fill="#3b3560"/><text x="408.0" y="197.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">0</text><rect x="440" y="172" width="52" height="40" rx="7" fill="#f97316"/><text x="466.0" y="197.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">1</text><text x="510" y="197" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">count[v] = times v appears</text><text x="24" y="281" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Output</text><rect x="150" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="176.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">0</text><rect x="208" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="234.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">0</text><rect x="266" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="292.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="324" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="350.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="382" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="408.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="440" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="466.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="498" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="524.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="556" y="256" width="52" height="40" rx="7" fill="#16a34a"/><text x="582.0" y="281.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><text x="620" y="281" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="start" font-weight="normal"></text><text x="150" y="244" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">↓ write each v, count[v] times</text><text x="150" y="136" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">↓ count every value</text><rect x="24" y="320" width="11" height="11" rx="3" fill="#3b3560"/><text x="41" y="330" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">value</text><rect x="94.5" y="320" width="11" height="11" rx="3" fill="#f97316"/><text x="111.5" y="330" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">present (count &gt; 0)</text><rect x="253.2" y="320" width="11" height="11" rx="3" fill="#16a34a"/><text x="270.2" y="330" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void countingSort(int[] a) {
    int max = 0;
    for (int x : a) max = Math.max(max, x);
    int[] cnt = new int[max + 1];
    for (int x : a) cnt[x]++;
    int idx = 0;
    for (int v = 0; v <= max; v++) {
        while (cnt[v]-- > 0) a[idx++] = v;
    }
}
```
</details>

<details>
<summary><b>9 · Radix Sort</b> — LSD, stable counting sort on each digit</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 404" width="720" role="img" aria-label="Radix Sort (LSD)"><defs><linearGradient id="g9" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="404" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g9)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Radix Sort (LSD)</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Stable-sort by each digit, from least significant to most significant.</text><text x="24" y="100" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Start</text><rect x="170" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="200.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">170</text><rect x="236" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="266.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">45</text><rect x="302" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="332.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">75</text><rect x="368" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="398.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">90</text><rect x="434" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="464.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">802</text><rect x="500" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="530.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">24</text><rect x="566" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="596.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="632" y="76" width="60" height="36" rx="7" fill="#3b3560"/><text x="662.0" y="99.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">66</text><text x="24" y="169" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Pass 1 · ones</text><rect x="170" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="200.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">170</text><rect x="236" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="266.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">90</text><rect x="302" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="332.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">802</text><rect x="368" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="398.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="434" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="464.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">24</text><rect x="500" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="530.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">45</text><rect x="566" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="596.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">75</text><rect x="632" y="146" width="60" height="36" rx="7" fill="#3b3560"/><text x="662.0" y="169.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">66</text><text x="200" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="266" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="332" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=2</text><text x="398" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=2</text><text x="464" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=4</text><text x="530" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=5</text><text x="596" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=5</text><text x="662" y="196" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=6</text><text x="24" y="245" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Pass 2 · tens</text><rect x="170" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="200.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">802</text><rect x="236" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="266.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="302" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="332.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">24</text><rect x="368" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="398.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">45</text><rect x="434" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="464.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">66</text><rect x="500" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="530.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">170</text><rect x="566" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="596.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">75</text><rect x="632" y="222" width="60" height="36" rx="7" fill="#3b3560"/><text x="662.0" y="245.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">90</text><text x="200" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="266" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="332" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=2</text><text x="398" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=4</text><text x="464" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=6</text><text x="530" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=7</text><text x="596" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=7</text><text x="662" y="272" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=9</text><text x="24" y="321" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Pass 3 · hundreds</text><rect x="170" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="200.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="236" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="266.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">24</text><rect x="302" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="332.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">45</text><rect x="368" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="398.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">66</text><rect x="434" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="464.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">75</text><rect x="500" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="530.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">90</text><rect x="566" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="596.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">170</text><rect x="632" y="298" width="60" height="36" rx="7" fill="#16a34a"/><text x="662.0" y="321.25" font-family="Segoe UI,Arial,sans-serif" font-size="15" fill="#fff" text-anchor="middle" font-weight="bold">802</text><text x="200" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="266" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="332" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="398" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="464" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="530" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=0</text><text x="596" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=1</text><text x="662" y="348" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#f97316" text-anchor="middle" font-weight="bold">d=8</text><rect x="24" y="380" width="11" height="11" rx="3" fill="#f97316"/><text x="41" y="390" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">digit used in this pass</text><rect x="207.9" y="380" width="11" height="11" rx="3" fill="#16a34a"/><text x="224.9" y="390" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void radixSort(int[] a) {
    int max = 0;
    for (int x : a) max = Math.max(max, x);
    for (int exp = 1; max / exp > 0; exp *= 10) countByDigit(a, exp);
}

private void countByDigit(int[] a, int exp) {
    int n = a.length;
    int[] out = new int[n], c = new int[10];
    for (int x : a) c[(x / exp) % 10]++;
    for (int i = 1; i < 10; i++) c[i] += c[i - 1];
    for (int i = n - 1; i >= 0; i--) out[--c[(a[i] / exp) % 10]] = a[i];   // right→left keeps stability
    System.arraycopy(out, 0, a, 0, n);
}
```
</details>

<details>
<summary><b>10 · Bucket Sort</b> — values in [0, 1) spread into buckets</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 352" width="720" role="img" aria-label="Bucket Sort"><defs><linearGradient id="g10" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="352" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g10)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Bucket Sort</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Spread values into buckets, sort each small bucket, then concatenate.</text><text x="24" y="74" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="start" font-weight="bold">Input</text><rect x="32" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="63.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.78</text><rect x="98" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="129.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.17</text><rect x="164" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="195.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.39</text><rect x="230" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="261.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.26</text><rect x="296" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="327.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.72</text><rect x="362" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="393.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.94</text><rect x="428" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="459.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.21</text><rect x="494" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="525.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.12</text><rect x="560" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="591.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.23</text><rect x="626" y="82" width="62" height="34" rx="7" fill="#3b3560"/><text x="657.0" y="103.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.68</text><text x="32" y="140" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">↓ scatter: bucket = floor(x × 10), then sort each bucket</text><rect x="32" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="63" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[0]</text><rect x="98" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="129" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[1]</text><rect x="102" y="172" width="54" height="20" rx="7" fill="#f97316"/><text x="129.0" y="186.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.12</text><rect x="102" y="195" width="54" height="20" rx="7" fill="#f97316"/><text x="129.0" y="209.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.17</text><rect x="164" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="195" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[2]</text><rect x="168" y="172" width="54" height="20" rx="7" fill="#f97316"/><text x="195.0" y="186.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.21</text><rect x="168" y="195" width="54" height="20" rx="7" fill="#f97316"/><text x="195.0" y="209.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.23</text><rect x="168" y="218" width="54" height="20" rx="7" fill="#f97316"/><text x="195.0" y="232.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.26</text><rect x="230" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="261" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[3]</text><rect x="234" y="172" width="54" height="20" rx="7" fill="#f97316"/><text x="261.0" y="186.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.39</text><rect x="296" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="327" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[4]</text><rect x="362" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="393" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[5]</text><rect x="428" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="459" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[6]</text><rect x="432" y="172" width="54" height="20" rx="7" fill="#f97316"/><text x="459.0" y="186.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.68</text><rect x="494" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="525" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[7]</text><rect x="498" y="172" width="54" height="20" rx="7" fill="#f97316"/><text x="525.0" y="186.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.72</text><rect x="498" y="195" width="54" height="20" rx="7" fill="#f97316"/><text x="525.0" y="209.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.78</text><rect x="560" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="591" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[8]</text><rect x="626" y="150" width="62" height="96" rx="7" fill="none" stroke="#6b6495" stroke-width="1.5"/><text x="657" y="166" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="middle" font-weight="normal">[9]</text><rect x="630" y="172" width="54" height="20" rx="7" fill="#f97316"/><text x="657.0" y="186.2" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#fff" text-anchor="middle" font-weight="bold">0.94</text><text x="32" y="268" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">↓ gather buckets in order</text><rect x="32" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="63.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.12</text><rect x="98" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="129.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.17</text><rect x="164" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="195.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.21</text><rect x="230" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="261.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.23</text><rect x="296" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="327.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.26</text><rect x="362" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="393.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.39</text><rect x="428" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="459.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.68</text><rect x="494" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="525.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.72</text><rect x="560" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="591.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.78</text><rect x="626" y="276" width="62" height="34" rx="7" fill="#16a34a"/><text x="657.0" y="297.55" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="middle" font-weight="bold">0.94</text><rect x="24" y="328" width="11" height="11" rx="3" fill="#3b3560"/><text x="41" y="338" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">input</text><rect x="94.5" y="328" width="11" height="11" rx="3" fill="#f97316"/><text x="111.5" y="338" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted inside bucket</text><rect x="259.5" y="328" width="11" height="11" rx="3" fill="#16a34a"/><text x="276.5" y="338" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">sorted</text></svg>
</div>

```java
public void bucketSort(float[] a) {
    int n = a.length;
    List<List<Float>> buckets = new ArrayList<>();
    for (int i = 0; i < n; i++) buckets.add(new ArrayList<>());
    for (float x : a) buckets.get((int) (x * n)).add(x);
    int idx = 0;
    for (List<Float> b : buckets) {
        Collections.sort(b);
        for (float x : b) a[idx++] = x;
    }
}
```
</details>

---

<div align="center">

## 🎯 Important Questions

| # | Problem | Level | Sort Behind It | Link |
|:-:|:--|:-:|:--|:-:|
| 1 | **Count Inversions** | 🔴 Hard | Merge Sort | [![GFG](https://img.shields.io/badge/GFG-2F8D46?style=flat-square&logo=geeksforgeeks&logoColor=white)](https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1/) [![TUF](https://img.shields.io/badge/TUF-7C3AED?style=flat-square)](https://takeuforward.org/practice/dsa/count-inversions) |
| 2 | **Reverse Pairs** | 🔴 Hard | Merge Sort | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/reverse-pairs/) |
| 3 | **Count of Smaller Numbers After Self** | 🔴 Hard | Merge Sort (on indices) | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) |
| 4 | **Merge Sorted Array** | 🟢 Easy | Merge step | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/merge-sorted-array/) |
| 5 | **Sort List** | 🟡 Medium | Merge Sort on Linked List | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/sort-list/) |
| 6 | **Kth Largest Element in an Array** | 🟡 Medium | Quickselect / Heap | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/kth-largest-element-in-an-array/) |
| 7 | **Sort an Array** | 🟡 Medium | Merge / Quick / Heap | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/sort-an-array/) |
| 8 | **Sort Colors** | 🟡 Medium | Counting / Partition | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/sort-colors/) |
| 9 | **Merge Intervals** | 🟡 Medium | Sort by start | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/merge-intervals/) |
| 10 | **Largest Number** | 🟡 Medium | Custom Comparator | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/largest-number/) |
| 11 | **Insertion Sort List** | 🟡 Medium | Insertion Sort | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/insertion-sort-list/) |
| 12 | **Top K Frequent Elements** | 🟡 Medium | Bucket Sort / Heap | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/top-k-frequent-elements/) |
| 13 | **Relative Sort Array** | 🟢 Easy | Counting Sort | [![LeetCode](https://img.shields.io/badge/LeetCode-FFA116?style=flat-square&logo=leetcode&logoColor=white)](https://leetcode.com/problems/relative-sort-array/) |

</div>

> [!TIP]
> **Keyword → Sort:** "count pairs `i < j` with `a[i] ? a[j]`" → **Merge Sort**. "Kth largest/smallest" → **Quickselect / Heap**. "Values in small range" → **Counting Sort**. "Order by custom rule" → **Comparator**.

---

## 🧠 Question Snippets

<details>
<summary><b>Count Inversions</b> — pairs with <code>i &lt; j</code> and <code>a[i] &gt; a[j]</code> (merge sort)</summary>

<div align="center">
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 720 336" width="720" role="img" aria-label="Counting Inversions While Merging"><defs><linearGradient id="g11" x1="0" x2="1"><stop offset="0" stop-color="#f97316"/><stop offset="1" stop-color="#db2777"/></linearGradient></defs><rect width="720" height="336" rx="14" fill="#1e1b2e"/><rect x="14" y="0" width="692" height="4" rx="2" fill="url(#g11)"/><text x="24" y="32" font-family="Segoe UI,Arial,sans-serif" font-size="18" fill="#fff" text-anchor="start" font-weight="bold">Counting Inversions While Merging</text><text x="24" y="52" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">Every time a right element is taken first, it is smaller than all remaining left elements.</text><text x="24" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Left (sorted)</text><rect x="190" y="76" width="46" height="36" rx="7" fill="#3b3560"/><text x="213.0" y="99.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="242" y="76" width="46" height="36" rx="7" fill="#3b3560"/><text x="265.0" y="99.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="294" y="76" width="46" height="36" rx="7" fill="#3b3560"/><text x="317.0" y="99.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><text x="24" y="151" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Right (sorted)</text><rect x="190" y="126" width="46" height="36" rx="7" fill="#3b3560"/><text x="213.0" y="149.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="242" y="126" width="46" height="36" rx="7" fill="#3b3560"/><text x="265.0" y="149.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><text x="24" y="221" font-family="Segoe UI,Arial,sans-serif" font-size="13" fill="#fff" text-anchor="start" font-weight="bold">Merged</text><rect x="190" y="196" width="46" height="36" rx="7" fill="#f97316"/><text x="213.0" y="219.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">2</text><rect x="242" y="196" width="46" height="36" rx="7" fill="#3b3560"/><text x="265.0" y="219.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">3</text><rect x="294" y="196" width="46" height="36" rx="7" fill="#3b3560"/><text x="317.0" y="219.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">5</text><rect x="346" y="196" width="46" height="36" rx="7" fill="#f97316"/><text x="369.0" y="219.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">6</text><rect x="398" y="196" width="46" height="36" rx="7" fill="#3b3560"/><text x="421.0" y="219.6" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#fff" text-anchor="middle" font-weight="bold">7</text><text x="213" y="252" font-family="Segoe UI,Arial,sans-serif" font-size="14" fill="#f97316" text-anchor="middle" font-weight="bold">+3</text><text x="369" y="252" font-family="Segoe UI,Arial,sans-serif" font-size="14" fill="#f97316" text-anchor="middle" font-weight="bold">+1</text><text x="190" y="274" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">2 jumps ahead of 3, 5, 7 → +3</text><text x="190" y="292" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">6 jumps ahead of 7 → +1</text><text x="458" y="226" font-family="Segoe UI,Arial,sans-serif" font-size="16" fill="#db2777" text-anchor="start" font-weight="bold">Total = 4</text><text x="400" y="101" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">if a[i] ≤ a[j] → take left</text><text x="400" y="151" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">if a[i] &gt; a[j] → take right,</text><text x="400" y="167" font-family="Segoe UI,Arial,sans-serif" font-size="12" fill="#b9b4d6" text-anchor="start" font-weight="normal">add (m − i + 1) inversions</text><rect x="24" y="312" width="11" height="11" rx="3" fill="#3b3560"/><text x="41" y="322" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">element</text><rect x="107.1" y="312" width="11" height="11" rx="3" fill="#f97316"/><text x="124.1" y="322" font-family="Segoe UI,Arial,sans-serif" font-size="11" fill="#b9b4d6" text-anchor="start" font-weight="normal">taken from right</text></svg>
</div>

**Idea:** while merging two sorted halves, if `a[i] > a[j]`, then *every* remaining element in the left half (`m - i + 1` of them) is also greater than `a[j]`.

```java
public long countInversions(int[] a) {
    return sort(a, 0, a.length - 1);
}

private long sort(int[] a, int l, int r) {
    if (l >= r) return 0;
    int m = l + (r - l) / 2;
    long cnt = sort(a, l, m) + sort(a, m + 1, r);
    int[] t = new int[r - l + 1];
    int i = l, j = m + 1, k = 0;
    while (i <= m && j <= r) {
        if (a[i] <= a[j]) t[k++] = a[i++];
        else { cnt += m - i + 1; t[k++] = a[j++]; }
    }
    while (i <= m) t[k++] = a[i++];
    while (j <= r) t[k++] = a[j++];
    System.arraycopy(t, 0, a, l, t.length);
    return cnt;
}
```
</details>

<details>
<summary><b>Reverse Pairs</b> — pairs with <code>i &lt; j</code> and <code>a[i] &gt; 2 * a[j]</code></summary>

**Idea:** same as inversions, but **count first, merge after**. Both halves are sorted, so a single moving pointer `j` is enough. Use `2L` to avoid overflow.

```java
public int reversePairs(int[] a) {
    return sort(a, 0, a.length - 1);
}

private int sort(int[] a, int l, int r) {
    if (l >= r) return 0;
    int m = l + (r - l) / 2;
    int cnt = sort(a, l, m) + sort(a, m + 1, r);
    int j = m + 1;
    for (int i = l; i <= m; i++) {
        while (j <= r && (long) a[i] > 2L * a[j]) j++;
        cnt += j - (m + 1);
    }
    merge(a, l, m, r);                  // standard merge from section 4
    return cnt;
}
```
</details>

<details>
<summary><b>Count of Smaller Numbers After Self</b> — merge sort on indices</summary>

**Idea:** sort *indices* by value. When an element from the left half is placed, add the number of right-half elements already placed (all strictly smaller).

```java
private int[] cnt;

public List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    cnt = new int[n];
    int[] idx = new int[n];
    for (int i = 0; i < n; i++) idx[i] = i;
    sort(nums, idx, 0, n - 1, new int[n]);
    List<Integer> res = new ArrayList<>();
    for (int c : cnt) res.add(c);
    return res;
}

private void sort(int[] a, int[] idx, int l, int r, int[] tmp) {
    if (l >= r) return;
    int m = l + (r - l) / 2;
    sort(a, idx, l, m, tmp);
    sort(a, idx, m + 1, r, tmp);
    int i = l, j = m + 1, k = l, right = 0;
    while (i <= m || j <= r) {
        if (j > r || (i <= m && a[idx[i]] <= a[idx[j]])) {
            cnt[idx[i]] += right;
            tmp[k++] = idx[i++];
        } else {
            right++;
            tmp[k++] = idx[j++];
        }
    }
    for (k = l; k <= r; k++) idx[k] = tmp[k];
}
```
</details>

<details>
<summary><b>Kth Largest Element</b> — Quickselect (average <code>O(n)</code>)</summary>

**Idea:** the Kth largest sits at index `n - k` once sorted. Partition, then only recurse into the side that contains it.

```java
public int findKthLargest(int[] a, int k) {
    int target = a.length - k, lo = 0, hi = a.length - 1;
    while (lo <= hi) {
        int p = partition(a, lo, hi);       // partition from section 5
        if (p == target) return a[p];
        if (p < target) lo = p + 1;
        else hi = p - 1;
    }
    return -1;
}
```

**Heap alternative (`O(n log k)`):**
```java
public int findKthLargestHeap(int[] a, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int x : a) {
        pq.offer(x);
        if (pq.size() > k) pq.poll();
    }
    return pq.peek();
}
```
</details>

<details>
<summary><b>Largest Number</b> — custom comparator</summary>

**Idea:** `x` goes before `y` if `x + y` &gt; `y + x` as strings.

```java
public String largestNumber(int[] nums) {
    String[] s = new String[nums.length];
    for (int i = 0; i < nums.length; i++) s[i] = String.valueOf(nums[i]);
    Arrays.sort(s, (x, y) -> (y + x).compareTo(x + y));
    if (s[0].equals("0")) return "0";           // all zeros
    return String.join("", s);
}
```
</details>

<details>
<summary><b>Merge Sorted Array</b> — merge from the back, no extra space</summary>

```java
public void merge(int[] a, int m, int[] b, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (j >= 0) {
        if (i >= 0 && a[i] > b[j]) a[k--] = a[i--];
        else a[k--] = b[j--];
    }
}
```
</details>

<details>
<summary><b>Merge Intervals</b> — sort by start, then sweep</summary>

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
</details>

---

## ⚠️ Java Sorting Pitfalls

| Pitfall | Fix |
|:--|:--|
| Comparator `(a, b) -> a - b` can overflow | Use `Integer.compare(a, b)` |
| `Arrays.sort(int[], comparator)` doesn't compile | Use `Integer[]`, or sort then reverse |
| Counting inversions with `int` | Use `long` (up to ~n²/2 pairs) |
| `a[i] > 2 * a[j]` overflows | Use `(long) a[i] > 2L * a[j]` |
| Quick Sort on sorted input is `O(n²)` | Random or median pivot |
| Counting Sort with negatives | Shift every value by `-min` |

---

## 🧠 Recommended Practice Flow

1. Write the sort from memory on a small array.
2. Dry-run one pass by hand.
3. Say its time, space and stability out loud.
4. Solve the question it powers (Inversions → Reverse Pairs → Smaller After Self).
5. Check the editorial only after your own attempt.

### ✅ Quick Revision Checklist

- [ ] Bubble, Selection, Insertion — 3
- [ ] Merge, Quick, Heap — 3
- [ ] Shell, Counting, Radix, Bucket — 4
- [ ] Merge-Sort questions: Inversions, Reverse Pairs, Smaller After Self
- [ ] Quickselect: Kth Largest

<div align="center">

![footer](https://capsule-render.vercel.app/api?type=waving&color=0:db2777,100:f97316&height=90&section=footer)

</div>
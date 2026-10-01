<div align="center">

# 🧠 DSA Mindset Playbook

*Not problems. Habits, tricks and thinking tools that build real logic.*

![Type](https://img.shields.io/badge/Type-Mindset-6C63FF?style=for-the-badge)
![Use](https://img.shields.io/badge/Use-Daily-2ea44f?style=for-the-badge)

</div>

> [!NOTE]
> Problems teach you *solutions*. These habits teach you *how to find solutions*. Skim once, then pick **two** to practice this week.

---

## 1. 🪜 The 5-Step Thinking Loop (use on every problem)

| Step | Question to ask yourself |
|:-:|:--|
| 1 | **Understand:** can I explain the problem in my own words? What are input, output, constraints? |
| 2 | **Examples:** can I solve 2–3 tiny cases by hand, including an edge case? |
| 3 | **Brute force:** what is the dumbest correct solution? Write its complexity. |
| 4 | **Optimise:** *what am I repeating or wasting?* Remove that waste. |
| 5 | **Verify:** dry-run, check edge cases, state final time and space complexity. |

> Never skip step 3. The brute force is where the optimal idea hides.

---

## 2. 🔍 The Magic Question: "What Am I Repeating?"

Almost every optimisation is the same move: **stop doing work twice.**

| Repeated work | Fix |
|:--|:--|
| Re-scanning to look something up | Hash map / set |
| Re-adding the same range of numbers | Prefix sum |
| Re-checking a window from scratch | Sliding window |
| Re-solving the same subproblem | Memoisation / DP |
| Re-searching in sorted data | Binary search |
| Comparing every pair | Sort + two pointers |

---

## 3. 📏 Constraints Are Hints (Read Them First)

The input size tells you the target complexity.

| n is about | Aim for | Typical ideas |
|:-:|:-:|:--|
| ≤ 10 | O(n!) / O(2ⁿ) | Backtracking, brute force |
| ≤ 20 | O(2ⁿ) | Bitmask, subsets |
| ≤ 500 | O(n³) | Triple loops, Floyd-Warshall |
| ≤ 5,000 | O(n²) | Nested loops, basic DP |
| ≤ 10⁵ | O(n log n) | Sorting, heap, binary search |
| ≤ 10⁶ | O(n) | Hashing, two pointers, sliding window |
| ≤ 10⁹ or more | O(log n) / O(1) | Binary search, math |

---

## 4. 🎯 Keyword → Technique Triggers

Train your brain to *react* to words in the problem.

| If you see... | Think... |
|:--|:--|
| "sorted array" | Binary search, two pointers |
| "subarray / substring" | Sliding window, prefix sum |
| "count / frequency / duplicate" | Hash map |
| "pair with sum" | Hash map or two pointers |
| "all combinations / permutations / subsets" | Recursion + backtracking |
| "minimum / maximum / count ways" | DP or greedy |
| "next greater / smaller" | Monotonic stack |
| "shortest path (unweighted)" | BFS |
| "parentheses / matching / undo" | Stack |
| "top K / K-th largest" | Heap |
| "linked list middle / cycle" | Slow & fast pointers |
| "in-place / O(1) space" | Two pointers, swapping, XOR |

---

## 5. 🧪 Small-Case Detective

Stuck? Solve **n = 1, 2, 3, 4** by hand and write each answer in a row. Look for the pattern.

```
n=1 -> 1
n=2 -> 2
n=3 -> 3
n=4 -> 5   <- looks like Fibonacci! (Climbing Stairs)
```

If you can't see the pattern, ask: *"How does the answer for n relate to the answer for n-1?"* That is the seed of recursion and DP.

---

## 6. 🔁 Reduce to a Known Problem

Before inventing something new, ask:
- Is this *Two Sum* in disguise?
- Is this *Binary Search* on the answer?
- Can I *sort first* and make it easy?
- Can I *reverse* the problem (work from the end)?
- Can I solve a *simpler version* first (1D before 2D, sorted before unsorted)?

Keep a "Disguises" list in your repo. Over time you will notice the same ~20 ideas repeating.

---

## 7. 🧱 Think in Invariants

An **invariant** is something that stays true at every step of a loop.

- Binary search: *"the answer is always inside [low, high]."*
- Selection sort: *"everything left of i is sorted and final."*
- Sliding window: *"the window always satisfies the rule."*
- Kadane's: *"current is the best sum ending at this index."*

Write the invariant as a comment above your loop. Bugs usually mean the invariant was broken.

---

## 8. 📝 Dry-Run Table Habit

Never "feel" that code is right. **Prove it with a trace table.**

| step | i | j | variable A | variable B | note |
|:-:|:-:|:-:|:-:|:-:|:--|
| 1 | 0 | 4 | | | |
| 2 | 1 | 3 | | | |

Do this on paper with one normal case and one edge case.

---

## 9. ⚠️ Edge Case Checklist

Run through this before submitting:

- [ ] Empty input / single element
- [ ] All elements the same
- [ ] Already sorted / reverse sorted
- [ ] Negative numbers and zero
- [ ] Duplicates
- [ ] Very large values (integer overflow?)
- [ ] Off-by-one on loop bounds (`<` vs `<=`)
- [ ] Even vs odd length

---

## 10. ⏱️ The Struggle Timer + Hint Ladder

Struggle is useful, but endless struggle is not.

| Time | Action |
|:-:|:--|
| 0–15 min | Think and try on paper, no hints |
| 15–25 min | Read only the **topic tag** (e.g. "Hashing") |
| 25–35 min | Read the **first line** of the approach |
| 35+ min | Watch / read the full solution |
| After | **Close it and code it from scratch**, no peeking |

> If you needed the full solution, re-solve the same problem after 3 days.

---

## 11. 🔂 Spaced Repetition (1 → 3 → 7 → 21)

You forget what you do not revisit. Re-solve problems after **1, 3, 7 and 21 days.** Mark a problem *"mastered"* only after you solve it cold, once, after a week.

**Daily routine:** 1 new problem + 1 revisit. Small and consistent beats a 10-hour weekend.

---

## 12. 🎮 Fun Challenges That Build Logic

| Challenge | What it trains |
|:--|:--|
| **Predict first:** guess the technique before reading the solution | Pattern recognition |
| **Handicap mode:** solve it again with O(1) extra space | Creativity |
| **Two ways:** solve with a hash map, then without | Flexibility |
| **Teach a beginner:** explain it in 5 lines without jargon | Deep understanding |
| **Break your own code:** write 3 tests meant to make it fail | Edge-case sense |
| **Follow-up game:** "what if the array is sorted / streaming / huge?" | Interview thinking |
| **Language swap:** re-solve in another language | Logic over syntax |
| **Reverse the problem:** can you count / find the *opposite*? | Lateral thinking |

---

## 13. 📓 Mistake Journal (the most underrated habit)

Keep `mistakes.md`. Every wrong submission goes here.

| Date | Problem | What went wrong | Root cause | Lesson |
|:--|:--|:--|:--|:--|
| 2026-10-02 | Two Sum | Used same element twice | Didn't read the statement | Re-read the constraints |

Categories of root cause: *misread problem / missed edge case / wrong approach / off-by-one / forgot to update variable / weak concept.* After 2 weeks, count which one dominates. **That is your real weakness.**

---

## 14. 🗂️ GitHub Setup That Keeps You Motivated

**Suggested structure**

```
dsa-journey/
├── README.md              <- progress + links to all trackers
├── 01-basics/
│   ├── maths/
│   ├── arrays/
│   └── strings/
├── 02-sorting/
├── 03-hashing/
├── 04-recursion/
├── notes/
│   ├── patterns.md        <- keyword -> technique table
│   ├── disguises.md       <- "this is secretly Two Sum"
│   └── mistakes.md
└── revision/
    └── revisit-queue.md
```

**Per-problem note template** (put it at the top of each solution file)

```
# Problem: <name>   | Platform: LC / GFG / TUF | Level: Easy
Link: <url>

## Idea in one line
<how I solved it>

## Pattern
<hashing / two pointers / ...>

## Approaches
1. Brute force -> O(?) time, O(?) space
2. Better      -> O(?) time, O(?) space
3. Optimal     -> O(?) time, O(?) space

## Mistakes / edge cases
- ...

## Revisit on: <date>
```

**Commit message habit:** `solve: two-sum (hashing) - O(n)` or `revise: kadane - solved cold`. Your commit graph then becomes a diary of growth.

---

## 15. 🧘 Mindset Rules

1. **"I don't know *yet*."** Stuck is a normal state, not a verdict on you.
2. **Understanding beats count.** 50 problems truly understood beat 300 skimmed.
3. **Plateaus are real.** Progress is invisible for weeks, then jumps. Keep going.
4. **Never copy-paste.** Typing a solution you don't understand teaches nothing.
5. **Compare with yesterday's you,** not other people's streaks.
6. **Fundamentals first.** Loops, arrays, recursion, hashing make everything else easier.
7. **Explain out loud.** If you can't explain it, you don't know it yet.

---

## 🧭 Your Weekly Review (10 minutes, every Sunday)

- What did I solve this week? Which pattern did I meet most?
- Which problem did I need the full solution for? (Add to revisit queue.)
- What does my mistake journal say my top weakness is?
- What is **one** habit from this playbook I'll practice next week?

---

<div align="center">

*Consistency + reflection = logic that sticks. Happy coding! 🚀*

</div>
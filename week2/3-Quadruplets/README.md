# Quadruplets

Given four vectors of `N` integer values, compute how many quadruplets
(one element from every vector) form a total sum of zero.

```
zero_quadruplets_count(a, b, c, d) {
  ...
  return count
}
```

## Example

```
zero_quadruplets_count([5, 3, 4], [-2, -1, 6], [-1, -2, 4], [-1, -2, 7])
=> 5
=======
Implement a function in [Java](Quadruplets.java), [Python](quadruplets.py)
or [C++](quadruplets.cpp) that given four vectors of `N` integer values,
computes how many quadruplets (one element from every vector) form a total
sum of zero.

## Limits

```
1 <= N <= 7000
```

## Example

Input:
```
3
5 3 4
-2 -1 6
-1 -2 4
-1 -2 7
```

Output:
```
7
```

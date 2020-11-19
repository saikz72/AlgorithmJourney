# DYNAMIC PROGRAMMING

We make use of the bottom up approach where we calculate smaller terms and walk our way up to the problem.

### When to use it?
* When the problem has optimal substructure (a problem is said to have optimal substructure if an optimal solution can be constructed fromoptimal solutions
of its subproblem. source wikipedia)

* <b>Note</b> : typically use greedy if the problem does not exhibit overlapping subproblems (like non-weighted activity selection problem) but dynamic programming
otherwise ( Fibonnaci sequence because sub-problems are reuse several times. e.g. F(n) = F(n-1) + F(n-2) but to comput F(n-1) we still depend on the sub-problem
F(n-2)) . 

### Weighted activity selection problem
- Sort the activities base on finishing time
- compte P (j) : largest i < j such that the activity j is compatible with i

<b>Two cases</b> : <br />
#### case 1
- Optimal solution (Opt) selects j
- add weight of j in the answer
- next select from {1,2...... P(j)}

#### case 2 
- Opt excludes j 
- next select from {1,2,.....P(j-1)}

* <b>Note</b> Since j could be less than the last activity n, then Opt might just be a subset of the optimal solution. 

### Solutions
1. Naive approach(Brute force) -> 
 ```
 Opt(j) =
 {  
    return 0                                       if j = 0
    return max (Opt( Weight(j) + Opt(P(j)), Opt(j-1)))   otherwise
 }       
 ```
 #### Runtime Complexity :
 #### Space Complexity :
 
 
 2. Memoization (Top - down approach)
 ```
initialize table of size n (M[n]):

for j = 1 to n :
  M[j] = empty
M[0] = 0     //base 

M_Opt(j):
if M[n] == empty
{
  M[j] = max(Weight(j) + M_Opt(P(j)), M_Opt(j - 1)))
}
return M[j]
```

 3. Dynamic Programming (Bottom - up approach)
 ```
initialize dynamic table of size n (M[n]):
M[0] = 0

for i = n :
  M[i] = max(Weight(j) + M[(P(j)], M[j - 1]))
  
return M[i]
 ```
 * <b>Note</b>: To build up the values that consitute the optimal solution, we use  <b>backtracking</b>. 
 
 
 
 
 
 
 
 
 
 

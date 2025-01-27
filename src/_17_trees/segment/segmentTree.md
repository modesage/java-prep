we use segment trees when 
we need to perform query on a range
like sum, avg, max, min, prod inside a range
in O(log(N))

- advantage:
everything happens in O(log(n)), like search, update etc
- disadvantage:
need to create extra space

segment tree is a binary tree which has internal info(like range) and query / operation(like sum)

segment tree is a full binary tree

- so leaf nodes = N
- internal node = N-1
- total nodes = 2N - 1

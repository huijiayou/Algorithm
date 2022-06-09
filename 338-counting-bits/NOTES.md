​create a array, count.length = n + 1
count[0] = 0
count[i] = count[i / 2] + i & 1
2: 010
4: 100
5: 101
if we want to calculate 4, 2 << 1
if we want to calculate 5, 2 << 1 + 1

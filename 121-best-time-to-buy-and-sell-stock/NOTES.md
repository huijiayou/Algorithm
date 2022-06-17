​     0  1   2   3   4   5
    [7, 1,  5,  3,  6,  4]
        i
     
 min: find lower price, update index
 profit: prices[cur] - prices[min] > profit
 
 if want to use min and max to remember the index of buy and sell,
 when buy index update, sell index need to update too so that max >= min
 we also need to maintain a profit to remember the global profit
 min
 max
 profit

but ususally we can use the current index i for max

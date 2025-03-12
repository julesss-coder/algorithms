/*
Problem by Gordon Zhu and Lily Gentner from Watch and Code, www.watchandcode.com
Solutions by me
-----------------------------------------------------------------------------------

Imagine you're testing strategies for when to buy and sell stocks. 
Each function should take an array of prices and a starting amount of money. They should determine how much money you'd have at the end. A few important notes:

- You can only buy full shares.
- You can't buy and sell on the same day.
- If you're left with shares at the end, you should return the amount of money you have plus the current value of the shares you own. 

Strategy 1: Buy and sell as often as possible
On any given day: 
- If you have shares to sell, you should sell them all
- Otherwise, you should buy as many shares as you can afford. 

Strategy 2: Moving average
On any given day:
- If the 5-day moving average is higher than the 10-day moving average, buy as many shares as you can.
- If the 5-day moving average is lower than the 10-day moving average, sell all of your shares.

Definition: On an given day, the n-day moving average is the average of the previous n prices. 

[0, 1, 2, 3, 4, 5]
    -  -  -  *
At index 4 above, the 3-day moving average is 2, because (3 + 2 + 1) / 3

*/

/*
My strategy for testing Strategy 1 (Buy and sell as often as possible)

testStrategy1([2, 4, 5, 3, 100], 100);
               * 

myShares = {}
myMoney = 100

For each price in prices: 
    If shares in myShares:
        // Sell all
        For each price, amount in myShares:
            myMoney += price * amount
            delete myShares[price]

    Else if no shares in myShares:
        // Buy:
        if myMoney / price < 1:
            not enough money to buy shares
        else:
            if price in myShares:
                myShares[price] += Math.trunc(myMoney / price) // TODO What if the same price occurrs in the prices array more than once? 
            else:
                myShares[price] = Math.trunc(myMoney / price) // TODO What if the same price occurrs in the prices array more than once? 
            myMoney = myMoney - (myShares[price] * price)
        



*/
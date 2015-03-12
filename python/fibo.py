# https://www.hackerrank.com/contests/infinitum10/challenges/fibonacci-finding-easy
# Author:Raghuveer Sagar
import sys
def fib(N):    
    # print(N)
    if N == 0:
        return x[0]
    elif N == 1:
        return x[1]
    else:
        if x[N - 1] == None:
            fib(N - 1)
        elif x[N - 1] == None:
            fib(N - 2)
    x[N] = x[N - 1] + x[N - 2]        
    return x[N]
   
 
cases = sys.stdin.readline()
x = list()
for _ in range(int(cases)):
    line = sys.stdin.readline()
    line_arr = line.split(" ")
    
    n = int(line_arr[2])
    x = [None for _ in range(n + 1)]
    x[0] = int(line_arr[0])
    x[1] = int (line_arr[1])
    print(str(fib(n)))

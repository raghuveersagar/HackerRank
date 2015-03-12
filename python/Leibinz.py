#https://www.hackerrank.com/challenges/leibniz
#@Author:Raghuveer Sagar


z=lambda :range(int(input()))
for q in [sum([(-1)**n/(2*n+1) for n in z()]) for k in z()]:print(q)
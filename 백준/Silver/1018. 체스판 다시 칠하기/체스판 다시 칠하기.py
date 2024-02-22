N, M = map(int,input().split())
import sys

chess = []
count_list = []

for i in range(N): #값 받기
    chess_batch = sys.stdin.readline().strip()
    chess.append(chess_batch)

for i in range(N-7):
    for j in range(M-7):
        idx1 = 0
        idx2 = 0
        for a in range(i, i+8):
            for b in range(j, j+8):
                if(a+b)%2 == 0:
                    if chess[a][b] != 'W':idx1 +=1
                    if chess[a][b] != 'B':idx2 += 1
                else:
                    if chess[a][b] != 'B':idx1 +=1
                    if chess[a][b] != 'W':idx2 += 1
        count_list.append(idx1)
        count_list.append(idx2)

print(min(count_list))
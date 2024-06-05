from random import randint
from time import time

# algoritmo 1:
def alg1(input_l, k):
    val = False
    for element_1 in input_l:
        for element_2 in input_l:
            if(element_1 + element_2 == k) and (element_1 != element_2):
                val = True
    return val

# algoritmo 2:
def alg2(input_l, k):
    val = False
    input_l.sort()
    i = 0
    j = len(input_l) - 1
    while i < j:
        sum = input_l[i] + input_l[j]
        if sum == k:
            val = True
            i += 1
        elif sum < k:
            i += 1
        else:
            j -= 1
    return val

# algoritmo 3:
def alg3(input_l, k):
    val = False
    seen = set()
    for element in input_l:
        if (k-element) in seen:
            if (element*2) == k or element > k: continue
            val = True
        else: seen.add(element)
    return val

for i in range(10):
    k = randint(1,199)
    print(f"k = {k}")
    lista = []
    for i in range(1000000):
        lista.append(randint(0,100))
    
    #print("Algoritmo 1:")
    #tempo = time()
    #print(alg1(lista, k))
    #print(f"Tempo para o algoritmo 1: {time() - tempo}\n")
    
    print("Algoritmo 2:")
    lista2 = lista.copy()
    tempo = time()
    print(alg2(lista2, k))
    print(f"Tempo para o algoritmo 2: {time() - tempo}\n")
    
    print("Algoritmo 3:")
    lista3 = lista.copy()
    tempo = time()
    print(alg3(lista3, k))
    print(f"Tempo para o algoritmo 3: {time() - tempo}\n")
    print("\n\n\n\n")
    

#Serie Fibonnacci 
def fibonnaci(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fibonnaci(n-1) + fibonnaci(n-2)

#print(fibonnaci(10))
#print(fibonnaci(10000)) #No se puede calcular, complejidad exponencial

def potencia(x,n): 
    if n == 0:
        return 1
    return x  * potencia(x,n-1)

'''
Escribir una función recursiva que reciba como parámetros dos cadena de caracteres a y b,
una lista X vacía y el índice de inicio. La función devuelve en X una lista con las posiciones
en donde se encuentra b dentro de a. Ejemplo:
>>> posiciones_de("Un tete a tete con Tete", "te",[],0)
[3, 5, 10, 12, 21]
'''

'''
def posiciones_de(a,b,X,i):
    for j in range(len(a)):
        if a[j] == b[0]:
            for k in range(j,len(b)):
                if a[k] != b[k-j]:
                    break
            X.append(j) 
    return X

print(posiciones_de("Un tete a tete con Tete", "te",[],0))
'''
def posiciones_de(a,b,X,i):
    if len(b) <= 0:
        return X
    for j in range(i,len(a)): 
        if a[j] == b[0]:
            X.append(j)
            X = posiciones_de(a[j+1:],b[1:],X,0)
    return X

#posiciones_de("estashola", "ho",[],0)
#print(posiciones_de("Un tete a tete con Tete", "te",[],0))

'''
Escribir una función booleana recursiva llamada VectoresIguales que reciba dos listas como
parámetros y devuelva TRUE si son iguales (mismos elementos en el mismo orden), o
FALSE en caso contrario.
'''
def vectoresIguales(a,b):
    if len(a) != len(b):
        return False 
    return vectoresIgualesRecursive(a,b)

def vectoresIgualesRecursive(a,b):
    if len(a) == 0:
        return True
    if a[0] != b[0]:
        return False
    return vectoresIgualesRecursive(a[1:],b[1:])

#a = [1,2,3,4,5]
#b = [1,2,3,4,7]
#print(vectoresIguales(a,a)) True 
#print(vectoresIguales(a,b)) False 

def invertir(L):
    return invertiRecursive(L,0, len(L))
def invertiRecursive(L,i,j): 
    if j <=0:
        return L 
    L.insert(j,L[i])
    L.pop(i)
    return invertiRecursive(L,0,j-1)

#l = [1,2,3,4]
#print(invertir(l)) # [5,4,3,2,1]


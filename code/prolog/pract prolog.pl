% Caso base: Si Y es 0, el MCD es X.
mcd(X, 0, X).

% Caso recursivo: Si Y no es 0, se calcula el MCD de Y y X mod Y.
mcd(X, Y, Z) :-
    Y \= 0,
    R is X mod Y,
    mcd(Y, R, Z).
pertenece(H|_,H).
pertenece(_|T,X):-
    pertenece(T,X).
concatena([],X,X).
concatena([X|L1],L2,[X|L3]):-
    concatena(L1,L2,L3).
reverse([],[]).
reverse([H|T],R):-
    reverse(T,L),
    concatena(L,[H],R).
palidromo(L):-
	reverse(L,L).
ultimo([H|[]],H).
ultimo([_|T],X):-
    ultimo(T,X).
append(L,X,R):-
    concatena(L,[X],R).
subconjunto([],[]).
subconjunto(L1,[X|L2]):-
    pertenece(X,L1),
    subconjunto(L1,L2).
inserta(X,L,[X|L]).
inserta(X, [Y|L1], [Y|L2]) :-
    inserta(X, L1, L2).
longitud(0,[]).
longitud(N,[_|T]):-
    longitud(N1,T),
    N is N1+1.
% Caso base: una lista vacía siempre está acotada.
lista_acotada([]).

% Caso recursivo: calcular la longitud de la lista, y verificar que el primer elemento es menor que la longitud.
lista_acotada([X|T]) :-
    longitud(N,[X|T]),
    N1 is N/2,
    X < N1,
    lista_acotada(T). % Recursivamente verificar el resto de la lista.
% Caso base: El máximo de una lista con un solo elemento es ese mismo elemento.
max_lista([X], X).

% Caso recursivo: si la lista tiene más de un elemento, comparamos el primer elemento con el máximo de la cola.
max_lista([X|T], X) :-
    max_lista(T, MaxT),
    X >= MaxT,!.

max_lista([X|T], MaxT) :-
    max_lista(T, MaxT),
    X < MaxT.
suma_lista([],0).
suma_lista([H|T],N):-
    suma_lista(T,N1),
    N is N1+H.
% Caso base: una lista vacía o una lista con un solo elemento está siempre ordenada.
ordenada([]).
ordenada([_]). 

% Caso recursivo: la lista está ordenada si el primer elemento es menor o igual que el segundo, y el resto de la lista también está ordenada.
ordenada([X, Y | T]) :-
    X =< Y,         % Verificar que el primer elemento es menor o igual que el segundo.
    ordenada([Y | T]). % Verificar recursivamente el resto de la lista.
lista(N,L):-
    lista_aux(N,L,N).
lista_aux(_,[],0).
lista_aux(N,[N|T],C):-
    C>0,
    C1 is C-1,
    lista_aux(N,T,C1).
lista_de_numeros(N,N,[N]).
lista_de_numeros(N,M,[N|T]):-
    N>0,
    M>0,
    N<M,
    N1 is N+1,
    lista_de_numeros(N1,M,T).
entre(N1,X,N2):-
    X>=N1,
    X=<N2.
%%
%%sublista(L1,L2):- 
    %%append( [_, L1, _], L2 ).

permutacion([X|Y],Z) :- 
    permutacion(Y,W), quitar(X,Z,W).
permutacion([],[]).
quitar(X,[X|Y],Y).
quitar(X,[H|T],[H|T1]):-
    quitar(X,T,T1).
multirot(_,[]).
multirot(L,L2):- permutacion(L,P), concatena(P,X,L2), multirot(L,X), !.
% repetir n, k veces y devolverlo en L
lista_repetir(N,K,L):- lista_repetir(N,K,[],L).
lista_repetir(_,0,L,L).
lista_repetir(N,K,L,L2):- 
    K > 0, 
    K1 is K-1, 
    concatena([N],L,L1), 
    lista_repetir(N,K1,L1,L2).

% repetir n, k veces y devolverlo en L (list of lists)
lista_repetir2(N,K,[L]):- 
    lista_repetir2(N,K,[],L).
lista_repetir2(_,0,L,L).
lista_repetir2(N,K,L,L2):- 
    K > 0, 
    K1 is K-1, 
    concatena([N],L,L1), 
    lista_repetir2(N,K1,L1,L2).

es_telescopio(N,L):- 
    es_telescopio(1,N,L).
es_telescopio(X,N,[]):- 
    X is N+1.
es_telescopio(I,N,L):- 
    I > 0, 
    N >= I, 
    I1 is I+1, 
    es_telescopio(I1,N,L1), 
    lista_repetir(I,I,R), 
    concatena(R,L1,L).

es_telescopio2(N,L):- 
    es_telescopio2(1,N,L).
es_telescopio2(X,N,[]):- 
    X is N+1.
es_telescopio2(I,N,L):- 
    I > 0, 
    N >= I, 
    I1 is I+1, 
    es_telescopio2(I1,N,L1), 
    lista_repetir2(I,I,R), 
    concatena(L1,R,L).

son_consecutivas(N,L):- 
    es_telescopio2(N,T), 
    permutacion(T,P), 
    append(P,L).
    






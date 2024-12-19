mago(harry, mestiza, [coraje, amistad, orgullo, inteligencia]).
mago(ron, pura, [amistad, diversion, coraje]).
mago(hermione, impura, [inteligencia, coraje, responsabilidad, amistad, orgullo]).
mago(hannahAbbott, mestiza, [amistad, diversion]).
mago(draco, pura, [inteligencia, orgullo]).
mago(lunaLovegood, mestiza, [inteligencia, responsabilidad, amistad, coraje]).

odia(harry,slytherin).
odia(draco,hufflepuff).
casa(gryffindor).
casa(hufflepuff).
casa(ravenclaw).
casa(slytherin).

caracteriza(gryffindor,amistad).
caracteriza(gryffindor,coraje).
caracteriza(slytherin,orgullo).
caracteriza(slytherin,inteligencia).
caracteriza(ravenclaw,inteligencia).
caracteriza(ravenclaw,responsabilidad).
caracteriza(hufflepuff,amistad).
caracteriza(hufflepuff,diversion).


lugarProhibido(bosque,50).
lugarProhibido(seccionRestringida,10).
lugarProhibido(tercerPiso,75).

alumnoFavorito(flitwick, hermione).
alumnoFavorito(snape, draco).
alumnoOdiado(snape, harry).


hizo(ron, buenaAccion(jugarAlAjedrez, 50)).
hizo(harry, fueraDeCama).
hizo(hermione, irA(tercerPiso)).
hizo(hermione, responder('Donde se encuentra un Bezoar', 15, snape)).
hizo(hermione, responder('Wingardium Leviosa', 25, flitwick)).
hizo(ron, irA(bosque)).
hizo(draco, irA(mazmorras)).

esDe(harry,gryffindor). 
esDe(hermione,gryffindor). 
esDe(ron,gryffindor). 
esDe(draco,slytherin). 
esDe(hannahAbbott,hufflepuff). 
esDe(lunaLovegood,ravenclaw). 

miembro(X,[X|_]). 
miembro(X,[_|T]):-
    miembro(X,T). 


%permiteEntrar/2 que relaciona a una casa con un mago. Este predicado se cumple para cualquier mago y cualquier casa excepto en el caso de Slytherin, que no permite entrar a magos de sangre impura.
%?- permiteEntrar(slytherin, hermione). No.

permiteEntrar(Casa,Mago):-
    casa(Casa), 
    Casa \= slytherin,
    mago(Mago,_,_).  

permiteEntrar(slytherin,Mago):-
    mago(Mago,pura,_). 

%tieneCaracter/2 que relaciona a un mago y una casa si su carácter (lista de características) incluye todo lo que caracteriza a esa casa.
%?- tieneCaracter(harry, Casa).
%Casa = gryffindor;
%Casa = slytherin; No.

tieneCaracter(M,C):-
    mago(M,_,L), 
    caracterCasa(C,R),
    tieneCaracterAux(R,L). 

caracterCasa(gryffindor,R):-
    findall(X,caracteriza(gryffindor,X),R). 


caracterCasa(slytherin,R):-
    findall(X,caracteriza(slytherin,X),R).


caracterCasa(hufflepuff,R):-
    findall(X,caracteriza(hufflepuff,X),R).

caracterCasa(ravenclaw,R):-
    findall(X,caracteriza(ravenclaw,X),R).


tieneCaracterAux([],[_|_]).
tieneCaracterAux([H|T],L2):-
    miembro(H,L2), 
    tieneCaracterAux(T,L2). 
    

%casaPosible/2 que relaciona a un mago con una casa en la cual podría quedar seleccionado. Esto se cumple si el mago tiene el carácter adecuado para la casa, la casa permite su entrada y además el mago no odia esa casa.
%?- casaPosible(harry, Casa).
%Casa = gryffindor; %No.
%?- casaPosible(hermione, Casa).
%Casa = gryffindor;
%Casa = ravenclaw; %No.

casaPosible(M,C):-
    tieneCaracter(M,C), 
    permiteEntrar(C,M),
    \+ odia(M,C). 

%cadenaDeAmistades/1 que se cumple para una lista de magos si todos ellos tienen la característica amistad y cada uno podría estar en la misma casa que el siguiente. No hace falta que sea inversible, se consultará de forma individual.
%?- cadenaDeAmistades([hannahAbbott, ron, harry, hermione, lunaLovegood]).%Yes
%?- cadenaDeAmistades([draco, harry, ron, hermione, lunaLovegood]).%No.

cadenaDeAmistades([_]). 
cadenaDeAmistades([M1,M2|T]):-
    mago(M1,_,L1),
    mago(M1,_,L2),
    miembro(amistad,L1), 
    miembro(amistad,L2),
    casaPosible(M1,C1),
    casaPosible(M2,C1),
    cadenaDeAmistades([M2|T]).


%esBuenAlumno/1 que se verifica para un mago que hizo al menos una acción 
%y ninguna de las cosas que hizo provocó un puntaje negativo.

esBuenAlumno(M) :-
    hizo(M, Accion), 
    esAccionBuena(Accion).

% Una acción es buena si no fue a un lugar prohibido
esAccionBuena(irA(X)) :- 
    \+ lugarProhibido(X, _).

% Una acción es buena si respondió una pregunta en clase
esAccionBuena(responder(_,_,_)).

% Una acción es buena si hizo una buena acción
esAccionBuena(buenaAccion(_, _)).

% Una acción es buena si no se levantó de la cama por la noche
esAccionBuena(not(fueraDeCama)).
 

%puntosDeCasa/2 que relaciona a una casa con el puntaje total que es la 
%sumatoria de los puntos obtenidos por los alumnos de esa casa.


%accionesDeCasa(Casa,[Accion|R]) :-
    %esDe(Alumno, Casa),
    %hizo(Alumno, Accion),
    %\+ miembro(Accion,R),
    %accionesDeCasa(Casa,R). 

.






    





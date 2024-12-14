data Set a = Set [a] deriving (Show,Eq) 

s = Set [1,2,3]

s1 = Set ['a','n','c']
s2 = Set ["hola","como","estas"]
s3 = Set [1.0,2.5,3.8]

--Insterta un elemento en el conjunto en una posición 

insert x pos set = if not(elem x set) && pos <= length set then insertAux x pos set else set 

insertAux x pos (h:hs) | pos == 0  = [x] ++ (h:hs)
                       | pos == 1 = (h:hs) ++ [x]
                       | otherwise = [h] ++ (insertAux x (pos-1) hs) 

--Agrega un elemento al comienzo del conjunto 
add x set = if not(elem x set) then addAux x set else set 
addAux x set = (x:set)

--Elimina un elemento del set 

delete x set = if not(elem x set) then set else deleteAux x set 
deleteAux x (h:hs) | x == h = hs 
                |otherwise = [h] ++ (delete x hs)

--Devuelve el producto cartesiano de dos conjuntos que cumplen determinada condición f 

prodCart set1 set2 f = [(x,y) | x <- set1, y <- set2, cumpleCondicion f x y ] 

sumaImpar x y = odd (x + y)

cumpleCondicion f x y  = f x y  


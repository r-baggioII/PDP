sumaNumeros :: (Num a) => [a] -> a 

sumaNumeros [] = 0 
sumaNumeros (x:xs) = x + sumaNumeros xs 

promedioFrecuenciaCardiaca :: [Int] -> Float 

promedioFrecuenciaCardiaca frec = fromIntegral(sum frec) / fromIntegral(length frec)


--esCapicua/1, si data una lista de listas, me devuelve si la concatenación de las sublistas es una lista capicua..Ej: 
--Main> esCapicua ["ne", "uqu", "en"] 
--True 

esCapicua list = (reverse.concat) list == concat list

--Definir la función existsAny/2, que dadas una 
--función booleana y una tupla de tres 
--elementos devuelve True si existe algún elemento de la tupla que haga 
--verdadera la función.

existsAny :: (a -> Bool) -> (a,a,a) -> Bool 
existsAny f (x,y,z) = f x || f y || f z 

--mejor/3, que recibe dos funciones y un número, y 
--devuelve el resultado de la función que dé un valor más alto

mejor :: (Ord a) => (t->a) ->(t->a) -> t->  a 
mejor f g num | f num > g num = f num 
              | otherwise = g num 

aplicaPar :: (a->b)->(a,a) -> (b,b)
aplicaPar f (x,y) = (f x, f y)

divisores :: Integral => a -> [a]
divisores n = [x|x <- [1..n], mod n x == 0 ]

esPrimo n = (length.divisores) n == 2 


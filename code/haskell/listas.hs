--lista de números pares hasta un valor n ingresado 

pares :: Int -> [Int] 
pares n = [x|x <- [1..n], mod x 2 == 0] 

--contarPalabras :: String -> [(String, Int)]

--contarPalabras (x:xs)


strToList :: String -> [String]
strToList s = map s 
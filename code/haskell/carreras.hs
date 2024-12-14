data Auto = Auto { color :: String, distancia :: Int, velocidad :: Int} deriving (Show,Eq) 

type Carrera = [Auto]

auto1 = Auto {color = "Azul", distancia = 15, velocidad = 120}
auto2 = Auto {color = "Rojo", distancia = 10, velocidad = 200}
auto3 = Auto {color = "Verde", distancia = 30, velocidad = 150}
 
carrera = [auto1,auto2,auto3]

estaCerca :: Auto -> Auto -> Bool 
estaCerca a1 a2 = a1 /= a2 && abs (distancia a1 - distancia a2) < 10 


vaGanandoCarrera :: [Auto] -> [Auto]

vaGanandoCarrera autos = filter (\auto -> distancia auto == maximaDistancia autos) autos

--Devuelve el auto en la carrera cuya distancia recorrida es la máxima 
maximaDistancia :: [Auto] -> Int 
maximaDistancia =  maximum.map distancia

ningunoCerca _ [] = True 
ningunoCerca a (x:xs) |a /= x = ningunoCerca a xs && not(estaCerca a x)  
                      |otherwise = ningunoCerca a xs 



vaTranquilo :: Auto -> Carrera -> Bool 
vaTranquilo a carrera = ningunoCerca a carrera && vaGanandoCarrera carrera== [a] 

cantidadGanando :: Auto -> [Auto] -> Int 
cantidadGanando auto [] = 0  
cantidadGanando auto (x:xs) | distancia x > distancia auto = cantidadGanando auto xs + 1 
                            | otherwise = cantidadGanando auto xs  

puesto :: Carrera -> Auto-> Int 
puesto autos a = 1 + cantidadGanando a autos 

corra ::  Int  -> Auto -> Auto 
corra tiempo auto = auto {distancia = distancia auto + tiempo * velocidad auto}

alterarVelocidad :: (Int -> Int-> Int) -> Auto -> Int -> Auto 
alterarVelocidad modificador auto cantidad = auto {velocidad = modificador (velocidad auto) cantidad}

reducirVelocidad :: Int -> Int -> Int 
reducirVelocidad v cantidad | v < cantidad = 0
                            | otherwise = v - cantidad


--Determina si un auto va perdiendo con respecto a otro 

vaPerdiendo :: Auto -> Auto -> [Auto] -> Bool
vaPerdiendo a1 a2 autos = puesto  autos a1  < puesto autos a2 

terremoto :: Auto -> Carrera -> Carrera 
terremoto a autos = afectarALosQueCumplen (estaCerca a) (\auto -> alterarVelocidad reducirVelocidad auto 50) autos


miguelitos :: Int -> Auto -> Carrera ->  Carrera
miguelitos cantidad a autos  = afectarALosQueCumplen (\auto -> vaPerdiendo a auto autos) (\auto -> alterarVelocidad reducirVelocidad auto cantidad) autos


jetPack :: Int -> Auto -> Carrera ->  Carrera  
jetPack tiempo auto carrera  = afectarALosQueCumplen (\a -> a == auto) (efectoJetPack tiempo) carrera

afectarALosQueCumplen :: (a -> Bool) -> (a -> a) -> [a] -> [a]
afectarALosQueCumplen criterio efecto lista
  = (map efecto . filter criterio) lista ++ filter (not.criterio) lista

efectoJetPack tiempo auto = auto { velocidad = (`div` 2) . velocidad . corra tiempo  $ (duplicaVel auto) }


duplicaVel :: Auto -> Auto
duplicaVel auto = auto { velocidad = velocidad auto * 2 } 

identidad auto = auto  

correnTodos :: Int-> Carrera ->  Carrera  
correnTodos tiempo carrera = map (corra tiempo) carrera  


usaPowerUp :: String -> (Auto -> Carrera ->  Carrera) -> Carrera -> Carrera 
usaPowerUp c powerUp carrera = aplicaPowerUp (head(filter (\auto-> color auto == c ) carrera)) carrera powerUp

aplicaPowerUp auto carrera powerUp = powerUp auto carrera 


eventos = [usaPowerUp "Azul" (jetPack 6), correnTodos 10]

simularCarrera carrera [] = zip (map (puesto carrera) carrera) (map color carrera)
simularCarrera carrera (e:es) = simularCarrera (e carrera) es  

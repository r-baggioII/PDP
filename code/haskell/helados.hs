type Helado = (String, Int, Float) 

h1 :: Helado 
h1 =  ("Frutilla",-5,0.4) 
h2 :: Helado 
h2 =  ("Durazno",1,0.2)

--Saber si un helado salió mal: no se congeló o la proporción de agua no es correcta \

salioMal :: Helado -> Bool 
salioMal helado = (not.congelado) helado && (not.proporcionCorrecta) helado 


congelado :: Helado -> Bool 
congelado (_,temp,_) = temp <= 0 

proporcionCorrecta :: Helado -> Bool 
proporcionCorrecta (nombre,temp,propAgua) | nombre == "frutilla" && propAgua == 0.4 = True 
                                          | nombre == "durazno" && propAgua <= 0.2 && propAgua <= 0.6 = True 
                                          | otherwise =  segunLetras (nombre,temp,propAgua) 

segunLetras :: Helado -> Bool 
segunLetras (nombre, _, propAgua) | length nombre <= 8 = propAgua == fromIntegral (length nombre) / 10 
                                  | otherwise = propAgua == fromIntegral (cantVocales nombre) / 10 

cantVocales :: String -> Int 
cantVocales [] = 0 
cantVocales (x:xs) | x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' = (cantVocales xs) + 1       
                   |otherwise = cantVocales xs                                                      

--Enfria un helado a una determinada temperatura 
heladera :: Helado -> Int -> Helado 
heladera (nombre, temp, agua) grados = (nombre, grados, agua)

--batidora: Toma un cajón de fruta y un bidón de agua y los mezcla, transformándolo en
--un helado del sabor de la fruta del cajón, la temperatura del agua y la proporción de agua
--que surge (litros por kg.).

type CajonFruta = (String,Float) --nombre de la fruta y peso en kg del cajón 
type Agua = Float 
type BidonAgua = (Agua,Int) -- Cantidad en litros de agua y la temperatura a la que se encuentra 
cajon :: CajonFruta
cajon = ("frutilla", 4.0 ) 
bidon :: BidonAgua 
bidon = (10.0,0) 

batidora :: BidonAgua ->CajonFruta -> Helado 
batidora  (litros,temp) (fruta,peso) = (fruta,temp,propAgua)
                                     where 
                                        propAgua =  peso / litros

--exprimidora:Toma un cajón de fruta natural y lo transforma en un nuevo cajón de fruta
--exprimida, perdiendo el 50% de su peso.


exprimidora :: CajonFruta -> CajonFruta
exprimidora (fruta,peso) = (fruta,newPeso)
                            where 
                                newPeso = peso * 0.5 

--mixturadora: Toma dos helados de frutas diferentes y obtiene uno nuevo, de gusto
--combinado, con la menor temperatura y la proporción promedio.
h3 :: Helado 
h3 = ("kiwi", 5, 0.6) 
h4 :: Helado 
h4 = ("melon", 3, 0.4)
mixturadora :: Helado -> Helado -> Helado 
mixturadora (helado1, temp1, propAgua1) (helado2,temp2,propAgua2) = (newHelado, newTemp,newPropAgua)
                                                                  where 
                                                                    newHelado = helado1 ++ ['-'] ++ helado2 
                                                                    newTemp = min temp1 temp2
                                                                    newPropAgua = (propAgua1 + propAgua2) / 2 

--dispenser: Toma una cantidad de agua y devuelve un bidón de la misma cantidad de
--agua, a 0 grados.
dispenser :: Agua -> BidonAgua 
dispenser litrosAgua = (litrosAgua,0) 

--Cinta transportadora: Combina tres máquinas de forma tal que el resultado de una sea
--ingresado a la otra y a su vez, su resultado sea ingresado en la restante.
cintaTransportadora m1 m2 m3 = m3.m2.m1 

m1 = exprimidora
m2 = batidora (10.0, 0)
m3 = heladera 0 
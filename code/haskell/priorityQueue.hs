data Element a = Element {value :: a, priority :: Int} deriving (Show,Eq) --un elemento tiene un valor y una prioridad 

data PriorityQueue a =  PriorityQueue [Element a]  deriving (Show,Eq) --lista de elementos 


e1 = Element {value = 'A', priority = 1} 
e2 = Element {value = 'B', priority = 2} 
e3 = Element {value = 'C', priority = 3} 

queue = PriorityQueue  [] 

enqueueHelper :: Element a -> [Element a] -> [Element a]
enqueueHelper x [] = [x]
enqueueHelper x (h:hs) | priority x <= priority h = x: h:hs 
                 |otherwise = h : enqueueHelper x hs 
                 
enqueue :: Element a -> PriorityQueue a -> PriorityQueue a 
enqueue x (PriorityQueue xs) = PriorityQueue (enqueueHelper x xs)
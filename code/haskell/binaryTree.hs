-- Define a binary search tree data type
data BST a = Empty| Node a (BST a) (BST a)  deriving (Show, Eq)-- Represents a tree node with a value and two subtrees 

b :: BST Int
b = Node 10 
        (Node 5 
            (Node 3 Empty Empty)
            (Node 7 Empty Empty))
        (Node 15
            Empty
            (Node 20 Empty Empty))

b1 :: BST Int 
b1 = Node 10 
        (Node 5 
            (Node 3 Empty Empty)
            (Node 7 Empty Empty))
        Empty

--Insert a value into a binary search tree 

insert key Empty = Node key Empty Empty   -- si el árbol está vacío se crea un nodo con el valor key
insert key (Node x left right) -- si el árbol no está vacío
    | key < x = Node x (insert key left) right --busca recursivamente por la izquierda
    | key > x = Node x left (insert key right) --busca recursivamente por la derecha
    | otherwise = Node x left right -- si el valor ya existe no se inserta


--Search for a value in a binary search tree 
search value Empty = False 
search value (Node x left right)
    | value == x = True 
    | value < x = search value left 
    | value > x = search value right

--Creates a binary search tree from a list of integers
fromListAux (x:xs) tree = fromListAux xs (insert x tree)
fromListAux [] tree = tree
fromList list = fromListAux list Empty

--izquierda, raiz, derecha
inOrder Empty = []
inOrder (Node x left right)  = inOrder left ++ [x] ++ inOrder right

--izquierda, derecha, raiz
preOrder Empty = []
preOrder (Node x left right) = preOrder left ++ preOrder right ++ [x]




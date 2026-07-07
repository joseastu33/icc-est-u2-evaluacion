## Universidad Politecnica Salesiana

## Estructuras de Datos G3
## José Andrés Astudillo Pacheco
## Cuenca, 06 julio 2026

## Primer metodo: filtrarYOrdenarTickets

## ¿ Que implementacion de Set o Map se utilizo?
Se utilizó una implementación de Set, esto con el objetivo de cumplir con los requisitos del
enunciado, pues este menciona que no se pueden permitir duplicados lógicos, asimismo
con la idea de que el resultado debe quedar ordenado automáticamente (es decir, con orden natural de datos)
siendo esta la razón por la cual se ha optado por un TreeSet.
## ¿ Por que se escogió esa implementacion?
Se utilizó la implementación partiendo de la idea de que esta estructura organiza automáticamente los elementos
por su orden natural, sin tener que emplear metodos de ordenamiento adicionales o formas de ordenamiento en el caso
de por ejemplo ser un HashSet, es equivalente a tener una estructura la cual beneficia en tiempo y espacio.
## ¿ Como se garantiza la unicidad de los datos?
La unicidad de los datos es garantizada por el uso de esta misma estructura (un Set) el cual no permite duplicados.
Sin embargo, más allá de esta idea, es aplicado un criterio del metodo compare, que lo hace útil no solo para
ordenamiento pues igualmente para eliminar casos duplicados (al retornar 0 si tanto la prioridad como el codigo son iguales)
es decir, la estructura del TreeSet necesita de este retorno o valor para saber cuando dejar de comparar.
## ¿ Como se conserva o define el orden de los resultados?
Los resultados tendrán un orden asignado por el método compare de acuerdo al umbral de prioridad mínima establecido
en este caso los resultados tendrán un orden de acuerdo a la estructura establecida, a diferencia de otras estructuras
como LinkedHashSet, en este TreeSet implementado los resultados tienen un orden que no se define por orden de insercion.
## ¿ Como funciona la lógica implementada?
La lógica primero realiza un filtro a cada uno de los tickets en la lista, en código primero se realiza un comparador
el cual hice con un método equals sobreescrito, primero se cubre un caso de duplicados viendo si la prioridad o codigo son iguales
si son iguales se detiene con el return, pero si son diferentes significa que sí es posible compararlos, entonces a través del
Integer.compare (descendentemente) se comparan enteros, si sale del else if (lo que significa que en este caso son iguales en prioridad)
se pasa a un último criterio de comparación como lo es un desempate entre el técnico (nombre).

## Segundo metodo: agruparCodigosPorPrioridad 

## ¿ Que implementacion de Set o Map se utilizo?
En este segundo método considerando que tanto las llaves como los valores de dichas llaves deben estar ordenadas
alfabéticamente se utilizó una estructura de Mapa (específicamente un TreeMap) el cual define el orden natural
de los datos al igual como lo hace el TreeSet.

## ¿ Por que se escogió esa implementacion?
Se utilizó la implementación del TreeMap debido a que resulta la más adecuada para poder ordenar naturalmente sin
necesidad de implementar un metodo de ordenamiento adicional tanto para un posible HashMap como para una estructura diferente. 
Asimismo considerando que también los números de los tickets deben estar ordenados naturalmente también se coloca un TreeMap.

## ¿ Como se garantiza la unicidad de los datos?
La unicidad de los datos en este caso es garantizada por el TreeSet, el cual no permite duplicados al igual que en el
metodo anterior, con la diferencia de que en este método no es necesario implementar una comparación adicional dado que
el orden natural en este caso resulta ascendentemente

## ¿ Como se conserva o define el orden de los resultados?
Los resultados conservan su orden de acuerdo al almacenamiento de estos tanto en el TreeSet como en el TreeMap, de forma
natural, a diferencia del método anterior en este método no se hace ninguna filtración ya que no resulta necesario

## ¿ Como funciona la lógica implementada?
Primeramente se crean los sets necesarios con el orden natural implementado (en este caso por cada tipo de prioridad)
bien se alta, media o baja, esto con el objetivo de tener la estructura del mapa requerido ya hecha. Luego de acuerdo
al lugar en donde esté la prioridad (si alta, media o baja) se guarda en su respectivo Set, todo esto realizando una conversión 
en este caso de String a Integer a través de un parseInteger.







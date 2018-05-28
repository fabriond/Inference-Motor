# MeuPrediAUX

Motor de inferência desenvolvido para o projeto MeuPredi, colocado num repositório separado para que possa ser melhor avaliado na disciplina de Inteligência Artificial

## Regras
As regras do motor de inferência se encontram no arquivo rules.txt e devem seguir o padrão:

**SE (condição) ENTAO (conclusão)**

- Variáveis utilizadas nas regras de inferência não podem conter E, OU, SE, ENTAO e nem operadores relacionais como partes de seus nomes

- SE e ENTAO devem sempre ser maiúsculos para que se diferenciem de nomes de variáveis

- Na condição podem ser utilizados quaisquer operadores relacionais(>, >=, <, <=, ==), e os operadores lógicos, os quais são definidos como ~(operador de negação, prefixo ao nome da variável a ser negada), E e OU (em maiúsculo) para que se diferenciem de nomes de variáveis

- Na conclusão podem ser utilizados os mesmos operadores das condições, **com exceção do operador OU**

- Caso seja necessário atribuir um valor a uma variável na conclusão, utilizar o operador ==

- O operador de negação **não pode** ser utilizado para negação de multiplas variáveis em conjunto, ou seja, tudo após a negação é tido como nome da variável alvo

- Conclusões importantes, tem de ser frases entre aspas, para que o programa consiga diferenciar conclusões que devem ser mostradas pela aplicação das conclusões que não são tão importantes

## Como instanciar casos de teste
Para criar um caso de teste, basta ir na classe Test.java e modificar os valores do HashMap userVariables

O HashMap userVariables deve conter os dados do caso de teste descritos na forma chave-valor: (variável, valor), sendo o nome da variável igual ao nome de alguma variável descrita nas regras (caso seja diferente, a variável não será considerada), e seu valor associado sempre em double
